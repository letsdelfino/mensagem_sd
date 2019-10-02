package banco_rmi;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		//Calculadora obj = null;
		//BigDecimal op = null;
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4200);
			//obj = (Calculadora) registry.lookup("OlaCalculadora");
			//op = obj.adicao(new BigDecimal(5), (new BigDecimal(7)));
			
		} catch (Exception e) {
			System.out.println("Client exception: " + e.getMessage());
		}
	}
}
