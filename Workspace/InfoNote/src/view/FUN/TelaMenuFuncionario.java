package view.FUN;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.ControleCliente;
import model.Funcionario;
import model.ItemDePedido;
import model.Notebook;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class TelaMenuFuncionario extends JFrame {

	private int i = 0;
	private double total = 0;
	private double subtotal = 0;
	private int qtde = 0;

	private NumberFormat f = NumberFormat.getCurrencyInstance();

	private JTextField textField;
	private JPanel panelImg = new JPanel();
	private JPanel panelInf = new JPanel();
	private JLabel img = new JLabel();
	private JLabel titulo = new JLabel();
	private JLabel preco = new JLabel();
	private JLabel labelQtde = new JLabel();
	private JButton[] botoes = new JButton[ControleCliente.metodoContar()];
	private JSpinner[] spinners = new JSpinner[ControleCliente.metodoContar()];
	JLabel label_2 = new JLabel("Usuario");
	private JLabel lblVariavelPreco = new JLabel("N/A");
	private JPanel panelCarrinho = new JPanel(new GridLayout(10000, 1));
	private JPanel painelProdutos = new JPanel(new GridLayout(0, 2));
	private JScrollPane sc_ItemDePedido = new JScrollPane();

	public TelaMenuFuncionario() throws HeadlessException {
		super();

		setSize(1280, 739);
		setLocation(290, 120);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 37, 1274, 14);
		getContentPane().add(separator);

		JLabel lblInfonote = new JLabel("InfoNote");
		lblInfonote.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblInfonote.setBounds(22, 47, 207, 58);
		getContentPane().add(lblInfonote);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 116, 1274, 23);
		getContentPane().add(separator_1);

		JLabel label_1 = new JLabel("Ol\u00E1,");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(22, 11, 26, 14);
		getContentPane().add(label_1);

		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(51, 11, 142, 14);
		getContentPane().add(label_2);

		JButton button = new JButton("Sair");
		button.setBounds(1158, 9, 89, 23);
		getContentPane().add(button);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 13));
		textField.setBounds(389, 62, 368, 32);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton.setBounds(767, 62, 89, 32);
		getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(646, 133, 618, 546);
		getContentPane().add(panel);

		JLabel lblNa = new JLabel(" ");
		lblNa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNa.setBounds(70, 466, 172, 14);
		panel.add(lblNa);

		JButton button_1 = new JButton("Finalizar compra");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBounds(371, 502, 237, 36);
		panel.add(button_1);

		JLabel label_4 = new JLabel("TOTAL:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(20, 502, 65, 19);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Adicione produtos no carrinho para compr\u00E1-los");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(20, 11, 565, 14);
		panel.add(label_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 55, 588, 437);
		panel.add(scrollPane);

		JLabel label_6 = new JLabel("Carrinho:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(20, 30, 142, 14);
		panel.add(label_6);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 133, 626, 546);
		getContentPane().add(scrollPane_1);

		JLabel lblPainelDoFuncionrio = new JLabel("Painel do funcion\u00E1rio");
		lblPainelDoFuncionrio.setBounds(1118, 62, 129, 32);
		getContentPane().add(lblPainelDoFuncionrio);
		lblPainelDoFuncionrio.setForeground(Color.BLACK);
		lblPainelDoFuncionrio.setFont(new Font("Dialog", Font.PLAIN, 13));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnConta = new JMenu("Conta");
		menuBar.add(mnConta);

		JMenuItem mntmDadosDoFuncionrio = new JMenuItem("Dados do funcion\u00E1rio");
		mnConta.add(mntmDadosDoFuncionrio);
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

	// Setando o nome do funcionario logado.
	public void setFuncionario(Funcionario funcionario) {
		this.label_2.setText(funcionario.getNome());
	}

}
