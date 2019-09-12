package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;

class Connection extends Thread {

	ObjectInputStream in;
	ObjectOutputStream out;
	Socket clientSocket;
	
	int contador = 0;

	public Connection(Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());

			this.start();
		} catch (IOException e) {
			System.out.println("Connection:" + e.getMessage());
		}
	}

	public void run() {
		try { // an echo server
			while (true) {
				Mensagem msgIn = (Mensagem) in.readObject();
				Mensagem msgOut = new Mensagem();
				ArrayList<BigDecimal> resultado = new ArrayList<>();
				BigDecimal temp;

				switch (msgIn.getTipoOperacao()) {
				case SOMA:
					temp = msgIn.getNumeros().get(0).add(msgIn.getNumeros().get(1));
					resultado.add(temp);
					contador++;
					break;
				case SUBTRACAO:
					temp = msgIn.getNumeros().get(0).subtract(msgIn.getNumeros().get(1));
					resultado.add(temp);
					contador++;
					break;
				case MULTIPLICACAO:
					temp = msgIn.getNumeros().get(0).multiply(msgIn.getNumeros().get(1));
					resultado.add(temp);
					contador++;
					break;
				case DIVISAO:
					temp = msgIn.getNumeros().get(0).divide(msgIn.getNumeros().get(1));
					resultado.add(temp);
					contador++;
					break;
				case REQUISICAO:
					BigDecimal valor = new BigDecimal(contador);
					temp = valor;
					resultado.add(temp);
					break;
				}
				
				msgOut = new Mensagem();
				msgOut.setNumeros(resultado);
				out.writeObject(msgOut);
				
				TCPServer.reqRespondidas++;
			}
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				/* close failed */}
		}
	}
}