package view.CLI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaSuporteCliente extends JFrame {
	JLabel lblAjudainfonotecom = new JLabel("E-mail:  contato@infonote.com");
	JLabel lblTelefones = new JLabel("SAC: (21) 4003 - 1228  /  (21) 4003 - 1232");
	JLabel lblEndereo = new JLabel("Rua Francisco, 3000 - Tijuca, Rio de Janeiro");
	JButton btnVoltar = new JButton("Voltar");

	public TelaSuporteCliente() {
		super("Suporte");
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.GRAY);
		getContentPane().setLayout(null);

		lblAjudainfonotecom.setForeground(Color.GRAY);
		lblAjudainfonotecom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAjudainfonotecom.setBounds(39, 175, 178, 11);
		getContentPane().add(lblAjudainfonotecom);

		lblTelefones.setForeground(Color.GRAY);
		lblTelefones.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefones.setBounds(39, 153, 241, 11);
		getContentPane().add(lblTelefones);

		lblEndereo.setForeground(Color.GRAY);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setBounds(39, 131, 228, 11);
		getContentPane().add(lblEndereo);

		JLabel lblSuporte = new JLabel("Suporte:");
		lblSuporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSuporte.setBounds(39, 24, 867, 23);
		getContentPane().add(lblSuporte);

		JLabel lblAquiVocPode = new JLabel("Aqui voc\u00EA pode encontrar nossos dados.");
		lblAquiVocPode.setForeground(Color.GRAY);
		lblAquiVocPode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAquiVocPode.setBounds(39, 58, 867, 14);
		getContentPane().add(lblAquiVocPode);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 83, 1270, 9);
		getContentPane().add(separator_1);

		btnVoltar.setBounds(586, 666, 89, 23);
		getContentPane().add(btnVoltar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 652, 1270, 9);
		getContentPane().add(separator);

		JLabel lblDesenvolvidoPorLucas = new JLabel("Desenvolvido por Lucas Te\u00F3filo");
		lblDesenvolvidoPorLucas.setForeground(Color.GRAY);
		lblDesenvolvidoPorLucas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesenvolvidoPorLucas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesenvolvidoPorLucas.setBounds(519, 604, 228, 23);
		getContentPane().add(lblDesenvolvidoPorLucas);

		JLabel lblVocTambmPode = new JLabel(
				"Voc\u00EA tamb\u00E9m pode pedir ajuda a qualquer um de nossos funcion\u00E1rios em nossa loja f\u00EDsica.");
		lblVocTambmPode.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblVocTambmPode.setForeground(Color.GRAY);
		lblVocTambmPode.setBounds(39, 252, 526, 14);
		getContentPane().add(lblVocTambmPode);

		JLabel lblProjetoSenai = new JLabel("SENAI");
		lblProjetoSenai.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjetoSenai.setForeground(Color.GRAY);
		lblProjetoSenai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProjetoSenai.setBounds(529, 628, 207, 14);
		getContentPane().add(lblProjetoSenai);

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

	public void addVoltarSuporteListener(ActionListener VoltarListener) {
		btnVoltar.addActionListener(VoltarListener);
	}
}
