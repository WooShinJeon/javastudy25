package ch04;

import java.util.Scanner;

public class CalCulatorExam {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		
		myCalc.powerOn();
		
		int result1 = myCalc.plus(10, 20);
		System.out.println("10 + 20 = "+result1);
		
		int x = 40;
		int y = 20;
		int result2 = myCalc.minus(x, y);
		System.out.println(x+" - "+y+" = "+result2);
		
		// 키보드로 숫자를 입력받아 곱하기를 진행해보세요.
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		int b = input.nextInt();
		int result3 = myCalc.multiply(a, b);
		System.out.println(a+" x "+b+" = "+result3);
		
		myCalc.powerOff();

	}

}
