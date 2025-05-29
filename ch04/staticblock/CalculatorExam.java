package ch04.staticblock;

public class CalculatorExam {

	public static void main(String[] args) {
		
		double result1 = 10*10*Calculator.pi;
		int result2 = Calculator.plus(10, 20);
		int result3 = Calculator.minus(50, 10);
		double result4 = Calculator.times(15, Calculator.pi);
		double result5 = Calculator.divide(30, 4);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
	}

}
