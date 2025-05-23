package ch04;

import java.util.Scanner;

public class MemberObjectExam {

	public static void main(String[] args) {
		// Member 클래스 호출
		Scanner input = new Scanner(System.in);
		Member[] members = null;
		
		System.out.println("가입 할 회원수를 입력해주세요.");
		System.out.print(">>> ");
		int count = input.nextInt();
		members = new Member[count];
		
		System.out.println("회원가입 프로그램을 실행합니다.");
		boolean run = true;
		while(run) {
			
			System.out.println("1.회원가입");
			System.out.println("2.회원전체보기");
			System.out.println("3.로그인");
			System.out.println("4.회원수정");
			System.out.println("5.회원탈퇴");
			System.out.println("1~5까지만 입력하세요.(다른키를 입력하면 프로그램이 종료됩니다.)");
			System.out.print(">>> ");
			int select = input.nextInt();
			
			switch(select) {
			case 1 :
				Member member1 = new Member(); // 객체생성
				for(int i=0 ; i<members.length ; i++) {
				member1 = member1.memberAdd(input);
				members[i] = member1;
				}
				System.out.println("회원가입이 완료되었습니다.");
				break;
				
			case 2 :
				Member member2 = new Member(); // 객체생성
				member2.memberAllList(members);
				break;
				
			case 3 :
				Member member3 = new Member(); // 객체생성
				member3.memberLogin(members, input);
				break;
				
			case 4 :
				Member member4 = new Member(); // 객체생성
				member4.memberUpdate();
				break;
				
			case 5 :
				Member member5 = new Member(); // 객체생성
				member5.memberDelete();
				break;
				
			default :
				System.out.println("회원가입 프로그램 종료");
				run = false;
				break;
			} // switch(select)문 종료
		} // while(run)문 종료

	} // main메서드 종료

} // class 종료
