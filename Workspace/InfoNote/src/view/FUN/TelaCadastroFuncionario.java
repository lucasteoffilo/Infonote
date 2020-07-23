package view.FUN;

import javax.swing.JFrame;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TelaCadastroFuncionario extends JFrame {
	private JTextField varNome;
	private JTextField varEmail;
	private JTextField varUsuario;
	private JPasswordField varPassword;
	private JFormattedTextField varTelefone = new JFormattedTextField((AbstractFormatter) null);
	private JFormattedTextField varCPF;
	private JButton btnVoltar = new JButton("<");
	private JButton btnCadastrar = new JButton("Cadastrar");

	JLabel lblSenha = new JLabel("Senha:");
	JLabel lblCpf = new JLabel("CPF:");
	JSeparator separator_1 = new JSeparator();
	JSeparator separator = new JSeparator();
	JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o:");
	JLabel lblTelefone = new JLabel("Telefone:");
	JLabel lblEmail = new JLabel("E-mail:");
	JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
	JLabel lblCadastroDeFuncionrio = new JLabel("CADASTRO DE FUNCION\u00C1RIO");
	JLabel lblNome = new JLabel("Nome:");

	String dado;
	String[] funcoes = { "Selecione uma função", "Gerente", "Vendedor" };

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox varFuncao = new JComboBox(funcoes);

	public TelaCadastroFuncionario() {
		super("Cadastro");

		lblCadastroDeFuncionrio.setBounds(76, 18, 601, 27);
		lblCadastroDeFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCadastroDeFuncionrio, BorderLayout.NORTH);

		separator.setBounds(0, 56, 784, 21);
		getContentPane().add(separator);

		separator_1.setBounds(0, 417, 784, 7);
		getContentPane().add(separator_1);

		lblNome.setBounds(25, 91, 46, 14);
		getContentPane().add(lblNome);

		varNome = new JTextField();
		varNome.setColumns(10);
		varNome.setBounds(112, 88, 247, 20);
		getContentPane().add(varNome);

		lblCpf.setBounds(25, 119, 46, 14);
		getContentPane().add(lblCpf);

		try {
			varCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		varCPF.setBounds(112, 116, 247, 20);
		getContentPane().add(varCPF);

		try {
			varTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));

		} catch (ParseException e) {
			e.printStackTrace();

		}

		varTelefone.setColumns(10);
		varTelefone.setBounds(112, 144, 247, 20);
		getContentPane().add(varTelefone);

		lblTelefone.setBounds(25, 147, 56, 14);
		getContentPane().add(lblTelefone);

		varEmail = new JTextField();
		varEmail.setColumns(10);
		varEmail.setBounds(112, 175, 247, 20);
		getContentPane().add(varEmail);

		lblEmail.setBounds(25, 178, 46, 14);
		getContentPane().add(lblEmail);

		lblFuncao.setBounds(23, 206, 63, 14);
		getContentPane().add(lblFuncao);

		varFuncao.setBounds(110, 206, 129, 22);
		getContentPane().add(varFuncao);
		varFuncao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				JComboBox o = (JComboBox) e.getSource();
				dado = (String) o.getSelectedItem();
			}
		});

		varUsuario = new JTextField();
		varUsuario.setColumns(10);
		varUsuario.setBounds(112, 307, 205, 20);
		getContentPane().add(varUsuario);

		lblUsuario.setBounds(23, 310, 99, 14);
		getContentPane().add(lblUsuario);

		lblSenha.setBounds(23, 335, 99, 14);
		getContentPane().add(lblSenha);

		varPassword = new JPasswordField();
		varPassword.setBounds(112, 332, 205, 20);
		getContentPane().add(varPassword);

		btnVoltar.setBounds(20, 19, 46, 23);
		getContentPane().add(btnVoltar);

		btnCadastrar.setBounds(305, 428, 182, 23);
		getContentPane().add(btnCadastrar);

		getContentPane().setLayout(null);
		setSize(800, 500);
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

	public String getVarNome() {
		String texto = varNome.getText();
		return texto;
	}

	public String getVarEmail() {
		String texto = varEmail.getText();
		return texto;
	}

	public String getVarUsuario() {
		String texto = varUsuario.getText();
		return texto;
	}

	public String getVarPassword() {
		String texto = varTelefone.getText();
		return texto;
	}

	public String getVarTelefone() {
		String texto = varTelefone.getText();
		return texto;
	}

	public String getVarCPF() {
		String texto = varCPF.getText();
		return texto;
	}

	public String getVarFuncao() {
		String texto = dado;
		return texto;
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

	public void addVoltarListener(ActionListener VoltarListener) {
		btnVoltar.addActionListener(VoltarListener);
	}

	public void addCadastrarListener(ActionListener CadastrarListener) {
		btnCadastrar.addActionListener(CadastrarListener);
	}

}
