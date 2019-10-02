package banco_rmi;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BancoImplementacao extends UnicastRemoteObject implements Interface{

	protected BancoImplementacao() throws RemoteException {
		super();
	}
	
	int identificador;
	String nomeCliente;
	BigDecimal saldo;
	
	public BancoImplementacao(int numero, String nomeCliente, BigDecimal saldo) throws RemoteException{
		this.identificador = numero;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
	}
	
	public BancoImplementacao(int numero, String nomeCliente) throws RemoteException{
		this.saldo = new BigDecimal(0.0);
		this.identificador = numero;
		this.nomeCliente = nomeCliente;
	}

	@Override
	public BigDecimal saque(BigDecimal valor) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal deposito(BigDecimal valor) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal saldo(BigDecimal valor) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String args[]) {
		try {
			BancoImplementacao obj = new BancoImplementacao();
			Registry registry = LocateRegistry.createRegistry(4200);
			registry.rebind("OlaBanco", obj);
			System.out.println("Banco no registry");
		} catch (Exception e) {
			System.out.println("BancoImpl erro: " + e.getMessage());
		}
	}
}