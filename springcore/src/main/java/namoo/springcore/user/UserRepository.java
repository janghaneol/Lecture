package namoo.springcore.user;

import java.util.List;

/**
 * 
 * 
 * @author Administrator
 *
 */
public interface UserRepository {
	/* 회원가입 */
	public void create(User user);
	
	/*사용자 id에 해당하는 정보 반환*/
	public User findById(String id);
	
	/* 사용자 전체 목록 반환 */
	public List<User> findByAll(); 

}
