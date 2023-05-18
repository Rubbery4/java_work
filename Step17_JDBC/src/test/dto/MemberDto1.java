package test.dto;

public class MemberDto1 {
	// 필드의 접근 지정자를 private 로 
	private int num;
	private String userId;
	private String passwd;
	private String name;
	private String phone;
	
	// 디폴트 생성자
	public MemberDto1() {}

	public MemberDto1(int num, String name, String addr, String userId, String passwd, String phone) {
		super();
		this.num = num;
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.phone = phone;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	


	
	// 마우스 우클릭 > source > generate 메뉴에서 constructor 와 setter, getter 메소드 생성 가능
	
}
