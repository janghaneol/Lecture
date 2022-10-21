package namoo.springjpa.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SequenceGenerator(
		name = "locker_seq_gen",
		sequenceName = "locker_seq",
		initialValue = 1,
		allocationSize = 1)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Locker {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locker_seq_gen")
	private Long id;
	private String name;
	
	@OneToOne(mappedBy = "locker")
	private Member member;
	
}
