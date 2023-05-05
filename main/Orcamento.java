package main;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Orcamento.
 */
public class Orcamento extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The txt pesquisar. */
	private JTextField txtPesquisar;

	/** The txt ID. */
	private JTextField txtID;

	/** The table. */
	private JTable table;

	/** The txt cliente. */
	private JTextField txtCliente;

	/** The txt email. */
	private JTextField txtEmail;

	/** The txt contato. */
	private JTextField txtContato;

	/** The txt empresa. */
	private JTextField txtEmpresa;

	/** The txt CNPJ. */
	private JTextField txtCNPJ;

	/** The txt OS. */
	private JTextField txtOS;

	/** The txt equipamento. */
	private JTextField txtEquipamento;

	/** The txt acessorio. */
	private JTextField txtAcessorio;

	/** The txt IMEI. */
	private JTextField txtIMEI;

	/** The txt defeito. */
	private JTextField txtDefeito;

	/** The txt diagnostico. */
	private JTextField txtDiagnostico;

	/** The txt valor. */
	private JTextField txtValor;

	/** The txt sinal. */
	private JTextField txtSinal;

	/** The txt receber. */
	private JTextField txtReceber;

	/** The btn cliente. */
	private JButton btnCliente;

	/** The btn impressora. */
	private JButton btnImpressora;

	/** The btn update. */
	private JButton btnUpdate;

	/** The btn delete. */
	private JButton btnDelete;

	/** The btn pesquisar. */
	private JButton btnPesquisar;

	/** The btn buscar OS. */
	private JButton btnBuscarOS;

	/** The cbo tecnico. */
	@SuppressWarnings("rawtypes")
	private JComboBox cboTecnico;

	/** The cbo status. */
	@SuppressWarnings("rawtypes")
	private JComboBox cboStatus;

	/** The data entrada. */
	private JDateChooser dataEntrada;

	/** The content panel. */
	private JPanel contentPanel;

	/** The lbl new label 11 1. */
	private JLabel lblNewLabel_11_1;

	/** The lbl new label 11 3. */
	private JLabel lblNewLabel_11_3;

	/** The lbl new label 11 4. */
	private JLabel lblNewLabel_11_4;

	/** The lbl new label 11 5. */
	private JLabel lblNewLabel_11_5;

	/** The lbl new label 16. */
	private JLabel lblNewLabel_16;

	/** The btn ADD. */
	private JButton btnADD;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			Orcamento dialog = new Orcamento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Instantiates a new orcamento.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Orcamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Orcamento.class.getResource("/img/logoapp.png")));
		getContentPane().setBackground(new Color(240, 240, 240));
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				pesquisarCliente();
				txtOS.requestFocus();
			}
		});
		setModal(true);
		setTitle("Orçamento");
		setBounds(100, 100, 800, 750);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Pesquisar Cliente",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 764, 233);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pesquisar");
		lblNewLabel.setBounds(10, 29, 61, 14);
		panel.add(lblNewLabel);

		txtPesquisar = new JTextField();
		txtPesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPesquisar.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				pesquisarCliente();
			}
		});
		txtPesquisar.setToolTipText("Pesquisar Cliente");
		txtPesquisar.setBounds(81, 26, 129, 20);
		panel.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID Cliente");
		lblNewLabel_1.setBounds(647, 29, 68, 14);
		panel.add(lblNewLabel_1);

		txtID = new JTextField();
		txtID.setToolTipText("ID do Cliente");
		txtID.setEditable(false);
		txtID.setBounds(711, 26, 43, 20);
		txtID.setColumns(10);
		panel.add(txtID);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBounds(3, 61, 758, 102);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setToolTipText("Selecione o Cliente");
		table.setCellSelectionEnabled(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, },
				new String[] { "Nome", "CPF", "Razão", "ID" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(10, 174, 46, 14);
		panel.add(lblNewLabel_2);

		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCliente.setToolTipText("Nome do Cliente");
		txtCliente.setBounds(67, 171, 186, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(292, 174, 46, 14);
		panel.add(lblNewLabel_3);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEmail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "qwertyuiopasdfghjklçzxcvbnm,.@132456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEmail.setToolTipText("Email");
		txtEmail.setColumns(10);
		txtEmail.setBounds(332, 171, 186, 20);
		panel.add(txtEmail);

		JLabel lblNewLabel_4 = new JLabel("Contato");
		lblNewLabel_4.setBounds(559, 171, 52, 14);
		panel.add(lblNewLabel_4);

		txtContato = new JTextField();
		txtContato.setEditable(false);
		txtContato.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtContato.setToolTipText("Contato");
		txtContato.setColumns(10);
		txtContato.setBounds(609, 168, 147, 20);
		panel.add(txtContato);

		JLabel lblNewLabel_5 = new JLabel("Razão");
		lblNewLabel_5.setBounds(10, 205, 52, 14);
		panel.add(lblNewLabel_5);

		txtEmpresa = new JTextField();
		txtEmpresa.setEditable(false);
		txtEmpresa.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEmpresa.setToolTipText("Razão Social");
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(67, 202, 186, 20);
		panel.add(txtEmpresa);

		txtCNPJ = new JTextField();
		txtCNPJ.setEditable(false);
		txtCNPJ.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCNPJ.setToolTipText("CNPJ");
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(332, 202, 186, 20);
		panel.add(txtCNPJ);

		JLabel lblNewLabel_6 = new JLabel("CNPJ");
		lblNewLabel_6.setBounds(292, 205, 36, 14);
		panel.add(lblNewLabel_6);

		btnCliente = new JButton("");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setVisible(true);
			}
		});
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.setIcon(new ImageIcon(Orcamento.class.getResource("/img/busca32x32.png")));
		btnCliente.setToolTipText("Cadastrar Cliente");
		btnCliente.setBounds(221, 18, 32, 32);
		panel.add(btnCliente);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Orcamento.class.getResource("/img/logo123.png")));
		lblNewLabel_12.setBounds(676, 630, 98, 70);
		getContentPane().add(lblNewLabel_12);

		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBounds(0, 0, 784, 711);
		getContentPane().add(contentPanel);

		btnPesquisar = new JButton("");
		btnPesquisar.setBounds(509, 630, 70, 70);
		contentPanel.add(btnPesquisar);
		btnPesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setToolTipText("Procurar Novo Orçamento");
		btnPesquisar.setIcon(new ImageIcon(Orcamento.class.getResource("/img/phoneNovabusca.png")));

		btnDelete = new JButton("");
		btnDelete.setBounds(402, 630, 70, 70);
		contentPanel.add(btnDelete);
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirOS();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Deletar Orçamento");
		btnDelete.setIcon(new ImageIcon(Orcamento.class.getResource("/img/phoneDelete.png")));

		btnUpdate = new JButton("");
		btnUpdate.setBounds(297, 630, 70, 70);
		contentPanel.add(btnUpdate);
		btnUpdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarOS();
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("Atualizar Orçamento");
		btnUpdate.setIcon(new ImageIcon(Orcamento.class.getResource("/img/phoneUpdate.png")));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 469, 764, 150);
		contentPanel.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Valor", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("Técnico");
		lblNewLabel_10.setBounds(10, 26, 46, 14);
		panel_2.add(lblNewLabel_10);

		cboTecnico = new JComboBox();
		cboTecnico.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboTecnico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboTecnico.setToolTipText("Técnico");
		cboTecnico.setModel(new DefaultComboBoxModel(new String[] { "", "Pedro", "Nicolas", "Alessandro" }));
		cboTecnico.setBounds(66, 22, 134, 22);
		panel_2.add(cboTecnico);

		JLabel lblNewLabel_11 = new JLabel("Status do Pedido");
		lblNewLabel_11.setBounds(239, 26, 110, 14);
		panel_2.add(lblNewLabel_11);

		cboStatus = new JComboBox();
		cboStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboStatus.setToolTipText("Status do Pedido");
		cboStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Aguardando Técnico", "Em Análise",
				"Aguardando Aprovação", "Não Aprovado", "Aprovado", "Em Manutenção", "Concluído", "Retirado" }));
		cboStatus.setBounds(347, 22, 171, 22);
		panel_2.add(cboStatus);

		JLabel lblNewLabel_13 = new JLabel("Valor");
		lblNewLabel_13.setBounds(21, 82, 46, 14);
		panel_2.add(lblNewLabel_13);

		txtValor = new JTextField();
		txtValor.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtValor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			public void keyReleased(KeyEvent e) {
				calcularValor();
			}
		});
		txtValor.setToolTipText("Valor do Conserto");
		txtValor.setBounds(66, 79, 86, 20);
		panel_2.add(txtValor);
		txtValor.setColumns(10);

		txtSinal = new JTextField();
		txtSinal.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSinal.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			public void keyReleased(KeyEvent e) {
				calcularValor();
			}
		});
		txtSinal.setToolTipText("Sinal do Conserto");
		txtSinal.setBounds(237, 79, 86, 20);
		panel_2.add(txtSinal);
		txtSinal.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Sinal");
		lblNewLabel_14.setBounds(200, 82, 39, 14);
		panel_2.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("a Receber");
		lblNewLabel_15.setBounds(365, 82, 69, 14);
		panel_2.add(lblNewLabel_15);

		txtReceber = new JTextField();
		txtReceber.setEditable(false);
		txtReceber.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReceber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtReceber.setToolTipText("Valor Restante a Receber");
		txtReceber.setBounds(432, 79, 86, 20);
		panel_2.add(txtReceber);
		txtReceber.setColumns(10);

		dataEntrada = new JDateChooser();
		dataEntrada.setBorder(new LineBorder(new Color(0, 0, 0)));
		dataEntrada.setToolTipText("Data de Entrada do Equipamento");
		dataEntrada.setEnabled(false);
		dataEntrada.setBounds(620, 24, 134, 20);
		panel_2.add(dataEntrada);

		JLabel lblNewLabel_4_1 = new JLabel("Entrada");
		lblNewLabel_4_1.setBounds(563, 26, 57, 14);
		panel_2.add(lblNewLabel_4_1);

		btnImpressora = new JButton("");
		btnImpressora.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnImpressora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirOS();
			}
		});
		btnImpressora.setEnabled(false);
		btnImpressora.setToolTipText("Imprimir Orçamento");
		btnImpressora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImpressora.setBounds(690, 75, 64, 64);
		panel_2.add(btnImpressora);
		btnImpressora.setIcon(new ImageIcon(Orcamento.class.getResource("/img/printer64x64.png")));

		lblNewLabel_11_5 = new JLabel("*");
		lblNewLabel_11_5.setForeground(Color.RED);
		lblNewLabel_11_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_5.setBounds(522, 26, 16, 14);
		panel_2.add(lblNewLabel_11_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 255, 764, 203);
		contentPanel.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Equipamento",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("nº Orçamento");
		lblNewLabel_7.setBounds(568, 23, 87, 14);
		panel_1.add(lblNewLabel_7);

		txtOS = new JTextField();
		txtOS.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtOS.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pesquisar();
				}
			}
		});
		txtOS.setToolTipText("Número do Orçamento");
		txtOS.setBounds(655, 20, 43, 20);
		panel_1.add(txtOS);
		txtOS.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Equipamento");
		lblNewLabel_8.setBounds(141, 57, 80, 14);
		panel_1.add(lblNewLabel_8);

		txtEquipamento = new JTextField();
		txtEquipamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEquipamento.setToolTipText("Equipamento");
		txtEquipamento.setBounds(221, 54, 488, 20);
		panel_1.add(txtEquipamento);
		txtEquipamento.setColumns(10);

		JLabel lblNewLabel_8_1 = new JLabel("Acessorios");
		lblNewLabel_8_1.setBounds(141, 85, 80, 14);
		panel_1.add(lblNewLabel_8_1);

		txtAcessorio = new JTextField();
		txtAcessorio.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAcessorio.setToolTipText("Acessórios");
		txtAcessorio.setColumns(10);
		txtAcessorio.setBounds(221, 82, 488, 20);
		panel_1.add(txtAcessorio);

		JLabel lblNewLabel_8_1_1 = new JLabel("IMEI");
		lblNewLabel_8_1_1.setBounds(141, 113, 80, 14);
		panel_1.add(lblNewLabel_8_1_1);

		txtIMEI = new JTextField();
		txtIMEI.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtIMEI.setToolTipText("IMEI");
		txtIMEI.setColumns(10);
		txtIMEI.setBounds(221, 110, 488, 20);
		panel_1.add(txtIMEI);

		txtDefeito = new JTextField();
		txtDefeito.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDefeito.setToolTipText("Defeito Relatado");
		txtDefeito.setColumns(10);
		txtDefeito.setBounds(221, 141, 488, 20);
		panel_1.add(txtDefeito);

		txtDiagnostico = new JTextField();
		txtDiagnostico.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDiagnostico.setToolTipText("Defeito Diagnósticado");
		txtDiagnostico.setEditable(false);
		txtDiagnostico.setColumns(10);
		txtDiagnostico.setBounds(221, 172, 488, 20);
		panel_1.add(txtDiagnostico);

		JLabel lblNewLabel_8_1_1_1 = new JLabel("Defeito");
		lblNewLabel_8_1_1_1.setBounds(141, 144, 80, 14);
		panel_1.add(lblNewLabel_8_1_1_1);

		JLabel lblNewLabel_8_1_1_2 = new JLabel("Diagnóstico");
		lblNewLabel_8_1_1_2.setBounds(141, 175, 80, 14);
		panel_1.add(lblNewLabel_8_1_1_2);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Orcamento.class.getResource("/img/celular.png")));
		lblNewLabel_9.setBounds(10, 40, 109, 152);
		panel_1.add(lblNewLabel_9);

		btnBuscarOS = new JButton("");
		btnBuscarOS.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBuscarOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnBuscarOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarOS.setIcon(new ImageIcon(Orcamento.class.getResource("/img/search.png")));
		btnBuscarOS.setToolTipText("Buscar Orçamento");
		btnBuscarOS.setBounds(708, 11, 46, 35);
		panel_1.add(btnBuscarOS);

		lblNewLabel_11_1 = new JLabel("*");
		lblNewLabel_11_1.setForeground(Color.RED);
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1.setBounds(711, 57, 16, 14);
		panel_1.add(lblNewLabel_11_1);

		lblNewLabel_11_3 = new JLabel("*");
		lblNewLabel_11_3.setForeground(Color.RED);
		lblNewLabel_11_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_3.setBounds(711, 113, 16, 14);
		panel_1.add(lblNewLabel_11_3);

		lblNewLabel_11_4 = new JLabel("*");
		lblNewLabel_11_4.setForeground(Color.RED);
		lblNewLabel_11_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_4.setBounds(711, 144, 16, 14);
		panel_1.add(lblNewLabel_11_4);

		lblNewLabel_16 = new JLabel("(*) Campos Obrigátorio");
		lblNewLabel_16.setBounds(10, 686, 153, 14);
		contentPanel.add(lblNewLabel_16);
		lblNewLabel_16.setForeground(Color.RED);

		btnADD = new JButton("");
		btnADD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarOS();
			}
		});
		btnADD.setIcon(new ImageIcon(Orcamento.class.getResource("/img/phoneAdd.png")));
		btnADD.setToolTipText("Adicionar Orçamento");
		btnADD.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnADD.setBounds(193, 630, 70, 70);
		contentPanel.add(btnADD);

		RestrictedTextField PesquisarCliente = new RestrictedTextField(txtPesquisar);
		PesquisarCliente.setOnlyText(true);
		PesquisarCliente.setLimit(10);

		RestrictedTextField IDCliente = new RestrictedTextField(txtID);
		IDCliente.setOnlyNums(true);
		IDCliente.setLimit(5);

		RestrictedTextField Cliente = new RestrictedTextField(txtCliente);
		Cliente.setAcceptSpace(true);
		Cliente.setOnlyText(true);
		Cliente.setLimit(50);

		RestrictedTextField Contato = new RestrictedTextField(txtContato);
		Contato.setOnlyNums(true);
		Contato.setLimit(11);

		RestrictedTextField Empresa = new RestrictedTextField(txtEmpresa);
		Empresa.setAcceptSpace(true);
		Empresa.setOnlyText(true);
		Empresa.setLimit(50);

		RestrictedTextField CNPJ = new RestrictedTextField(txtCNPJ);
		CNPJ.setOnlyNums(true);
		CNPJ.setLimit(14);

		RestrictedTextField OS = new RestrictedTextField(txtOS);
		OS.setOnlyNums(true);
		OS.setLimit(5);

		RestrictedTextField Equipamento = new RestrictedTextField(txtEquipamento);
		Equipamento.setAcceptSpace(true);
		Equipamento.setLimit(50);

		RestrictedTextField Acessorio = new RestrictedTextField(txtAcessorio);
		Acessorio.setAcceptSpace(true);
		Acessorio.setLimit(50);

		RestrictedTextField IMEI = new RestrictedTextField(txtIMEI);
		IMEI.setAcceptSpace(true);
		IMEI.setLimit(50);

		RestrictedTextField Defeito = new RestrictedTextField(txtDefeito);
		Defeito.setAcceptSpace(true);
		Defeito.setLimit(50);

		RestrictedTextField Diagnostico = new RestrictedTextField(txtDiagnostico);
		Diagnostico.setAcceptSpace(true);
		Diagnostico.setLimit(50);
	}

	/** The dao. */
	DAO dao = new DAO();

	/**
	 * Setar campos.
	 */
	void setarCampos() {
		int setar = table.getSelectedRow();
		txtID.setText(table.getModel().getValueAt(setar, 3).toString());
		pesquisarDadosCliente();
		txtCliente.setEditable(false);
		txtEmail.setEditable(false);
		txtContato.setEditable(false);
		txtEmpresa.setEditable(false);
		txtCNPJ.setEditable(false);
		((DefaultTableModel) table.getModel()).setRowCount(0);
		txtPesquisar.setEditable(false);
		txtEquipamento.requestFocus();
	}

	/**
	 * Pesquisar cliente.
	 */
	private void pesquisarCliente() {
		String read3 = "select nomeContato as Nome, cpf as CPF, razao as Razão, idFor as ID  from clientes where nomeContato like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			pst.setString(1, txtPesquisar.getText() + "%");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Pesquisar dados cliente.
	 */
	void pesquisarDadosCliente() {
		String read = "select * from clientes where idFor = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtID.getText());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtID.setText(rs.getString(1));
				txtCliente.setText(rs.getString(9));
				txtEmail.setText(rs.getString(12));
				txtContato.setText(rs.getString(11));
				txtEmpresa.setText(rs.getString(14));
				txtCNPJ.setText(rs.getString(16));
				txtOS.setEditable(false);
				btnBuscarOS.setEnabled(false);
				txtEquipamento.requestFocus();
				btnCliente.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "Cliente inexistente");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Pesquisar.
	 */
	void pesquisar() {
		if (txtOS.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o número do Orçamento");
			txtOS.requestFocus();
		} else {
			String read = "select * from servico where idOs = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtOS.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtID.setText(rs.getString(2));
					txtEquipamento.setText(rs.getString(3));
					txtAcessorio.setText(rs.getString(4));
					txtIMEI.setText(rs.getString(5));
					txtDefeito.setText(rs.getString(6));
					txtDiagnostico.setText(rs.getString(7));
					cboTecnico.setSelectedItem(rs.getString(8));
					cboStatus.setSelectedItem(rs.getString(9));
					txtValor.setText(rs.getString(10));
					txtSinal.setText(rs.getString(11));
					txtReceber.setText(rs.getString(12));
					String setarData = rs.getString(13);
					Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
					dataEntrada.setDate(dataFormatada);
					pesquisarDadosCliente();
					btnBuscarOS.setEnabled(false);
					txtOS.setEditable(false);
					txtCliente.setEditable(false);
					txtEmail.setEditable(false);
					txtContato.setEditable(false);
					txtEmpresa.setEditable(false);
					txtCNPJ.setEditable(false);
					txtPesquisar.setEditable(false);
					btnCliente.setEnabled(false);
					btnADD.setEnabled(false);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnImpressora.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Orçamento inexistente");
					limpar();
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Atualizar OS.
	 */
	void atualizarOS() {
		if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecione o Cliente");
			txtPesquisar.requestFocus();

		} else if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Equipamento");
			txtEquipamento.requestFocus();

		} else if (txtIMEI.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o IMEI do Equipamento");
			txtIMEI.requestFocus();

		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito Informado");
			txtDefeito.requestFocus();

		} else if (cboStatus.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Status do Orçamento");

		} else {
			String update = "update servico set idCliente = ?, equipamento = ?, acessorio = ?, IMEI = ?, defeito = ?, diagnostico = ?, tecnico = ?, statusreparo = ?, valor = ?, sinal = ?, receber = ? where idOs = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtID.getText());
				pst.setString(2, txtEquipamento.getText());
				pst.setString(3, txtAcessorio.getText());
				pst.setString(4, txtIMEI.getText());
				pst.setString(5, txtDefeito.getText());
				pst.setString(6, txtDiagnostico.getText());
				pst.setString(7, cboTecnico.getSelectedItem().toString());
				pst.setString(8, cboStatus.getSelectedItem().toString());
				pst.setString(9, txtValor.getText());
				pst.setString(10, txtSinal.getText());
				pst.setString(11, txtReceber.getText());
				pst.setString(12, txtOS.getText());
				int executa = pst.executeUpdate();
				if (executa == 1) {
					JOptionPane.showMessageDialog(null, "Ordem de Serviço Atualizado com Sucesso!");
					limpar();
				} else {
					JOptionPane.showMessageDialog(null, "Erro: Ordem de Serviço não atualizado!");
					limpar();
				}
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Erro - Tente Novamente!");
				limpar();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Cadastrar OS.
	 */
	private void cadastrarOS() {
		if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecione o Cliente");
			txtPesquisar.requestFocus();
		} else if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Equipamento ");
			txtEquipamento.requestFocus();
		} else if (txtIMEI.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o IMEI do Equipamento");
			txtIMEI.requestFocus();
		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito Informado");
			txtDefeito.requestFocus();
		} else if (cboStatus.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Status do Orçamento");
		} else {
			String insert = "insert into servico (idCliente,equipamento,acessorio,IMEI,defeito,diagnostico,tecnico,statusreparo,valor,sinal,receber) values (?,?,?,?,?,?,?,?,?,?,?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(insert);
				pst.setString(1, txtID.getText());
				pst.setString(2, txtEquipamento.getText());
				pst.setString(3, txtAcessorio.getText());
				pst.setString(4, txtIMEI.getText());
				pst.setString(5, txtDefeito.getText());
				pst.setString(6, txtDiagnostico.getText());
				pst.setString(7, cboTecnico.getSelectedItem().toString());
				pst.setString(8, cboStatus.getSelectedItem().toString());
				pst.setString(9, txtValor.getText());
				pst.setString(10, txtSinal.getText());
				pst.setString(11, txtReceber.getText());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Orçamento Cadastrado com Sucesso");
					limpar();
					adicionarOS();
					pesquisar();
					int excluir = JOptionPane.showConfirmDialog(null, "Imprimir Orçamento?", "",
							JOptionPane.YES_NO_OPTION);
					if (excluir == JOptionPane.YES_OPTION)
						imprimirOS();
				}
				con.close();
			} catch (java.sql.SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao Cadastrar o Orçamento, Tente Novamente");
				limpar();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Excluir OS.
	 */
	void excluirOS() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Orçamento ?",
				"ATENÇÃO, Não Recomendado!!", JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from servico where idOs = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtOS.getText());
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Orçamento excluído com sucesso");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Adicionar OS.
	 */
	void adicionarOS() {
		String read = "SELECT MAX(idOs) FROM servico;  ";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtOS.setText(rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Imprimir OS.
	 */
	private void imprimirOS() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Orcamento.pdf"));
			document.open();
			
			com.itextpdf.text.Image figura = com.itextpdf.text.Image.getInstance(Orcamento.class.getResource("/img/logo.PNG"));
			figura.scaleToFit(100, 100);
			figura.setAbsolutePosition(472, 730);
			document.add(figura);
			
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			Paragraph paragraph2 = new Paragraph(20F, "Ordem de Serviço",FontFactory.getFont(FontFactory.HELVETICA, 20F, Font.BOLD));
			paragraph2.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph2);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			Paragraph paragraph = new Paragraph(11);
			String relClientes = "select servico.idOs as IdServiço, servico.defeito as Defeito, nomeContato as Nome, servico.equipamento as Equipamento, servico.imei as IMEI, servico.receber as Valor, whatsapp as Contato, \r\n"
					+ "email as Email, razao as Razao, cpf as CPF \r\n"
					+ "from servico inner join clientes on servico.idCliente = clientes.idFor where idOs = ?;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relClientes);
				pst.setString(1, txtOS.getText());
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Paragraph col1 = new Paragraph(new Paragraph(13F, "NÚMERO: " + rs.getString(1),
							FontFactory.getFont(FontFactory.HELVETICA, 13F, Font.BOLD)));
					col1.setAlignment(Element.ALIGN_RIGHT);
					Paragraph col2 = new Paragraph(new Paragraph("Defeito: " + rs.getString(2)));
					Paragraph col3 = new Paragraph(
							new Paragraph(rs.getString(3), FontFactory.getFont(FontFactory.HELVETICA, 14F, Font.BOLD)));
					col3.setAlignment(Element.ALIGN_CENTER);
					Paragraph col4 = new Paragraph(new Paragraph("Equipamento: " + rs.getString(4)));
					Paragraph col5 = new Paragraph(new Paragraph("IMEI: " + rs.getString(5)));
					Paragraph col6 = new Paragraph(new Paragraph("Valor: " + rs.getString(6)));
					Paragraph col7 = new Paragraph(new Paragraph("Contato: " + rs.getString(7)));
					Paragraph col8 = new Paragraph(new Paragraph("E-mail: " + rs.getString(8)));
					Paragraph col9 = new Paragraph(new Paragraph(rs.getString(9),
							FontFactory.getFont(FontFactory.HELVETICA, 17F, Font.BOLD, BaseColor.GRAY)));
					col9.setAlignment(Element.ALIGN_CENTER);
					Paragraph col10 = new Paragraph(new Paragraph("CPF: " + rs.getString(10)));
					Paragraph col11 = new Paragraph(new Paragraph(" "));

					paragraph.add(col1);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col9);
					paragraph.add(col3);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col10);
					paragraph.add(col8);
					paragraph.add(col7);
					paragraph.add(col11);
					paragraph.add(col4);
					paragraph.add(col5);
					paragraph.add(col2);
					paragraph.add(col11);
					paragraph.add(col6);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(
							"__________________________                                                   __________________________");
					paragraph.add(col11);
					paragraph.add(
							"                 CLIENTE                                                                              TECH UNDERGROUND");
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add(col11);
					paragraph.add("*Garantia de 90 dias para mesmo defeito apresentado.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			document.add(paragraph);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}
		try {
			Desktop.getDesktop().open(new File("Orcamento.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Limpar.
	 */
	void limpar() {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		txtID.setText(null);
		txtCliente.setText(null);
		txtEmail.setText(null);
		txtContato.setText(null);
		txtEmpresa.setText(null);
		txtCNPJ.setText(null);
		txtOS.setText(null);
		txtEquipamento.setText(null);
		txtAcessorio.setText(null);
		txtIMEI.setText(null);
		txtDefeito.setText(null);
		txtDiagnostico.setText(null);
		cboTecnico.setSelectedItem("");
		cboStatus.setSelectedItem("");
		dataEntrada.setDate(null);
		txtValor.setText(null);
		txtSinal.setText(null);
		txtReceber.setText(null);
		txtOS.setEditable(true);
		btnBuscarOS.setEnabled(true);
		txtPesquisar.setEditable(true);
		txtCliente.setEditable(true);
		txtEmail.setEditable(true);
		txtContato.setEditable(true);
		txtEmpresa.setEditable(true);
		txtCNPJ.setEditable(true);
		btnCliente.setEnabled(true);
		btnADD.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnImpressora.setEnabled(false);
		txtValor.setEditable(true);
		txtSinal.setEditable(true);
		txtOS.requestFocus();
	}

	/**
	 * Calcular valor.
	 */
	void calcularValor() {
		if (txtSinal.getText().isEmpty()) {
			txtReceber.setText(txtValor.getText());
		} else {
			double valor, sinal, receber;
			valor = Double.parseDouble(txtValor.getText());
			sinal = Double.parseDouble(txtSinal.getText());
			receber = (valor - sinal);
			txtReceber.setText(String.valueOf(receber));
		}
	}
}
