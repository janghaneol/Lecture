package namoo.springcore.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ��ü�� �����ϰ� ������ ��ü�鰣�� �������踦 ����(DI)�ϴ� ������ Ŭ����
 * ����� Ŭ����(���丮)
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
