package view.CLI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;

@SuppressWarnings("serial")
public class TelaFinalizarPedidoCliente extends JFrame {
	double total;
	String dado;
	String[] fp = { "Selecione o pagamento", "Boleto", "Dinheiro", "Depósito bancário" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox comboBox = new JComboBox(fp);

	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	JLabel lblFinalizarOPedido = new JLabel("Finalizar o Pedido");
	JSeparator separator = new JSeparator();
	JLabel lblNome = new JLabel("Nome:");
	JLabel lblNewLabel = new JLabel("e-Mail:");
	JLabel lblTelefone = new JLabel("Telefone:");
	JSeparator separator_1 = new JSeparator();
	JLabel lblFormaDePagamento = new JLabel("Forma de pagamento:");
	JButton btnFinalizar = new JButton("Finalizar");
	JButton btnVoltar = new JButton("Voltar");
	JLabel nomeProduto = new JLabel();
	JLabel qtdeProduto = new JLabel();
	JLabel valorProduto = new JLabel();
	JLabel linha = new JLabel();
	JLabel espaco = new JLabel();
	private NumberFormat f = NumberFormat.getCurrencyInstance();
	private final JLabel lblTotal = new JLabel("TOTAL:");
	private final JLabel lblNa = new JLabel();

	public TelaFinalizarPedidoCliente() throws HeadlessException {
		super("Finalizar o pedido");

		setSize(637, 387);
		setLocationRelativeTo(null);
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
		getContentPane().setLayout(null);

		lblFinalizarOPedido.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFinalizarOPedido.setBounds(217, 11, 161, 24);
		getContentPane().add(lblFinalizarOPedido);

		separator.setBounds(10, 46, 601, 18);
		getContentPane().add(separator);

		lblNome.setBounds(10, 75, 58, 14);
		getContentPane().add(lblNome);

		lblNewLabel.setBounds(10, 100, 58, 14);
		getContentPane().add(lblNewLabel);

		lblTelefone.setBounds(10, 125, 58, 14);
		getContentPane().add(lblTelefone);

		separator_1.setBounds(10, 200, 601, 18);
		getContentPane().add(separator_1);

		lblFormaDePagamento.setBounds(10, 229, 124, 14);
		getContentPane().add(lblFormaDePagamento);

		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(78, 72, 418, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(78, 97, 418, 20);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setEditable(false);
		textFieldTelefone.setBounds(78, 122, 169, 20);
		getContentPane().add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		comboBox.setBounds(142, 225, 185, 22);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				JComboBox o = (JComboBox) e.getSource();
				dado = (String) o.getSelectedItem();
			}
		});
		getContentPane().add(comboBox);

		btnFinalizar.setBounds(316, 317, 89, 23);
		getContentPane().add(btnFinalizar);

		btnVoltar.setBounds(217, 317, 89, 23);
		getContentPane().add(btnVoltar);

		JLabel lblcasoOsDados = new JLabel("*Verifique seus dados antes de concluir o pedido");
		lblcasoOsDados.setBackground(Color.GRAY);
		lblcasoOsDados.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblcasoOsDados.setBounds(10, 151, 603, 14);
		getContentPane().add(lblcasoOsDados);
		lblTotal.setBounds(10, 276, 46, 14);
		getContentPane().add(lblTotal);
		lblNa.setBounds(54, 276, 557, 14);
		getContentPane().add(lblNa);

	}

	public void addVoltarSuporteListener(ActionListener VoltarListener) {
		btnVoltar.addActionListener(VoltarListener);
	}

	public void addFinalizarListener(ActionListener fListener) {
		btnFinalizar.addActionListener(fListener);
	}

	public void setFieldNome(String nome) {
		this.textFieldNome.setText(nome);

	}

	public void setFieldEmail(String e) {
		this.textFieldEmail.setText(e);

	}

	public void setFieldTelefone(String t) {
		this.textFieldTelefone.setText(t);

	}

	public String getComboBox() {
		String texto = dado;
		return texto;
	}

	public void setTotal(double total) {
		lblNa.setText(String.valueOf(f.format(total)));
	}

	public int acionarAlerta() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja mesmo finalizar?");
		return dialogResult;
	}

	public void escolhaPagamento() {
		JOptionPane.showMessageDialog(null, "Escolha uma forma de pagamento.");
	}

	public void confirmacao() {
		JOptionPane.showMessageDialog(null, "Pedido efetuado.");
	}

}
