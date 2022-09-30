package namoo.springcore;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import namoo.springcore.user.AppConfig;
import namoo.springcore.user.User;
import namoo.springcore.user.UserService;

public class UserServiceTest {
	UserService userService;
	
	@BeforeEach
	public void setUp() {
		AppConfig appConfig = new AppConfig();
		userService = appConfig.userService();
	}
	
	@Test
//	@Disabled
	@DisplayName("������ϼ��� �׽�Ʈ")
	public void Test() {
		User user = new User("haneol","1112","���Ѿ�","jhano9@naver.com");
		System.out.println("ȸ�����ԿϷ�");
		System.out.println(user);
		userService.registUser(user);
	}
	
	@Test
	@DisplayName("������� �ҷ�����")
	public void Test2() {
		List<User> list = userService.findUsers();
		System.out.println(list);
	}
}
