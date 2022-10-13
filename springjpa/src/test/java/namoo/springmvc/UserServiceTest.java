package namoo.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import namoo.springjpa.entity.user.User;
import namoo.springjpa.service.user.UserService;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void findAll() {
		List<User> list = userService.findUsers();
		System.out.println(list);
	}
	
	@Test
	public void findById() {
		User user = userService.findUser("sehoon");
		System.out.println(user);
	}
	
	@Test
	public void registUser() {
		User user = new User("elelele","1234","생성테스트","zxc@zxc.com");
		userService.registUser(user);
		System.out.println(user + "  등록완료");
	}
	
}






