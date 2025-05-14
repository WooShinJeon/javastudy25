package ch01;

import java.util.Scanner;

public class LogicalOrExam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("2의 배수이거나 5의 배수인 것을 찾아볼까요?");
		System.out.print(">>> ");
		int value = input.nextInt();
		if( (value % 2 == 0) || (value % 5 == 0)) {
			System.out.println("2 또는 5의 배수입니다.");
		}else {
			System.out.println("2 또는 5의 배수가 아닙니다.");
		}
		

	}

}
