package view.CLI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import model.Cliente;
import model.ItemDePedido;
import model.Notebook;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

import controller.ControleCliente;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class TelaMenuCliente extends JFrame {

	private int i = 0;
	private double total = 0;
	private double subtotal = 0;
	private int qtde = 0;

	private JScrollPane sc_Produtos = new JScrollPane();
	private JPanel painelProdutos = new JPanel(new GridLayout(0, 2));
	private JPanel painelItensDePedido = new JPanel();
	private JLabel ola = new JLabel("Ol\u00E1,");
	private JLabel lblUsuario = new JLabel("Usuario");
	private JLabel lblInformacoes = new JLabel("Adicione produtos no carrinho para compr\u00E1-los");
	private JScrollPane sc_ItemDePedido = new JScrollPane();
	private JButton btnFinalizar = new JButton("Finalizar compra");
	private JLabel lblTotal = new JLabel("TOTAL:");
	private JLabel lblVariavelPreco = new JLabel("N/A");
	private JPanel panelCarrinho = new JPanel(new GridLayout(10000, 1));
	private JLabel lblCarrinho = new JLabel("Carrinho:");
	private JButton btnLogout = new JButton("Sair");
	JMenuBar menuBar = new JMenuBar();
	JMenu mnConta = new JMenu("Conta");
	JMenu mnAjuda = new JMenu("Ajuda");
	JMenuItem mntmAlterarCadastro = new JMenuItem("Alterar Cadastro");
	JMenuItem mntmContato = new JMenuItem("Suporte");
	JMenuItem mntmPedidos = new JMenuItem("Pedidos");
	TelaSuporteCliente sup = new TelaSuporteCliente();

	private NumberFormat f = NumberFormat.getCurrencyInstance();

	private JPanel panelImg = new JPanel();
	private JPanel panelInf = new JPanel();
	private JLabel img = new JLabel();
	private JLabel titulo = new JLabel();
	private JLabel preco = new JLabel();
	private JLabel labelQtde = new JLabel();
	private JButton[] botoes = new JButton[ControleCliente.metodoContar()];
	private JSpinner[] spinners = new JSpinner[ControleCliente.metodoContar()];
	private final JLabel label = new JLabel("InfoNote");
	private final JLabel label_1 = new JLabel("A maior loja de inform\u00E1tica do Brasil");

	// Layout da tela.
	public TelaMenuCliente() throws HeadlessException {
		super("Produtos em Estoque");

		sc_ItemDePedido.getVerticalScrollBar().setUnitIncrement(12);

		sc_Produtos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sc_Produtos.getVerticalScrollBar().setUnitIncrement(12);
		sc_Produtos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sc_Produtos.setBounds(10, 122, 735, 548);
		sc_Produtos.setViewportView(painelProdutos);

		lblInformacoes.setForeground(Color.GRAY);
		lblInformacoes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInformacoes.setBounds(10, 11, 565, 14);

		sc_ItemDePedido.setBounds(10, 55, 479, 435);

		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(10, 511, 65, 14);

		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFinalizar.setBounds(252, 501, 237, 36);

		lblVariavelPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVariavelPreco.setBounds(70, 511, 172, 14);

		painelItensDePedido.setLayout(null);
		painelItensDePedido.setBounds(755, 122, 499, 548);
		painelItensDePedido.add(lblVariavelPreco);
		painelItensDePedido.add(btnFinalizar);
		painelItensDePedido.add(lblTotal);
		painelItensDePedido.add(lblInformacoes);
		painelItensDePedido.add(sc_ItemDePedido);
		getContentPane().setLayout(null);
		getContentPane().add(painelItensDePedido);
		lblCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCarrinho.setBounds(10, 30, 142, 14);

		painelItensDePedido.add(lblCarrinho);
		getContentPane().add(sc_Produtos, BorderLayout.WEST);
		label.setFont(new Font("Dialog", Font.PLAIN, 40));
		label.setBounds(20, 41, 207, 36);

		getContentPane().add(label);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(20, 81, 207, 14);

		getContentPane().add(label_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 99, 1274, 23);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 34, 1274, 14);
		getContentPane().add(separator_1);
		ola.setBounds(20, 9, 26, 14);
		getContentPane().add(ola);

		ola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(49, 9, 142, 14);
		getContentPane().add(lblUsuario);

		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBounds(1165, 7, 89, 23);
		getContentPane().add(btnLogout);

		setSize(1280, 739);
		setLocation(290, 120);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					repaint();
				}
			}
		});

		setJMenuBar(menuBar);

		menuBar.add(mnConta);

		mnConta.add(mntmPedidos);

		mnConta.add(mntmAlterarCadastro);

		menuBar.add(mnAjuda);

		mnAjuda.add(mntmContato);
	}

	// Layout dos produtos importados do BD.
	public void construirProdutos(String imgC, String tituloC, double precoC, Notebook notebook) {
		/*
		 * Será construido 2 paineis 1 para a imagem e outro para informaçoes, spinner e
		 * botao.
		 */

		// painel imagem
		panelImg = new JPanel(new GridLayout(1, 1));
		img = new JLabel();
		img.setIcon(new ImageIcon(imgC));

		// painel informacoes
		panelInf = new JPanel(new GridLayout(6, 0));
		titulo = new JLabel();
		titulo.setFont(new Font("Comprar", Font.PLAIN, 15));
		titulo.setText(tituloC);

		preco = new JLabel();
		preco.setFont(new Font("Comprar", Font.BOLD, 19));
		preco.setText(String.valueOf(f.format(precoC)));

		labelQtde = new JLabel("Quantidade:");

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));

		JButton botao = new JButton();
		botao.setText("Adicionar");
		botao.setFont(new Font("", Font.PLAIN, 13));
		botao.setActionCommand(String.valueOf(i));
		botao.addActionListener(new ActionListener() {

			// Listener do botao comprar
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// Coletando Informaçoes do produto adicionado
				JButton btn = (JButton) arg0.getSource();
				qtde = (int) spinners[Integer.valueOf(btn.getActionCommand())].getValue();
				subtotal = (precoC) * qtde;
				total += subtotal;

				// Criando um ItemDePedido e adicionando-o no carrinho na classe Controle
				ItemDePedido item = ControleCliente.addItemDePedido(qtde, subtotal, notebook);

				// Exibindo Informações do pedido adicionado ao carrinho
				JLabel labelProduto = new JLabel();
				labelProduto.setText("Produto: " + notebook.getDescricao());
				labelProduto.setFont(new Font("", Font.BOLD, 12));
				JLabel labelQtde = new JLabel();
				labelQtde.setText("Unidades: " + qtde);
				labelQtde.setFont(new Font("", Font.PLAIN, 12));
				JLabel labelSubtotal = new JLabel();
				labelSubtotal.setText("Subtotal: " + f.format(subtotal));
				labelSubtotal.setFont(new Font("", Font.PLAIN, 12));
				lblVariavelPreco.setText(String.valueOf(f.format(total)));
				JSeparator separadorCompra = new JSeparator();
				JLabel branco = new JLabel("");
				JButton remover = new JButton("Remover");
				remover.setActionCommand(String.valueOf(subtotal));
				remover.addActionListener(new ActionListener() {

					// Listener do botao remover da sacola
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JButton sbt = (JButton) arg0.getSource();
						double subtracao = Double.valueOf(sbt.getActionCommand());

						// excluindo da List
						ControleCliente.deletarItem(item);

						// excluindo da tela
						panelCarrinho.setVisible(false);
						panelCarrinho.remove(labelProduto);
						panelCarrinho.remove(labelQtde);
						panelCarrinho.remove(labelSubtotal);
						panelCarrinho.remove(remover);
						panelCarrinho.remove(separadorCompra);
						panelCarrinho.remove(branco);
						panelCarrinho.setVisible(true);

						// ajustando o total
						total -= subtracao;
						lblVariavelPreco.setText(String.valueOf(f.format(total)));
					}
				});

				panelCarrinho.add(labelProduto, BorderLayout.NORTH);
				panelCarrinho.add(labelQtde, BorderLayout.NORTH);
				panelCarrinho.add(labelSubtotal, BorderLayout.NORTH);
				panelCarrinho.add(remover, BorderLayout.NORTH);
				panelCarrinho.add(branco, BorderLayout.NORTH);
				panelCarrinho.add(separadorCompra, BorderLayout.NORTH);
				sc_ItemDePedido.setViewportView(panelCarrinho);

			}
		});

		spinners[i] = spinner;
		botoes[i] = botao;
		panelImg.add(img);
		panelInf.add(titulo);
		panelInf.add(preco);
		panelInf.add(labelQtde);
		panelInf.add(spinner);
		panelInf.add(botao);
		painelProdutos.add(panelImg);
		painelProdutos.add(panelInf);
		i++;
	}

	public void addLogoutListener(ActionListener LogoutListener) {
		btnLogout.addActionListener(LogoutListener);
	}

	public void addSuporteListener(ActionListener Listener) {
		mntmContato.addActionListener(Listener);
	}

	public void addAlteracaoListener(ActionListener Listener) {
		mntmAlterarCadastro.addActionListener(Listener);
	}

	public void addPedidosListener(ActionListener Listener) {
		mntmPedidos.addActionListener(Listener);
	}

	public void addFinalizarListener(ActionListener Listener) {
		btnFinalizar.addActionListener(Listener);
	}

	public void acionarConfirmaçaoDePedido() {
		JOptionPane.showConfirmDialog(null, "Deseja finalizar o pedido?");
	}

	public double getTotal() {
		return total;
	}

	// Setando o nome do cliente logado.
	public void setCliente(Cliente cliente) {
		this.lblUsuario.setText(cliente.getNome());
	}

	public void adiconeItens() {
		JOptionPane.showMessageDialog(null, "Adicione itens para finalizar");
	}

	public void renovarMenu() {
		panelCarrinho.removeAll();
		panelCarrinho.setVisible(false);
		panelCarrinho.setVisible(true);
		lblVariavelPreco.setText("N/A");

	}
}
