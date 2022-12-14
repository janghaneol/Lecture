package namoo.springjpa.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "team_seq_gen", sequenceName = "team_seq", initialValue = 1, allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_gen")
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<Member>();
}