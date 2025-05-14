package ch02;

import java.util.Scanner;

public class IfSsnExam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("주민등록번호 13자리를 입력해주세요 : ");
		String ssn = input.next();
		
		char ssn1 = ssn.charAt(6); // 성별확인용
		int num1 = Character.getNumericValue(ssn1);
		
		if(num1%2==0) {
			System.out.println("여자");
		}else if(num1%2==1) {
			System.out.println("남자");
		}else {
			System.out.println("다시 작성해주세요.");
		}
		
		int num2 = Integer.parseInt(ssn.substring(0,2)); // 태어난 년도 추출
		
		if(num1==1 || num1==2 || num1==5 || num1==6) {
			System.out.println("나이는" + (2025 - (1900 + num2) + 1) + "입니다.");
		}else if(num1==3 || num1==4 || num1==7 || num1==8) {
			System.out.println("나이는" + (2025 - (2000 + num2) + 1) + "입니다.");
		}else {
			System.out.println("다시 작성해주세요.");
		}
		
		int num3 = Integer.parseInt(ssn.substring(2,4));
		
		if(num3 <= 0 || num3 >= 13) {
			System.out.println("다시 작성해주세요.");
		} else if(num3 >= 3 && num3 <= 5) {
			System.out.println("봄에 태어났습니다.");
		} else if(num3 >= 6 && num3 <= 8) {
			System.out.println("여름에 태어났습니다.");
		} else if(num3 >= 9 && num3 <= 11) {
			System.out.println("가을에 태어났습니다.");
		} else {
			System.out.println("겨울에 태어났습니다.");
		}

	}

}
