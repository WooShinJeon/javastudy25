package ch05.package_test.package1;

public class A { // default 접근제한
	// pubilc을 삭제하면 디폴트 접근 제한으로 작동한다.
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	public A(boolean b) {} // public 접근제한
	A(int b){}					 // default 접근제한
	private A(String s) {}   // private 접근제한
	
	
	
	public int field1;
	int field2;
	private int field3;
	
	public A() {
		field1 = 1;
		field2 = 2;
		field3 = 3;
		
	method1();
	method2();
	method3();
	}
	
	public void method1() {}
	void method2() {}
	private void method3() {}
}
