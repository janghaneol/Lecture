package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Administrator JDBC API를 이용한 DataBase 연동
 *
 */
public class SelectExample {

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
			String sql = "SELECT e.employee_id, e.last_name, e.salary, TO_CHAR(hire_date,'YYYY-MM-DD DAY')hiredate,d.department_name dname\r\n"
					+ "FROM employees e\r\n"
					+ "    JOIN departments d\r\n"
					+ "        ON e.department_id = d.department_id";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id = res.getInt("employee_id");
				String name = res.getString("last_name");
				int salary = res.getInt("salary");
				String hire = res.getString("hiredate");
				String dname = res.getString("dname");
				System.out.println(id + "\t" + name + "\t" + salary + "\t" + hire + "\t" + dname);
			};
			res.close();
			pstmt.close();
			conn.close();
	}
}
