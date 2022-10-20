package namoo.springjpa;

import java.util.Optional;

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
public class JpaRelationTest {

	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;

	@Test
	public void jpaTest() {
		// Team 생성
		Team insertTeam = new Team();
		insertTeam.setName("Real Madrid");
		teamRepository.save(insertTeam);

		// Member 생성
		Member insertMember = new Member();
		insertMember.setName("Benzema");
		insertMember.setAge(33);
		insertMember.setTeamId(insertTeam.getId());
		memberRepository.save(insertMember);

		// 조회 시 2번 조회해야 한다.
		Optional<Member> optional = memberRepository.findById(insertMember.getId());
		if (optional.isPresent()) {
			Member findMember = optional.get();

			// 참조를 이용해서 팀정보 조회
			Optional<Team> optional2 = teamRepository.findById(insertTeam.getId());
			if (optional2.isPresent()) {
				Team findTeam = optional2.get();
				log.info("회원명, 팀명 : {}, {}", findMember.getName(), findTeam.getName());
			}
		}
	}
}
