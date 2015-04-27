package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class FormConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btnExportar;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormConsulta frame = new FormConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormConsulta() {
		setTitle("Consulta de Entregas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDataDeEntrega = new JLabel("Data de Entrega:");
		lblDataDeEntrega.setBounds(10, 24, 116, 14);
		contentPane.add(lblDataDeEntrega);

		textField = new JTextField();
		textField.setBounds(10, 49, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(170, 48, 89, 23);
		contentPane.add(btnBuscar);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		table.setBounds(10, 97, 390, 305);
		contentPane.add(table);

		btnExportar = new JButton("EXPORTAR");
		btnExportar.setBounds(55, 425, 105, 23);
		contentPane.add(btnExportar);

		btnSair = new JButton("SAIR");
		btnSair.setBounds(235, 425, 105, 23);
		contentPane.add(btnSair);
	}
}
