package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Funcionario;

import util.Conexao;
import util.Configurador;

public class FuncionarioDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public FuncionarioDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Funcionario inserir(String login, String senha, int tipo, String cpf, String nome, String email,
			String telefone, double salario, String dataContratado, String funcao) {
		Funcionario funcionario = null;
		FuncionarioDAO funDAO = new FuncionarioDAO();

		try {
			// Criação do insert
			String sql = "insert into funcionario "
					+ "(cpf, nome, email, telefone, salario, dataContratado, funcao, login) "
					+ "values (?,?,?,?,?,?,?,?)";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(funDAO.url, funDAO.driver, funDAO.login, funDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cpf);
			comando.setString(2, nome);
			comando.setString(3, email);
			comando.setString(4, telefone);
			comando.setDouble(5, salario);
			comando.setString(6, dataContratado);
			comando.setString(7, funcao);
			comando.setString(8, login);
			// não é fklogin, porque aqui a referência é da Classe e não do BD

			// Comando executado
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		funcionario = new Funcionario(login, senha, tipo, cpf, nome, email, telefone, salario, dataContratado, funcao);

		return funcionario;
	}

	public static Funcionario buscarPorLoginSenha(String login, String senha) {
		Funcionario funcionario = null;

		FuncionarioDAO funcDAO = new FuncionarioDAO();
		
		try {
			// Criação do insert
			String sql = "select * from usuario u, cliente c " + "where u.login=c.fklogin and u.login = ? "
					+ "and u.senha = ?";

			// Obter a conexão com o BD
			Conexao conex = new Conexao(funcDAO.url, funcDAO.driver, funcDAO.login, funcDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, login);
			comando.setString(2, senha);
			
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				funcionario = new Funcionario(rs.getString("login"), rs.getString("senha"), rs.getInt("tipo"),
						rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"),
						rs.getDouble("salario"), rs.getString("dataContratado"), rs.getString("funcao"));
			}
			
			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(funcionario);
		return funcionario;
	}
}
