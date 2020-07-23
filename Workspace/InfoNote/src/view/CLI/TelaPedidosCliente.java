package view.CLI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSeparator;

import controller.ControleCliente;
import model.ItemDePedido;
import model.Pagamento;
import model.Pedido;
import model.DAO.ItemDePedidoDAO;
import model.DAO.PagamentoDAO;
import model.DAO.PedidoDAO;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class TelaPedidosCliente extends JFrame {

	int numeroDePedido = 0;
	int i = 0;

	Pagamento pagamento = null;
	Pedido pedido = null;
	List<ItemDePedido> itens = new ArrayList<ItemDePedido>();

	NumberFormat f = NumberFormat.getCurrencyInstance();

	// Componentes do painel de status
	JLabel lblStatusDePagamento = new JLabel("Status de pagamento:");
	JLabel lblTotal = new JLabel("Total:");
	JLabel lblDataDeAprovao = new JLabel("Data de aprova\u00E7\u00E3o:");
	JLabel lblEndereoDeEntrega = new JLabel("Endere\u00E7o de entrega:");
	JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
	JLabel lblDataDeEmisso = new JLabel("Data de emiss\u00E3o:");
	JLabel varTotal = new JLabel("Sem dados");
	JLabel varStatus = new JLabel("Sem dados");
	JLabel varAprovacao = new JLabel("-- / -- / ----");
	JLabel varEmissao = new JLabel("Sem dados");
	JLabel varLogradouro = new JLabel("Logradouro");
	JLabel varSituacao = new JLabel("Sem dados");
	JLabel varCidade = new JLabel("Cidade");
	JLabel varBairro = new JLabel("Bairro");
	JLabel label_4 = new JLabel("....................................................................................");
	JLabel label = new JLabel("....................................................................................");
	JLabel lblNmeroDePedido = new JLabel("N\u00FAmero de pedido:");
	JLabel varNumPed = new JLabel("Sem dados");

	// Componentes do painel que exibe os itens
	JScrollPane scrItemDePedido = new JScrollPane();
	JPanel painelItemDePedido = new JPanel(new GridLayout(10000, 1));

	// Componentes do painel que exibe os pedidos
	@SuppressWarnings("unused")
	JButton[] botoes = new JButton[ControleCliente.metodoContarPedidos()];
	JPanel painelInformacoes = new JPanel(new GridLayout(5, 1));
	JScrollPane scrPedidos = new JScrollPane();
	JPanel panel = new JPanel();
	JLabel titulo = new JLabel();
	JLabel preco = new JLabel();
	JLabel lblTitulo = new JLabel("Meus Pedidos:");
	JPanel painelPedidos = new JPanel(new GridLayout(10000, 1));

	// Componentes do JFrame
	JButton btnVoltar = new JButton("Voltar");
	JSeparator separator = new JSeparator();
	JSeparator separator_1 = new JSeparator();
	JLabel lblAquiVocEncontra = new JLabel("Aqui voc\u00EA encontra todos seus pedidos efetuados anteriormente.");

	public TelaPedidosCliente() throws HeadlessException {
		super("Pedidos Realizados");
		getContentPane().setLayout(null);

		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(28, 22, 498, 25);
		getContentPane().add(lblTitulo);
		scrPedidos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scrPedidos.setBounds(10, 106, 385, 523);
		getContentPane().add(scrPedidos);

		scrPedidos.setColumnHeaderView(painelPedidos);

		scrItemDePedido.setBounds(405, 106, 487, 523);
		getContentPane().add(scrItemDePedido);

		scrItemDePedido.setColumnHeaderView(painelItemDePedido);

		btnVoltar.setBounds(587, 664, 107, 25);
		getContentPane().add(btnVoltar);

		separator.setBounds(0, 83, 1270, 24);
		getContentPane().add(separator);
		separator_1.setBounds(0, 645, 1270, 14);

		getContentPane().add(separator_1);
		lblAquiVocEncontra.setForeground(Color.GRAY);
		lblAquiVocEncontra.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblAquiVocEncontra.setBounds(28, 58, 507, 14);

		getContentPane().add(lblAquiVocEncontra);

		panel.setBounds(902, 106, 352, 523);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblStatusDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStatusDePagamento.setBounds(10, 11, 133, 20);
		panel.add(lblStatusDePagamento);

		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(10, 492, 46, 20);
		panel.add(lblTotal);

		lblDataDeAprovao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeAprovao.setBounds(10, 42, 133, 20);
		panel.add(lblDataDeAprovao);

		lblEndereoDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEndereoDeEntrega.setBounds(10, 162, 133, 20);
		panel.add(lblEndereoDeEntrega);

		lblSituao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSituao.setBounds(10, 131, 133, 20);
		panel.add(lblSituao);

		lblDataDeEmisso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeEmisso.setBounds(10, 73, 133, 20);
		panel.add(lblDataDeEmisso);

		varTotal.setFont(new Font("Tahoma", Font.ITALIC, 12));
		varTotal.setBounds(64, 497, 278, 14);
		panel.add(varTotal);

		varStatus.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varStatus.setBounds(153, 15, 189, 14);
		panel.add(varStatus);

		varAprovacao.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varAprovacao.setBounds(153, 46, 189, 14);
		panel.add(varAprovacao);

		varEmissao.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varEmissao.setBounds(153, 77, 189, 14);
		panel.add(varEmissao);

		varLogradouro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varLogradouro.setBounds(153, 166, 189, 14);
		panel.add(varLogradouro);

		varSituacao.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varSituacao.setBounds(153, 135, 189, 14);
		panel.add(varSituacao);

		label_4.setBounds(10, 104, 332, 14);
		panel.add(label_4);

		varBairro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varBairro.setBounds(153, 191, 189, 14);
		panel.add(varBairro);

		varCidade.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varCidade.setBounds(153, 216, 189, 14);
		panel.add(varCidade);

		label.setBounds(10, 241, 332, 14);
		panel.add(label);

		lblNmeroDePedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNmeroDePedido.setBounds(10, 266, 133, 20);
		panel.add(lblNmeroDePedido);

		varNumPed.setFont(new Font("Tahoma", Font.ITALIC, 11));
		varNumPed.setBounds(153, 270, 189, 14);
		panel.add(varNumPed);

		setResizable(false);
		setSize(1280, 739);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sa�da",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					repaint();
				}

			}

		});

		panel.setVisible(false);

	}

	public void construirProdutos(int numPedido, double precoPedido) {
		painelInformacoes = new JPanel(new GridLayout(5, 1));
		titulo = new JLabel();
		titulo.setFont(new Font("", Font.BOLD, 15));
		titulo.setText("#" + String.valueOf(numPedido));

		preco = new JLabel();
		preco.setFont(new Font("Comprar", Font.PLAIN, 15));
		preco.setText("Total: " + String.valueOf(f.format(precoPedido)));

		JButton botaoVer = new JButton();
		botaoVer.setText("Visualizar");
		botaoVer.setFont(new Font("", Font.PLAIN, 13));
		botaoVer.setActionCommand(String.valueOf(numPedido));
		botaoVer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton bt = (JButton) arg0.getSource();
				numeroDePedido = Integer.valueOf(bt.getActionCommand());
				painelItemDePedido.removeAll();
				painelItemDePedido.setVisible(false);
				painelItemDePedido.setVisible(true);
				itens.clear();

				pagamento = PagamentoDAO.buscarPagamento(numeroDePedido);
				itens = ItemDePedidoDAO.buscarPorNumDePedido(numeroDePedido);
				pedido = PedidoDAO.buscarPorNumPedido(numeroDePedido);

				for (ItemDePedido itemDePedido : itens) {

					JLabel labelProduto = new JLabel();
					labelProduto.setFont(new Font("", Font.BOLD, 12));
					labelProduto.setText("Produto: " + itemDePedido.getNotebook().getDescricao());
					JLabel labelQtde = new JLabel();
					labelQtde.setFont(new Font("", Font.PLAIN, 12));
					labelQtde.setText("Quantidade: " + itemDePedido.getQtde());
					JLabel labelSubtotal = new JLabel();
					labelSubtotal.setFont(new Font("", Font.PLAIN, 12));
					labelSubtotal
							.setText("Valor Unitario: " + String.valueOf(f.format(itemDePedido.getValorUnitario())));
					JSeparator separadorCompra = new JSeparator();
					JLabel branco = new JLabel("");
					panel.setVisible(true);
					painelItemDePedido.add(labelProduto, BorderLayout.NORTH);
					painelItemDePedido.add(labelQtde, BorderLayout.NORTH);
					painelItemDePedido.add(labelSubtotal, BorderLayout.NORTH);
					painelItemDePedido.add(branco, BorderLayout.NORTH);
					painelItemDePedido.add(separadorCompra, BorderLayout.NORTH);
					scrItemDePedido.setViewportView(painelItemDePedido);
				}

				painelItemDePedido.setVisible(true);
				if (pagamento.getDataAprovado() == null) {
					varStatus.setText("Pendente");
					varAprovacao.setText("-- / -- / ----");
				} else {
					varStatus.setText("Aprovado");
					varAprovacao.setText("" + pagamento.getDataAprovado());
				}

				varEmissao.setText("" + pedido.getDataEmissao());
				varLogradouro.setText("" + ControleCliente.getLogradouro());
				varBairro.setText("" + ControleCliente.getBairro());
				varCidade.setText("" + ControleCliente.getCidade());
				varSituacao.setText("" + pedido.getSituacao());
				varNumPed.setText("" + numPedido);
				varTotal.setText("" + String.valueOf(f.format(pedido.getValorTotal())));

			}
		});

		JLabel espaco = new JLabel(" ");
		espaco.setFont(new Font("Comprar", Font.PLAIN, 4));

		painelInformacoes.add(titulo);
		painelInformacoes.add(preco);
		painelInformacoes.add(botaoVer);
		painelPedidos.add(painelInformacoes);
		painelPedidos.setSize(518, 100);
		scrPedidos.getVerticalScrollBar().setUnitIncrement(12);
		scrItemDePedido.getVerticalScrollBar().setUnitIncrement(12);
		scrPedidos.setViewportView(painelPedidos);
	}

	public void addVoltarListener(ActionListener Listener) {
		btnVoltar.addActionListener(Listener);
	}

	public void renovarPedidos() {
		painelPedidos.removeAll();
	}

	public void reset() {
		painelItemDePedido.removeAll();
		panel.setVisible(false);
	}

	public void resetLogout() {
		painelItemDePedido.removeAll();
		panel.setVisible(false);
		painelInformacoes.removeAll();
	}
}
