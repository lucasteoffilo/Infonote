package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Funcionario;
import model.ItemDePedido;
import model.Notebook;
import model.Pedido;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.NotebookDAO;
import view.FUN.TelaCadastroFuncionario;
import view.FUN.TelaLoginFuncionario;
import view.FUN.TelaMenuFuncionario;

/*
 * Nesta classe controle, utilizada pelo(a) vendedor(a),
 * é possível ter acesso a ferramentas de compra.
 * Não é possível  cadastrar funcionarios.
 */
public class ControleVendedor {

	private Funcionario funcionario;
	private Endereco endereco;
	boolean aberto = false;

	// Telas instanciadas.
	private TelaCadastroFuncionario telaCadastroFuncionario = new TelaCadastroFuncionario();
	private TelaLoginFuncionario telaLoginFuncionario = new TelaLoginFuncionario();
	private TelaMenuFuncionario telaMenuFuncionario = new TelaMenuFuncionario();

	// Carrinho da loja, onde é armazenado todos os produtos.
	static List<ItemDePedido> itens = new ArrayList<ItemDePedido>();
	// List que armazena todos os notebooks do banco de dados.
	static List<Notebook> notebooks = NotebookDAO.buscarTodos();
	// List que armazena todos os pedidos realizados pelo cliente.
	static List<Pedido> pedidosDoCliente = new ArrayList<Pedido>();

	public ControleVendedor() {

		this.telaLoginFuncionario.addLoginListener(new EntrarMenuListener());
		this.telaLoginFuncionario.setVisible(true);
	}

	public static void main(String[] args) {
		new ControleVendedor();
	}

	class EntrarCadastroListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			telaLoginFuncionario.dispose();
			telaCadastroFuncionario.setVisible(true);
		}

	}

	class EntrarMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				
				funcionario = FuncionarioDAO.buscarPorLoginSenha(telaLoginFuncionario.getCampoLogin(),telaLoginFuncionario.getPasswordField());
				endereco = EnderecoDAO.buscarEndereco(funcionario.getCpf());
				telaMenuFuncionario.setFuncionario(funcionario);
				telaMenuFuncionario.setVisible(true);
				telaLoginFuncionario.dispose();
				telaLoginFuncionario.setPasswordField("");
				telaLoginFuncionario.setTextField("");

				// verificando se os produtos ja foram exbidos anteriormente.
				if (aberto == false) {

					aberto = true;

					for (Notebook notebook : notebooks) {

						String img = notebook.getFigura();
						String titulo = notebook.getDescricao();
						double preco = notebook.getPrecoUnitario();
						telaMenuFuncionario.construirProdutos(img, titulo, preco, notebook);
					}
				}
			} catch (NullPointerException e1) {

				telaLoginFuncionario.setErroAoProcurarUsuario();
			}

		}

	}

}
