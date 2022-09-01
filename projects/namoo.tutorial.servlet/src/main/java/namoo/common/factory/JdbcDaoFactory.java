package namoo.common.factory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import namoo.user.dao.JdbcUserDao;
import namoo.user.dao.UserDao;

/**
 * JDBC 기술을 이용하여 DAO 객체를 생성하는 팩토리
 * 
 * @author Administrator
 *
 */
public class JdbcDaoFactory implements DaoFactory {

	private static JdbcDaoFactory instance = new JdbcDaoFactory();
	private String driver;
	private String url;
	private String user;
	private String password;
	private DataSource dataSource;
	private UserDao userDao;

	private JdbcDaoFactory() {
		loadProperties();
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(10); // 풀의 초기 커넥션 개수
		ds.setMaxTotal(100); // 최대 커넥션 개수
		ds.setMaxIdle(10); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		ds.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		dataSource = ds;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
			e.printStackTrace();
		}
	}

	public static JdbcDaoFactory getInstance() {
		return instance;
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new JdbcUserDao(dataSource);
		}
		return userDao;
	}
	

}
