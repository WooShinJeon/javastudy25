package ch04.staticblock;

public class Television {
	static String company = "Samsung";
	static String model = "LED";
	static String info;
	
	static {
		info = company+"-"+model;
	}
	
	
	
	int field1;              // 인스턴스 필드
	void method1() {   // 인스턴스 메서드
	}
	
	static int field2;             // 정적 필드
	static void method2() {  // 정적 메서드
	}
	
	static { // 정적블록
		// field1 = 10;  인스턴스 필드 사용불가
		// method1();  인스턴스 메서드 사용불가
		field2 = 20;
		method2();
	}
	
	static void Method3() { // 정적 메서드
		// this.field1 = 10;  this사용불가, 컴파일 오류
		// this.mrthod1();   this사용불가, 컴파일 오류
		Television tel = new Television();
		tel.field1 = 10; // 객체 생성하여 변수와 연결
		tel.method1();  // 인스턴스 멤버는 객체가 필요
		field2 = 20;
		method2();
	}

}
