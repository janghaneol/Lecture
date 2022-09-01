package namoo.yorizori.dao.user;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.common.web.Params;
import namoo.yorizori.dto.user.User;

public class MybatisUserDao implements UserDao {

	@Override
	public void create(User user) throws SQLException {
		

	}

	@Override
	public User read(String id) throws SQLException {
		
		return null;
	}

	@Override
	public User login(String id, String passwd) throws SQLException {
		
		return null;
	}

	@Override
	public List<User> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listByPage(int page) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listByPage(int page, int listSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listByPage(int page, int listSize, String searchType, String searchValue) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByPage(String searchType, String searchValue) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> listByPage(Params params) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByPage(Params params) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
