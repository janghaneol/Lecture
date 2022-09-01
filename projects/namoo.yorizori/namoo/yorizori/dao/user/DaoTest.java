package namoo.yorizori.dao.user;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import namoo.yorizori.common.factory.JdbcDaoFactory;
import namoo.yorizori.dto.user.User;

/**
 * 서버에서 동작하는 비즈니스 객체라 가정...
 * @author 김기정
 *
 */
public class DaoTest {

	public static void main(String[] args) {
//		DataSource dataSource = ConnectionFactory.getInstance().getDataSource();
//		UserDao userDao = new JdbcUserDao(dataSource);
//		UserDao userDao = new MybatisUserDao(dataSource);
		
		UserDao userDao = JdbcDaoFactory.getInstance().getUserDao();
//		User user = new User("admin", "1234", "김킬러", "xxx@gmail.com");
		try {
//			userDao.create(user);
//			System.out.println("정상 가입 완료...");
			
//			User user = userDao.read("bangry");
//			if(user != null) {
//				System.out.println(user.getId() + ", " + user.getName());
//			}else {
//				System.out.println("존재하지 않는 아이디입니다.");
//			}
			
//			User user = userDao.login("bangry", "111155");
//			if(user != null) {
//				System.out.println(user.getName() + "님 로그인처리되었습니다..");
//			}else {
//				System.out.println("아이디와 비밀번호를 확인하여 주세요.");
//			}
			
			List<User> list = userDao.list();
			Iterator<User> iter = list.iterator();
			while (iter.hasNext()) {
				User user = iter.next();
//				System.out.println(user.toString());
				System.out.println(user);
			}
			
			
		} catch (SQLException e) {
			System.out.println("회원 가입 처리중 예외 발생 : " + e);
			e.printStackTrace();
		}
	}

}
