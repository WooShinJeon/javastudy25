package ch04;

public class Calculator { // 계산기 프로그램
	// 메서드
	public void powerOn() {
		System.out.println("계산기의 전원을 켭니다.");
	}
	
	public int plus(int x, int y) { // 덧셈
		int result = x + y;
		return result;
	}
	
	public int minus(int x, int y) { // 뺄셈
		int result = x - y;
		return result;
	}
	
	public int multiply(int x, int y) { // 곱셈
		int result = x * y;
		return result;
	}
	
	public double devide(int x, int y) { // 나눗셈
		double result = (double)x / (double)y;
		return result;
	}
	
	public int remainder(int x, int y) { // 나머지
		int result = x % y;
		return result;
	}
	
	public void powerOff() {
		System.out.println("계산기의 전원을 끕니다.");
	}

}
