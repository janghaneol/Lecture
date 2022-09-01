package namoo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.user.dto.User;

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
	public void read(String id) throws SQLException {
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
			if (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
			}

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
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
		sb.append(" SELECT id, password, name, email, regdate )")
		  .append(" FROM users ");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<User>();
			while (rs.next()) {
				User user1 = new User();
				user1.setId(rs.getString("id"));
				user1.setPassword(rs.getString("password"));
				user1.setName(rs.getString("name"));
				user1.setEmail(rs.getString("email"));
				user1.setRegdate(rs.getString("regdate"));
				list.add(user1);
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
}
