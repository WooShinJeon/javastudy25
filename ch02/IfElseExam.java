package ch02;

import java.util.Scanner;

public class IfElseExam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = input.nextInt();
		
		if(num%2==0) {
			System.out.println("짝수!");
		}else {
			System.out.println("홀수!");
		}
		System.out.println("종료합니다.");

	}

}
