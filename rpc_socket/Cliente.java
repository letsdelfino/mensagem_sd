package rpc_socket;

import java.math.BigDecimal;

public class Cliente {
	public static void main(String[] args) {
		Calculadora calculadora = new StubCliente();

		System.out.println(calculadora.soma(new BigDecimal(1.2), (new BigDecimal(2.1))));
		System.out.println(calculadora.subtraction(new BigDecimal(1.2), (new BigDecimal(2.1))));
		System.out.println(calculadora.multiply(new BigDecimal(1.2), (new BigDecimal(2.1))));
		System.out.println(calculadora.division(new BigDecimal(1.2), (new BigDecimal(2.1))));
	}
}
