package ch02;

import java.util.Scanner;

public class SwitchStringExam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("현재 사원님의 직급을 입력해주세요.");
		System.out.print(">>> ");
		String position = input.next();
		
		switch(position) {
		case "부장":
			System.out.println(position + " 성과급은 1000만원입니다.");
			break;
		case "과장":
			System.out.println(position + " 성과급은 1500만원입니다.");
			break;
		case "대리":
			System.out.println(position + " 성과급은 2000만원입니다.");
			break;
		default:
			System.out.println("성과급 없음.");
		}
			
	}

}
