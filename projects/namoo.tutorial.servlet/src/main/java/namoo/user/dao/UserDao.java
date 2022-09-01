package namoo.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import namoo.user.dto.User;

/**
 * DAO 객체는 영속적 데이터 처리를 위한 다양한 기술(JDBC, JPA, ibatis, Hibernate 등)들을
 * 일관된 방법으로 접근할 수 있도록 규약 메소드 선언
 * @author Administrator
 *
 */
public interface UserDao {
	/* 회원 가입 */
	public void create(User user) throws SQLException;
	
	/* 사용자 아이디에 해당하는 정보 반환*/
	public void read(String id) throws SQLException;
	
	/* 사용자 로그인 */
	public User login(String id, String password) throws SQLException;
	
	/* 사용자 전체 조회*/
	public List<User> list() throws SQLException; 
}
