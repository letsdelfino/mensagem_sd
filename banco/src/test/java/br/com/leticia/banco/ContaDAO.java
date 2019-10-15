package br.com.leticia.banco;

import java.math.BigDecimal;

public interface ContaDAO {
	public Conta consultar(String nome);
	public boolean inserir(Conta conta);
	public boolean depositar(String nome, BigDecimal valor);
}