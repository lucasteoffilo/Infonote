package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ItemDePedido;
import util.Conexao;
import util.Configurador;

public class ItemDePedidoDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public ItemDePedidoDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();

	}

	public static void inserir(int qtde, double valorUnitario, int fkNumPedido, String fkserial) {

		ItemDePedidoDAO iteDAO = new ItemDePedidoDAO();

		try {

			// Criação do insert
			String sql = "insert into itemdepedido" + "(qtde, valorUnitario, fkNumPedido, fkserial) "
					+ "values (?,?,?,?)";

			Conexao conex = new Conexao(iteDAO.url, iteDAO.driver, iteDAO.login, iteDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, qtde);
			comando.setDouble(2, valorUnitario);
			comando.setInt(3, fkNumPedido);
			comando.setString(4, fkserial);

			// Comando executado
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static List<ItemDePedido> buscarPorNumDePedido(int NumPedido) {
		List<ItemDePedido> itens = null;
		ItemDePedidoDAO itensDAO = new ItemDePedidoDAO();

		try {
			// Criação do insert
			String sql = "select * from itemdepedido where fkNumPedido = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(itensDAO.url, itensDAO.driver, itensDAO.login, itensDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, NumPedido);

			/*
			 * ResultSet - Classe java que monta em memória uma matriz com a resposta das
			 * linhas do BD
			 */
			ResultSet rs = comando.executeQuery();

			itens = new ArrayList<ItemDePedido>();

			while (rs.next()) {
				itens.add(new ItemDePedido(rs.getInt("qtde"), rs.getDouble("valorUnitario"), rs.getString("fkserial")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return itens;
	}

}
