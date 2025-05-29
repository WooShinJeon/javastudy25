package ch05.extended.people;

public class People { // 부모 클래스
	public String name;
	public String ssn;
	
	public People(String name, String ssn) { // 생성자 선언
		this.name = name;
		this.ssn = ssn;
	} // 부모객체의 생성자 생성완료 (기본생성자 없음)
}
