package ch02;

import java.util.Scanner;

public class SwitchCharExam {

	public static void main(String[] args) {
		Scanner inChar = new Scanner(System.in);
		System.out.print("회원 등급을 입력하세요. (A~C) : ");
		char gradeChaStr = inChar.next().charAt(0);
		
		// System.out.println("검증 코드용 : " + gradeChaStr);
		
		switch(gradeChaStr) {
		case 'a':
		case 'A':
			System.out.println("우수회원입니다.");
			break;
		case 'b':
		case 'B':
			System.out.println("일반회원입니다.");
			break;
		case 'c':
		case 'C':
			System.out.println("사업자회원입니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다. 회원이 아니시라면 회원가입을 진행해주세요.");
			System.out.println("회원가입을 진행하시겠습니까? (y/n)");
			System.out.print(">>> ");
			String answer = inChar.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("회원가입을 진행합니다.");
				System.out.print("ID를 입력하세요 : ");
				String id = inChar.next();
				System.out.println(id + "님 회원가입을 축하드립니다.");
				break;
			}else {
				System.out.println("안녕히 가세요! 다음 기회에 뵙겠습니다.");
				System.out.println("단, 두번 다시 못 뵐 수도 있습니다.");
			}
			
			
			
		}

	}

}
