package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Cliente;
import util.Conexao;
import util.Configurador;

public class ClienteDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public ClienteDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Cliente inserir(String cpf, String nome, String email, String telefone, String login, String senha,
			int tipo) {
		Cliente cliente = null;
		ClienteDAO cliDAO = new ClienteDAO();
		try {

			// Criação do insert
			String sql = "insert into cliente " + "(cpf, nome, email, telefone, fklogin) " + "values (?,?,?,?,?)";

			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver, cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cpf);
			comando.setString(2, nome);
			comando.setString(3, email);
			comando.setString(4, telefone);
			comando.setString(5, login);// não é fklogin, porque aqui a referência é da Classe e não do BD

			// Comando executado
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		cliente = new Cliente(login, senha, tipo, cpf, nome, email, telefone, null);

		return cliente;
	}

	public static Cliente update(String email, String telefone, String fklogin) {
		Cliente cliente = null;

		ClienteDAO cliDAO = new ClienteDAO();

		try {
			// Criação do insert
			String sql = "update cliente set email = ?, telefone = ? where fklogin = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver, cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, email);
			comando.setString(2, telefone);
			comando.setString(3, fklogin);

			// Comando executado
			comando.executeUpdate();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cliente;
	}

	public static Cliente buscarPorLoginSenha(String login, String senha) {
		Cliente cliente = null;

		ClienteDAO cliDAO = new ClienteDAO();
		try {
			// Criação do select
			String sql = "select * from usuario u, cliente c " + "where u.login=c.fklogin and u.login = ? "
					+ "and u.senha = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver, cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, login);
			comando.setString(2, senha);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				cliente = new Cliente(rs.getString("login"), rs.getString("senha"), rs.getInt("tipo"),
						rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"),
						null);

			}
			System.out.println(cliente);
			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}

	public static boolean ConferirCpf(String cpf) {
		String cpfFind = null;
		ClienteDAO cliDAO = new ClienteDAO();
		boolean cadastrado = true;
		boolean naoCadastrado = false;
		try {
			// Criação do select
			String sql = "select * from cliente where cpf = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver, cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cpf);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				cpfFind = rs.getString("cpf");
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (cpfFind != null) {
			return cadastrado;
		}
		return naoCadastrado;
	}

}
