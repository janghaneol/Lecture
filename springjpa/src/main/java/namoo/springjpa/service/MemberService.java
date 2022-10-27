package namoo.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.UserRepository;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	UserRepository userRepository;
	
	public void biz1() {
		log.info("biz1()메소드 실행됨...");
		List<User> userList = userRepository.findAll();
		log.info("회원의 수 : {}",userList.size());
	}
	
	public void biz2() {
		log.info("biz2()메소드 실행됨...");
		throw new RuntimeException("테스트 예외 발생");
	}
}
