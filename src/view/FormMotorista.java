package view;

import controller.ControllerMotorista;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Motorista;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

public class FormMotorista extends JInternalFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JLabel lblNmeroDaCnh;
    private JLabel lblValidade;
    private JLabel lblNewLabel;
    private JLabel lblMotorista;
    private JLabel lblCaminhao;
    private JLabel lblPlaca;
    private JLabel lblEstadoDoLicenciamento;

    // TextFields
    private JTextField textNomeMotorista;
    private JTextField textCNH;
    private JTextField textValidadeCNH;
    private JTextField textPlaca;
    private JTextField textCarga;
    private JTextField textAltura;
    private JTextField textComprimento;
    private JTextField textVolume;
    private JTextField textLargura;
    private JTextField textCidade;

    private JFormattedTextField textTelefone1;
    private JFormattedTextField textTelefone2;

    private MaskFormatter mascaratel;

    // Combo Box
    private JComboBox comboTipoVeiculo;
    private JComboBox comboCarroceria;
    private JComboBox comboEstado;

    // Buttons
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnSair;

    private MaskFormatter mascaraData;

    private MaskFormatter mascaraPlaca;

    private MaskFormatter mascaraCNH;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormMotorista frame = new FormMotorista();
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
    public FormMotorista() {
        setTitle("Cadastro de Motoristas");
        setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 735, 444);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textNomeMotorista = new JTextField();
        textNomeMotorista.setBounds(10, 54, 268, 20);
        contentPane.add(textNomeMotorista);
        textNomeMotorista.setColumns(10);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 39, 46, 14);
        contentPane.add(lblNome);

        lblNmeroDaCnh = new JLabel("N\u00FAmero da CNH");
        lblNmeroDaCnh.setBounds(10, 85, 128, 14);
        contentPane.add(lblNmeroDaCnh);

        lblValidade = new JLabel("Validade:");
        lblValidade.setBounds(181, 85, 56, 14);
        contentPane.add(lblValidade);

        try {
            mascaratel = new MaskFormatter("(##)#####-####");
            mascaratel.setPlaceholderCharacter('_');

            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');

            mascaraPlaca = new MaskFormatter("###-####");
            mascaraPlaca.setPlaceholderCharacter('_');

            mascaraCNH = new MaskFormatter("#########");
            mascaraCNH.setPlaceholderCharacter('_');
        } catch (ParseException excp) {
        }

        textCNH = new JFormattedTextField(mascaraCNH);
        textCNH.setBounds(10, 102, 143, 20);
        contentPane.add(textCNH);
        textCNH.setColumns(10);

        textValidadeCNH = new JFormattedTextField(mascaraData);
        textValidadeCNH.setBounds(181, 102, 97, 20);
        contentPane.add(textValidadeCNH);
        textValidadeCNH.setColumns(10);

        textTelefone1 = new JFormattedTextField(mascaratel);
        textTelefone1.setBounds(10, 159, 128, 20);
        contentPane.add(textTelefone1);
        textTelefone1.setColumns(10);

        textTelefone2 = new JFormattedTextField(mascaratel);
        textTelefone2.setBounds(148, 159, 130, 20);
        contentPane.add(textTelefone2);
        textTelefone2.setColumns(10);

        lblNewLabel = new JLabel("Telefones para Contato:");
        lblNewLabel.setBounds(10, 133, 195, 14);
        contentPane.add(lblNewLabel);

        lblMotorista = new JLabel("Motorista");
        lblMotorista.setHorizontalAlignment(SwingConstants.CENTER);
        lblMotorista.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblMotorista.setBounds(10, 11, 254, 20);
        contentPane.add(lblMotorista);

        lblCaminhao = new JLabel("Ve\u00EDculo");
        lblCaminhao.setHorizontalAlignment(SwingConstants.CENTER);
        lblCaminhao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblCaminhao.setBounds(360, 15, 310, 20);
        contentPane.add(lblCaminhao);

        textPlaca = new JFormattedTextField(mascaraPlaca);
        textPlaca.setBounds(370, 54, 115, 20);
        contentPane.add(textPlaca);
        textPlaca.setColumns(10);

        lblPlaca = new JLabel("Placa:");
        lblPlaca.setBounds(370, 39, 46, 14);
        contentPane.add(lblPlaca);

        comboTipoVeiculo = new JComboBox();
        comboTipoVeiculo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Toco")) {
                    textCarga.setText("16.000 kg");
                } else if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Truck")) {
                    textCarga.setText("23.000 kg");
                } else if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Carreta 2 eixos")) {
                    textCarga.setText("33.000 kg");
                } else if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Carreta Baú")) {
                    textCarga.setText("41.500 kg");
                } else if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Carreta 3 eixos")) {
                    textCarga.setText("41.500 kg");
                } else if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Carreta Cavalo Truckado")) {
                    textCarga.setText("45.000 kg");
                } else if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Carreta Cavalo Truckado Baú")) {
                    textCarga.setText("45.000 kg");
                } else if (comboTipoVeiculo.getSelectedItem().toString()
                        .equals("Bi-trem(Treminhão) - 7 eixos")) {
                    textCarga.setText("57.000 kg");
                } else {
                    textCarga.setText("");
                }
            }
        });
        comboTipoVeiculo.setBounds(370, 102, 300, 20);
        comboTipoVeiculo.addItem("");
        comboTipoVeiculo.addItem("Toco");
        comboTipoVeiculo.addItem("Truck");
        comboTipoVeiculo.addItem("Carreta 2 eixos");
        comboTipoVeiculo.addItem("Carreta Baú");
        comboTipoVeiculo.addItem("Carreta 3 eixos");
        comboTipoVeiculo.addItem("Carreta Cavalo Truckado");
        comboTipoVeiculo.addItem("Carreta Cavalo Truckado Baú");
        comboTipoVeiculo.addItem("Bi-trem(Treminhão) - 7 eixos");
        contentPane.add(comboTipoVeiculo);

        JLabel lblTipoDoVeculo = new JLabel("Tipo do Ve\u00EDculo:");
        lblTipoDoVeculo.setBounds(370, 85, 97, 14);
        contentPane.add(lblTipoDoVeculo);

        textCarga = new JTextField();
        textCarga.setEditable(false);
        textCarga.setBounds(370, 148, 103, 20);
        contentPane.add(textCarga);
        textCarga.setColumns(10);

        JLabel lblCarga = new JLabel("Capacidade de Carga:");
        lblCarga.setBounds(370, 133, 128, 14);
        contentPane.add(lblCarga);

        JLabel lblKg = new JLabel("Kg");
        lblKg.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblKg.setBounds(477, 151, 20, 14);
        contentPane.add(lblKg);

        JLabel lblCarroceria = new JLabel("Carroceria:");
        lblCarroceria.setBounds(370, 179, 143, 14);
        contentPane.add(lblCarroceria);

        comboCarroceria = new JComboBox();
        comboCarroceria.addItem("");
        comboCarroceria.addItem("Carroceria tipo sider tamanho padrão");
        comboCarroceria.addItem("Carroceria tipo sider semi reboque");
        comboCarroceria
                .addItem("Carroceria tipo baú para capacidade de 4.000 kg");
        comboCarroceria
                .addItem("Carroceria tipo baú para capacidade de 6.000 kg");
        comboCarroceria
                .addItem("Carroceria tipo baú semi reboque - tamanho externo 15,10 m");
        comboCarroceria.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (comboCarroceria.getSelectedItem().toString()
                        .equals("Carroceria tipo sider tamanho padrão")) {
                    textComprimento.setText("7,650");
                    textLargura.setText("2,460");
                    textAltura.setText("3,000");
                    textVolume.setText("56,000 m³");
                } else if (comboCarroceria.getSelectedItem().toString()
                        .equals("Carroceria tipo sider semi reboque")) {
                    textComprimento.setText("14,860");
                    textLargura.setText("2,510");
                    textAltura.setText("3,000");
                    textVolume.setText("112,000 m³");
                } else if (comboCarroceria
                        .getSelectedItem()
                        .toString()
                        .equals("Carroceria tipo baú para capacidade de 4.000 kg")) {
                    textComprimento.setText("5,320");
                    textLargura.setText("2,080");
                    textAltura.setText("2,200");
                    textVolume.setText("24,000 m³");
                } else if (comboCarroceria
                        .getSelectedItem()
                        .toString()
                        .equals("Carroceria tipo baú para capacidade de 6.000 kg")) {
                    textComprimento.setText("7,320");
                    textLargura.setText("2,480");
                    textAltura.setText("2,630");
                    textVolume.setText("48,000 m³");
                } else if (comboCarroceria
                        .getSelectedItem()
                        .toString()
                        .equals("Carroceria tipo baú semi reboque - tamanho externo 15,10 m")) {
                    textComprimento.setText("14,940");
                    textLargura.setText("2,480");
                    textAltura.setText("2,730");
                    textVolume.setText("101,000 m³");
                } else {
                    textComprimento.setText("");
                    textLargura.setText("");
                    textAltura.setText("");
                    textVolume.setText("");
                }
            }
        });
        comboCarroceria.setBounds(370, 193, 300, 20);
        contentPane.add(comboCarroceria);

        textAltura = new JTextField();
        textAltura.setEditable(false);
        textAltura.setBounds(370, 242, 86, 20);
        contentPane.add(textAltura);
        textAltura.setColumns(10);

        textComprimento = new JTextField();
        textComprimento.setEditable(false);
        textComprimento.setColumns(10);
        textComprimento.setBounds(528, 242, 86, 20);
        contentPane.add(textComprimento);

        textVolume = new JTextField();
        textVolume.setEditable(false);
        textVolume.setColumns(10);
        textVolume.setBounds(528, 291, 86, 20);
        contentPane.add(textVolume);

        textLargura = new JTextField();
        textLargura.setEditable(false);
        textLargura.setColumns(10);
        textLargura.setBounds(370, 291, 86, 20);
        contentPane.add(textLargura);

        JLabel lblNewLabel_1 = new JLabel("Altura");
        lblNewLabel_1.setBounds(370, 224, 46, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblComprimento = new JLabel("Comprimento");
        lblComprimento.setBounds(528, 224, 86, 14);
        contentPane.add(lblComprimento);

        JLabel lblNewLabel_2 = new JLabel("Largura");
        lblNewLabel_2.setBounds(372, 273, 46, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Volume");
        lblNewLabel_3.setBounds(528, 273, 46, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblMetros = new JLabel("Metros");
        lblMetros.setBounds(467, 245, 46, 14);
        contentPane.add(lblMetros);

        JLabel label = new JLabel("Metros");
        label.setBounds(624, 245, 46, 14);
        contentPane.add(label);

        JLabel label_1 = new JLabel("Metros");
        label_1.setBounds(466, 294, 46, 14);
        contentPane.add(label_1);

        JLabel lblM = new JLabel("M\u00B3");
        lblM.setBounds(624, 294, 46, 14);
        contentPane.add(lblM);

        lblEstadoDoLicenciamento = new JLabel("Estado de Registro");
        lblEstadoDoLicenciamento.setBounds(370, 322, 165, 14);
        contentPane.add(lblEstadoDoLicenciamento);

        btnSalvar = new JButton("SALVAR");
        btnSalvar.setForeground(Color.RED);
        btnSalvar.setBounds(49, 269, 89, 23);
        contentPane.add(btnSalvar);

        btnLimpar = new JButton("LIMPAR");
        btnLimpar.setForeground(Color.RED);
        btnLimpar.setBounds(175, 269, 89, 23);
        contentPane.add(btnLimpar);

        btnSair = new JButton("SAIR");
        btnSair.setForeground(Color.RED);
        btnSair.setBounds(113, 345, 89, 23);
        contentPane.add(btnSair);

        comboEstado = new JComboBox();
        comboEstado.setBounds(370, 346, 112, 20);
        comboEstado.addItem("");
        ControllerMotorista cm = new ControllerMotorista();
        String[] estados = cm.getEstado();
        for (String estado : estados) {
            comboEstado.addItem(estado);
        }

        contentPane.add(comboEstado);

        textCidade = new JTextField();
        textCidade.setBounds(528, 346, 142, 20);
        contentPane.add(textCidade);
        textCidade.setColumns(10);

        JLabel lblCidadeDoLicenciamento = new JLabel("Cidade de Registro:");
        lblCidadeDoLicenciamento.setBounds(528, 322, 142, 14);
        contentPane.add(lblCidadeDoLicenciamento);
        // Carrega Action Listeners dos botões
        salvar();
        limpar();
        sair();
    }

    public void salvar() {
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Motorista objMotorista = new Motorista();

                objMotorista.setNomeMotorista(textNomeMotorista.getText());
                objMotorista.setCnh(textCNH.getText());
                objMotorista.setValidadeCNH(textValidadeCNH.getText());
                objMotorista.setTelefone1(textTelefone1.getText());
                objMotorista.setTelefone2((textTelefone2.getText()));
                objMotorista.setPlaca(textPlaca.getText());
                objMotorista.setCarga(textCarga.getText());
                objMotorista.setAltura((textAltura.getText()));
                objMotorista.setComprimento((textComprimento.getText()));
                objMotorista.setVolume((textVolume.getText()));
                objMotorista.setLargura((textLargura.getText()));
                // objMotorista.setEstado(textEstado.getText());
                objMotorista.setCidade(textCidade.getText());

                // Envia para o Controller Tratar e salvar as informações.
                ControllerMotorista controlMotorista = new ControllerMotorista();
                controlMotorista.salvarMotorista(objMotorista);
            }
        });
    }

    public void limpar() {
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNomeMotorista.setText("");
                textCNH.setText("");
                textValidadeCNH.setText("");
                textTelefone1.setText("");
                textTelefone2.setText("");
                textPlaca.setText("");
                textCarga.setText("");
                textAltura.setText("");
                textComprimento.setText("");
                textVolume.setText("");
                textLargura.setText("");
                comboCarroceria.setSelectedIndex(0);
                comboEstado.setSelectedIndex(0);
                comboTipoVeiculo.setSelectedIndex(0);
                // textEstado.setText("");
                textCidade.setText("");
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
