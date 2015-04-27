package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import model.Cliente;

import controller.ControllerCliente;

public class FormCliente extends JFrame {

	//
	private JPanel contentPane;
	private JTextField textCliente;
	private JTextField textLogradouro;
	private JTextField textCep;
	private JTextField textBairro;
	private JTextField textNumero;
	private JLabel lblN;
	private JLabel lblBairro;
	private JTextField txtSoPaulo;
	private JLabel lblCidade;
	private JTextField textCnpj;
	private JLabel lblCnpj;
	private JSeparator separator;
	private JLabel lblDatasPossveisDe;

	// Checkboxes
	private JCheckBox checkSegunda;
	private JCheckBox checkTerca;
	private JCheckBox checkQuarta;
	private JCheckBox checkQuinta;
	private JCheckBox checkSexta;
	private JCheckBox checkSabado;
	private JCheckBox checkDomingo;

	// Buttons
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JButton btnSair;
	private MaskFormatter mascaraCEP;
	private MaskFormatter mascaraCNPJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try {
		 * FormCliente frame = new FormCliente(); frame.setVisible(true); }
		 * catch (Exception e) { e.printStackTrace(); } } });
		 */
		FormCliente frame = new FormCliente();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public FormCliente() {
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			mascaraCEP = new MaskFormatter("#####-###");
			mascaraCEP.setPlaceholderCharacter('_');

			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraCNPJ.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textCliente = new JTextField();
		textCliente.setBounds(10, 31, 340, 20);
		contentPane.add(textCliente);
		textCliente.setColumns(10);

		textLogradouro = new JTextField();
		textLogradouro.setColumns(10);
		textLogradouro.setBounds(10, 123, 219, 20);
		contentPane.add(textLogradouro);

		textCep = new JFormattedTextField(mascaraCEP);
		textCep.setColumns(10);
		textCep.setBounds(10, 167, 154, 20);
		contentPane.add(textCep);

		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(10, 211, 154, 20);
		contentPane.add(textBairro);

		JLabel lblNomeDoCliente = new JLabel("Nome Do Cliente:");
		lblNomeDoCliente.setBounds(10, 11, 107, 14);
		contentPane.add(lblNomeDoCliente);

		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setBounds(10, 153, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblEndereo = new JLabel("Logradouro:");
		lblEndereo.setBounds(10, 109, 86, 14);
		contentPane.add(lblEndereo);

		textNumero = new JTextField();
		textNumero.setBounds(264, 123, 86, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);

		lblN = new JLabel("N\u00BA :");
		lblN.setBounds(239, 126, 26, 14);
		contentPane.add(lblN);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 198, 46, 14);
		contentPane.add(lblBairro);

		txtSoPaulo = new JTextField();
		txtSoPaulo.setEditable(false);
		txtSoPaulo.setText("S\u00E3o Paulo");
		txtSoPaulo.setBounds(205, 211, 145, 20);
		contentPane.add(txtSoPaulo);
		txtSoPaulo.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(205, 198, 46, 14);
		contentPane.add(lblCidade);

		textCnpj = new JFormattedTextField(mascaraCNPJ);
		textCnpj.setBounds(10, 74, 219, 20);
		contentPane.add(textCnpj);
		textCnpj.setColumns(10);

		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 62, 46, 14);
		contentPane.add(lblCnpj);

		separator = new JSeparator();
		separator.setBounds(10, 257, 376, 2);
		contentPane.add(separator);

		lblDatasPossveisDe = new JLabel("Datas Poss\u00EDveis de Entrega:");
		lblDatasPossveisDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatasPossveisDe.setBounds(10, 270, 171, 14);
		contentPane.add(lblDatasPossveisDe);

		checkSegunda = new JCheckBox("Segunda-Feira");
		checkSegunda.setBounds(10, 298, 118, 23);
		contentPane.add(checkSegunda);

		checkTerca = new JCheckBox("Ter\u00E7a-Feira");
		checkTerca.setBounds(10, 324, 97, 23);
		contentPane.add(checkTerca);

		checkQuarta = new JCheckBox("Quarta-Feira");
		checkQuarta.setBounds(10, 350, 97, 23);
		contentPane.add(checkQuarta);

		checkQuinta = new JCheckBox("Quinta-Feira");
		checkQuinta.setBounds(10, 376, 97, 23);
		contentPane.add(checkQuinta);

		checkSexta = new JCheckBox("Sexta-Feira");
		checkSexta.setBounds(154, 298, 97, 23);
		contentPane.add(checkSexta);

		checkSabado = new JCheckBox("S\u00E1bado");
		checkSabado.setBounds(154, 324, 97, 23);
		contentPane.add(checkSabado);

		checkDomingo = new JCheckBox("Domingo");
		checkDomingo.setBounds(154, 350, 97, 23);
		contentPane.add(checkDomingo);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.setForeground(Color.RED);
		btnSalvar.setBounds(53, 424, 89, 23);
		contentPane.add(btnSalvar);

		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(Color.RED);
		btnLimpar.setBounds(154, 424, 89, 23);
		contentPane.add(btnLimpar);

		btnSair = new JButton("SAIR");
		btnSair.setForeground(Color.RED);
		btnSair.setBounds(253, 424, 89, 23);
		contentPane.add(btnSair);

		// Carrega ActionListener salvar;
		salvar();

		// Carrega ActionListener Limpar;
		limpar();

		// Carrega ActionListener Sair;
		sair();
	}

	public void salvar() {
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente objCliente = new Cliente();

				objCliente.setCliente(textCliente.getText());
				objCliente.setLogradouro(textLogradouro.getText());
				objCliente.setCep(textCep.getText());
				objCliente.setBairro(textBairro.getText());
				objCliente.setNumero(textNumero.getText());
				objCliente.setCnpj(textCnpj.getText());

				objCliente.setDomingo(checkDomingo.isSelected());
				objCliente.setSegunda(checkSegunda.isSelected());
				objCliente.setTerca(checkTerca.isSelected());
				objCliente.setQuarta(checkQuarta.isSelected());
				objCliente.setQuinta(checkQuinta.isSelected());
				objCliente.setSexta(checkSexta.isSelected());
				objCliente.setSabado(checkSabado.isSelected());

				// Envia para o Controller Tratar e salvar as informações.
				ControllerCliente controlCliente = new ControllerCliente();

				controlCliente.salvarCliente(objCliente);

				JOptionPane.showMessageDialog(null,
						"Registro inserido com sucesso");
			}
		});
	}

	public void limpar() {
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCliente.setText("");
				textLogradouro.setText("");
				textCep.setText("");
				textBairro.setText("");
				textNumero.setText("");
				textCnpj.setText("");

				checkDomingo.setSelected(false);
				checkSegunda.setSelected(false);
				checkTerca.setSelected(false);
				checkQuarta.setSelected(false);
				checkQuinta.setSelected(false);
				checkSexta.setSelected(false);
				checkSabado.setSelected(false);

			}
		});
	}

	public void sair() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
