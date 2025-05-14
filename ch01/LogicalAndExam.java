package ch01;

import java.util.Scanner;

public class LogicalAndExam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수를 입력하시면 대소문자나 숫자를 판단해드립니다!");
		System.out.println("유니코드표를 참고하여 프로그램을 제작하였습니다.");
		System.out.print("숫자입력 >>> ");
		int charCode = input.nextInt();
		
		if( (charCode >= 65) && (charCode <= 90)) {
			System.out.println("현재 입력된 숫자는 대문자입니다 : " +(char)charCode);
		} else if( (charCode >= 97) && (charCode <= 122)) {
			System.out.println("현재 입력된 숫자는 소문자입니다 : " +(char)charCode);
		} else if( (charCode >= 48) && (charCode <= 57)) {
			System.out.println("현재 입력된 숫자는 유니코드의 문자형숫자입니다 : " +(char)charCode);
		} else {
			System.out.println("대문자, 소문자, 숫자의 유니코드표에 없는 숫자입니다.");
			System.out.println("프로그램을 다시 실행해주세요.");
		}
		
	}

}
