package model;

public class Cliente extends Usuario implements IUsuario {

	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private Endereco enderecos[];
	private boolean pedido;

	public Cliente() {
		super();

	}

	public Cliente(String login, String senha, int tipo, String cpf, String nome, String email, String telefone,
			Endereco[] enderecos) {
		super(login, senha, tipo);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.enderecos = enderecos;
	}

	public boolean validarLogin(String login, String senha) {
		return false;
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

	public Endereco[] getEnderecos() {

		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}

	public boolean isPedido() {
		return pedido;
	}

	public void setPedido(boolean pedido) {
		this.pedido = pedido;
	}

	public String getNomeCliente(Cliente cliente) {
		String nome, sobrenome;

		int posicao = getNome().indexOf(" ");
		nome = getNome().substring(0, posicao);

		posicao = getNome().lastIndexOf(" ");
		sobrenome = getNome().substring(posicao + 1);

		return nome + sobrenome;
	}

}
