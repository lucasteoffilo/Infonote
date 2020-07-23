package view.CLI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class TelaCadastroCliente extends JFrame {
	public static final String getTextField_11 = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JButton btnSair = new JButton("<");
	private JLabel lblNome = new JLabel("Nome:");
	private JLabel lblTelefone = new JLabel("Telefone:");
	private JLabel lblNewLabel = new JLabel("E-mail:");
	private JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio:");
	private JLabel lblSenha = new JLabel("Senha:");
	private JSeparator separator = new JSeparator();
	private JLabel lblpreenchaTodosOs = new JLabel("*Preencha todos os campos.");
	private JLabel lblCadastroDeUsurio = new JLabel("CADASTRO DE CLIENTE");
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JLabel lblEndereo = new JLabel("CEP:");
	private JLabel lblNumero = new JLabel("Logradouro:");
	private JLabel lblCep = new JLabel("Estado:");
	private JLabel lblCpf = new JLabel("CPF:");
	private JLabel lblComplemento = new JLabel("Numero:");
	private JLabel lblBairro = new JLabel("Complemento:");
	private JLabel lblCidade = new JLabel("Bairro:");
	private JLabel lblEstado = new JLabel("Cidade:");
	String dado;
	String[] estados = { "N/A", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
			"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox comboBox = new JComboBox(estados);
	private final JSeparator separator_1 = new JSeparator();

	public TelaCadastroCliente() throws HeadlessException {
		super("Cadastro");

		getContentPane().setLayout(null);

		lblNome.setBounds(29, 114, 46, 14);
		getContentPane().add(lblNome);

		lblTelefone.setBounds(29, 139, 56, 14);
		getContentPane().add(lblTelefone);

		lblNewLabel.setBounds(29, 164, 46, 14);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1.setBounds(430, 114, 99, 14);
		getContentPane().add(lblNewLabel_1);

		lblSenha.setBounds(430, 139, 99, 14);
		getContentPane().add(lblSenha);

		textField = new JTextField();
		textField.setBounds(116, 111, 247, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		try {
			textField_1 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textField_1.setColumns(10);
		textField_1.setBounds(116, 136, 247, 20);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 161, 247, 20);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(539, 111, 205, 20);
		getContentPane().add(textField_3);

		separator.setBounds(0, 407, 794, 9);
		getContentPane().add(separator);

		lblpreenchaTodosOs.setForeground(Color.GRAY);
		lblpreenchaTodosOs.setBackground(Color.WHITE);
		lblpreenchaTodosOs.setBounds(29, 71, 182, 14);
		getContentPane().add(lblpreenchaTodosOs);

		lblCadastroDeUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroDeUsurio.setBounds(79, 13, 195, 23);
		getContentPane().add(lblCadastroDeUsurio);

		btnCadastrar.setBounds(303, 427, 182, 23);
		getContentPane().add(btnCadastrar);

		btnSair.setBounds(23, 13, 46, 23);
		getContentPane().add(btnSair);

		passwordField = new JPasswordField();
		passwordField.setBounds(539, 136, 205, 20);
		getContentPane().add(passwordField);

		lblEndereo.setBounds(29, 340, 119, 14);
		getContentPane().add(lblEndereo);

		try {
			textField_4 = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textField_4.setColumns(10);
		textField_4.setBounds(116, 337, 247, 20);
		getContentPane().add(textField_4);

		lblNumero.setBounds(29, 214, 119, 14);
		getContentPane().add(lblNumero);

		lblComplemento.setBounds(29, 239, 119, 14);
		getContentPane().add(lblComplemento);

		lblBairro.setBounds(29, 264, 125, 14);
		getContentPane().add(lblBairro);

		lblCidade.setBounds(29, 289, 63, 14);
		getContentPane().add(lblCidade);

		lblEstado.setBounds(29, 314, 63, 14);
		getContentPane().add(lblEstado);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(116, 211, 247, 20);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(116, 236, 247, 20);
		getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(116, 261, 247, 20);
		getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(116, 286, 247, 20);
		getContentPane().add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(116, 311, 247, 20);
		getContentPane().add(textField_9);

		lblCep.setBounds(29, 365, 63, 14);
		getContentPane().add(lblCep);

		try {
			textField_11 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textField_11.setBounds(116, 186, 247, 20);
		getContentPane().add(textField_11);

		lblCpf.setBounds(29, 189, 46, 14);
		getContentPane().add(lblCpf);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				JComboBox o = (JComboBox) e.getSource();
				dado = (String) o.getSelectedItem();
			}
		});
		comboBox.setBounds(116, 365, 46, 22);
		getContentPane().add(comboBox);
		separator_1.setBounds(0, 51, 794, 9);

		getContentPane().add(separator_1);

		setSize(800, 500);
		setResizable(false);
		setLocationRelativeTo(null);
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

	public void addVoltarListener(ActionListener VoltarListener) {
		btnSair.addActionListener(VoltarListener);
	}

	public void addCadastrarListener(ActionListener CadastrarListener) {
		btnCadastrar.addActionListener(CadastrarListener);
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

	public String getComboBox() {
		String texto = dado;
		return texto;
	}

	public String getTextField_11() {
		String texto = textField_11.getText();
		return texto;
	}

	public String getPasswordField() {
		String senha = String.valueOf(passwordField.getPassword());
		return senha;
	}

	public void setTextField(String textField) {
		this.textField.setText(textField);
		;
	}

	public void setTextField_1(String textField) {
		this.textField_1.setText(textField);
		;
	}

	public void setTextField_2(String textField) {
		this.textField_2.setText(textField);
		;
	}

	public void setTextField_3(String textField) {
		this.textField_3.setText(textField);
		;
	}

	public void setPasswordField(String passwordField) {
		this.passwordField.setText(passwordField);
	}

	public void setTextField_4(String textField) {
		this.textField_4.setText(textField);
		;
	}

	public void setTextField_5(String textField) {
		this.textField_5.setText(textField);
		;
	}

	public void setTextField_6(String textField) {
		this.textField_6.setText(textField);
		;
	}

	public void setTextField_7(String textField) {
		this.textField_7.setText(textField);
		;
	}

	public void setTextField_8(String textField) {
		this.textField_8.setText(textField);
		;
	}

	public void setTextField_9(String textField) {
		this.textField_9.setText(textField);
		;
	}

	public void setTextField_11(String textField) {
		this.textField_11.setText(textField);
		;
	}

	public void setCpfErro() {
		JOptionPane.showMessageDialog(null, "CPF já cadastrado");
	}

	public void setCamposErro() {
		JOptionPane.showMessageDialog(null, "Preencha todos os campos");
	}

	public void setUsuarioErro() {
		JOptionPane.showMessageDialog(null, "Usuario já cadastrado");
	}

	public boolean setCadastroRealizado() {
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		return true;
	}

	public void setEmailInvalido() {
		JOptionPane.showMessageDialog(null, "Email Inválido");
	}

	public void setEstadoInvalido() {
		JOptionPane.showMessageDialog(null, "Estado Inválido");
	}
}
