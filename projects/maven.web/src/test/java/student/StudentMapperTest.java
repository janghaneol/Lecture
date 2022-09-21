package student;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import student.dto.Student;
import student.mapper.StudentMapper;

public class StudentMapperTest {
	SqlSession sqlsession;
	
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
		sqlsession = sqlSessionFactory.openSession(true); //Auto Commit
//		sqlsession = sqlSessionFactory.openSession(); //Not Auto Commit
	}
	
	@Test
	@Disabled
	public void test1() {
		System.out.println("================ 전체 학생 조회 =====================");
		StudentMapper mapper = sqlsession.getMapper(StudentMapper.class);
		
		List<Student> student = mapper.search(null);
		
		for(Student list : student) {
			System.out.println(list);
		}
	}
	
	@Test
	@Disabled
	public void test2() {
		System.out.println("================ 학생 조회 =====================");
		StudentMapper mapper = sqlsession.getMapper(StudentMapper.class);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", "num");
		param.put("value", 3);
		
		List<Student> student = mapper.search(param);
		for(Student list : student) {
			System.out.println(list);
		}
	}
	
	@Test
	public void test3() {
		System.out.println("================ 학생 생성 =====================");
		StudentMapper mapper = sqlsession.getMapper(StudentMapper.class);
		Student student = new Student();
		
		student.setNum(9);
		student.setName("베컴");
		student.setKor(77);
		student.setEng(77);
		student.setMath(77);
		mapper.create(student);
		System.out.println("================ 등록완료 =====================");
	}
}
