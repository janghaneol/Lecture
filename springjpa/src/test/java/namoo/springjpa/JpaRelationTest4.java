package namoo.springjpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.Locker;
import namoo.springjpa.entity.user.Member;
import namoo.springjpa.entity.user.Team;
import namoo.springjpa.repository.user.JpaLockerRepository;
import namoo.springjpa.repository.user.JpaMemberRepository;
import namoo.springjpa.repository.user.JpaTeamRepository;

@Slf4j
@SpringBootTest
public class JpaRelationTest4 {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaLockerRepository lockerRepository;
	
	// 객체지향적인 방식
	@Test
	@Transactional
//	@Disabled
	public void jpaInsert() {
		Locker locker = new Locker();
		locker.setName("락커1");
		lockerRepository.save(locker);
		
		
		Member member = new Member();
		member.setName("장한얼");
		member.setAge(30);
		member.setLocker(locker);
		memberRepository.save(member);
		
		Locker locker2 = member.getLocker();
		log.info("락커 이름 : {} 회원 이름 : {}", locker2.getName(),member.getName());
		
//		Member member2 = locker2.getMember();
//		log.info("라커이름 : {} 회원이름 : {}",member2.getLocker().getName(), member2.getName());
	}
	
	@Test
	public void jpaRead() {
		Optional<Locker> optional = lockerRepository.findById(3L);
		Locker locker = optional.get();
		Member member = locker.getMember();
		
		log.info("락커 : {} || 락커주인 : {}",locker.getName(), member.getName());
		log.info("락커 : {} || 락커주인 : {}",locker.getName(), locker.getMember().getName());
	}

}
