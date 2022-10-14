package namoo.springjpa;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.UserRepository;

@Transactional
@Slf4j
@SpringBootTest
class UserRepositoryTest2 {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	@Disabled
	public void findAll() {
		List<User> userList = userRepository.findAll();
		log.info("실행하는 객체 : {}" , userRepository.getClass().getName());
		log.info("검색된 회원 수 : {}", userList.size());
		log.info("사용자 목록 : {}", userList);
	}
	
	@Test
	@Disabled
	public void findById() {
		User findUser= userRepository.findById("killer");
		log.info("검색된 사용자 목록 : {}", findUser);
	}
	
	@Test
	@Disabled
//	@Commit	// Spring에선 Commit이란 어노테이션을 통해 롤백을 안시키고 바로 커밋시킬 수 있다. 
	public void registUser() {
		User user = new User();
		user.setId("asdf");
		user.setPasswd("1234");
		user.setName("Torress");
		user.setEmail("asdf@asdf.com");
		userRepository.create(user);
		log.info("생성된 사용자 정보 : {}",user);
	}
	
	@Test
	@Disabled
//	@Commit
	public void updateUser() {
		User user = new User();
		user.setId("admin");
		user.setPasswd("7777");
		user.setName("김킬러");
		user.setEmail("update@gmail.com");
		userRepository.update(user);
		log.info("업데이트된 사용자 정보 : {}" ,user);
	}
	
	@Test
	public void findUser() {
		String searchValue = "장한얼";
		List<User> user = userRepository.findByName(searchValue);
		log.info("검색된 searchValue의 값을 가진 회원 정보 {} : ", user);
	}
	
}






