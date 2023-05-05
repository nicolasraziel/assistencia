package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.dom4j.io.SAXReader;

import org.dom4j.Document;
import org.dom4j.Element;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.border.TitledBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
@SuppressWarnings("serial")
public class Cliente extends JDialog {
	
	/** The table. */
	JTable table;
	
	/** The btn adicionar. */
	JButton btnAdicionar;
	
	/** The btn update. */
	JButton btnUpdate;
	
	/** The btn delete 1. */
	JButton btnDelete_1;
	
	/** The btn pesquisar. */
	JButton btnPesquisar;
	
	/** The txt cliente. */
	JTextField txtCliente;
	
	/** The txt contato. */
	JTextField txtContato;
	
	/** The txt telefone. */
	JTextField txtTelefone;
	
	/** The lbl new label 1. */
	JLabel lblNewLabel_1;
	
	/** The lbl new label 2. */
	JLabel lblNewLabel_2;
	
	/** The lbl email. */
	JLabel lblEmail;
	
	/** The txt email. */
	JTextField txtEmail;
	
	/** The lbl new label 3. */
	JLabel lblNewLabel_3;
	
	/** The txt CPF. */
	JTextField txtCPF;
	
	/** The txt razao. */
	JTextField txtRazao;
	
	/** The txt fantasia. */
	JTextField txtFantasia;
	
	/** The txt CNPJ. */
	JTextField txtCNPJ;
	
	/** The txt inscricao. */
	JTextField txtInscricao;
	
	/** The txt CEP. */
	JTextField txtCEP;
	
	/** The txt endereco. */
	JTextField txtEndereco;
	
	/** The txt cidade. */
	JTextField txtCidade;
	
	/** The txt bairro. */
	JTextField txtBairro;
	
	/** The txt numero. */
	JTextField txtNumero;
	
	/** The txt complemento. */
	JTextField txtComplemento;
	
	/** The txt observacao. */
	JTextField txtObservacao;
	
	/** The txt pesquisar. */
	JTextField txtPesquisar;
	
	/** The txt ID. */
	JTextField txtID;
	
	/** The lbl new label 9. */
	JLabel lblNewLabel_9;
	
	/** The content panel. */
	JPanel contentPanel;
	
	/** The lbl new label 11 2. */
	JLabel lblNewLabel_11_2;
	
	/** The lbl new label 11 3. */
	JLabel lblNewLabel_11_3;
	
	/** The lbl new label 11 4. */
	JLabel lblNewLabel_11_4;
	
	/** The lbl new label 11 5. */
	JLabel lblNewLabel_11_5;
	
	/** The lbl new label 11 6. */
	JLabel lblNewLabel_11_6;
	
	/** The lbl new label 11 7. */
	JLabel lblNewLabel_11_7;
	
	/** The lbl new label 11 8. */
	JLabel lblNewLabel_11_8;
	
	/** The lbl new label 11 9. */
	JLabel lblNewLabel_11_9;
	
	/** The cbo UF. */
	@SuppressWarnings("rawtypes")
	JComboBox cboUF;
	
	/** The chck juridico. */
	JCheckBox chckJuridico;
	
	/** The btn delete. */
	JButton btnDelete;
	
	/** The btn busca CEP. */
	JButton btnBuscaCEP;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			Cliente dialog = new Cliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Cliente() {
		getContentPane().setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/img/logoapp.png")));
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				pesquisarClienteNome();
				txtPesquisar.requestFocus();
			}
		});
		setModal(true);
		setTitle("Cadastro de Cliente");
		setBounds(100, 100, 800, 750);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Pesquisar Cliente",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 764, 150);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		scrollPane.setBounds(3, 48, 758, 98);
		panel.add(scrollPane);

		table = new JTable();
		table.setToolTipText("Selecione o Cliente");
		table.setCellSelectionEnabled(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, { ' ', ' ' }, },
				new String[] { "Nome", "CPF", "Razão", "ID" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_7 = new JLabel("Pesquisar");
		lblNewLabel_7.setBounds(10, 20, 67, 14);
		panel.add(lblNewLabel_7);

		txtPesquisar = new JTextField();
		txtPesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPesquisar.setToolTipText("Pesquisar Cliente");
		txtPesquisar.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				pesquisarClienteNome();
			}
		});
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(76, 17, 160, 20);
		panel.add(txtPesquisar);

		txtID = new JTextField();
		txtID.setToolTipText("ID do Cliente");
		txtID.setEditable(false);
		txtID.setBounds(709, 17, 45, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("ID");
		lblNewLabel_8.setBounds(684, 20, 25, 14);
		panel.add(lblNewLabel_8);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Endere\u00E7o",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 447, 764, 172);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 21, 42, 14);
		panel_2.add(lblCep);

		txtCEP = new JTextField();
		txtCEP.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCEP.setToolTipText("CEP");
		txtCEP.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarCEP();
					txtCEP.requestFocus();
				}
			}
		});
		txtCEP.setBounds(77, 18, 86, 20);
		panel_2.add(txtCEP);
		txtCEP.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEndereco.setToolTipText("Endereço");
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(77, 58, 185, 20);
		panel_2.add(txtEndereco);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 61, 57, 14);
		panel_2.add(lblEndereco);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 104, 57, 14);
		panel_2.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCidade.setToolTipText("Cidade");
		txtCidade.setColumns(10);
		txtCidade.setBounds(77, 101, 185, 20);
		panel_2.add(txtCidade);

		JLabel lblEndereo_1_1 = new JLabel("Bairro");
		lblEndereo_1_1.setBounds(309, 104, 42, 14);
		panel_2.add(lblEndereo_1_1);

		txtBairro = new JTextField();
		txtBairro.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtBairro.setToolTipText("Bairro");
		txtBairro.setColumns(10);
		txtBairro.setBounds(354, 101, 185, 20);
		panel_2.add(txtBairro);

		JLabel lblEndereo_1_1_1 = new JLabel("Nº");
		lblEndereo_1_1_1.setBounds(319, 61, 32, 14);
		panel_2.add(lblEndereo_1_1_1);

		txtNumero = new JTextField();
		txtNumero.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtNumero.setToolTipText("Número");
		txtNumero.setColumns(10);
		txtNumero.setBounds(354, 58, 57, 20);
		panel_2.add(txtNumero);

		txtComplemento = new JTextField();
		txtComplemento.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtComplemento.setToolTipText("Complemento");
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(552, 58, 202, 20);
		panel_2.add(txtComplemento);

		JLabel lblNewLabel_4 = new JLabel("Complemento");
		lblNewLabel_4.setBounds(468, 61, 86, 14);
		panel_2.add(lblNewLabel_4);

		cboUF = new JComboBox();
		cboUF.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboUF.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboUF.setToolTipText("UF");
		cboUF.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUF.setBounds(608, 100, 57, 22);
		panel_2.add(cboUF);

		JLabel lblNewLabel_5 = new JLabel("UF");
		lblNewLabel_5.setBounds(580, 104, 32, 14);
		panel_2.add(lblNewLabel_5);

		btnBuscaCEP = new JButton("");
		btnBuscaCEP.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBuscaCEP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscaCEP.setIcon(new ImageIcon(Cliente.class.getResource("/img/search.png")));
		btnBuscaCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCEP();
			}
		});
		btnBuscaCEP.setToolTipText("Buscar CEP");
		btnBuscaCEP.setBounds(185, 11, 46, 35);
		panel_2.add(btnBuscaCEP);

		JLabel lblNewLabel_6 = new JLabel("OBS");
		lblNewLabel_6.setBounds(10, 147, 46, 14);
		panel_2.add(lblNewLabel_6);

		txtObservacao = new JTextField();
		txtObservacao.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtObservacao.setToolTipText("Observação");
		txtObservacao.setColumns(10);
		txtObservacao.setBounds(77, 144, 459, 20);
		panel_2.add(txtObservacao);

		btnAdicionar = new JButton("");
		btnAdicionar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();
			}
		});
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setToolTipText("Adicionar Cliente");
		btnAdicionar.setIcon(new ImageIcon(Cliente.class.getResource("/img/clienteadd.png")));
		btnAdicionar.setBounds(194, 630, 70, 70);
		getContentPane().add(btnAdicionar);

		btnUpdate = new JButton("");
		btnUpdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarCliente();
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("Atualizar Cliente");
		btnUpdate.setIcon(new ImageIcon(Cliente.class.getResource("/img/phoneUpdate.png")));
		btnUpdate.setBounds(300, 630, 70, 70);
		getContentPane().add(btnUpdate);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Pessoa F\u00EDsica",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 178, 764, 103);
		getContentPane().add(panel_2_1);

		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 25, 50, 14);
		panel_2_1.add(lblNewLabel);

		txtCliente = new JTextField();
		txtCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCliente.setToolTipText("Nome do Cliente");
		txtCliente.setBounds(59, 22, 160, 20);
		panel_2_1.add(txtCliente);
		txtCliente.setColumns(10);

		txtContato = new JTextField();
		txtContato.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtContato.setToolTipText("Número para Contato");
		txtContato.setColumns(10);
		txtContato.setBounds(594, 22, 160, 20);
		panel_2_1.add(txtContato);

		txtTelefone = new JTextField();
		txtTelefone.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTelefone.setToolTipText("Telefone");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(330, 22, 160, 20);
		panel_2_1.add(txtTelefone);

		lblNewLabel_1 = new JLabel("Telefone");
		lblNewLabel_1.setBounds(266, 25, 63, 14);
		panel_2_1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Contato");
		lblNewLabel_2.setBounds(538, 25, 57, 14);
		panel_2_1.add(lblNewLabel_2);

		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 69, 50, 14);
		panel_2_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321qwertyuiopasdfghjklçzxcvbnm@.-_";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtEmail.setToolTipText("E-mail");
		txtEmail.setColumns(10);
		txtEmail.setBounds(59, 66, 160, 20);
		panel_2_1.add(txtEmail);

		lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(266, 69, 63, 14);
		panel_2_1.add(lblNewLabel_3);

		txtCPF = new JTextField();
		txtCPF.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCPF.setToolTipText("CPF");
		txtCPF.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321x";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCPF.setColumns(10);
		txtCPF.setBounds(330, 66, 160, 20);
		panel_2_1.add(txtCPF);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(240, 240, 240));
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Pessoa Jur\u00EDdica",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1.setBounds(10, 299, 764, 129);
		getContentPane().add(panel_2_1_1);

		chckJuridico = new JCheckBox("Pessoa Jurídica");
		chckJuridico.setBackground(new Color(240, 240, 240));
		chckJuridico.setBorder(new LineBorder(new Color(0, 0, 0)));
		chckJuridico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckJuridico.setToolTipText("Pessoa Jurídica");
		chckJuridico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox juridica = (JCheckBox) e.getSource();
				if (juridica.isSelected()) {
					txtRazao.setEditable(true);
					txtFantasia.setEditable(true);
					txtCNPJ.setEditable(true);
					txtInscricao.setEditable(true);
					panel_2_1_1.setBackground(new Color(255, 255, 255));
					chckJuridico.setBackground(new Color(255, 255, 255));
				} else {
					txtRazao.setEditable(false);
					txtFantasia.setEditable(false);
					txtCNPJ.setEditable(false);
					txtInscricao.setEditable(false);
					txtRazao.setText(null);
					txtFantasia.setText(null);
					txtCNPJ.setText(null);
					txtInscricao.setText(null);
					panel_2_1_1.setBackground(new Color(240, 240, 240));
					chckJuridico.setBackground(new Color(240, 240, 240));
				}
			}
		});
		chckJuridico.setBounds(10, 11, 122, 23);
		panel_2_1_1.add(chckJuridico);

		JLabel lblRazo = new JLabel("Razão");
		lblRazo.setBounds(10, 47, 56, 14);
		panel_2_1_1.add(lblRazo);

		txtRazao = new JTextField();
		txtRazao.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtRazao.setToolTipText("Razão Social");
		txtRazao.setEditable(false);
		txtRazao.setColumns(10);
		txtRazao.setBounds(66, 44, 265, 20);
		panel_2_1_1.add(txtRazao);

		JLabel lblNewLabel_1_1 = new JLabel("Fantasia");
		lblNewLabel_1_1.setBounds(424, 47, 63, 14);
		panel_2_1_1.add(lblNewLabel_1_1);

		txtFantasia = new JTextField();
		txtFantasia.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFantasia.setToolTipText("Nome Fantasia");
		txtFantasia.setEditable(false);
		txtFantasia.setColumns(10);
		txtFantasia.setBounds(489, 44, 265, 20);
		panel_2_1_1.add(txtFantasia);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 90, 56, 14);
		panel_2_1_1.add(lblCnpj);

		txtCNPJ = new JTextField();
		txtCNPJ.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCNPJ.setToolTipText("CNPJ");
		txtCNPJ.setEditable(false);
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(66, 87, 265, 20);
		panel_2_1_1.add(txtCNPJ);

		JLabel lblNewLabel_1_1_1 = new JLabel("Inscrição");
		lblNewLabel_1_1_1.setBounds(424, 90, 63, 14);
		panel_2_1_1.add(lblNewLabel_1_1_1);

		txtInscricao = new JTextField();
		txtInscricao.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtInscricao.setToolTipText("Inscrição Estadual");
		txtInscricao.setEditable(false);
		txtInscricao.setColumns(10);
		txtInscricao.setBounds(489, 87, 265, 20);
		panel_2_1_1.add(txtInscricao);

		btnDelete = new JButton("");
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Cliente.class.getResource("/img/clientedelete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
			}
		});
		btnDelete.setToolTipText("Deletar Cliente");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(407, 630, 70, 70);
		getContentPane().add(btnDelete);

		lblNewLabel_11_2 = new JLabel("*");
		lblNewLabel_11_2.setForeground(Color.RED);
		lblNewLabel_11_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_2.setBounds(221, 25, 16, 14);
		panel_2_1.add(lblNewLabel_11_2);

		lblNewLabel_11_3 = new JLabel("*");
		lblNewLabel_11_3.setForeground(Color.RED);
		lblNewLabel_11_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_3.setBounds(492, 25, 16, 14);
		panel_2_1.add(lblNewLabel_11_3);

		lblNewLabel_11_4 = new JLabel("*");
		lblNewLabel_11_4.setForeground(Color.RED);
		lblNewLabel_11_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_4.setBounds(221, 69, 16, 14);
		panel_2_1.add(lblNewLabel_11_4);

		lblNewLabel_11_5 = new JLabel("*");
		lblNewLabel_11_5.setForeground(Color.RED);
		lblNewLabel_11_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_5.setBounds(492, 69, 16, 14);
		panel_2_1.add(lblNewLabel_11_5);

		JLabel lblNewLabel_11 = new JLabel("*");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setForeground(new Color(255, 0, 0));
		lblNewLabel_11.setBounds(414, 61, 16, 14);
		panel_2.add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("*");
		lblNewLabel_11_1.setForeground(Color.RED);
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1.setBounds(265, 61, 16, 14);
		panel_2.add(lblNewLabel_11_1);

		lblNewLabel_11_6 = new JLabel("*");
		lblNewLabel_11_6.setForeground(Color.RED);
		lblNewLabel_11_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_6.setBounds(265, 104, 16, 14);
		panel_2.add(lblNewLabel_11_6);

		lblNewLabel_11_7 = new JLabel("*");
		lblNewLabel_11_7.setForeground(Color.RED);
		lblNewLabel_11_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_7.setBounds(541, 104, 16, 14);
		panel_2.add(lblNewLabel_11_7);

		lblNewLabel_11_8 = new JLabel("*");
		lblNewLabel_11_8.setForeground(Color.RED);
		lblNewLabel_11_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_8.setBounds(667, 104, 16, 14);
		panel_2.add(lblNewLabel_11_8);

		lblNewLabel_11_9 = new JLabel("*");
		lblNewLabel_11_9.setForeground(Color.RED);
		lblNewLabel_11_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_9.setBounds(165, 21, 16, 14);
		panel_2.add(lblNewLabel_11_9);

		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Cliente.class.getResource("/img/logo123.png")));
		lblNewLabel_9.setBounds(676, 630, 98, 70);
		getContentPane().add(lblNewLabel_9);

		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBounds(0, 0, 784, 750);
		getContentPane().add(contentPanel);

		JLabel lblNewLabel_10 = new JLabel("(*) Campos Obrigátorio");
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		lblNewLabel_10.setBounds(10, 683, 139, 14);
		contentPanel.add(lblNewLabel_10);

		btnPesquisar = new JButton("");
		btnPesquisar.setBounds(515, 645, 55, 55);
		contentPanel.add(btnPesquisar);
		btnPesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setToolTipText("Pesquisar Novo Cliente");
		btnPesquisar.setIcon(new ImageIcon(Cliente.class.getResource("/img/search.png")));
		
		RestrictedTextField ID = new RestrictedTextField(txtID);
		ID.setOnlyNums(true);
		ID.setLimit(10);

		RestrictedTextField CEP = new RestrictedTextField(txtCEP);
		CEP.setOnlyNums(true);
		CEP.setLimit(8);

		RestrictedTextField Endereco = new RestrictedTextField(txtEndereco);
		Endereco.setOnlyNums(false);
		Endereco.setLimit(50);

		RestrictedTextField Numero = new RestrictedTextField(txtNumero);
		Numero.setOnlyNums(true);
		Numero.setLimit(6);

		RestrictedTextField Complemento = new RestrictedTextField(txtComplemento);
		Complemento.setOnlyNums(false);
		Complemento.setLimit(20);

		RestrictedTextField Bairro = new RestrictedTextField(txtBairro);
		Bairro.setOnlyNums(false);
		Bairro.setLimit(50);

		RestrictedTextField Cidade = new RestrictedTextField(txtCidade);
		Cidade.setOnlyText(true);
		Cidade.setAcceptSpace(true);
		Cidade.setLimit(50);

		RestrictedTextField Cliente = new RestrictedTextField(txtCliente);
		Cliente.setOnlyText(true);
		Cliente.setAcceptSpace(true);
		Cliente.setLimit(30);

		RestrictedTextField Telefone = new RestrictedTextField(txtTelefone);
		Telefone.setOnlyNums(true);
		Telefone.setLimit(11);

		RestrictedTextField Inscricao = new RestrictedTextField(txtInscricao);
		Inscricao.setOnlyNums(false);
		Inscricao.setLimit(14);

		RestrictedTextField Cpf = new RestrictedTextField(txtCPF);
		Cpf.setLimit(11);

		RestrictedTextField Razao = new RestrictedTextField(txtRazao);
		Razao.setLimit(50);

		RestrictedTextField Fantasia = new RestrictedTextField(txtFantasia);
		Fantasia.setLimit(50);

		RestrictedTextField CNPJ = new RestrictedTextField(txtCNPJ);
		CNPJ.setOnlyNums(true);
		CNPJ.setLimit(14);

		RestrictedTextField Contato = new RestrictedTextField(txtContato);
		Contato.setOnlyNums(true);
		Contato.setLimit(11);

		RestrictedTextField Email = new RestrictedTextField(txtEmail);
		Email.setLimit(50);

		RestrictedTextField observacao = new RestrictedTextField(txtObservacao);
		observacao.setLimit(250);
	}

	/** The dao. */
	DAO dao = new DAO();

	/**
	 * Pesquisar cliente.
	 */
	void pesquisarCliente() {
		if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o ID");
			txtID.requestFocus();
		} else {
			String read = "select * from clientes where idFor = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtID.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtCEP.setText(rs.getString(2));
					txtEndereco.setText(rs.getString(3));
					txtNumero.setText(rs.getString(4));
					txtComplemento.setText(rs.getString(5));
					txtBairro.setText(rs.getString(6));
					txtCidade.setText(rs.getString(7));
					cboUF.setSelectedItem(rs.getString(8));
					txtCliente.setText(rs.getString(9));
					txtTelefone.setText(rs.getString(10));
					txtContato.setText(rs.getString(11));
					txtEmail.setText(rs.getString(12));
					txtCPF.setText(rs.getString(18));
					txtRazao.setText(rs.getString(14));
					txtFantasia.setText(rs.getString(15));
					txtCNPJ.setText(rs.getString(16));
					txtInscricao.setText(rs.getString(17));
					txtObservacao.setText(rs.getString(13));
					txtID.setEditable(false);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnAdicionar.setEnabled(false);
					if (txtRazao.getText().isEmpty()) {
						chckJuridico.setSelected(false);
						txtRazao.setEditable(false);
						txtFantasia.setEditable(false);
						txtCNPJ.setEditable(false);
						txtInscricao.setEditable(false);
					} else {
						chckJuridico.setSelected(true);
						txtRazao.setEditable(true);
						txtFantasia.setEditable(true);
						txtCNPJ.setEditable(true);
						txtInscricao.setEditable(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Cliente inexistente");
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					btnAdicionar.setEnabled(true);
					txtID.setText(null);
					txtCliente.requestFocus();
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Atualizar cliente.
	 */
	void atualizarCliente() {
		if (txtCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
			txtCliente.requestFocus();
		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Telefone");
			txtTelefone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o E-mail");
			txtEmail.requestFocus();
		} else if (txtCPF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CPF");
			txtCPF.requestFocus();
		} else if (cboUF.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha a UF");
		} else {
			String update = "update clientes set cep = ?, endereço = ?, numero = ? , complemento = ?, bairro = ?, cidade = ?, uf = ?, nomeContato = ?, fone = ?, whatsapp = ?, email = ?, cpf = ?, razao = ?, fantasia = ?, CNPJ = ?, inscricao = ?, obs = ? where idFor = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtCEP.getText());
				pst.setString(2, txtEndereco.getText());
				pst.setString(3, txtNumero.getText());
				pst.setString(4, txtComplemento.getText());
				pst.setString(5, txtBairro.getText());
				pst.setString(6, txtCidade.getText());
				pst.setString(7, cboUF.getSelectedItem().toString());
				pst.setString(8, txtCliente.getText());
				pst.setString(9, txtTelefone.getText());
				pst.setString(10, txtContato.getText());
				pst.setString(11, txtEmail.getText());
				pst.setString(12, txtCPF.getText());
				pst.setString(13, txtRazao.getText());
				pst.setString(14, txtFantasia.getText());
				pst.setString(15, txtCNPJ.getText());
				pst.setString(16, txtInscricao.getText());
				pst.setString(17, txtObservacao.getText());
				pst.setString(18, txtID.getText());
				int executa = pst.executeUpdate();
				if (executa == 1) {
					JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso!");
					limpar();
					txtPesquisar.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Erro: Cliente não atualizado!");
				}
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cliente não adicionado - Cliente ja cadastrado");
				txtPesquisar.setText(null);
				txtPesquisar.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Excluir cliente.
	 */
	void excluirCliente() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Cliente ?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from clientes where idFor = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtID.getText());
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
				}
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cliente não Excluido! - Cliente vinculado a uma O.S");
				limpar();
				txtCliente.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Cadastrar cliente.
	 */
	void cadastrarCliente() {
		if (txtCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
			txtCliente.requestFocus();
		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone");
			txtTelefone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Email");
			txtEmail.requestFocus();
		} else if (txtCEP.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP");
			txtCEP.requestFocus();
		} else if (txtCPF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CPF");
			txtCPF.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Número");
			txtNumero.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade");
			txtCidade.requestFocus();
		} else if (cboUF.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha a UF");
		} else {
			String create = "insert into clientes (cep,endereço,numero,complemento,bairro,cidade,uf,nomeContato,fone,whatsapp,email,obs,razao,fantasia,cnpj,inscricao,cpf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtCEP.getText());
				pst.setString(2, txtEndereco.getText());
				pst.setString(3, txtNumero.getText());
				pst.setString(4, txtComplemento.getText());
				pst.setString(5, txtBairro.getText());
				pst.setString(6, txtCidade.getText());
				pst.setString(7, cboUF.getSelectedItem().toString());
				pst.setString(8, txtCliente.getText());
				pst.setString(9, txtTelefone.getText());
				pst.setString(10, txtContato.getText());
				pst.setString(11, txtEmail.getText());
				pst.setString(12, txtObservacao.getText());
				pst.setString(13, txtRazao.getText());
				pst.setString(14, txtFantasia.getText());
				pst.setString(15, txtCNPJ.getText());
				pst.setString(16, txtInscricao.getText());
				pst.setString(17, txtCPF.getText());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente Adicionado");
					limpar();
					adicionarOs();
					pesquisarCliente();
					int excluir = JOptionPane.showConfirmDialog(null, "Cliente Cadastrado, Cadastrar novo Cliente?", "",
							JOptionPane.YES_NO_OPTION);
					if (excluir == JOptionPane.YES_OPTION)
						limpar();
					txtCliente.requestFocus();
				}
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cliente Não Adicionado - Cliente ja cadastrado");
				limpar();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Adicionar os.
	 */
	void adicionarOs() {
		String read = "SELECT MAX(idFor) FROM clientes;  ";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtID.setText(rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Setar campos.
	 */
	void setarCampos() {
		int setar = table.getSelectedRow();
		txtID.setText(table.getModel().getValueAt(setar, 3).toString());
		pesquisarCliente();
		((DefaultTableModel) table.getModel()).setRowCount(0);
		txtPesquisar.setEditable(false);
	}

	/**
	 * Pesquisar cliente nome.
	 */
	private void pesquisarClienteNome() {
		String read3 = "select nomeContato as Nome, cpf as CPF, razao as Razão, idFor as ID from clientes where nomeContato like ?";
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
		txtID.setText(null);
		txtCEP.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		txtCliente.setText(null);
		txtTelefone.setText(null);
		txtContato.setText(null);
		txtRazao.setText(null);
		txtFantasia.setText(null);
		txtCNPJ.setText(null);
		txtInscricao.setText(null);
		txtCPF.setText(null);
		txtEmail.setText(null);
		txtObservacao.setText(null);
		txtPesquisar.setText(null);
		cboUF.setSelectedItem("");
		txtRazao.setEditable(false);
		txtFantasia.setEditable(false);
		txtCNPJ.setEditable(false);
		txtInscricao.setEditable(false);
		txtID.setEditable(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		chckJuridico.setSelected(false);
		btnAdicionar.setEnabled(true);
		txtPesquisar.setEditable(true);
		((DefaultTableModel) table.getModel()).setRowCount(0);
		txtPesquisar.requestFocus();
		pesquisarClienteNome();
	}

	/**
	 * Buscar CEP.
	 */
	void buscarCEP() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCEP.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (@SuppressWarnings("unchecked")
			Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUF.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						txtNumero.setText(null);
						txtComplemento.setText(null);
						txtObservacao.setText(null);
						txtNumero.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
						txtCEP.setText(null);
						txtEndereco.setText(null);
						txtNumero.setText(null);
						txtComplemento.setText(null);
						txtCidade.setText(null);
						txtBairro.setText(null);
						txtObservacao.setText(null);
						cboUF.setSelectedItem("");
					}
				}
			}
			txtEndereco.setText(tipoLogradouro + " " + logradouro);
			txtNumero.requestFocus();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
