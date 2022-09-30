package namoo.springcore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import namoo.springcore.user.AppConfig;
import namoo.springcore.user.AppConfig2;
import namoo.springcore.user.User;
import namoo.springcore.user.UserService;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class SpringApplicationContextTest2 {
	
	ApplicationContext applicationContext;
	UserService userService;
	
	@BeforeEach
	public void setUp() {
		// ������ �����̳� ����
		applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
		
		userService = applicationContext.getBean("userServiceImpl", UserService.class);
		System.out.println(userService);
		//���� Ÿ������ �˻�
//		userService = applicationContext.getBean(UserService.class);
		
	}
	
	@Test
//	@Disabled
	@Order(1)
	public void regist() {
		User user = new User("haneol","1112","���Ѿ�","jhano9@naver.com");
		userService.registUser(user);
		System.out.println("��ϿϷ�");
	}
	
	@Test
//	@Disabled
	@Order(2)
	public void find() {
		User user = userService.findUser("haneol");
		System.out.println("findUser()�޼ҵ� : "+user);
	}
}
