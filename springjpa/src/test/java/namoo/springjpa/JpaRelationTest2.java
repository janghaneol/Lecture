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
public class JpaRelationTest2 {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;
	
	@Test
	public void jpaInsert() {
		// 팀 생성 and Save
		Team insertTeam = new Team();
		insertTeam.setName("Real Madrid");
		teamRepository.save(insertTeam);
		
		// 멤버 생성 and Save
		Member insertMember = new Member();
		insertMember.setName("Benzema");
		insertMember.setAge(33);
		insertMember.setTeam(insertTeam);
		
		
		Member insertMember2 = new Member();
		insertMember2.setName("Ronaldo");
		insertMember2.setAge(35);
		insertMember2.setTeam(insertTeam);
		
		memberRepository.save(insertMember);
		memberRepository.save(insertMember2);
		
//		List<Member> list = insertTeam.getMembers();
//		log.info("리스트 사이즈 : {}",list.size());
//		
//		for (Member member : list) {
//			log.info("팀에 소속된 멤버 : {}", member );
//		}
		
	}
	
	@Test
	@Transactional
	public void jpaRead() {
		Optional<Team> optional = teamRepository.findById(7L);
		Team team = optional.get();
		String teamName = team.getName();
		
		log.info("팀이름 : {}",teamName);
		List<Member> teamMemberList = team.getMembers();
		log.info("팀의 회원 수 : {}", teamMemberList.size());
		for (Member member : teamMemberList) {
			log.info("{}에 소속된 선수 이름 : {}",teamName, member.getName());
		}
		
	}
	
	
}
