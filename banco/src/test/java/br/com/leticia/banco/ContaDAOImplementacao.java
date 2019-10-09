package br.com.leticia.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAOImplementacao implements ContaDAO {

	public Conta consultar(String nome) {
		PreparedStatement ps = null;
		ResultSet rs;
		String url;
		Connection conexaoBanco = null;
		Conta conta;
		try {
			url = "jdbc:postgresql://localhost/banco?user=postgres&password=postgres";
			conexaoBanco = DriverManager.getConnection(url);
			ps = conexaoBanco.prepareStatement("select id, nome, saldo from contas where nome=?");
			ps.setString(1, nome);
			rs = ps.executeQuery();

			if (rs.next()) {
				conta = new Conta();

				conta.setId(rs.getInt("id"));
				conta.setNome(rs.getString("nome"));
				conta.setSaldo(rs.getBigDecimal("saldo"));

				return conta;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (conexaoBanco != null) {
				try {
					conexaoBanco.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}