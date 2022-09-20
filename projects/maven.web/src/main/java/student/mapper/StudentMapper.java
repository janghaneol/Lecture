package student.mapper;

import java.util.List;

import student.dto.Student;

public class StudentMapper {
	
	/*학생 전체목록 조회*/
	public List<Student> findAll();
	
	/*학생 검색*/
	public List<Student> search();
	
	/*학생 등록*/
	public void create(Student student);
	
	/*학생 삭제*/
	public void delate(Student student);
	
}
