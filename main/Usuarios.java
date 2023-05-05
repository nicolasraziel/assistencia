package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;

import models.DAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuarios.
 */
public class Usuarios extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The txt id. */
	private JTextField txtId;
	
	/** The txt usuario. */
	private JTextField txtUsuario;
	
	/** The txt login. */
	private JTextField txtLogin;
	
	/** The txt password. */
	private JPasswordField txtPassword;
	
	/** The cbo perfil. */
	@SuppressWarnings("rawtypes")
	private JComboBox cboPerfil;
	
	/** The chck senha. */
	private JCheckBox chckSenha;
	
	/** The btn excluir. */
	private JButton btnExcluir;
	
	/** The btn editar. */
	private JButton btnEditar;
	
	/** The btn adicionar. */
	private JButton btnAdicionar;
	
	/** The btn limpar. */
	private JButton btnLimpar;
	
	/** The btn buscar. */
	private JButton btnBuscar;
	
	/** The content panel. */
	private JPanel contentPanel;
	
	/** The lbl new label 5. */
	private JLabel lblNewLabel_5;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new usuarios.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Usuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/logoapp.png")));
		setModal(true);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		setResizable(false);
		setTitle("Cadastro de Usuário");
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 684, 461);
		getContentPane().add(contentPanel);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Usuarios.class.getResource("/img/logo123.png")));
		lblNewLabel_5.setBounds(570, 373, 104, 77);
		contentPanel.add(lblNewLabel_5);

		txtId = new JTextField();
		txtId.setBounds(628, 30, 46, 20);
		contentPanel.add(txtId);
		txtId.setToolTipText("ID do Usuário");
		txtId.setEditable(false);
		txtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(599, 33, 29, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.setBounds(34, 245, 38, 14);
		contentPanel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));

		cboPerfil = new JComboBox();
		cboPerfil.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboPerfil.setBounds(90, 241, 119, 22);
		contentPanel.add(cboPerfil);
		cboPerfil.setToolTipText("Perfil do Usuário");
		cboPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboPerfil.setModel(
		new DefaultComboBoxModel(new String[] { "", "Recepcionista", "Tecnico", "Gerente", "Administrador" }));

		txtPassword = new JPasswordField();
		txtPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPassword.setBounds(90, 178, 263, 20);
		contentPanel.add(txtPassword);
		txtPassword.setToolTipText("Senha");

		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(34, 181, 46, 14);
		contentPanel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		chckSenha = new JCheckBox("Alterar senha");
		chckSenha.setBorder(new LineBorder(new Color(0, 0, 0)));
		chckSenha.setBounds(380, 177, 120, 23);
		contentPanel.add(chckSenha);
		chckSenha.setToolTipText("Selecione para Alterar a Senha");
		chckSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setBounds(31, 118, 46, 14);
		contentPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtUsuario = new JTextField();
		txtUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtUsuario.setBounds(89, 115, 378, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setToolTipText("Usuario");
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(33, 61, 46, 14);
		contentPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtLogin = new JTextField();
		txtLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtLogin.setBounds(89, 58, 118, 20);
		contentPanel.add(txtLogin);
		txtLogin.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pesquisarUsuario();
				}
			}
		});
		txtLogin.setToolTipText("Login");
		txtLogin.setColumns(10);

		btnBuscar = new JButton("");
		btnBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBuscar.setBounds(217, 51, 46, 35);
		contentPanel.add(btnBuscar);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search.png")));
		btnBuscar.setToolTipText("Buscar Usuário");

		btnAdicionar = new JButton("");
		btnAdicionar.setBounds(358, 380, 70, 70);
		contentPanel.add(btnAdicionar);
		btnAdicionar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setToolTipText("Adicionar Usuário");
		btnAdicionar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/clienteadd.png")));

		btnEditar = new JButton("");
		btnEditar.setBounds(242, 380, 70, 70);
		contentPanel.add(btnEditar);
		btnEditar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setEnabled(false);
		btnEditar.setToolTipText("Atualizar Usuário");
		btnEditar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/update48x48.png")));

		btnExcluir = new JButton("");
		btnExcluir.setBounds(127, 380, 70, 70);
		contentPanel.add(btnExcluir);
		btnExcluir.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setEnabled(false);
		btnExcluir.setToolTipText("Deletar Usuário");
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/img/clientedelete.png")));

		btnLimpar = new JButton("");
		btnLimpar.setBounds(467, 395, 55, 55);
		contentPanel.add(btnLimpar);
		btnLimpar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Procurar Novo Usuário");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckSenha.isSelected()) {
					alterarUsuarioSenha();
				} else {
					alterarUsuario();
				}
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});
		chckSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPassword.setEditable(true);
				txtPassword.setText(null);
				txtPassword.requestFocus();
				txtPassword.setBackground(Color.LIGHT_GRAY);
			}
		});
		chckSenha.setVisible(false);
		
		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setOnlyNums(false);
		login.setLimit(20);
		
		RestrictedTextField usuario = new RestrictedTextField(txtUsuario);
		usuario.setOnlyNums(false);
		usuario.setLimit(50);
	}

	/** The dao. */
	DAO dao = new DAO();

	/**
	 * Pesquisar usuario.
	 */
	private void pesquisarUsuario() {
		String read = "select * from usuario where login = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtLogin.getText());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtUsuario.setText(rs.getString(2));
				txtId.setText(rs.getString(1));
				txtPassword.setText(rs.getString(4));
				cboPerfil.setSelectedItem(rs.getString(5));
				chckSenha.setVisible(true);
				txtPassword.setEditable(false);
				txtLogin.setEditable(false);
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnAdicionar.setEnabled(false);
				btnBuscar.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "Usuario inexistente");
				limparCampos();
				txtLogin.requestFocus();
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Adicionar usuario.
	 */
	@SuppressWarnings("deprecation")
	private void adicionarUsuario() {
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtLogin.requestFocus();
		} else if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuario");
			txtUsuario.requestFocus();
		} else if (txtPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Senha");
			txtPassword.requestFocus();
		} else if (cboPerfil.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Perfil");
		} else {
			String create = "insert into usuario (usuario,login,senha,perfil) values (?,?,md5(?),?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				String capturaSenha = new String(txtPassword.getPassword());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Usuario nao adicionado");
				}
				limparCampos();
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Usuario nao adicionado - Login existente");
				txtLogin.setText(null);
				txtLogin.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	/**
	 * Alterar usuario.
	 */
	private void alterarUsuario() {
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
			txtLogin.requestFocus();
		} else if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Telefone");
			txtUsuario.requestFocus();
		} else if (cboPerfil.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Perfil");
		} else {
			String update = "update usuario set usuario = ?, login = ?, perfil = ? where id = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, cboPerfil.getSelectedItem().toString());
				pst.setString(4, txtId.getText());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do usuario alterados com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Dados do usuario nao foram alterados");
				}
				limparCampos();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Alterar usuario senha.
	 */
	private void alterarUsuarioSenha() {
		String update = "update usuario set usuario = ?, login = ?, senha = md5(?), perfil = ? where id = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtLogin.getText());
			String capturaSenha = new String(txtPassword.getPassword());
			pst.setString(3, capturaSenha);
			pst.setString(4, cboPerfil.getSelectedItem().toString());
			pst.setString(5, txtId.getText());
			int confirma = pst.executeUpdate();
			if (confirma == 1) {
				JOptionPane.showMessageDialog(null, "Dados do usuario alterados com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "ERRO - Dados do usuario nao foram alterados");
			}
			limparCampos();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Excluir usuario.
	 */
	private void excluirUsuario() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusao deste usuario ?", "ATENCAO!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from usuario where id = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				int excluido = pst.executeUpdate();
				if (excluido == 1) {
					limparCampos();
					JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro na exclusao do usuario");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Limpar campos.
	 */
	private void limparCampos() {
		txtId.setText(null);
		txtUsuario.setText(null);
		txtLogin.setText(null);
		txtPassword.setText(null);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setEditable(true);
		cboPerfil.setSelectedItem("");
		chckSenha.setSelected(false);
		chckSenha.setVisible(false);
		txtLogin.setEditable(true);
		txtLogin.requestFocus();
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnAdicionar.setEnabled(true);
		btnBuscar.setEnabled(true);
	}
}
