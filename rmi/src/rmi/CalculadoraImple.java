package rmi;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImple extends UnicastRemoteObject implements Calculadora {
	
	public CalculadoraImple() throws RemoteException {
		super();
	}
	
	public BigDecimal adicao(BigDecimal op1, BigDecimal op2) {
		return op1.add(op2);
	}
	public BigDecimal subtracao(BigDecimal op1, BigDecimal op2) {
		return op1.subtract(op2);
	}
	public BigDecimal multiplicacao(BigDecimal op1, BigDecimal op2) {
		return op1.multiply(op2);
	}
	public BigDecimal divisao(BigDecimal op1, BigDecimal op2) {
		return op1.divide(op2);
	}
	
	public static void main(String args[]) {
		try {
			CalculadoraImple obj = new CalculadoraImple();
			Registry registry = LocateRegistry.createRegistry(4200);
			registry.rebind("Calculadora", obj);
			System.out.println("Servidor carregado no registry");
		} catch (Exception e) {
			System.out.println("OlaImpl erro: " + e.getMessage());
		}
	}
}
