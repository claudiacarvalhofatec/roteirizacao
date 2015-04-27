package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.awt.event.ActionListener;

public class FormMenu extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMenu frame = new FormMenu();
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
	public FormMenu() {
		setTitle("Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnMotorista = new JButton("Motorista");
		btnMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormMotorista fc = new FormMotorista();
				fc.setVisible(true);
			}
		});
		btnMotorista.setBounds(157, 67, 118, 121);
		contentPane.add(btnMotorista);

		JButton btnEntrega = new JButton("Entregas");
		btnEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormEntregas fc = new FormEntregas();
				fc.setVisible(true);
			}
		});
		btnEntrega.setBounds(285, 67, 118, 121);
		contentPane.add(btnEntrega);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormCliente fc = new FormCliente();
				fc.setVisible(true);

			}
		});
		btnClientes.setBounds(27, 67, 120, 121);
		contentPane.add(btnClientes);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
