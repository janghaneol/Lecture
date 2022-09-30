package namoo.springcore.user;

public class UserServiceApp {
	
	
	public static void main(String[] args) {
//		UserService userService = new UserServiceImpl();
		AppConfig appConfig = new AppConfig();
		UserService userService = appConfig.userService();
		
		User user = new User("haneol","1111","장한얼","jhano9@naver.com");
		
		userService.registUser(user);
		System.out.println(user.getId() + " 등록완료");
		
		System.out.println(userService.findUser("haneol"));
		
		System.out.println(userService.findUsers());
	}
	
}
