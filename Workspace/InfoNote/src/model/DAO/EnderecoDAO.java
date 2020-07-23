package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Endereco;
import util.Conexao;
import util.Configurador;

public class EnderecoDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public EnderecoDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Endereco inserir(String logradouro, String numero, String complemento, String bairro, String cidade,
			String estado, String cep, String cpf) {

		Endereco endereco = null;

		EnderecoDAO endDAO = new EnderecoDAO();
		try {
			// Criação do insert
			String sql = "insert into endereco values (?,?,?,?,?,?,?,?,?)";

			// Obter a conexão com o BD

			Conexao conex = new Conexao(endDAO.url, endDAO.driver, endDAO.login, endDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, null);
			comando.setString(2, logradouro);
			comando.setString(3, numero);
			comando.setString(4, complemento);
			comando.setString(5, bairro);
			comando.setString(6, cidade);
			comando.setString(7, estado);
			comando.setString(8, cep);
			comando.setString(9, cpf);

			// Comando executado
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		endereco = new Endereco(null, logradouro, numero, complemento, bairro, cidade, estado, cep);

		return endereco;
	}

	public static Endereco update(String logradouro, String numero, String complemento, String bairro, String cidade,
			String estado, String cep, String fkcpf) {
		Endereco endereco = null;

		EnderecoDAO endDAO = new EnderecoDAO();

		try {
			// Criação do insert
			String sql = "update endereco set logradouro = ?," + " numero = ?," + " complemento = ?," + " bairro = ?,"
					+ " cidade = ?," + " estado = ?," + " cep = ? " + "where fkcpf = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(endDAO.url, endDAO.driver, endDAO.login, endDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, logradouro);
			comando.setString(2, numero);
			comando.setString(3, complemento);
			comando.setString(4, bairro);
			comando.setString(5, cidade);
			comando.setString(6, estado);
			comando.setString(7, cep);
			comando.setString(8, fkcpf);

			// Comando executado
			comando.executeUpdate();
			comando.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return endereco;
	}

	public static Endereco buscarEndereco(String cpf) {
		Endereco endereco = null;

		EnderecoDAO endDAO = new EnderecoDAO();
		try {
			// Criação do select
			String sql = "select * from endereco where fkcpf = ? ";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(endDAO.url, endDAO.driver, endDAO.login, endDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cpf);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				endereco = new Endereco(rs.getString("idEndereco"), rs.getString("logradouro"), rs.getString("numero"),
						rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"),
						rs.getString("estado"), rs.getString("cep"));

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return endereco;
	}

}
