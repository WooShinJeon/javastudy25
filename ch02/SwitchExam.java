package ch02;

import java.util.Scanner;

public class SwitchExam {

	public static void main(String[] args) {
		int num = (int)(Math.random()*6)+1;
		Scanner input = new Scanner(System.in);
		
		System.out.println("주사위를 돌리시겠습니까? (y/n)");
		System.out.print(">>> ");
		String answer = input.next();
		
		
		if (answer.equalsIgnoreCase("y")) {
			switch (num) {
			case 1:
				System.out.println("1이 나왔습니다.");
				break;
			case 2:
				System.out.println("2가 나왔습니다.");
				break;
			case 3:
				System.out.println("3이 나왔습니다.");
				break;
			case 4:
				System.out.println("4가 나왔습니다.");
				break;
			case 5:
				System.out.println("5가 나왔습니다.");
				break;
			case 6:
				System.out.println("6이 나왔습니다.");
				break;
			}
		}else if (answer.equalsIgnoreCase("n")) {
			System.out.println("주사위를 돌리지 않겠습니다.");
		}else {
			System.out.println("y/n 를 다시 입력해주세요.");
		}

	}

}
