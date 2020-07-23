package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;
import util.Conexao;
import util.Configurador;

public class UsuarioDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public UsuarioDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Usuario inserir(String login, String senha, int tipo) {
		Usuario usuario = null;

		UsuarioDAO usuDAO = new UsuarioDAO();

		try {
			// Criação do insert
			String sql = "insert into usuario (login, senha, tipo) values (?,?,?)";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(usuDAO.url, usuDAO.driver, usuDAO.login, usuDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, login);
			comando.setString(2, senha);
			comando.setInt(3, tipo);

			// Comando executado
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return usuario;
	}

	public static Usuario update(String senha, String login) {
		Usuario usuario = null;

		UsuarioDAO usuDAO = new UsuarioDAO();

		try {
			// Criação do insert
			String sql = "update usuario set senha = ? where login = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(usuDAO.url, usuDAO.driver, usuDAO.login, usuDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, senha);
			comando.setString(2, login);

			// Comando executado

			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return usuario;
	}

	public static boolean ConferirUsuario(String usuario) {
		String usuarioFind = null;
		UsuarioDAO usuDAO = new UsuarioDAO();
		boolean cadastrado = true;
		boolean naoCadastrado = false;
		try {
			// Criação do select
			String sql = "select * from usuario where login = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(usuDAO.url, usuDAO.driver, usuDAO.login, usuDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, usuario);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				usuarioFind = rs.getString("login");
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (usuarioFind != null) {
			return cadastrado;
		}

		return naoCadastrado;
	}

}
