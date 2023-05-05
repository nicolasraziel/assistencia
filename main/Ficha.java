package main;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import com.mysql.cj.jdbc.Blob;
import com.toedter.calendar.JDateChooser;
import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class Ficha.
 */
@SuppressWarnings("serial")
public class Ficha extends JDialog {

	/** The content panel. */
	private final JPanel contentPanel = new JPanel();
	
	/** The text field. */
	private JTextField textField;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The text field 3. */
	private JTextField textField_3;
	
	/** The text field 4. */
	private JTextField textField_4;
	
	/** The text field 5. */
	private JTextField textField_5;
	
	/** The text field 6. */
	private JTextField textField_6;
	
	/** The txt pesquisar. */
	private JTextField txtPesquisar;
	
	/** The txt ID. */
	private JTextField txtID;
	
	/** The txt cliente. */
	private JTextField txtCliente;
	
	/** The txt email. */
	private JTextField txtEmail;
	
	/** The txt contato. */
	private JTextField txtContato;
	
	/** The txt razao. */
	private JTextField txtRazao;
	
	/** The txt CNPJ. */
	private JTextField txtCNPJ;
	
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
	
	/** The tamanho. */
	private int tamanho;
	
	/** The fis. */
	private FileInputStream fis;
	
	/** The data entrada. */
	private JDateChooser dataEntrada;
	
	/** The btn pesquisar. */
	private JButton btnPesquisar;
	
	/** The btn update. */
	private JButton btnUpdate;
	
	/** The btn foto. */
	private JButton btnFoto;
	
	/** The lbl foto. */
	private JLabel lblFoto;
	
	/** The cbo status. */
	@SuppressWarnings("rawtypes")
	private JComboBox cboStatus;
	
	/** The cbo tecnico. */
	@SuppressWarnings("rawtypes")
	private JComboBox cboTecnico;
	
	/** The table. */
	private JTable table;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			Ficha dialog = new Ficha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Instantiates a new ficha.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Ficha() {
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				pesquisarOS();
				txtPesquisar.requestFocus();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha.class.getResource("/img/logoapp.png")));
		setTitle("Ficha Ténica");
		setModal(true);
		setBounds(100, 100, 800, 750);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Pesquisar O.S",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 764, 218);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("Nº O.S");
			lblNewLabel.setBounds(10, 14, 61, 14);
			panel.add(lblNewLabel);

			txtPesquisar = new JTextField();
			txtPesquisar.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					pesquisarOS();
				}
			});
			txtPesquisar.setToolTipText("Pesquisar Orçamento");
			txtPesquisar.setColumns(10);
			txtPesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtPesquisar.setBounds(66, 11, 61, 20);
			panel.add(txtPesquisar);

			JLabel lblNewLabel_1 = new JLabel("ID Cliente");
			lblNewLabel_1.setBounds(643, 14, 68, 14);
			panel.add(lblNewLabel_1);

			txtID = new JTextField();
			txtID.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtID.setToolTipText("ID do Cliente");
			txtID.setEditable(false);
			txtID.setColumns(10);
			txtID.setBounds(711, 11, 43, 20);
			panel.add(txtID);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(255, 255, 255));
			scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			scrollPane.setBounds(3, 36, 758, 102);
			panel.add(scrollPane);

			table = new JTable();
			table.setToolTipText("Selecione o Orçamento");
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					setarCampos();
				}
			});
			table.setModel(new DefaultTableModel(
					new Object[][] { { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, },
					new String[] { "Orcamento", "Equipamento", "Defeito", "Cliente", "Status" }));

			scrollPane.setViewportView(table);

			JLabel lblNewLabel_2 = new JLabel("Cliente");
			lblNewLabel_2.setBounds(10, 154, 46, 14);
			panel.add(lblNewLabel_2);

			txtCliente = new JTextField();
			txtCliente.setEditable(false);
			txtCliente.setToolTipText("Nome do Cliente");
			txtCliente.setColumns(10);
			txtCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtCliente.setBounds(66, 151, 186, 20);
			panel.add(txtCliente);

			JLabel lblNewLabel_3 = new JLabel("E-mail");
			lblNewLabel_3.setBounds(285, 154, 46, 14);
			panel.add(lblNewLabel_3);

			txtEmail = new JTextField();
			txtEmail.setEditable(false);
			txtEmail.setToolTipText("Email");
			txtEmail.setColumns(10);
			txtEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtEmail.setBounds(331, 151, 186, 20);
			panel.add(txtEmail);

			JLabel lblNewLabel_4 = new JLabel("Contato");
			lblNewLabel_4.setBounds(555, 154, 52, 14);
			panel.add(lblNewLabel_4);

			txtContato = new JTextField();
			txtContato.setEditable(false);
			txtContato.setToolTipText("Contato");
			txtContato.setColumns(10);
			txtContato.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtContato.setBounds(607, 149, 147, 20);
			panel.add(txtContato);

			JLabel lblNewLabel_5 = new JLabel("Razão");
			lblNewLabel_5.setBounds(10, 190, 52, 14);
			panel.add(lblNewLabel_5);

			txtRazao = new JTextField();
			txtRazao.setEditable(false);
			txtRazao.setToolTipText("Razão Social");
			txtRazao.setColumns(10);
			txtRazao.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtRazao.setBounds(66, 187, 186, 20);
			panel.add(txtRazao);

			txtCNPJ = new JTextField();
			txtCNPJ.setEditable(false);
			txtCNPJ.setToolTipText("CNPJ");
			txtCNPJ.setColumns(10);
			txtCNPJ.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtCNPJ.setBounds(331, 187, 186, 20);
			panel.add(txtCNPJ);

			JLabel lblNewLabel_6 = new JLabel("CNPJ");
			lblNewLabel_6.setBounds(285, 190, 36, 14);
			panel.add(lblNewLabel_6);
		}

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Equipamento",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 229, 764, 174);
		contentPanel.add(panel_1);

		JLabel lblNewLabel_8 = new JLabel("Equipamento");
		lblNewLabel_8.setBounds(10, 25, 80, 14);
		panel_1.add(lblNewLabel_8);

		txtEquipamento = new JTextField();
		txtEquipamento.setEditable(false);
		txtEquipamento.setToolTipText("Equipamento");
		txtEquipamento.setColumns(10);
		txtEquipamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEquipamento.setBounds(93, 22, 424, 20);
		panel_1.add(txtEquipamento);

		JLabel lblNewLabel_8_1 = new JLabel("Acessorios");
		lblNewLabel_8_1.setBounds(10, 56, 80, 14);
		panel_1.add(lblNewLabel_8_1);

		txtAcessorio = new JTextField();
		txtAcessorio.setEditable(false);
		txtAcessorio.setToolTipText("Acessórios");
		txtAcessorio.setColumns(10);
		txtAcessorio.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAcessorio.setBounds(93, 53, 424, 20);
		panel_1.add(txtAcessorio);

		JLabel lblNewLabel_8_1_1 = new JLabel("IMEI");
		lblNewLabel_8_1_1.setBounds(10, 87, 80, 14);
		panel_1.add(lblNewLabel_8_1_1);

		txtIMEI = new JTextField();
		txtIMEI.setToolTipText("IMEI");
		txtIMEI.setColumns(10);
		txtIMEI.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtIMEI.setBounds(93, 84, 424, 20);
		panel_1.add(txtIMEI);

		txtDefeito = new JTextField();
		txtDefeito.setEditable(false);
		txtDefeito.setToolTipText("Defeito Relatado");
		txtDefeito.setColumns(10);
		txtDefeito.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDefeito.setBounds(93, 115, 424, 20);
		panel_1.add(txtDefeito);

		txtDiagnostico = new JTextField();
		txtDiagnostico.setToolTipText("Defeito Diagnósticado");
		txtDiagnostico.setColumns(10);
		txtDiagnostico.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDiagnostico.setBounds(93, 146, 424, 20);
		panel_1.add(txtDiagnostico);

		JLabel lblNewLabel_8_1_1_1 = new JLabel("Defeito");
		lblNewLabel_8_1_1_1.setBounds(10, 118, 80, 14);
		panel_1.add(lblNewLabel_8_1_1_1);

		JLabel lblNewLabel_8_1_1_2 = new JLabel("Diagnóstico");
		lblNewLabel_8_1_1_2.setBounds(10, 149, 80, 14);
		panel_1.add(lblNewLabel_8_1_1_2);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Foto", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 407, 764, 292);
		contentPanel.add(panel_2);

		dataEntrada = new JDateChooser();
		dataEntrada.setToolTipText("Data de Entrada do Equipamento");
		dataEntrada.setEnabled(false);
		dataEntrada.setBorder(new LineBorder(new Color(0, 0, 0)));
		dataEntrada.setBounds(626, 18, 128, 20);
		panel_2.add(dataEntrada);

		JLabel lblNewLabel_4_1 = new JLabel("Entrada");
		lblNewLabel_4_1.setBounds(569, 21, 57, 14);
		panel_2.add(lblNewLabel_4_1);

		lblFoto = new JLabel("");
		lblFoto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblFoto.setBounds(10, 18, 221, 263);
		panel_2.add(lblFoto);

		btnFoto = new JButton("");
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarFoto();
			}
		});
		btnFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnFoto.setIcon(new ImageIcon(Ficha.class.getResource("/img/fotoadd.png")));
		btnFoto.setToolTipText("Adicionar Foto");
		btnFoto.setEnabled(false);
		btnFoto.setBounds(241, 18, 55, 55);
		panel_2.add(btnFoto);

		btnUpdate = new JButton("");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarOS();
			}
		});
		btnUpdate.setIcon(new ImageIcon(Ficha.class.getResource("/img/phoneUpdate.png")));
		btnUpdate.setToolTipText("Atualizar Orçamento");
		btnUpdate.setEnabled(false);
		btnUpdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdate.setBounds(404, 211, 70, 70);
		panel_2.add(btnUpdate);

		btnPesquisar = new JButton("");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(Ficha.class.getResource("/img/search.png")));
		btnPesquisar.setToolTipText("Pesquisar Novo Orçamento");
		btnPesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPesquisar.setBounds(518, 226, 55, 55);
		panel_2.add(btnPesquisar);

		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setIcon(new ImageIcon(Ficha.class.getResource("/img/logo123.png")));
		lblNewLabel_9_1.setBounds(656, 211, 98, 70);
		panel_2.add(lblNewLabel_9_1);

		JLabel lblNewLabel_10_1 = new JLabel("(*) Campos Obrigátorio");
		lblNewLabel_10_1.setForeground(Color.RED);
		lblNewLabel_10_1.setBounds(241, 267, 142, 14);
		panel_2.add(lblNewLabel_10_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Pesquisar");
		lblNewLabel.setBounds(10, 11, 62, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setToolTipText("Pesquisar Cliente");
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setBounds(75, 7, 129, 20);
		panel.add(textField);

		JLabel lblNewLabel_1 = new JLabel("ID Cliente");
		lblNewLabel_1.setBounds(646, 11, 68, 14);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setToolTipText("ID do Cliente");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(713, 9, 43, 20);
		panel.add(textField_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBounds(1, 37, 763, 102);
		panel.add(scrollPane);

		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(10, 150, 46, 14);
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setToolTipText("Nome do Cliente");
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_2.setBounds(67, 147, 186, 20);
		panel.add(textField_2);

		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(292, 150, 46, 14);
		panel.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setToolTipText("Email");
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_3.setBounds(332, 147, 186, 20);
		panel.add(textField_3);

		JLabel lblNewLabel_4 = new JLabel("Contato");
		lblNewLabel_4.setBounds(559, 150, 46, 14);
		panel.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setToolTipText("Contato");
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_4.setBounds(609, 147, 147, 20);
		panel.add(textField_4);

		JLabel lblNewLabel_5 = new JLabel("Razão");
		lblNewLabel_5.setBounds(10, 186, 52, 14);
		panel.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setToolTipText("Razão Social");
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_5.setBounds(67, 183, 186, 20);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setToolTipText("CNPJ");
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_6.setBounds(332, 183, 186, 20);
		panel.add(textField_6);

		JLabel lblNewLabel_6 = new JLabel("CNPJ");
		lblNewLabel_6.setBounds(292, 186, 36, 14);
		panel.add(lblNewLabel_6);

		JButton btnCliente = new JButton("");
		btnCliente.setToolTipText("Cadastrar Cliente");
		btnCliente.setBounds(210, 2, 32, 32);
		panel.add(btnCliente);
		setLocationRelativeTo(null);

		cboStatus = new JComboBox();
		cboStatus.setBounds(572, 48, 170, 22);
		panel_1.add(cboStatus);
		cboStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Aguardando Técnico", "Em Análise",
				"Aguardando Aprovação", "Não Aprovado", "Aprovado", "Em Manutenção", "Concluído", "Retirado" }));
		cboStatus.setToolTipText("Status do Pedido");
		cboStatus.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel_11 = new JLabel("Status do Pedido");
		lblNewLabel_11.setBounds(606, 25, 104, 14);
		panel_1.add(lblNewLabel_11);

		cboTecnico = new JComboBox();
		cboTecnico.setBounds(614, 87, 128, 22);
		panel_1.add(cboTecnico);
		cboTecnico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboTecnico.setModel(new DefaultComboBoxModel(new String[] { "", "Pedro", "Nicolas", "Alessandro" }));
		cboTecnico.setToolTipText("Técnico");
		cboTecnico.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel_10 = new JLabel("Técnico");
		lblNewLabel_10.setBounds(556, 90, 58, 14);
		panel_1.add(lblNewLabel_10);

		txtValor = new JTextField();
		txtValor.setBounds(645, 130, 97, 20);
		panel_1.add(txtValor);
		txtValor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtValor.setToolTipText("Valor do Conserto");
		txtValor.setColumns(10);
		txtValor.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel_13 = new JLabel("Valor");
		lblNewLabel_13.setBounds(600, 133, 46, 14);
		panel_1.add(lblNewLabel_13);

		JLabel lblNewLabel_11_2 = new JLabel("*");
		lblNewLabel_11_2.setForeground(Color.RED);
		lblNewLabel_11_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_2.setBounds(519, 87, 16, 14);
		panel_1.add(lblNewLabel_11_2);

		JLabel lblNewLabel_11_2_1 = new JLabel("*");
		lblNewLabel_11_2_1.setForeground(Color.RED);
		lblNewLabel_11_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_2_1.setBounds(519, 149, 16, 14);
		panel_1.add(lblNewLabel_11_2_1);

		JLabel lblNewLabel_11_2_2 = new JLabel("*");
		lblNewLabel_11_2_2.setForeground(Color.RED);
		lblNewLabel_11_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_2_2.setBounds(744, 51, 16, 14);
		panel_1.add(lblNewLabel_11_2_2);

		JLabel lblNewLabel_11_2_3 = new JLabel("*");
		lblNewLabel_11_2_3.setForeground(Color.RED);
		lblNewLabel_11_2_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_2_3.setBounds(744, 90, 16, 14);
		panel_1.add(lblNewLabel_11_2_3);

		RestrictedTextField Diagnostico = new RestrictedTextField(txtDiagnostico);
		Diagnostico.setLimit(50);

		RestrictedTextField Pesquisar = new RestrictedTextField(txtPesquisar);
		Pesquisar.setOnlyNums(true);
		Pesquisar.setLimit(5);

		RestrictedTextField Valor = new RestrictedTextField(txtValor);
		Valor.setLimit(10);

		RestrictedTextField IMEI = new RestrictedTextField(txtIMEI);
		IMEI.setAcceptSpace(true);
		IMEI.setLimit(50);
	}

	/** The dao. */
	DAO dao = new DAO();

	/**
	 * Pesquisar orcamento.
	 */
	void pesquisarOrcamento() {
		if (txtPesquisar.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o número da O.S");
			txtPesquisar.requestFocus();
		} else {
			String read = "select * from servico where idOs = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtPesquisar.getText());
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
					String setarData = rs.getString(13);
					Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
					dataEntrada.setDate(dataFormatada);

					txtPesquisar.setEditable(false);
					btnUpdate.setEnabled(true);
					pesquisarCliente();
					buscarFoto();
					btnFoto.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "O.S inexistente");
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
			txtID.requestFocus();

		} else if (txtIMEI.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o IMEI");
			txtIMEI.requestFocus();

		} else if (txtDiagnostico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito Diagnosticado");
			txtDiagnostico.requestFocus();

		} else if (cboStatus.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Status do Pedido");

		} else if (cboTecnico.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Tecnico");

		} else {
			String update = "update servico set idCliente = ?, equipamento = ? , IMEI = ?, defeito = ?, diagnostico = ?, tecnico = ?, valor = ?, statusreparo = ? where idOs = ?";

			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtID.getText());
				pst.setString(2, txtEquipamento.getText());
				pst.setString(3, txtIMEI.getText());
				pst.setString(4, txtDefeito.getText());
				pst.setString(5, txtDiagnostico.getText());
				pst.setString(6, cboTecnico.getSelectedItem().toString());
				pst.setString(7, txtValor.getText());
				pst.setString(8, cboStatus.getSelectedItem().toString());
				pst.setString(9, txtPesquisar.getText());
				int executa = pst.executeUpdate();
				if (executa == 1) {
					JOptionPane.showMessageDialog(null, "O.S Atualizado com Sucesso!");
					limpar();
				} else {
					JOptionPane.showMessageDialog(null, "Erro: O.S não atualizado!");
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
	 * Atualizar foto.
	 */
	void atualizarFoto() {
		if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecione o Cliente");
			txtID.requestFocus();
		} else {
			String update = "update servico set foto = ? where idOs = ?";

			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setBlob(1, fis, tamanho);
				pst.setString(2, txtPesquisar.getText());
				int executa = pst.executeUpdate();
				if (executa == 1) {
				} else {
					JOptionPane.showMessageDialog(null, "Erro: Foto não atualizado!");
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
	 * Pesquisar cliente.
	 */
	void pesquisarCliente() {
		if (txtID.getText().isEmpty()) {
		} else {
			String read = "select * from clientes where idFor = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtID.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtCliente.setText(rs.getString(9));
					txtContato.setText(rs.getString(11));
					txtEmail.setText(rs.getString(12));
					txtRazao.setText(rs.getString(14));
					txtCNPJ.setText(rs.getString(16));
				} else {
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Selecionar foto.
	 */
	private void selecionarFoto() {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Selecionar Arquivo");
		jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de Imagens(*.PNG, *.JPG, *.JPEG", "png", "jpg", "jpeg"));
		int resultado = jfc.showOpenDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			try {
				fis = new FileInputStream(jfc.getSelectedFile());
				tamanho = (int) jfc.getSelectedFile().length();
				Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblFoto.getWidth(),
						lblFoto.getHeight(), Image.SCALE_SMOOTH);
				lblFoto.setIcon(new ImageIcon(foto));
				lblFoto.updateUI();
				atualizarFoto();
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Foto não cadastrado");
			}
		}
	}

	/**
	 * Buscar foto.
	 */
	private void buscarFoto() {
		String read = "select * from servico where idOs = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtPesquisar.getText());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Blob blob = (Blob) rs.getBlob(14);
				byte[] img = blob.getBytes(1, (int) blob.length());
				BufferedImage imagem = null;
				try {
					imagem = ImageIO.read(new ByteArrayInputStream(img));
				} catch (Exception e) {
					System.out.println(e);
				}
				ImageIcon icone = new ImageIcon(imagem);
				Icon foto = new ImageIcon(icone.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_SMOOTH));
				lblFoto.setIcon(foto);
			}
			con.close();
		} catch (Exception e) {
			((DefaultTableModel) table.getModel()).setRowCount(0);
			int excluir = JOptionPane.showConfirmDialog(null, "Foto não cadastrada, Cadastrar agora?", "",
					JOptionPane.YES_NO_OPTION);
			if (excluir == JOptionPane.YES_OPTION)
				selecionarFoto();
		}
	}

	/**
	 * Setar campos.
	 */
	void setarCampos() {
		int setar = table.getSelectedRow();
		txtPesquisar.setText(table.getModel().getValueAt(setar, 0).toString());
		pesquisarOrcamento();
		((DefaultTableModel) table.getModel()).setRowCount(0);
	}

	/**
	 * Pesquisar OS.
	 */
	private void pesquisarOS() {
		String read3 = "select servico.idOs as Orcamento, equipamento as Equipamento, defeito as Defeito, clientes.nomeContato as Cliente, statusreparo as Status from servico join clientes on servico.idCliente = clientes.idFor where idOs like ?";
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
	 * Limpar.
	 */
	void limpar() {
		txtPesquisar.setText(null);
		txtID.setText(null);
		txtEquipamento.setText(null);
		txtAcessorio.setText(null);
		txtIMEI.setText(null);
		txtDefeito.setText(null);
		txtDiagnostico.setText(null);
		txtValor.setText(null);
		dataEntrada.setDate(null);
		lblFoto.setIcon(null);
		txtCliente.setText(null);
		txtContato.setText(null);
		txtEmail.setText(null);
		txtRazao.setText(null);
		txtCNPJ.setText(null);
		cboStatus.setSelectedItem("");
		cboTecnico.setSelectedItem("");
		txtPesquisar.setEditable(true);
		lblFoto.setIcon(null);
		txtPesquisar.requestFocus();
		btnFoto.setEnabled(false);
		btnUpdate.setEnabled(false);
		((DefaultTableModel) table.getModel()).setRowCount(0);
		pesquisarOS();
	}
}
