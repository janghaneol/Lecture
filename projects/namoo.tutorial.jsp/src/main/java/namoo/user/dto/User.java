package namoo.user.dto;

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
	private String regdate; // Date타입은 toDate()라는 함수가 있기때문에 읽어들일땐 String을 사용한다.

	public User() {
//		super(); 클래스는 사용하나 안사용하나 자유
		this(null, null, null, null, null);
	}

//	regdate는 자동으로 값이 들어오므로 생략한 생성자도 생성
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
