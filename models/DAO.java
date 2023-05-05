package models;

import java.sql.Connection;
import java.sql.DriverManager;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";

	/** The url. */
	private String url = "jdbc:mysql://10.26.45.131:3306/assistencia";
	
	/** The user. */
	private String user = "dba";
	
	/** The password. */
	private String password = "123@senac";

	/** The con. */
	private Connection con;

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	public Connection conectar() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

