package view;

import controller.ControllerEntrega;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import model.Entrega;

public class FormEntregas extends JInternalFrame {

    private JPanel contentPane;
    private JSeparator separator;

    private JLabel lblDataParaEntregar;
    private JLabel lblCarga;
    private JLabel lblCliente_1;
    private JLabel lblQuantidadeDePaletes;
    private JLabel lblPeso;
    private JLabel lblKg;
    private JLabel lblVolume;
    private JLabel lblM;

    // Buttons
    private JButton btnBuscar;
    private JButton btnRegistrar;
    private JButton btnLimpar;
    private JButton btnSair;

    // textfields
    private JTextField textCliente;
    private JTextField textDataEntrega;
    private JTextField textQtdePaletes;
    private JTextField textPeso;
    private JTextField textVolume;
    private MaskFormatter mascaraData;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormEntregas frame = new FormEntregas();
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
    public FormEntregas() {
        setTitle("Registro de Entregas");
        setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 422, 416);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        try {
            mascaraData = new MaskFormatter("##/##/####");

            mascaraData.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        textCliente = new JTextField();
        textCliente.setBounds(10, 45, 289, 20);
        contentPane.add(textCliente);
        textCliente.setColumns(10);
        textCliente.setEditable(false);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(10, 28, 46, 14);
        contentPane.add(lblCliente);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(309, 44, 89, 23);
        contentPane.add(btnBuscar);

        textDataEntrega = new JFormattedTextField(mascaraData);
        textDataEntrega.setBounds(10, 91, 132, 20);
        contentPane.add(textDataEntrega);
        textDataEntrega.setColumns(10);

        lblDataParaEntregar = new JLabel("Data para Entregar:");
        lblDataParaEntregar.setBounds(10, 76, 154, 14);
        contentPane.add(lblDataParaEntregar);

        separator = new JSeparator();
        separator.setBounds(10, 130, 388, 9);
        contentPane.add(separator);

        lblCarga = new JLabel("Carga");
        lblCarga.setHorizontalAlignment(SwingConstants.CENTER);
        lblCarga.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCarga.setBounds(10, 150, 388, 14);
        contentPane.add(lblCarga);

        lblCliente_1 = new JLabel("Cliente");
        lblCliente_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblCliente_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCliente_1.setBounds(10, 11, 388, 14);
        contentPane.add(lblCliente_1);

        textQtdePaletes = new JTextField();
        textQtdePaletes.setBounds(10, 204, 114, 20);
        contentPane.add(textQtdePaletes);
        textQtdePaletes.setColumns(10);

        lblQuantidadeDePaletes = new JLabel("Quantidade de Paletes:");
        lblQuantidadeDePaletes.setBounds(10, 186, 154, 14);
        contentPane.add(lblQuantidadeDePaletes);

        textPeso = new JTextField();
        textPeso.setBounds(10, 254, 86, 20);
        contentPane.add(textPeso);
        textPeso.setColumns(10);

        textVolume = new JTextField();
        textVolume.setColumns(10);
        textVolume.setBounds(213, 254, 86, 20);
        contentPane.add(textVolume);

        lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(10, 235, 46, 14);
        contentPane.add(lblPeso);

        lblKg = new JLabel("KG");
        lblKg.setBounds(106, 257, 46, 14);
        contentPane.add(lblKg);

        lblVolume = new JLabel("Volume:");
        lblVolume.setBounds(214, 235, 71, 14);
        contentPane.add(lblVolume);

        lblM = new JLabel("M\u00B3");
        lblM.setBounds(303, 257, 46, 14);
        contentPane.add(lblM);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setForeground(Color.RED);
        btnRegistrar.setBounds(10, 336, 114, 23);
        contentPane.add(btnRegistrar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setForeground(Color.RED);
        btnLimpar.setBounds(157, 336, 106, 23);
        contentPane.add(btnLimpar);

        btnSair = new JButton("Fechar");
        btnSair.setForeground(Color.RED);
        btnSair.setBounds(291, 336, 101, 23);
        contentPane.add(btnSair);

        // Carrega Action Listeners dos botões
        salvar();
        limpar();
        sair();
    }

    public void salvar() {
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Entrega objEntrega = new Entrega();

                objEntrega.setClienteId(Integer.parseInt(textCliente.getText()));
                objEntrega.setPeso(Double.parseDouble(textDataEntrega.getText()));
                objEntrega.setQtdePaletes(Integer.parseInt(textQtdePaletes
                        .getText()));
                objEntrega.setVolume(Double.parseDouble(textPeso.getText()));
                objEntrega.setDataEntrega(textVolume.getText());

                // Envia para o Controller Tratar e salvar as informações.
                ControllerEntrega controlCliente = new ControllerEntrega();
                controlCliente.salvarEntrega(objEntrega);
            }
        });
    }

    public void limpar() {
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textCliente.setText("");
                textDataEntrega.setText("");
                textQtdePaletes.setText("");
                textPeso.setText("");
                textVolume.setText("");
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
