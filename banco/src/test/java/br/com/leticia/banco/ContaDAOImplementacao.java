package br.com.leticia.banco;

import java.math.BigDecimal;
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
			url = "jdbc:postgresql://localhost/postgres?user=postgres&password=@Wonder777";
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
	public boolean inserir(Conta conta) {
		PreparedStatement ps = null;
		int rs;
		String url;
		Connection conexaoBanco = null;
		try {
			url = "jdbc:postgresql://localhost/postgres?user=postgres&password=@Wonder777";
			conexaoBanco = DriverManager.getConnection(url);
			ps = conexaoBanco.prepareStatement("insert into contas (id, nome, saldo) values (?,?,?)");
			ps.setInt(1, conta.getId());
			ps.setString(2, conta.getNome());
			ps.setBigDecimal(3, conta.getSaldo());
			rs = ps.executeUpdate();

			if (rs > 0 ) {
				return true;
			} else {
				return false;
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
	public boolean depositar(String nome, BigDecimal valor) {
		PreparedStatement ps = null;
		int rs;
		String url;
		Connection conexaoBanco = null;
		ResultSet ls;
		try {
			Conta conta;
			conta = new Conta();
			url = "jdbc:postgresql://localhost/postgres?user=postgres&password=@Wonder777";
			conexaoBanco = DriverManager.getConnection(url);
			ps = conexaoBanco.prepareStatement("insert into contas (saldo) values (?) where nome=(?)");
			ps.setString(1, nome);
			ps.setBigDecimal(2, conta.getSaldo().add(valor));
			rs = ps.executeUpdate();
			
			return true;
			
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