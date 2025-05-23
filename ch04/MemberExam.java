package ch04;

import java.util.Scanner;

public class MemberExam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] names = null;
		String[] ids = null;
		String[] pws = null;
		MemberGrade[] grades = null;
		
		
		System.out.println("몇명의 회원을 등록 하시겠습니까?");
		System.out.print(">>> ");
		int count = input.nextInt();
		names = new String[count];
		ids = new String[count];
		pws = new String[count];
		grades = new MemberGrade[count];
		
		System.out.println("회원가입을 진행하겠습니다.");
		for(int i=0;i<count;i++) {
			System.out.print("이름 >>> ");			
			names[i]=input.next();
			System.out.print("id >>> ");
			ids[i]=input.next();
			System.out.print("pw >>> ");
			pws[i]=input.next();
			
			System.out.println("등급을 선택하세요.");
			System.out.println("1.GUEST");
			System.out.println("2.MEMBER");
			System.out.println("3.VIP");
			System.out.println("4.VVIP");
			System.out.println("5.ADMIN");
			System.out.print(">>> ");
			String grade = input.next();
			switch(grade) {
			case "1" :
				grades[i]=MemberGrade.GUEST;
				System.out.println("비회원 등급입니다.");
				break;
			case "2" :
				grades[i]=MemberGrade.MEMBER;
				System.out.println("회원 등급입니다.");
				break;
			case "3" :
				grades[i]=MemberGrade.VIP;
				System.out.println("vip 등급입니다.");
				break;
			case "4" :
				grades[i]=MemberGrade.VVIP;
				System.out.println("vvip 등급입니다.");
				break;
			case "5" :
				grades[i]=MemberGrade.ADMIN;
				System.out.println("관리자 등급입니다.");
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
					
			} // switch(grade)문 종료
			System.out.println(names[i]+"님 "+grades[i]+"(으)로 가입되었습니다.");
		} // for문 종료
		System.out.println("현재 가입 내용입니다.");
		for(int i=0 ; i<count ; i++) {
			System.out.print("이름 : "+names[i]);
			System.out.print(" / id : "+ids[i]);
			System.out.print(" / pw : "+pws[i]);
			System.out.println(" / 등급 : "+grades[i]);
			System.out.println();
		}

	} // main메서드 종료

} // class 종료
