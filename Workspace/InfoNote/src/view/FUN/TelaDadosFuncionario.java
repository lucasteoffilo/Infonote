package view.FUN;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TelaDadosFuncionario extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JFormattedTextField formattedTextField = new JFormattedTextField((AbstractFormatter) null);
	private JFormattedTextField formattedTextField_1 = new JFormattedTextField((AbstractFormatter) null);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox comboBox = new JComboBox(new Object[] {});

	JLabel label = new JLabel("Nome:");
	JLabel label_1 = new JLabel("CPF:");
	JLabel label_2 = new JLabel("Telefone:");
	JLabel label_3 = new JLabel("E-mail:");
	JLabel label_4 = new JLabel("Fun\u00E7\u00E3o:");
	JLabel label_5 = new JLabel("Usu\u00E1rio:");
	JLabel label_6 = new JLabel("Senha:");
	JSeparator separator = new JSeparator();
	JSeparator separator_1 = new JSeparator();
	JLabel lblApenasAdministaradoresPodem = new JLabel("Apenas administaradores podem alterar os dados.");
	JLabel lblNewLabel = new JLabel("Dados do Funcion\u00E1rio");
	JButton btnVoltar = new JButton("Voltar");

	public TelaDadosFuncionario() throws HeadlessException {
		super("Dados do funcionário");

		setSize(1280, 739);
		setLocation(290, 120);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		label.setBounds(465, 216, 46, 14);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(552, 213, 247, 20);
		getContentPane().add(textField);

		label_1.setBounds(465, 244, 46, 14);
		getContentPane().add(label_1);

		formattedTextField.setEditable(false);
		formattedTextField.setBounds(552, 241, 247, 20);
		getContentPane().add(formattedTextField);

		label_2.setBounds(465, 272, 56, 14);
		getContentPane().add(label_2);

		formattedTextField_1.setEditable(false);
		formattedTextField_1.setColumns(10);
		formattedTextField_1.setBounds(552, 269, 247, 20);
		getContentPane().add(formattedTextField_1);

		label_3.setBounds(465, 303, 46, 14);
		getContentPane().add(label_3);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(552, 300, 247, 20);
		getContentPane().add(textField_1);

		label_4.setBounds(463, 331, 63, 14);
		getContentPane().add(label_4);

		comboBox.setEnabled(false);
		comboBox.setBounds(550, 331, 129, 22);
		getContentPane().add(comboBox);

		label_5.setBounds(463, 435, 99, 14);
		getContentPane().add(label_5);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(552, 432, 205, 20);
		getContentPane().add(textField_2);

		label_6.setBounds(463, 460, 99, 14);
		getContentPane().add(label_6);

		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setBounds(552, 457, 205, 20);
		getContentPane().add(passwordField);

		separator.setBounds(0, 647, 1274, 14);
		getContentPane().add(separator);

		separator_1.setBounds(0, 65, 1274, 21);
		getContentPane().add(separator_1);

		lblApenasAdministaradoresPodem.setForeground(Color.GRAY);
		lblApenasAdministaradoresPodem.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblApenasAdministaradoresPodem.setBounds(463, 485, 336, 14);
		getContentPane().add(lblApenasAdministaradoresPodem);

		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 11, 306, 43);
		getContentPane().add(lblNewLabel);

		btnVoltar.setBounds(552, 672, 182, 23);
		getContentPane().add(btnVoltar);
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

	public void addVoltarListener(ActionListener Listener) {
		btnVoltar.addActionListener(Listener);
	}
}
