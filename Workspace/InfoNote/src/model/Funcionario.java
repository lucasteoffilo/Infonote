package model;

public class Funcionario extends Usuario implements IUsuario {

	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private double salario;
	private String dataContratado;
	private String funcao;

	public Funcionario() {
		super();
	}

	public Funcionario(String login, String senha, int tipo, String cpf, String nome, String email, String telefone,
			double salario, String dataContratado, String funcao) {
		super(login, senha, tipo);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.salario = salario;
		this.dataContratado = dataContratado;
		this.funcao = funcao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDataContratado() {
		return dataContratado;
	}

	public void setDataContratado(String dataContratado) {
		this.dataContratado = dataContratado;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public boolean validarLogin(String login, String senha) {
		return false;
	}

}
