package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		
		
		
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.print("회원가입할 id를 입력해주세요 : ");
		String loginid = input.nextLine();
		
		System.out.print("회원가입할 암호를 입력해주세요 : ");
		String loginpw1 = input.nextLine();
		System.out.print("암호 확인 : ");
		String loginpw2 = input.nextLine();
		
		if(loginpw1.equals(loginpw2)) {
			System.out.println("암호가 일치합니다.");
			System.out.println("회원가입이 완료되셨습니다.");
			
			System.out.print("로그인할 id를 입력하세요 : ");
			String id = input.nextLine();
			
			System.out.print("로그인할 암호를 입력하세요 : ");
			String pw = input.nextLine();
			System.out.println("===== 검증 중입니다. =====");
			
			if( (loginid.equals(id)) & loginpw2.equals(pw) ) {
				System.out.println("id와 암호가 일치합니다.");
				System.out.println("로그인 성공!!!!!!");
			}else { 
				System.out.println("id나 암호가 일치하지 않습니다.");
				System.out.println("로그인 실패!!!!!!");
			
			}
			
		}else {
			System.out.println("암호를 다시 확인해주세요.");
			System.out.println("id와 암호를 다시 입력해주세요.");
			
		}
		
		
		
		

	}

}
