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
public class UpdateExample3 {
//	재사용을 위해 메소드화 시키기
	public static int updateDepartmentName(int departmentId, String deparmentName) throws ClassNotFoundException, SQLException {
		// 오라클 드라이버 로드 & DriverManager에 오라클 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
		// 오라클 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; // DB
		String user = "hr"; // user 이름
		String password = "1234"; // 비밀번호
			
			conn = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE departments \r\n"
					   + "    SET department_name = ?\r\n"
					   + "WHERE department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deparmentName);
			pstmt.setInt(2, departmentId);
			int count = pstmt.executeUpdate(); // return타입이 int형 (변경된 행의 갯수)
			return count;
			
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int count = updateDepartmentName(330, "대통령실");
		System.out.println(count + "개의 부서명을 변경하였습니다.");
	}
}
