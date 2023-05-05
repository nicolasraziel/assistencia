package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	JPanel contentPane;
	
	/** The btn clientes. */
	JButton btnClientes;
	
	/** The btn orcamentos. */
	JButton btnOrcamentos;
	
	/** The btn usuarios. */
	JButton btnUsuarios;
	
	/** The btn relatorios. */
	JButton btnRelatorios;
	
	/** The lbl usuario 1. */
	public Object lblUsuario_1;
	
	/** The panel usuarios. */
	private JPanel panelUsuarios;
	
	/** The lbl status. */
	private JLabel lblStatus;
	
	/** The btn ficha. */
	JButton btnFicha;
	
	/** The btn sobre. */
	private JButton btnSobre;
	
	/** The lbl usuario. */
	JLabel lblUsuario;
	
	/** The panel usuarios 1. */
	private JPanel panelUsuarios_1;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new main.
	 */
	public Main() {
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblStatus.setText(formatador.format(data));
			}
		});
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/logoapp.png")));
		setTitle("Tech Underground");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		btnClientes = new JButton("");
		btnClientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnClientes.setEnabled(false);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setVisible(true);
			}
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Cadastro de Cliente");
		btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/cadastrarcliente.png")));
		btnClientes.setBounds(63, 99, 135, 135);
		contentPane.add(btnClientes);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setEnabled(false);
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setToolTipText("Cadastro de Usuario");
		btnUsuarios.setIcon(new ImageIcon(Main.class.getResource("/img/cadastrarusuario.png")));
		btnUsuarios.setBounds(263, 285, 135, 135);
		contentPane.add(btnUsuarios);
		
		btnOrcamentos = new JButton("");
		btnOrcamentos.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnOrcamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orcamento orcamento = new Orcamento();
				orcamento.setVisible(true);
			}
		});
		btnOrcamentos.setEnabled(false);
		btnOrcamentos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrcamentos.setToolTipText("Orçamento");
		btnOrcamentos.setIcon(new ImageIcon(Main.class.getResource("/img/orcamento128x128.png")));
		btnOrcamentos.setBounds(263, 99, 135, 135);
		contentPane.add(btnOrcamentos);
		
		btnRelatorios = new JButton("");
		btnRelatorios.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorio = new Relatorio();
				relatorio.setVisible(true);
			}
		});
		btnRelatorios.setEnabled(false);
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setToolTipText("Relatório");
		btnRelatorios.setIcon(new ImageIcon(Main.class.getResource("/img/relatório.png")));
		btnRelatorios.setBounds(63, 285, 135, 135);
		contentPane.add(btnRelatorios);
		
		panelUsuarios = new JPanel();
		panelUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuarios.setLayout(null);
		panelUsuarios.setBackground(new Color(26, 183, 242));
		panelUsuarios.setBounds(0, 0, 660, 64);
		contentPane.add(panelUsuarios);
		
		lblStatus = new JLabel("");
		lblStatus.setToolTipText("Data");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus.setBounds(187, 11, 407, 48);
		panelUsuarios.add(lblStatus);
		
		btnFicha = new JButton("");
		btnFicha.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnFicha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFicha.setEnabled(false);
		btnFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ficha ficha = new Ficha();
				ficha.setVisible(true);
			}
		});
		btnFicha.setIcon(new ImageIcon(Main.class.getResource("/img/ficha128x128.png")));
		btnFicha.setToolTipText("Ficha Técnica");
		btnFicha.setBounds(460, 99, 135, 135);
		contentPane.add(btnFicha);
		
		btnSobre = new JButton("");
		btnSobre.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/sobre.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBounds(460, 285, 135, 135);
		contentPane.add(btnSobre);
		
		panelUsuarios_1 = new JPanel();
		panelUsuarios_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuarios_1.setLayout(null);
		panelUsuarios_1.setBackground(new Color(26, 183, 242));
		panelUsuarios_1.setBounds(0, 497, 660, 64);
		contentPane.add(panelUsuarios_1);
		
		lblUsuario = new JLabel("");
		lblUsuario.setToolTipText("Usuário");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setBounds(269, 11, 134, 42);
		panelUsuarios_1.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(556, 421, 104, 77);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/img/logo123.png")));
	}
}
