package namoo.springjpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.Member;
import namoo.springjpa.entity.user.Team;
import namoo.springjpa.repository.user.JpaMemberRepository;
import namoo.springjpa.repository.user.JpaTeamRepository;

@Slf4j
@SpringBootTest
public class JpaRelationTest3 {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;

	// 객체지향적인 방식
	@Test
	@Transactional
	public void jpaInsert() {
		// 팀 생성 and Save
		Team insertTeam = new Team();
		insertTeam.setName("FC Barcelona");
		teamRepository.save(insertTeam);

		// 멤버 생성 and Save
		Member insertMember = new Member();
		insertMember.setName("Messi");
		insertMember.setAge(32);
		insertMember.setTeam(insertTeam);
		insertTeam.getMembers().add(insertMember);

		Member insertMember2 = new Member();
		insertMember2.setName("Xavi");
		insertMember2.setAge(40);
		insertMember2.setTeam(insertTeam);
		insertTeam.getMembers().add(insertMember2);

		memberRepository.save(insertMember);
		memberRepository.save(insertMember2);
		
		Optional<Team> optional = teamRepository.findById(insertTeam.getId());
		Team team = optional.get();
		List<Member> newMembers = team.getMembers();
		for (Member member : newMembers) {
			log.info("{}에 등록된 선수의 이름 : {} , 나이 : {}",team.getName(),member.getName(),member.getAge());
		}
		
	}

}
