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
public class JDBCExample2 {

	public static void main(String[] args) {
		// 오라클 드라이버 로드 & DriverManager에 오라클 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로딩 완료."); // module에 java.sql을 requires 해줘야 정상 실행된다.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 오라클 연결
		Connection conn = null;
		PreparedStatement pstmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE"; // DB
		String user = "hr"; // user 이름
		String password = "1234"; // 비밀번호

		// 네트워크이기때문에 다양한 예외처리가 발생한다.
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클에 연결 되었습니다. ");
			System.out.println(conn);

			String sql = " INSERT INTO departments (department_id, department_name)"
					+ " VALUES (departments_seq.NEXTVAL, ?)";

			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt);
			pstmt.setString(1, "KOREA IT");

			int count = pstmt.executeUpdate(); // return타입이 int형 (변경된 행의 갯수)
			System.out.println(count + "행이 추가되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
