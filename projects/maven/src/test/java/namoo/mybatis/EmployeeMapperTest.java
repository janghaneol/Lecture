package namoo.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import namoo.mybatis.ems.dto.Employee;
import namoo.mybatis.ems.mapper.EmployeeMapper;
/**
 * Layered Archetecture 기반에서 Service 클래스 역할이라 가정
 * @author Administrator
 *
 */
public class EmployeeMapperTest {
	SqlSession sqlSession;	
	@BeforeEach
	public void setUp() {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession(true); //Auto Commit
		sqlSession = sqlSessionFactory.openSession(); //Not Auto Commit
		
	}
	
	@Test
	@Disabled
	public void test1(){
		System.out.println("==================== 전체사원 조회 ========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	@Test
//	@Disabled
	public void test2(){
		System.out.println("==================== 사원번호로 사원조회 ========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(mapper); 	// mapper는 proxy객체이다.
		Employee employee = mapper.findById(150);
		
		System.out.println(employee);
	}
	
	@Test
	@Disabled
	public void test3() {
		System.out.println("=================== 성으로 사원조회 ==========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.findByLastName("%A%");
		for(Employee employee : list) {
			System.out.println(employee);
		}
		
//		System.out.println(list);
	}
	
	@Test
	public void test4() {
		System.out.println("=================== 사원정보수정 ==========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee emp = new Employee();
		emp.setId(200);
		emp.setFirstName("한얼");
		emp.setLastName("장");
		emp.setSalary(50000);
		mapper.update2(emp);
		sqlSession.commit();
		System.out.println("수정완료");
		
	}
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}







