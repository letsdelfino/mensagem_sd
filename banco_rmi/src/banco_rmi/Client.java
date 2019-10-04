package banco_rmi;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		Interface obj = null;
		BigDecimal op = null;
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4020);
			obj = (Interface) registry.lookup("OlaBanco");
			Interface aux = new BancoImplementacao(1, "Leticia");
			op = obj.deposito(new BigDecimal(7));
			System.out.println("Depósito realizado. Saldo atual: " + op);
			//op = obj.saque(new BigDecimal(5));
			//System.out.println("Saque realizado. Saldo atual: " + op);
			op = obj.saldo();
			System.out.println("Saldo atual: " + op);
			
		} catch (Exception e) {
			System.out.println("Client exception: " + e.getMessage());
		}
	}
}
