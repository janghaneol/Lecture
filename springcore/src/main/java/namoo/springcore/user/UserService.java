package namoo.springcore.user;

import java.util.List;

/**
 * ȸ�� ���� �������̽� (����)
 * @author Administrator
 *
 */
public interface UserService {
	
	public void registUser(User user);
	public User findUser(String id);
	public List<User> findUsers();
}
