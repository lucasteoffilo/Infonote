package view.ADM;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TelaMenuFuncionario extends JFrame {
	private JTextField textField;

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
		
		JLabel label = new JLabel("InfoNote");
		label.setFont(new Font("Dialog", Font.PLAIN, 40));
		label.setBounds(22, 62, 207, 43);
		getContentPane().add(label);
		
		JLabel lblPainelDoFuncionrio = new JLabel("Painel do funcion\u00E1rio");
		lblPainelDoFuncionrio.setForeground(Color.BLACK);
		lblPainelDoFuncionrio.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPainelDoFuncionrio.setBounds(22, 52, 131, 14);
		getContentPane().add(lblPainelDoFuncionrio);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 116, 1274, 23);
		getContentPane().add(separator_1);
		
		JLabel label_1 = new JLabel("Ol\u00E1,");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(22, 11, 26, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Usuario");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(51, 11, 142, 14);
		getContentPane().add(label_2);
		
		JButton button = new JButton("Sair");
		button.setBounds(1158, 9, 89, 23);
		getContentPane().add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 13));
		textField.setBounds(389, 132, 368, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton.setBounds(767, 132, 89, 32);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(748, 175, 499, 525);
		getContentPane().add(panel);
		
		JLabel lblNa = new JLabel(" ");
		lblNa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNa.setBounds(70, 466, 172, 14);
		panel.add(lblNa);
		
		JButton button_1 = new JButton("Finalizar compra");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBounds(252, 466, 237, 36);
		panel.add(button_1);
		
		JLabel label_4 = new JLabel("TOTAL:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(10, 466, 65, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Adicione produtos no carrinho para compr\u00E1-los");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(10, 11, 565, 14);
		panel.add(label_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 479, 400);
		panel.add(scrollPane);
		
		JLabel label_6 = new JLabel("Carrinho:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(10, 30, 142, 14);
		panel.add(label_6);
		
		JLabel label_3 = new JLabel(">>");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		label_3.setBounds(721, 387, 36, 14);
		getContentPane().add(label_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(37, 174, 674, 515);
		getContentPane().add(scrollPane_1);
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
