package namoo.springjpa.repository.user;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springjpa.entity.user.User;

public interface SpringDataJpaUserRepository extends JpaRepository<User , String> {		//2번째는 클래스의 식별자 타입 User는 ID가 String으로 되어있음.
	// 필요한 메소드를 추가할 수 도 있는 Interface
	// Query Method 활용
	public List<User> findAllByNameLike(String name);
	public List<User> findAllByNameContaining(String name);
	
	public List<User> findAllByNameStartingWith(String lastName);
	// 날짜에 의한 검색
	List<User> findAllByRegdateGreaterThanEqual(Date regdate);
	// JPQL 직접 사용
	//@Query("select u from User u where u.regdate >= :regdate")
	//List<User> findAllByRegdateGreaterThanEqual(@Param("regdate") Date regdate);
	// 날짜 범위에 의한 검색
	List<User> findAllByRegdateBetween(Date startRegdate, Date endRegdate);
	
	//로그인 검색
	User findByIdAndPasswd(String id, String passwd);
	
	//이름과 이메일로 정렬검색
	List<User> findAllByNameContaining(String name, Sort sort);
	
	//ID나 이메일(OR)로 검색한 뒤 Paging처리 
	Page<User> findAllByIdContainingOrEmailContaining(String id, String email, Pageable pageable);
}