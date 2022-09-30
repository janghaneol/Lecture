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
	@DisplayName("유저등록서비스 테스트")
	public void Test() {
		User user = new User("haneol","1112","장한얼","jhano9@naver.com");
		System.out.println("회원가입완료");
		System.out.println(user);
		userService.registUser(user);
	}
	
	@Test
	@DisplayName("유저목록 불러오기")
	public void Test2() {
		List<User> list = userService.findUsers();
		System.out.println(list);
	}
}
