package rpc_socket;

import java.net.*;
import java.io.*;
import java.math.BigDecimal;

public class StubCliente implements Calculadora {

	@Override
	public BigDecimal soma(BigDecimal op1, BigDecimal op2) {
		Socket s = null;
		Mensagem mensagem;

		try {
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);

			mensagem = new Mensagem();
			mensagem.setOperacao(TipoOperacao.SOMA);
			mensagem.adicionarArgumento(op1);
			mensagem.adicionarArgumento(op2);

			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());

			out.writeObject(mensagem);

			mensagem = (Mensagem) in.readObject();

			return (BigDecimal) mensagem.getArgumento(0);

		} catch (UnknownHostException e) {
			System.out.println("Sock:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Object:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}
		}

		return null;
	}
}