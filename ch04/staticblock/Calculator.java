package ch04.staticblock;

public class Calculator { // 계산기 프로그램
	static double pi = 3.131592;
	// pi 필드선언 및 초기값 입력
	
	static int plus(int x , int y) {
		return x+y;
	}
	
	static int minus(int x, int y) {
		return x-y;
	}
	
	static double times(int x, double y) {
		return x*y;
	}
	
	static double divide(int x, int y) {
		return x/y;
	}
}
