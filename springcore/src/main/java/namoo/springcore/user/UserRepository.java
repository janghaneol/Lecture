package namoo.springcore.user;

import java.util.List;

/**
 * 
 * 
 * @author Administrator
 *
 */
public interface UserRepository {
	/* ȸ������ */
	public void create(User user);
	
	/*����� id�� �ش��ϴ� ���� ��ȯ*/
	public User findById(String id);
	
	/* ����� ��ü ��� ��ȯ */
	public List<User> findByAll(); 

}
