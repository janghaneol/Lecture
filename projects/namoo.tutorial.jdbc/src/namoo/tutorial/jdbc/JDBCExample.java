package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Administrator JDBC API를 이용한 DataBase 연동
 *
 */
public class JDBCExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 오라클 드라이버 로드 & DriverManager에 오라클 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
		// 오라클 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; // DB
		String user = "hr"; // user 이름
		String password = "1234"; // 비밀번호
		// 네트워크이기때문에 다양한 예외처리가 발생한다.
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = " INSERT INTO departments (department_id, department_name)"
					+ " VALUES (departments_seq.NEXTVAL, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "KOREA IT");
			int count = pstmt.executeUpdate(); // return타입이 int형 (변경된 행의 갯수)
			System.out.println(count + "행이 추가되었습니다.");
			pstmt.close();
			conn.close();
	}
}
