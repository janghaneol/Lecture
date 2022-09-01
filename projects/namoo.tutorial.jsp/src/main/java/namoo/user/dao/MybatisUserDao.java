package namoo.user.dao;

import java.sql.SQLException;
import java.util.List;

import namoo.user.dto.User;

public class MybatisUserDao implements UserDao {

	@Override
	public void create(User user) throws SQLException {
		
	}

	@Override
	public boolean read(String id) throws SQLException {
		return true;
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

	@Override
	public List<User> listByPage(int page) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<User> listByPage(int page, int pageSize) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<User> listByPage(int page, int pageSize, String searchType, String searchValue) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int countByPage(String searchType, String searchValue) throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
