package namoo.springjpa.repository.user;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;

@Slf4j
@Transactional
@Repository
public class JpaUserRepositoryV2 implements UserRepository {
	
	@Autowired
	private SpringDataJpaUserRepository userRepository;

	@Override
	public void create(User user) {
		userRepository.save(user);
	}

	@Override
	public User findById(String id) {
//		User user = null;
		Optional<User> optional = userRepository.findById(id);
//		if(optional.isPresent()) {		
//			user = optional.get();
//		}
//		return user;
		if(optional.isEmpty()) {
			throw new RuntimeException(id+"에 해당하는 유저를 찾을 수 없습니다.");
		}
		return optional.get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void update(User user) {
		User findUser = findById(user.getId());
		if(user.getPasswd() !=null)	findUser.setPasswd(user.getPasswd());
		if(user.getEmail() !=null)	findUser.setEmail(user.getEmail());
		
	}

	@Override
	public List<User> findByName(String name) {
		return userRepository.findAllByNameLike(name);
	}
	
	@Override
	public List<User> findByLastName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findAllByNameStartingWith(name);
	}
	
}
