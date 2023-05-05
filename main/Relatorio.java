package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import models.DAO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Desktop;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Relatorio.
 */
public class Relatorio extends JDialog {

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
					Relatorio dialog = new Relatorio();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new relatorio.
	 */
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	public Relatorio() {
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblStatus.setText(formatador.format(data));
			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
			setModal(true);
			setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorio.class.getResource("/img/logoapp.png")));
			setTitle("Relatório");
			setBounds(100, 100, 650, 475);
			getContentPane().setLayout(null);
			setLocationRelativeTo(null);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.setToolTipText("Relatório de Concluidos");
			btnNewButton.setIcon(new ImageIcon(Relatorio.class.getResource("/img/relatorioconcluido.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						relatorioConcluidos();
				}
			});
			btnNewButton.setBounds(455, 154, 135, 135);
			getContentPane().add(btnNewButton);
			
			JPanel panelUsuarios = new JPanel();
			panelUsuarios.setLayout(null);
			panelUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelUsuarios.setBackground(new Color(26, 183, 242));
			panelUsuarios.setBounds(0, 0, 634, 64);
			getContentPane().add(panelUsuarios);
			
			lblStatus = new JLabel("");
			lblStatus.setToolTipText("Data");
			lblStatus.setForeground(Color.WHITE);
			lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblStatus.setBounds(144, 11, 344, 48);
			panelUsuarios.add(lblStatus);
			
			JLabel lblStatus_1 = new JLabel("");
			lblStatus_1.setToolTipText("Data");
			lblStatus_1.setForeground(Color.WHITE);
			lblStatus_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblStatus_1.setBounds(203, 11, 259, 48);
			panelUsuarios.add(lblStatus_1);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Relatorio.class.getResource("/img/logo123.png")));
			lblNewLabel.setBounds(520, 348, 104, 77);
			getContentPane().add(lblNewLabel);
			
			JPanel contentPanel = new JPanel();
			contentPanel.setBackground(new Color(255, 255, 255));
			contentPanel.setLayout(null);
			contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			contentPanel.setBounds(0, 0, 634, 436);
			getContentPane().add(contentPanel);
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setBounds(50, 152, 135, 135);
			contentPanel.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorioCliente();
				}
			});
			btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_1.setToolTipText("Relatório de Clientes");
			btnNewButton_1.setIcon(new ImageIcon(Relatorio.class.getResource("/img/relatorioclientes.png")));
			
						JButton btnRelatorio = new JButton("");
						btnRelatorio.setBounds(254, 152, 135, 135);
						contentPanel.add(btnRelatorio);
						btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btnRelatorio.setToolTipText("Relatório de Pendentes");
						btnRelatorio.setIcon(new ImageIcon(Relatorio.class.getResource("/img/pendente128x128.png")));
						btnRelatorio.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								relatorioPendentes(); 
							}
						});
		}
	
		/** The dao. */
		DAO dao = new DAO();
				
		/**
		 * Relatorio cliente.
		 */
		private void relatorioCliente() {
			Document document = new Document(PageSize.A4.rotate());
			try {
				PdfWriter.getInstance(document, new FileOutputStream("Clientes.pdf"));
				document.open();
				Image figura = Image.getInstance(Relatorio.class.getResource("/img/logo.PNG"));
				figura.scaleAbsolute(100, 100);
				figura.setAbsolutePosition(730, 485);
				document.add(figura);	
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				document.add(new Paragraph(new Paragraph(formatador.format(data))));
				document.add(new Paragraph(" "));
				document.add(new Paragraph(" "));
				Paragraph paragraph = new Paragraph(17F, "Clientes",
				FontFactory.getFont(FontFactory.HELVETICA, 17F, Font.BOLD));
				paragraph.setAlignment(Element.ALIGN_CENTER);
				document.add(paragraph);
				document.add(new Paragraph(" "));
				document.add(new Paragraph(" "));
				PdfPTable tabela = new PdfPTable(6);
				PdfPCell col1 = new PdfPCell(new Paragraph("Nº O.S"));
				col1.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell col2 = new PdfPCell(new Paragraph("Cliente"));
				col2.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
				col3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell col4 = new PdfPCell(new Paragraph("CPF"));
				col3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell col5 = new PdfPCell(new Paragraph("Empresa"));
				col4.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell col6 = new PdfPCell(new Paragraph("CNPJ"));
				col5.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col6);
				String relClientes = "select idFor as ID, nomeContato as Cliente, cpf as CPF, fone as Telefone, razao as Razao, cnpj as CNPJ from clientes";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(relClientes);		
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						tabela.addCell(rs.getString(1));
						tabela.addCell(rs.getString(2));
						tabela.addCell(rs.getString(4));
						tabela.addCell(rs.getString(3));
						tabela.addCell(rs.getString(5));
						tabela.addCell(rs.getString(6));
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			} finally { 
				document.close();
			}
			try {
				Desktop.getDesktop().open(new File("Clientes.pdf"));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
			/**
			 * Relatorio pendentes.
			 */
			private void relatorioPendentes() {
				Document document = new Document();
				try {
					PdfWriter.getInstance(document, new FileOutputStream("Pendentes.pdf"));
					document.setPageSize(PageSize.A4.rotate());
					document.open();
					Image figura = Image.getInstance(Relatorio.class.getResource("/img/logo.PNG"));
					figura.scaleAbsolute(100, 100);
					figura.setAbsolutePosition(730, 485);
					document.add(figura);	
					Date data = new Date();
					DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
					document.add(new Paragraph(new Paragraph(formatador.format(data))));
					document.add(new Paragraph("■"));
					document.add(new Paragraph("■"));
					document.add(new Paragraph("■"));
					Paragraph paragraph2 = new Paragraph(17F, "Chamados Pendentes",
					FontFactory.getFont(FontFactory.HELVETICA, 17F, Font.BOLD));
					paragraph2.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph2);
					document.add(new Paragraph("■"));
					document.add(new Paragraph("■"));
					PdfPTable tabela = new PdfPTable(6);
					PdfPCell col1 = new PdfPCell(new Paragraph("nº O.S"));
					col1.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col2 = new PdfPCell(new Paragraph("Cliente"));
					col2.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col3 = new PdfPCell(new Paragraph("Equipamento"));
					col3.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col4 = new PdfPCell(new Paragraph("Defeito"));
					col4.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col5 = new PdfPCell(new Paragraph("Técnico"));
					col5.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col6 = new PdfPCell(new Paragraph("Status"));
					col6.setHorizontalAlignment(Element.ALIGN_CENTER);
					tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);
					tabela.addCell(col4);
					tabela.addCell(col5);
					tabela.addCell(col6);
					String relClientes = "select idOs as ID, nomeContato as Cliente, equipamento as Equipamento, defeito as Defeito, tecnico as Técnico, statusreparo as Status from servico inner join clientes on servico.idCliente = clientes.idFor where statusreparo = 'Aguardando Técnico' or statusreparo = 'Em Analise' or statusreparo = 'Aguardando Aprovação' or statusreparo = 'Aprovado' or statusreparo = 'Em Manutenção' ";
					try {
						Connection con = dao.conectar();
						PreparedStatement pst = con.prepareStatement(relClientes);		
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							tabela.addCell(rs.getString(1));
							tabela.addCell(rs.getString(2));
							tabela.addCell(rs.getString(3));
							tabela.addCell(rs.getString(4));
							tabela.addCell(rs.getString(5));
							tabela.addCell(rs.getString(6));
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					document.add(tabela);
				} catch (Exception e) {
					System.out.println(e);
				} finally { 
					document.close();
				}
				try {
					Desktop.getDesktop().open(new File("Pendentes.pdf"));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			
			/**
			 * Relatorio concluidos.
			 */
			private void relatorioConcluidos() {
				Document document = new Document();
				try {
					PdfWriter.getInstance(document, new FileOutputStream("concluido.pdf"));
					document.setPageSize(PageSize.A4.rotate());
					document.open();
					Image figura = Image.getInstance(Relatorio.class.getResource("/img/logo.PNG"));
					figura.scaleAbsolute(100, 100);
					figura.setAbsolutePosition(730, 485);
					document.add(figura);	
					Date data = new Date();
					DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
					document.add(new Paragraph(new Paragraph(formatador.format(data))));
					document.add(new Paragraph("■"));
					document.add(new Paragraph("■"));
					document.add(new Paragraph("■"));
					Paragraph paragraph2 = new Paragraph(17F, "Chamados Concluidos",
					FontFactory.getFont(FontFactory.HELVETICA, 17F, Font.BOLD));
					paragraph2.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph2);
					document.add(new Paragraph("■"));
					document.add(new Paragraph("■"));
					PdfPTable tabela = new PdfPTable(7);
					PdfPCell col1 = new PdfPCell(new Paragraph("nº O.S"));
					col1.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col2 = new PdfPCell(new Paragraph("Cliente"));
					col2.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col3 = new PdfPCell(new Paragraph("Equipamento"));
					col3.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col4 = new PdfPCell(new Paragraph("Defeito"));
					col4.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col5 = new PdfPCell(new Paragraph("Técnico"));
					col5.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col6 = new PdfPCell(new Paragraph("Valor"));
					col6.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell col7 = new PdfPCell(new Paragraph("Status"));
					col7.setHorizontalAlignment(Element.ALIGN_CENTER);
					tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);
					tabela.addCell(col4);
					tabela.addCell(col5);
					tabela.addCell(col6);
					tabela.addCell(col7);
					String relClientes = "select idOs as ID, nomeContato as Cliente, equipamento as Equipamento, defeito as Defeito, tecnico as Técnico, valor as Valor, statusreparo as Status from servico inner join clientes on servico.idCliente = clientes.idFor where statusreparo = 'Não Aprovado' or statusreparo = 'Concluído' or statusreparo = 'Retirado' ";
					try {
						Connection con = dao.conectar();
						PreparedStatement pst = con.prepareStatement(relClientes);		
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							tabela.addCell(rs.getString(1));
							tabela.addCell(rs.getString(2));
							tabela.addCell(rs.getString(3));
							tabela.addCell(rs.getString(4));
							tabela.addCell(rs.getString(5));
							tabela.addCell(rs.getString(6));
							tabela.addCell(rs.getString(7));
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					document.add(tabela);
				} catch (Exception e) {
					System.out.println(e);
				} finally { 
					document.close();
				}
				try {
					Desktop.getDesktop().open(new File("concluido.pdf"));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
