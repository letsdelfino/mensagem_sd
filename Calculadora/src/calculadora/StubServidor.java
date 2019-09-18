package calculadora;

import java.net.*;
import java.io.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StubServidor {

	public static void main(String[] args) {
		try {
			CalculadoraImpl obj = new CalculadoraImpl();
			int serverPort = 8989;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while (true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch (IOException e) {
			System.out.println("Listen :" + e.getMessage());
		}
	}
}