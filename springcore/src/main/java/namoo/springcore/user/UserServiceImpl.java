package namoo.springcore.user;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class UserServiceImpl implements UserService {
	
//	private UserRepository userRepository = new MemoryUserRepository();
	private UserRepository userRepository;
	
//	�������� ������ ���� ������
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init() �޼ҵ� ȣ���..");
	}
	
	@Override
	public void registUser(User user) {
		userRepository.create(user);
	}

	@Override
	public User findUser(String id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findUsers() {
		return userRepository.findByAll();
	}

}
