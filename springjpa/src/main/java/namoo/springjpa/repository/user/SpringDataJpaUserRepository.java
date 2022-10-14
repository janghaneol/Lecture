package namoo.springjpa.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springjpa.entity.user.User;

public interface SpringDataJpaUserRepository extends JpaRepository<User , String> {		//2번째는 클래스의 식별자 타입 User는 ID가 String으로 되어있음.
	// 필요한 메소드를 추가할 수 도 있는 Interface
	
	// Query Method 활용
	public List<User> findAllByNameLike(String name);
}
