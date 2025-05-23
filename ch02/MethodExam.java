package ch02;

import java.util.Scanner;

public class MethodExam {

	public static void main(String[] args) {
		// 성적처리용 프로그램을 메서드로 재구현
		// 메인 메서드에는 주 메뉴를 구현
		// 사용자 지정 메서드는 부 메뉴를 구현
		
		Scanner inputInt = new Scanner(System.in);
		boolean run = true;
		String id = "kkw";
		String pw = "1234";
		boolean session = false; // 로그인 상태 저장용
		
		
		while(run) {
			System.out.println("==== 엠비씨 성적처리용 ====");
			System.out.println("1. 로그인");
			System.out.println("2. 교사관리");
			System.out.println("3. 학생관리");
			System.out.println("4. 성적관리");
			System.out.println("9. 프로그램 종료");
			System.out.print(">>> ");
			int select = inputInt.nextInt();
			
			switch(select) {
			case 1:
				System.out.println("로그인 메뉴로 이동합니다.");
				session = loginOk(id, pw, session);
				
				if(session == true) {
					System.out.println(id+"님 환영합니다.");
					System.out.println("2~4메뉴를 사용하실 수 있습니다.");
				}else {
					System.out.println("  ");
				}
				
				
				break;
			case 2:
				System.out.println("교사관리 메뉴로 이동합니다.");
				break;
			case 3:
				System.out.println("학생관리 메뉴로 이동합니다.");
				break;
			case 4:
				System.out.println("성적관리 메뉴로 이동합니다.");
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			
			} // 스위치문 종료
			
		}
		
		
		

	} // 메인 메서드 종료

	static boolean loginOk(String id, String pw, boolean session) {
		// 로그인 여부를 결정하는 메서드
		Scanner inputLogin = new Scanner(System.in);
		System.out.println("로그인 id를 입력하세요.");
		System.out.print(">>> ");
		String inputId = inputLogin.next(); // 키보드로 id 입력
		
		System.out.println("로그인 pw를 입력하세요.");
		System.out.print(">>> ");
		String inputPw = inputLogin.next(); // 키보드로 pw 입력
		
		if(id.equals(inputId) && pw.equals(inputPw)) {
			System.out.println("id와 pw가 일치합니다.");
			System.out.println("로그인 성공!!");
			session = true;
		}else {
			System.out.println("id와 pw가 불일치합니다.");
			System.out.println("로그인 실패!!");
			session = false;
		} // id pw 일치 판단문 종료
		
		return session; // 로그인 성공과 실패 결과를 리턴함
		
		
		
	}

} // 클래스 종료
