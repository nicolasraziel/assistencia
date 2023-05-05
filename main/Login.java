
package main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import main.Login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The lbl status. */
	private JLabel lblStatus;
	
	/** The lbl login. */
	private JLabel lblLogin;
	
	/** The txt login. */
	private JTextField txtLogin;
	
	/** The lbl new label 1. */
	private JLabel lblNewLabel_1;
	
	/** The txt senha. */
	private JPasswordField txtSenha;
	
	/** The lbl new label. */
	private JLabel lblNewLabel;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new login.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/logoapp.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setTitle("Tech Underground");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 318);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAcessar.setToolTipText("Acessar o Sistema");
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAcessar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setBounds(163, 164, 105, 33);
		contentPane.add(btnAcessar);

		lblStatus = new JLabel("");
		lblStatus.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblStatus.setToolTipText("Status do Sistema");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(10, 223, 48, 48);
		contentPane.add(lblStatus);

		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(115, 73, 46, 14);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtLogin.setToolTipText("Login");
		txtLogin.setBounds(171, 70, 128, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(115, 116, 46, 14);
		contentPane.add(lblNewLabel_1);
		getRootPane().setDefaultButton(btnAcessar);

		txtSenha = new JPasswordField();
		txtSenha.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSenha.setToolTipText("Senha");
		txtSenha.setBounds(172, 113, 127, 20);
		contentPane.add(txtSenha);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/logo123.png")));
		lblNewLabel.setBounds(329, 201, 98, 70);
		contentPane.add(lblNewLabel);
		
		RestrictedTextField Login = new RestrictedTextField(txtLogin);
		Login.setLimit(20);
		
		RestrictedTextField Senha = new RestrictedTextField(txtSenha);
		Senha.setLimit(20);
	}

	/** The dao. */
	DAO dao = new DAO();
	
	/**
	 * Status.
	 */
	private void status() {
		try {
			Connection con = dao.conectar();
			if (con == null) {
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Logar.
	 */
	private void logar() {
		String capturaSenha = new String(txtSenha.getPassword());
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu Login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Digite a sua Senha");
			txtSenha.requestFocus();
		} else {
			String read = "select * from usuario where login= ? and senha= md5(?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					Main main = new Main();
					String perfil = rs.getString(5);
					if (perfil.equals("Gerente")) {
						main.setVisible(true);
						main.lblUsuario.setText(rs.getString(2));
						main.btnClientes.setEnabled(true);
						main.btnOrcamentos.setEnabled(true);
						main.btnFicha.setEnabled(true);
						main.btnRelatorios.setEnabled(true);
						this.dispose();
					} else if (perfil.equals("Recepcionista")) {
						main.setVisible(true);
						main.lblUsuario.setText(rs.getString(2));
						main.btnClientes.setEnabled(true);
						main.btnOrcamentos.setEnabled(true);
						this.dispose();
					} else if (perfil.equals("Tecnico")) {
						main.setVisible(true);
						main.lblUsuario.setText(rs.getString(2));
						main.btnClientes.setEnabled(true);
						main.btnOrcamentos.setEnabled(true);
						main.btnFicha.setEnabled(true);
						this.dispose();
					} else {
						main.setVisible(true);
						main.lblUsuario.setText(rs.getString(2));
						main.btnClientes.setEnabled(true);
						main.btnOrcamentos.setEnabled(true);
						main.btnFicha.setEnabled(true);
						main.btnRelatorios.setEnabled(true);
						main.btnUsuarios.setEnabled(true);
						this.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Login e/ou senha Incorreta");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
