package br.com.leticia.banco;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		ContaDAO contaDAO = new ContaDAOImplementacao();

		Conta contaDiego = contaDAO.consultar("Diego");

		System.out.println(contaDiego.toString());

		Conta contaJoao = contaDAO.consultar("Joao");

		if (contaJoao != null)
			System.out.println(contaJoao.toString());
		else
			System.out.println("Conta não encontrada");
	}
}