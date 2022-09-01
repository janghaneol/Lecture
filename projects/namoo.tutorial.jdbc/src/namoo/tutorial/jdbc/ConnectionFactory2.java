package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 싱글톤 패턴이 적용된 Connection Factory
 * @author Administrator
 *
 */
public class ConnectionFactory2 {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "hr";
	private static final String PASSWORD = "1234";
	private static ConnectionFactory2 instance = new ConnectionFactory2();
	
	private ConnectionFactory2() {
			try {
				Class.forName(DRIVER_NAME);
				} catch (ClassNotFoundException e) { 
					e.printStackTrace();
				}
			}
	
	public static ConnectionFactory2 getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
