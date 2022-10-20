package namoo.springjpa.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "member_seq_gen",	//시퀀스 생성 이름
		sequenceName = "member_seq",		//DB에 실제하는 시퀀스 이름
		initialValue = 1,					//시퀀스의 시작 값
		allocationSize = 1)					//JPA에서 가상으로 관리할 시퀀스 할당 범위(1로 설정하는 경우 매번 INSERT시마다 DB의 시퀀스 사용)

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
/**
 * 	Member_DTO
 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
	private Long id;
	@Column(name="team_id")
	private Long teamId;
	private String name;
	private int age;
	
}
