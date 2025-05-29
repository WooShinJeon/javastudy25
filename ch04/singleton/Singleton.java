package ch04.singleton;

public class Singleton {
	
	// 정적 필드
	private static Singleton st = new Singleton();
	// 객체 1개만 만들어지는 싱글톤 객테 생성
	
	// 생성자
	private Singleton() {}
	
	// 정적 메서드
	static Singleton getInstance() {
		return st;
	}
}
