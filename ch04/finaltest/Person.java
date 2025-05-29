package ch04.finaltest;

public class Person {
	// 필드생성
	final String nation = "Korea"; // 초기값 있음
	final String ssn;					   // 초기값 없음(생성자로 받음)
	String name;						   // 일반 필드 선언
	
	// 생성자 생성
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
}
