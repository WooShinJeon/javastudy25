package ch04;

public class Korean {
	// 필드선언
	String nation = "대한민국";
	String name; // 이름
	String ssn;  // 주민번호
	
	// 생성자
	public Korean(String name, String ssn) {
		this.name = name; // this사용으로 인해 Korean 생성자의 매개변수이름을 name과 ssn으로 사용 가능(가독성문제)
		this.ssn = ssn;
	}

}
