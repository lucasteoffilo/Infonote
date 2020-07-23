package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Pagamento;
import util.Conexao;
import util.Configurador;

public class PagamentoDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public PagamentoDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();

	}

	public static void inserir(String tipoDePagamento, double valortotal, int fkNumPedido) {

		PagamentoDAO pagDAO = new PagamentoDAO();
		try {

			// Criação do insert
			String sql = "insert into pagamento " + "(tipoDePagamento, valorTotal, fkNumPedido) " + "values (?,?,?)";

			Conexao conex = new Conexao(pagDAO.url, pagDAO.driver, pagDAO.login, pagDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, tipoDePagamento);
			comando.setDouble(2, valortotal);
			comando.setInt(3, fkNumPedido);

			// Comando executado
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static Pagamento buscarPagamento(int NumPedido) {
		Pagamento pagamento = null;
		ItemDePedidoDAO DAO = new ItemDePedidoDAO();

		try {
			// Criação do insert
			String sql = "select * from pagamento where fkNumPedido = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(DAO.url, DAO.driver, DAO.login, DAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, NumPedido);

			/*
			 * ResultSet - Classe java que monta em memória uma matriz com a resposta das
			 * linhas do BD
			 */
			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				pagamento = new Pagamento(rs.getString("tipoDePagamento"), rs.getString("dataAprovado"),
						rs.getDouble("valorTotal"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pagamento;
	}

}
