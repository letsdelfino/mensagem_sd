package rpc_socket;

import java.math.BigDecimal;

public class CalculadoraImplementacao implements Calculadora {

	@Override
	public BigDecimal soma(BigDecimal op1, BigDecimal op2) {
		return op1.add(op2);
	}

}
