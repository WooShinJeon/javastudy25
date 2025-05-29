package ch05.package_test.package2;

import ch05.package_test.package1.A;
import ch05.package_test.package1.B;

public class C {
	// A a; // A클래스 접근불가
	B b; // B클래스 접근가능 (import 진행)
	
	A a1 = new A(true);
	// A a2 = new A(1);        // default 접근제한(패키지가 다름)
	// A a3 = new A("문자열"); // private 접근제한
	
	
	public C() {
		A a= new A();
		a.field1 = 1;
		// a.field2 = 2; 컴파일 에러
		// a.field3 = 3; 컴파일 에러
		
		a.method1();
		// a.method2(); 컴파일 에러
		// a.method3(); 컴파일 에러
	}
}
