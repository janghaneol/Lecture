package namoo.springcore.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 객체를 생성하고 생성된 객체들간의 의존관계를 주입(DI)하는 역할의 클래스
 * 어셈블러 클래스(팩토리)
 * @author Administrator
 *
 */

@Configuration
public class AppConfig {
	
	@Bean
	public UserRepository userRepository() {
		return new MemoryUserRepository();
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl(userRepository());
	}
}
