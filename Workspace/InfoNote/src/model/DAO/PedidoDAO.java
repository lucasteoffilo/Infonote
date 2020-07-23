package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import util.Conexao;
import util.Configurador;

public class PedidoDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	private static int idGerado;

	public PedidoDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static int inserir(String situacao, double valorTotal, String fkcpf, String fkIdEnd) {
		PedidoDAO pedidoDAO = new PedidoDAO();

		try {
			// Criação do insert
			String sql = "insert into pedido " + "(dataemissao, situacao, valorTotal, fkcpf, fkIdEnd)"
					+ "values (?,?,?,?,?)";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(pedidoDAO.url, pedidoDAO.driver, pedidoDAO.login, pedidoDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			comando.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
			comando.setString(2, situacao);
			comando.setDouble(3, valorTotal);
			comando.setString(4, fkcpf);
			comando.setString(5, fkIdEnd);
			comando.executeUpdate();

			ResultSet rs = comando.getGeneratedKeys();

			if (rs.next()) {
				idGerado = rs.getInt(1);
			}

			comando.close();
			con.close();
			comando.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return idGerado;

	}

	public static List<Pedido> buscarTodos(String fkcpf) {
		List<Pedido> pedidos = null;
		PedidoDAO pedidoDAO = new PedidoDAO();

		try {
			// Criação do insert
			String sql = "select * from pedido where fkcpf = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(pedidoDAO.url, pedidoDAO.driver, pedidoDAO.login, pedidoDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, fkcpf);

			/*
			 * ResultSet - Classe java que monta em memória uma matriz com a resposta das
			 * linhas do BD
			 */
			ResultSet rs = comando.executeQuery();

			pedidos = new ArrayList<Pedido>();

			while (rs.next()) {
				Date data = rs.getDate("dataEmissao");
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				String dataFormatada = formato.format(data);
				pedidos.add(new Pedido(rs.getInt("numeroPedido"), dataFormatada, rs.getString("situacao"),
						rs.getDouble("valorTotal"), rs.getString("fkcpf"), rs.getInt("fkIdEnd")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pedidos;
	}

	public static Pedido buscarPorNumPedido(int NumPedido) {
		Pedido pedido = null;
		PedidoDAO DAO = new PedidoDAO();

		try {
			// Criação do insert
			String sql = "select * from pedido where numeroPedido = ?";

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
				pedido = new Pedido(rs.getInt("numeroPedido"), rs.getString("dataEmissao"), rs.getString("situacao"),
						rs.getDouble("valorTotal"), rs.getString("fkcpf"), rs.getInt("fkIdEnd"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pedido;
	}

}
