package calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote{
	BigDecimal soma(BigDecimal op1, BigDecimal op2) throws RemoteException;
	BigDecimal subtracao(BigDecimal op1, BigDecimal op2) throws RemoteException;
	BigDecimal divisao(BigDecimal op1, BigDecimal op2) throws RemoteException;
	BigDecimal multiplicacao(BigDecimal op1, BigDecimal op2) throws RemoteException;
}