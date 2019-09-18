package calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StubServidor {

	public static void main(String[] args) {
		try {
			
			Registry registry = LocateRegistry.createRegistry(8989);
			registry.rebind("OlaServidor", obj);
			System.out.println("Servidor carregado no registry");
		} catch (Exception e) {
			System.out.println("CalcImpl erro: " + e.getMessage());
		}
	}
}
