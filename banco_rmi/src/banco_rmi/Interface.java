package banco_rmi;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
	public BigDecimal saque(BigDecimal valor) throws RemoteException;
	public BigDecimal deposito(BigDecimal valor) throws RemoteException;
	public BigDecimal saldo(BigDecimal valor) throws RemoteException;
}
