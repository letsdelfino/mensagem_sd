package rpc_socket;

import java.math.BigDecimal;

public class CalculadoraImplementacao implements Calculadora {

	@Override
	public BigDecimal soma(BigDecimal op1, BigDecimal op2) {
		return op1.add(op2);
	}
	public BigDecimal subtracao(BigDecimal op1, BigDecimal op2) {
		return op1.subtraction(op2);
	}
	public BigDecimal multiplicacao(BigDecimal op1, BigDecimal op2) {
		return op1.multiply(op2);
	}
	public BigDecimal divisao(BigDecimal op1, BigDecimal op2) {
		return op1.division(op2);
	}

}
