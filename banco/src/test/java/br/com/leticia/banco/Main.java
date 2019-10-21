package br.com.leticia.banco;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {
		ContaDAOImplementacao contaDAO = new ContaDAOImplementacao();

		Conta contaJoaoConsulta = contaDAO.consultar("José");
		System.out.println(contaJoaoConsulta.toString());

		Conta contaId5 = contaDAO.consultar(5);
		contaDAO.excluir(contaId5);

	}
}
