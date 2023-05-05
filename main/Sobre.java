package main;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class Sobre.
 */
public class Sobre extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The lbl status. */
	private JLabel lblStatus;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new sobre.
	 */
	public Sobre() {
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblStatus.setText(formatador.format(data));
			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
		setModal(true);
		getContentPane().setForeground(SystemColor.textHighlight);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/logoapp.png")));
		setBounds(150, 150, 700, 500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Sobre.class.getResource("/img/logo123.png")));
		lblNewLabel_9.setBounds(576, 380, 98, 70);
		getContentPane().add(lblNewLabel_9);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPanel.setBounds(0, 0, 684, 461);
		getContentPane().add(contentPanel);
		
		JButton btnYoutube = new JButton("");
		btnYoutube.setBounds(610, 242, 64, 64);
		contentPanel.add(btnYoutube);
		btnYoutube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.youtube.com/channel/UCySbdH4Tt_l5W4gQJrNqm-Q");
			}
		});
		btnYoutube.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnYoutube.setToolTipText("Youtube");
		btnYoutube.setIcon(new ImageIcon(Sobre.class.getResource("/img/youtube.png")));
		
		JButton btnGitHub = new JButton("");
		btnGitHub.setBounds(610, 155, 64, 64);
		contentPanel.add(btnGitHub);
		btnGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/alessandrosribeiro");
			}
		});
		btnGitHub.setIcon(new ImageIcon(Sobre.class.getResource("/img/git.png")));
		btnGitHub.setToolTipText("GitHub");
		btnGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_7 = new JLabel("Versão 1.8");
		lblNewLabel_7.setBounds(10, 115, 138, 22);
		contentPanel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Assistência Técnica Smartphone ");
		lblNewLabel_6.setBounds(10, 90, 466, 22);
		contentPanel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panelUsuarios = new JPanel();
		panelUsuarios.setLayout(null);
		panelUsuarios.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelUsuarios.setBackground(new Color(26, 183, 242));
		panelUsuarios.setBounds(0, 0, 684, 79);
		contentPanel.add(panelUsuarios);
		
		lblStatus = new JLabel("");
		lblStatus.setToolTipText("Data");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus.setBounds(203, 11, 312, 48);
		panelUsuarios.add(lblStatus);
		
		JLabel lblStatus_1 = new JLabel("");
		lblStatus_1.setToolTipText("Data");
		lblStatus_1.setForeground(Color.WHITE);
		lblStatus_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus_1.setBounds(203, 11, 259, 48);
		panelUsuarios.add(lblStatus_1);
		
		JLabel lblStatus_2 = new JLabel("");
		lblStatus_2.setToolTipText("Data");
		lblStatus_2.setForeground(Color.WHITE);
		lblStatus_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus_2.setBounds(203, 11, 259, 48);
		panelUsuarios.add(lblStatus_2);
		
		JLabel lblNewLabel_1 = new JLabel("@Autores");
		lblNewLabel_1.setBounds(10, 352, 219, 22);
		contentPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_5 = new JLabel("Alessandro da Silva");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 385, 138, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Copyright (c) <2023>");
		lblNewLabel_4.setBounds(289, 436, 120, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(317, 377, 70, 70);
		contentPanel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(Sobre.class.getResource("/img/MIT.png")));
		
		JLabel lblNewLabel_8 = new JLabel("Aplicativo para Desktop a base de Java e Banco de dados MYSQL, contendo:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 167, 524, 22);
		contentPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Ferramenta para cadastro de cliente, cadastro de equipamento, controle técnico,");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1.setBounds(10, 200, 557, 22);
		contentPanel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("gerador de O.S, e Relatórios.");
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_2.setBounds(10, 233, 524, 22);
		contentPanel.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel = new JLabel("Pedro Chato Marcellus");
		lblNewLabel.setBounds(10, 410, 154, 14);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Nicolas Brabo Raziel");
		lblNewLabel_2.setBounds(10, 435, 138, 14);
		contentPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

	}
	
	/**
	 * Link.
	 *
	 * @param site the site
	 */
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
