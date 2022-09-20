package namoo.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import namoo.mybatis.ems.dto.Employee;

public class MybatisTestExample {
	
	private static final String namespace = "namoo.mybatis.ems.mapper.EmployeeMapper";
	
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "product");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println("sqlSession 생성 완료..");
		
		System.out.println("==================== 전체사원 조회 ========================");
		List<Employee> employeeList = sqlSession.selectList(namespace+".findAll");
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
		
		System.out.println("==================== 사원번호로 사원조회 ========================");
		int id = 200;
		Employee employee = sqlSession.selectOne(namespace + ".findById", id);
		System.out.println(employee);
		
		System.out.println("==================== 사원번호로 급여조회 ========================");
		int salary = sqlSession.selectOne(namespace + ".findBySalary", id);
		System.out.println("받는 급여 : " + salary);
		
	}
}
