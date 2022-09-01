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
public class SelectExample2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//			ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection conn = ConnectionFactory.getInstance().getConnection(); // 1줄로 가능
//			Connection conn = connectionFactory.getConnection();

		PreparedStatement pstmt = null;

		String sql = "SELECT e.employee_id, e.last_name, e.salary, TO_CHAR(hire_date,'YYYY-MM-DD DAY')hiredate,d.department_name dname\r\n"
				+ "FROM employees e\r\n" + "    JOIN departments d\r\n"
				+ "        ON e.department_id = d.department_id";
		pstmt = conn.prepareStatement(sql);

		ResultSet res = pstmt.executeQuery();
		while (res.next()) {
			int id = res.getInt("employee_id");
			String name = res.getString("last_name");
			int salary = res.getInt("salary");
			String hire = res.getString("hiredate");
			String dname = res.getString("dname");
			System.out.println(id + "\t" + name + "\t" + salary + "\t" + hire + "\t" + dname);
		}
		;
		res.close();
		pstmt.close();
		conn.close();
		// Connection Pool 에서의 close() 메소드는 커넥션을 닫는게 아니라 반납하는 개념이다.
	}
}
