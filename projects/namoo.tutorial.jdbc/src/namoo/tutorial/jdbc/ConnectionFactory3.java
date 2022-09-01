package namoo.tutorial.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 싱글톤 패턴이 적용된 Connection Factory 에 프로퍼티적용하기
 * @author Administrator
 *
 */
public class ConnectionFactory3 {
	private static ConnectionFactory3 instance = new ConnectionFactory3();
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private ConnectionFactory3() {
			loadProperties();
			try {
				Class.forName(driver);
				} catch (ClassNotFoundException e) { 
					e.printStackTrace();
				}
			}
	private void loadProperties() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		try {
			prop.load(in);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.user = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
	public static ConnectionFactory3 getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
