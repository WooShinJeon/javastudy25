package ch04;

import java.util.Scanner;

public class Member {
	// 회원용 객체
	// 필드, 생성자, 메서드 필요
	
	// 필드(회원번호, id, pw, ...)
	public int mno;   // 회원번호
	public String id; // 회원id
	public String pw; // 회원pw
	
	// 생성자 : Exam클래스를 main()메서드에서 호출할때 동작
	public Member() {
	}
	
	// 메서드 : Member클래스에서 행해지는 동작 = CRUD
	public Member memberAdd(Scanner input) {
		Member member = new Member(); // 리턴용 객체
		
		System.out.println("회원가입용 메서드입니다.");
		System.out.print("회원번호(숫자)를 입력하세요 : ");
		member.mno = input.nextInt();
		
		System.out.print("회원 id를 입력하세요 : ");
		member.id = input.next();
		
		System.out.print("회원 pw를 입력하세요 : ");
		member.pw = input.next();
		
		return member;
	}
	public void memberAllList(Member[] members) {
		System.out.println("모든회원보기 리스트 메서드입니다.");
		for(int i=0 ; i<members.length ; i++) {
			System.out.print("회원번호 : "+members[i].mno);
			System.out.print(" / 회원id : "+members[i].id);
			System.out.println(" / 회원pw : "+members[i].pw);
			System.out.println("---------------------------------------------");
		}
	}
	public void memberLogin(Member[] members, Scanner input) {
		System.out.println("로그인 메서드입니다.");
		System.out.print("id : ");
		String typedId = input.next();
		System.out.print("pw : ");
		String typedPw = input.next();
		for(int i=0 ; i<members.length ; i++) {
			if(typedId==members[i].id && typedPw==members[i].pw) {
				
			}
		}
		
		
		
		
	}
	public void memberUpdate() {
		System.out.println("회원수정 메서드입니다.");
	}
	public void memberDelete() {
		System.out.println("회원탍퇴 메서드입니다.");
	}
	
	
	
	

}
