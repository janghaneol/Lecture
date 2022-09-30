package namoo.springcore.user;

import java.util.List;

/**
 * 회원 관리 인터페이스 (역할)
 * @author Administrator
 *
 */
public interface UserService {
	
	public void registUser(User user);
	public User findUser(String id);
	public List<User> findUsers();
}
