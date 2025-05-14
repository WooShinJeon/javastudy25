package ch01;

public class OperationExam {

	public static void main(String[] args) {
		int x = 10;
		x++;
		System.out.println("10에 ++ 단항연산항 결과 : " + x);
		x--;
		System.out.println("11에 -- 단항연산항 결과 : " + x);
		
		int y = 20;
		int result = x + y;
		System.out.println("x + y = " + result);
		
		boolean result1 = (result>10) ? true : false ;
		System.out.println("result가 10보다 큰가? " + result1);
		String result2 = (result>50) ? "크다" : "작다";
		System.out.println("result가 50보다 큰가? " + result2);
		
		int x1 = 10*10;
		int x2 = 10/3;
		int x3 = 10%3;
		System.out.println("10곱하기 10은? : " + x1);
		System.out.println("10을 3으로 나눈 몫은? : " + x2);
		System.out.println("10을 3으로 나눈 나머지는? : " + x3);
		
		
		
	}

}
