package namoo.springcore.user;

/**
 * User DTO
 * @author Administrator
 *
 */
public class User {
	private String id;
	private String password;
	private String name;
	private String email;
	private String regdate;

	public User() {
		this(null, null, null, null, null);
	}

	public User(String id, String password, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public User(String id, String password, String name, String email, String regdate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return id+"\t****\t"+name+"\t"+email+"\t"+regdate;
	}
}
