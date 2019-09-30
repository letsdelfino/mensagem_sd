package rmi;

import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		Calculadora obj = null;
		BigDecimal op = null;
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4200);
			obj = (Calculadora) registry.lookup("OlaCalculadora");
			op = obj.adicao(new BigDecimal(5), (new BigDecimal(7)));
			System.out.println("Adição: " + op);
			op = obj.subtracao(new BigDecimal(15), (new BigDecimal(5)));
			System.out.println("Subtração: " + op);
			op = obj.divisao(new BigDecimal(10), (new BigDecimal(2)));
			System.out.println("Divisão: " + op);
			op = obj.multiplicacao(new BigDecimal(7), (new BigDecimal(6)) );
			System.out.println("Multiplicação: " + op);
		} catch (Exception e) {
			System.out.println("Client exception: " + e.getMessage());
		}
	}
}
