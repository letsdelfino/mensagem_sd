package br.com.leticia.banco;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		ContaDAO contaDAO = new ContaDAOImplementacao();

		Conta contaDiego = contaDAO.consultar("Diego");
		
		if (contaDiego != null)
			System.out.println(contaDiego.toString());		
		else
			System.out.println("Conta não encontrada");
		
		Conta contaLucas = contaDAO.consultar("Lucas");
		
		if (contaLucas != null)
			System.out.println(contaLucas.toString());		
		else
			System.out.println("Conta não encontrada");

		Conta contaJoao = new Conta();
		contaJoao.setId(5);
		contaJoao.setNome("João");
		contaJoao.setSaldo(new BigDecimal("300"));

		if (contaJoao != null)
			System.out.println(contaJoao.toString());
		
		boolean contaDiego1 = contaDAO.depositar("Diego", new BigDecimal("200"));
		
	}
}