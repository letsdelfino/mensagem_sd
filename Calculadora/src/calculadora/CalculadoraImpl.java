package calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
	public CalculadoraImpl() throws RemoteException {
		super();
	}

	public BigDecimal soma(BigDecimal op1, BigDecimal op2) {
		return op1.add(op2);
	}

	public BigDecimal subtracao(BigDecimal op1, BigDecimal op2) {
		return op1.subtract(op2);
	}

	public BigDecimal divisao(BigDecimal op1, BigDecimal op2) {
		return op1.divide(op2);
	}

	public BigDecimal multiplicacao(BigDecimal op1, BigDecimal op2) {
		return op1.multiply(op2);
	}

}
