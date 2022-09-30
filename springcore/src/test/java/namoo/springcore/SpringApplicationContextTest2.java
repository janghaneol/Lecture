package namoo.springcore;

import java.util.Iterator;

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
		// 스프링 컨테이너 생성
		applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
		
//		userService = applicationContext.getBean("userServiceImpl", UserService.class);
		//빈의 타입으로 검색
		userService = applicationContext.getBean(UserService.class);
		System.out.println(userService);
		
	}
	
	@Test
	@Disabled
	@Order(1)
	public void regist() {
		User user = new User("haneol","1112","장한얼","jhano9@naver.com");
		userService.registUser(user);
		System.out.println("등록완료");
	}
	
	@Test
	@Disabled
	@Order(2)
	public void find() {
		User user = userService.findUser("haneol");
		System.out.println("findUser()메소드 : "+user);
	}
	
	@Test
	@Order(3)
	public void beanList() {
		String[] beanNames= applicationContext.getBeanDefinitionNames();
		System.out.println("-------- 스프링 컨테이너에 등록된 모든 빈 목록 ---------");
		
		for(String beanName: beanNames) {
			Object bean = applicationContext.getBean(beanName);
			System.out.println(beanName + " : " + bean);
		}
	}
}
