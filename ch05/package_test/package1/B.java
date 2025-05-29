package ch05.package_test.package1;

public class B { // public 접근제한
	A a; // 같은 패키지이므로 A클래스 접근가능(import없이 필드로 선언가능)
	
	A a1 = new A(true);
	A a2 = new A(1);
	// A a3 = new A("문자열"); private 접근제한
	
	
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 2;
		// a.field3 = 3; 컴파일 에러
		
		a.method1();
		a.method2();
		// a.method3(); 컴파일 에러
	}
}
