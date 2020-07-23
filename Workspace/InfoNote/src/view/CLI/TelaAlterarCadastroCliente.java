package view.CLI;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;

@SuppressWarnings("serial")
public class TelaAlterarCadastroCliente extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel label_3 = new JLabel("Usu\u00E1rio:");
	String dado;
	String[] estados = { "N/A", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
			"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	JButton btnVoltar = new JButton("Voltar");
	JLabel label_1 = new JLabel("Telefone:");
	JLabel label_2 = new JLabel("E-mail:");
	JLabel label_4 = new JLabel("Senha:");
	JLabel label = new JLabel("Nome:");
	JLabel label_11 = new JLabel("Estado:");
	JLabel label_5 = new JLabel("CEP:");
	JLabel label_6 = new JLabel("Logradouro:");
	JLabel label_7 = new JLabel("Numero:");
	JLabel label_8 = new JLabel("Complemento:");
	JLabel label_9 = new JLabel("Bairro:");
	JLabel label_10 = new JLabel("Cidade:");
	JLabel label_12 = new JLabel("CPF:");
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox comboBox = new JComboBox(estados);
	JButton btnAlterarDados = new JButton("Alterar Dados");
	JSeparator separator = new JSeparator();
	JLabel lblAlterarCadastro = new JLabel("Alterar cadastro");
	private JTextField textField_8;
	private JTextField textField_9 = new JTextField();
	private JTextField textField_10 = new JTextField();

	public TelaAlterarCadastroCliente() throws HeadlessException {
		super("Alterar Cadastro");
		getContentPane().setLayout(null);

		label.setBounds(227, 197, 46, 14);
		getContentPane().add(label);

		label_1.setBounds(227, 222, 56, 14);
		getContentPane().add(label_1);

		label_2.setBounds(227, 247, 46, 14);
		getContentPane().add(label_2);

		label_3.setBounds(745, 200, 99, 14);
		getContentPane().add(label_3);

		label_4.setBounds(745, 225, 99, 14);
		getContentPane().add(label_4);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(314, 194, 247, 20);
		getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(314, 244, 247, 20);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(854, 197, 205, 20);
		getContentPane().add(textField_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(854, 222, 205, 20);
		getContentPane().add(passwordField);

		label_5.setBounds(227, 423, 119, 14);
		getContentPane().add(label_5);

		label_6.setBounds(227, 297, 119, 14);
		getContentPane().add(label_6);

		label_7.setBounds(227, 322, 119, 14);
		getContentPane().add(label_7);

		label_8.setBounds(227, 347, 125, 14);
		getContentPane().add(label_8);

		label_9.setBounds(227, 372, 63, 14);
		getContentPane().add(label_9);

		label_10.setBounds(227, 397, 63, 14);
		getContentPane().add(label_10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(314, 294, 247, 20);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(314, 319, 247, 20);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(314, 344, 247, 20);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(314, 369, 247, 20);
		getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(314, 394, 247, 20);
		getContentPane().add(textField_7);

		label_11.setBounds(227, 448, 63, 14);
		getContentPane().add(label_11);

		label_12.setBounds(227, 272, 46, 14);
		getContentPane().add(label_12);

		comboBox.setBounds(314, 448, 46, 22);
		getContentPane().add(comboBox);

		separator.setBounds(0, 634, 1264, 9);
		getContentPane().add(separator);

		btnAlterarDados.setBounds(635, 654, 138, 23);
		getContentPane().add(btnAlterarDados);

		btnVoltar.setBounds(487, 654, 138, 23);
		getContentPane().add(btnVoltar);

		lblAlterarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlterarCadastro.setBounds(58, 11, 125, 50);
		getContentPane().add(lblAlterarCadastro);

		textField_8 = new JTextField();
		try {
			textField_8 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textField_8.setColumns(10);
		textField_8.setBounds(314, 219, 247, 20);
		getContentPane().add(textField_8);
		textField_9.setColumns(10);
		try {
			textField_9 = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();

		}
		textField_9.setBounds(314, 420, 247, 20);

		getContentPane().add(textField_9);
		textField_10.setColumns(10);
		try {
			textField_10 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textField_10.setEnabled(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textField_10.setBounds(314, 269, 247, 20);

		getContentPane().add(textField_10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 72, 1264, 9);
		getContentPane().add(separator_1);

		setSize(1280, 739);
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

	}

	public void setTextField(String s) {
		textField.setText(s);
	}

	public void setTextField_1(String s) {
		textField_1.setText(s);
	}

	public void setTextField_2(String string) {
		textField_2.setText(string);
	}

	public String getPasswordField() {
		String senha = String.valueOf(passwordField.getPassword());
		return senha;
	}

	public void setPasswordField(String passwordField) {
		this.passwordField.setText(passwordField);
	}

	public void setTextField_3(String string) {
		textField_3.setText(string);
	}

	public void setTextField_4(String string) {
		textField_4.setText(string);
	}

	public void setTextField_5(String string) {
		textField_5.setText(string);
	}

	public void setTextField_6(String string) {
		textField_6.setText(string);
	}

	public void setTextField_7(String string) {
		textField_7.setText(string);
	}

	public void setTextField_9(String string) {
		textField_9.setText(string);
	}

	public void setTextField_10(String string) {
		textField_10.setText(string);
	}

	public void setTextField_8(String string) {
		textField_8.setText(string);
	}

	public String getTextField() {
		String texto = textField.getText();
		return texto;
	}

	public String getTextField_1() {
		String texto = textField_1.getText();
		return texto;
	}

	public String getTextField_2() {
		String texto = textField_2.getText();
		return texto;
	}

	public String getTextField_3() {
		String texto = textField_3.getText();
		return texto;
	}

	public String getTextField_4() {
		String texto = textField_4.getText();
		return texto;
	}

	public String getTextField_5() {
		String texto = textField_5.getText();
		return texto;
	}

	public String getTextField_6() {
		String texto = textField_6.getText();
		return texto;
	}

	public String getTextField_7() {
		String texto = textField_7.getText();
		return texto;
	}

	public String getTextField_8() {
		String texto = textField_8.getText();
		return texto;
	}

	public String getTextField_9() {
		String texto = textField_9.getText();
		return texto;
	}

	public String getTextField_10() {
		String texto = textField_10.getText();
		return texto;
	}

	public JLabel getLabel_3() {
		return label_3;
	}

	public void setLabel_3(JLabel label_3) {
		this.label_3 = label_3;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JLabel getLabel_1() {
		return label_1;
	}

	public void setLabel_1(JLabel label_1) {
		this.label_1 = label_1;
	}

	public JLabel getLabel_2() {
		return label_2;
	}

	public void setLabel_2(JLabel label_2) {
		this.label_2 = label_2;
	}

	public JLabel getLabel_4() {
		return label_4;
	}

	public void setLabel_4(JLabel label_4) {
		this.label_4 = label_4;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getLabel_11() {
		return label_11;
	}

	public void setLabel_11(JLabel label_11) {
		this.label_11 = label_11;
	}

	public JLabel getLabel_5() {
		return label_5;
	}

	public void setLabel_5(JLabel label_5) {
		this.label_5 = label_5;
	}

	public JLabel getLabel_6() {
		return label_6;
	}

	public void setLabel_6(JLabel label_6) {
		this.label_6 = label_6;
	}

	public JLabel getLabel_7() {
		return label_7;
	}

	public void setLabel_7(JLabel label_7) {
		this.label_7 = label_7;
	}

	public JLabel getLabel_8() {
		return label_8;
	}

	public void setLabel_8(JLabel label_8) {
		this.label_8 = label_8;
	}

	public JLabel getLabel_9() {
		return label_9;
	}

	public void setLabel_9(JLabel label_9) {
		this.label_9 = label_9;
	}

	public JLabel getLabel_10() {
		return label_10;
	}

	public void setLabel_10(JLabel label_10) {
		this.label_10 = label_10;
	}

	public JLabel getLabel_12() {
		return label_12;
	}

	public void setLabel_12(JLabel label_12) {
		this.label_12 = label_12;
	}

	public String getComboBox() {
		String c = (String) comboBox.getSelectedItem();
		return c;
	}

	public void setComboBox(String s) {
		comboBox.setSelectedItem(s);
	}

	public JButton getBtnAlterarDados() {
		return btnAlterarDados;
	}

	public void setBtnAlterarDados(JButton btnAlterarDados) {
		this.btnAlterarDados = btnAlterarDados;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public JLabel getLblAlterarCadastro() {
		return lblAlterarCadastro;
	}

	public void setLblAlterarCadastro(JLabel lblAlterarCadastro) {
		this.lblAlterarCadastro = lblAlterarCadastro;
	}

	public void addVoltarAlteracaoListener(ActionListener VoltarListener) {
		btnVoltar.addActionListener(VoltarListener);
	}

	public void updateListener(ActionListener VoltarListener) {
		btnAlterarDados.addActionListener(VoltarListener);
	}

	public void alertarSenhaEmBranco() {
		JOptionPane.showMessageDialog(null, "Insira a senha");
	}

	public void sucesso() {
		JOptionPane.showMessageDialog(null, "Alteração concluída");
	}
}
