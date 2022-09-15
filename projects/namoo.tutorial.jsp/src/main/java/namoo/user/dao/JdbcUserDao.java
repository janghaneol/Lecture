package namoo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.user.dto.User;
import oracle.net.aso.r;

public class JdbcUserDao implements UserDao {

	private DataSource dataSource;
	
//	DataSource를 할당받아야된다.
	public JdbcUserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
//		String sql = "INSERT INTO users(id, password, name, email)\r\n"
//		   + "VALUES ('haneol','1234','장한얼','jhano9@naver.com')";
		sb.append(" INSERT INTO users(id, password, name, email)").append(" VALUES (?,?,?,?)");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

	}

	@Override
	public User read(String id) throws SQLException {
//		boolean result = false;
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, password, name, email, TO_CHAR(regdate,'YYYYMMDD')")
		  .append(" FROM users ")
		  .append(" WHERE id = ?");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
//			result = rs.next();
			user = createUser(rs);
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
//		return result;
		return user;
	}

	@Override
	public User login(String id, String password) throws SQLException {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, password, name, email, regdate")
		  .append(" FROM users ")
		  .append(" WHERE id = ? AND password = ?");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
			}
		}
			finally {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			}
		return user;
		}

	public List<User> list() throws SQLException {
		List<User> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		StringBuilder sb = new StringBuilder();
//		SELECT * 은 효율이 떨어진다
		sb.append(" SELECT id, password, name, email, regdate ")
		  .append(" FROM users ");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
				list.add(user);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return list;
	}

	private User createUser(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getString("id"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setRegdate(rs.getString("regdate"));
		return user;
	}

	@Override
	public List<User> listByPage(int page) throws SQLException {
		List<User> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT id, name, password, email, regdate")
		  .append(" FROM ( SELECT CEIL(rownum / 10) request_page, id, name, password, email, regdate")
		  .append("       FROM   ( SELECT id, name, password, email, regdate")
		  .append("                FROM users")
		  .append("                ORDER  BY regdate DESC))")
		  .append("	WHERE  request_page = ?");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1 , page);
			rs = pstmt.executeQuery();
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = createUser(rs);
				list.add(user);
			}
		}finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		
		return list;
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
