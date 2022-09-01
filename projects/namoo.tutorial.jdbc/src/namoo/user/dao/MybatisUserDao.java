package namoo.user.dao;

import java.sql.SQLException;
import java.util.List;

import namoo.user.dto.User;

public class MybatisUserDao implements UserDao {

	@Override
	public void create(User user) throws SQLException {
		
	}

	@Override
	public void read(String id) throws SQLException {

	}

	@Override
	public User login(String id, String password) throws SQLException {
		
		return null;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
