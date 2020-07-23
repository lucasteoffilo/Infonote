package view.CLI;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TelaLoginCliente extends JFrame {
	private JPasswordField passwordField;
	private JLabel lblLogin = new JLabel("Usu\u00E1rio:");
	private JButton btnCadastro = new JButton("Cadastro");
	private JLabel lblSenha = new JLabel("Senha:");
	private JButton btnLogin = new JButton("Entrar");
	private JTextField textField;

	public TelaLoginCliente() throws HeadlessException {
		super("Login");

		getContentPane().setLayout(null);

		lblLogin.setBounds(253, 143, 268, 14);
		getContentPane().add(lblLogin);

		lblSenha.setBounds(253, 199, 268, 14);
		getContentPane().add(lblSenha);

		btnCadastro.setBounds(402, 270, 89, 23);
		getContentPane().add(btnCadastro);

		passwordField = new JPasswordField();
		passwordField.setBounds(253, 224, 268, 20);
		getContentPane().add(passwordField);

		btnLogin.setBounds(287, 270, 89, 23);
		getContentPane().add(btnLogin);

		textField = new JTextField();
		textField.setBounds(253, 168, 268, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

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

	public String getPasswordField() {
		String senha = String.valueOf(passwordField.getPassword());
		return senha;
	}

	public String getTextField() {
		String texto = textField.getText();
		return texto;
	}

	public void setPasswordField(String passwordField) {
		this.passwordField.setText(passwordField);
	}

	public void setTextField(String textField) {
		this.textField.setText(textField);
		;
	}

	public void setErroAoProcurarUsuario() {
		JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto(a)");
	}

	public void addCadastroListener(ActionListener CadastroListener) {
		btnCadastro.addActionListener(CadastroListener);
	}

	public void addLoginListener(ActionListener LoginListener) {
		btnLogin.addActionListener(LoginListener);
	}

}
