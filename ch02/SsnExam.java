package ch02;

import java.util.Scanner;

public class SsnExam {

	public static void main(String[] args) {
		System.out.println("주민번호를 입력하시면 성별을 판단해드리겠습니다.");
		System.out.println("당신의 주민번호를 입력해주세요(중간에 -을 기입해주세요.)");
		System.out.print(">>> ");
		Scanner in = new Scanner(System.in);
		String regNo = in.nextLine();
		char gender = regNo.charAt(7);
		
		switch(gender) {
		case '1':case'3':case'5':case'7':
			System.out.println("당신은 남자입니다.");
			break;
		case '2':case'4':case'6':case'8':
			System.out.println("당신은 여자입니다.");
			break;
		default:
			System.out.println("주민번호를 다시 확인해주세요.");
			System.out.println("정확히 입력하셨다면 당신은 사람이 아닙니다.");
		}

	}

}
