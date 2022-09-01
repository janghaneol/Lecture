package namoo.user.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import namoo.common.factory.JdbcDaoFactory;
import namoo.user.dto.User;

/**
 * 서버에서 동작하는 비즈니스 객체라 가정
 * 
 * @author Administrator
 *
 */
public class DaoTest {

	public static void main(String[] args) throws SQLException {
//		DataSource dataSource= ConnectionFactory.getInstance().getDataSource();
//		UserDao userDao = new JdbcUserDao(dataSource);
//		UserDao userDao2 = new MybatisUserDao(dataSource);

		UserDao userDao = JdbcDaoFactory.getInstance().getUserDao();

//		User user = new User("asdfsad", "1234", "홍길동", "qwe@na.com");
//		try {
//			userDao.create(user);
//			System.out.println("정상 접근");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("회원가입 처리중 예외 발생 : " + e);
//		}
		
		List<User> list =userDao.list();
		Iterator<User> iter =list.iterator(); 
		while(iter.hasNext()) {
			User user = iter.next();
			System.out.println(user.toString());
		}
	}
}
