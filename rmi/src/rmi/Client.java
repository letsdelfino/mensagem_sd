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
			obj = (Calculadora) registry.lookup("Calculadora");
			op = obj.adicao(new BigDecimal(2), (new BigDecimal(3)));
			System.out.println(op);
			op = obj.subtracao(new BigDecimal(2), (new BigDecimal(3)));
			System.out.println(op);
			op = obj.multiplicacao(new BigDecimal(2), (new BigDecimal(3)));
			System.out.println(op);
			op = obj.divisao(new BigDecimal(2), (new BigDecimal(3)));
			System.out.println(op);
		} catch (RemoteException e) {
			System.out.println("Client exception: " + e.getMessage());
		}catch ( NotBoundException e) {
			System.out.println("Client exception: " + e.getMessage());
		}
		
	}
}
