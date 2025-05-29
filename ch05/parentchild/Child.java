package ch05.parentchild;

public class Child extends Parent{
	
	@Override
	public void method2() {
		System.out.println("자식의 2번 메소드");
		System.out.println("Child-method2");
	}
	public void method3() {
		System.out.println("자식의 3번 메소드");
		System.out.println("Child-method3");
	}
	

}
