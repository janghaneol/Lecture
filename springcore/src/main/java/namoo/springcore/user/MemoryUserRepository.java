package namoo.springcore.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MemoryUserRepository implements UserRepository {
	
	private Map<String, User> map = new HashMap<String, User>();
	
	@Override
	public void create(User user) {
		map.put(user.getId(),user);
	}

	@Override
	public User findById(String id) {
//		return map.get(id);
		return new User("aaaa", "1234", "kk", "mail");
	}

	@Override
	public List<User> findByAll() {
		List<User> list = new ArrayList<User>();
		Collection<User> collection = map.values();
		Iterator<User>iter = collection.iterator();
		while (iter.hasNext()) {
			User user = iter.next();
			list.add(user);
		}
		return list;
	}
	
	
}