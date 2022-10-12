package namoo.springmvc.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.mapper.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void registUser(User user) {
		userMapper.create(user);
	}

	@Override
	public User findUser(String id) {
		return userMapper.findById(id);
	}

	@Override
	public List<User> findUsers() {
		return userMapper.findAll();
	}
	
	@Override
	public List<User> search(String type, String value){
		Map<String, String> searchMap = new HashMap<String, String>();
		if(type.equalsIgnoreCase("name")) {
			
		}
		searchMap.put("type", type);
		searchMap.put("value", value);
		return userMapper.findByOption(searchMap);
	}

}
