package view.FUN;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TelaFinalizarPedidoFuncionario extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public TelaFinalizarPedidoFuncionario() throws HeadlessException {
		super("Finalizar");
		setSize(1280, 739);
		setLocation(290, 120);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblFinalizarPedido = new JLabel("Finalizar Pedido");
		lblFinalizarPedido.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblFinalizarPedido.setBounds(27, 11, 306, 43);
		getContentPane().add(lblFinalizarPedido);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 65, 1274, 21);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 647, 1274, 14);
		getContentPane().add(separator_1);
		
		JButton button = new JButton("Voltar");
		button.setBounds(552, 672, 182, 23);
		getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 90, 640, 546);
		getContentPane().add(panel);
		
		JLabel label = new JLabel(" ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(70, 466, 172, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("TOTAL:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(20, 502, 65, 19);
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 602, 456);
		panel.add(scrollPane);
		
		JLabel label_3 = new JLabel("Carrinho:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(20, 11, 142, 14);
		panel.add(label_3);
		
		JLabel lblSemDados = new JLabel("Sem Dados");
		lblSemDados.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblSemDados.setBounds(81, 506, 527, 14);
		panel.add(lblSemDados);
		
		JLabel lblDadosDePagamento = new JLabel("Dados de pagamento:");
		lblDadosDePagamento.setBounds(709, 204, 527, 21);
		getContentPane().add(lblDadosDePagamento);
		lblDadosDePagamento.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblNomeDoCliente = new JLabel("Nome do funcion\u00E1rio");
		lblNomeDoCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNomeDoCliente.setBounds(710, 251, 137, 14);
		getContentPane().add(lblNomeDoCliente);
		
		textField = new JTextField();
		textField.setBounds(857, 249, 375, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoCliente_1 = new JLabel("Nome do cliente:");
		lblNomeDoCliente_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNomeDoCliente_1.setBounds(710, 276, 137, 14);
		getContentPane().add(lblNomeDoCliente_1);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do cliente:");
		lblCpfDoCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCpfDoCliente.setBounds(710, 301, 137, 14);
		getContentPane().add(lblCpfDoCliente);
		
		JLabel lblTelefoneDoCliente = new JLabel("Telefone do cliente:");
		lblTelefoneDoCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTelefoneDoCliente.setBounds(709, 326, 138, 14);
		getContentPane().add(lblTelefoneDoCliente);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(857, 274, 375, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(857, 299, 375, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(857, 324, 375, 20);
		getContentPane().add(textField_3);
		
		JLabel lblEndereoDoCliente = new JLabel("Endere\u00E7o do cliente:");
		lblEndereoDoCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEndereoDoCliente.setBounds(709, 349, 138, 18);
		getContentPane().add(lblEndereoDoCliente);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(857, 349, 375, 20);
		getContentPane().add(textField_4);
		
		JButton btnImprimirRecibo = new JButton("Imprimir Recibo");
		btnImprimirRecibo.setBounds(857, 380, 182, 23);
		getContentPane().add(btnImprimirRecibo);
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
}
