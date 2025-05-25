package ch04.marioKart.service;

import java.util.Scanner;

import ch04.marioKart.dto.MemberDTO;

public class MemberService {

	public MemberDTO menu(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
			
		System.out.println("==== 회원관리 메뉴에 진입하셨습니다. ====");
		boolean subRun = true;
		while(subRun) {
			System.out.println("1.가입 | 2.로그인 | 3.수정 | 4.삭제 | 5.종료");
			System.out.print(">>> ");
			String select = input.next();
				
			switch(select) {
			case "1" :
				System.out.println("계정을 생성합니다.");
				create(input, memberDTOs);
				break;
					
			case "2" :
				System.out.println("로그인 화면입니다.");
				loginState = login(input, memberDTOs, loginState);
				break;
					
			case "3" :
				System.out.println("계정비밀번호를 수정합니다.");
				modify(input, memberDTOs, loginState);
				break;
					
			case "4" :
				System.out.println("계정을 삭제합니다.");
				delete(input, memberDTOs, loginState);
				break;
					
			case "5" :
				System.out.println("회원관리 메뉴를 종료합니다.");
				System.out.println("메인메뉴로 복귀합니다.");
				subRun = false;
				break;
					
			case "99" :
				System.out.println("관리자 페이지입니다.");
				admin(input, memberDTOs, loginState);
				break;
					
			default :
				System.out.println("1~5사이의 숫자를 입력해주세요.");
			}
		}
		
			return null;
	}

	public void admin(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		boolean admRun = true;
		while (admRun) {
			System.out.println("1.모든 회원정보 보기 | 2.현재 로그인되어있는 회원정보 보기 | 3.회원 삭제하기 | 4. 관리자메뉴 종료하기");
			System.out.print(">>> ");
			String select = input.next();
			switch (select) {
			case "1":
				System.out.println("모든 회원의 정보를 보여드리겠습니다.");
				for(int i=0 ; i<memberDTOs.length ; i++) {
					if(memberDTOs[i] != null) {
						System.out.println();
						System.out.println((i+1)+"번째 회원정보");
						System.out.print("id : "+memberDTOs[i].id+" | pw : "+memberDTOs[i].pw+" | 닉네임 : "+memberDTOs[i].nickName+" | 이메일 : "+memberDTOs[i].email);
					}
				}
				System.out.println();
				System.out.println("관리자 메뉴로 돌아갑니다.");
				break;

			case "2":
				if(loginState == null) {
					System.out.println("현재 로그인되어있지 않습니다.");
				}else {
					System.out.println("현재 로그인되어있는 회원의 정보를 보여드리겠습니다.");
					System.out.println("현재 로그인되어있는 "+loginState.nickName+"님의 회원정보");
					System.out.print("id : "+loginState.id+" | pw : "+loginState.pw+" | 닉네임 : "+loginState.nickName+" | 이메일 : "+loginState.email);
				}
				System.out.println();
				System.out.println("관리자 메뉴로 돌아갑니다.");
				break;

			case "3":
				System.out.println("원하는 회원의 정보를 삭제합니다.");
				System.out.println("가입되어있는 회원의 닉네임을 보여드리겠습니다. 삭제하고싶은 회원의 번호를 골라주세요.");
				for(int i=0 ; i<memberDTOs.length ; i++) {
					if(memberDTOs[i] != null) {
						System.out.println((i+1)+". "+memberDTOs[i].nickName);
					}
				}
				System.out.print(">>> ");
				int delSelect = input.nextInt();
				System.out.println(delSelect+"번 "+memberDTOs[delSelect-1].nickName+"의 회원정보를 삭제합니다.");
				memberDTOs[delSelect-1] = null;
				System.out.println(".........");
				System.out.println("회원정보의 삭제가 완료되었습니다.");
				System.out.println();
				System.out.println("관리자 메뉴로 돌아갑니다.");
				break;

			case "4":
				System.out.println("관리자메뉴를 종료하고 회원관리메뉴로 돌아갑니다.");
				admRun = false;
				break;
			}
		}
		
	}

	public void delete(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		MemberDTO deleteMember = new MemberDTO();
		
		System.out.println("계정삭제 메뉴입니다.");
		System.out.println("삭제하고싶은 계정의 id와 pw를 입력하세요.");
		System.out.println("id : ");
		deleteMember.id = input.next();
		System.out.println("pw : ");
		deleteMember.pw = input.next();
		
		for(int i=0 ; i<memberDTOs.length ; i++) {
			if(memberDTOs[i].id.equals(deleteMember.id) && memberDTOs[i].pw.equals(deleteMember.pw)) {
				System.out.println(memberDTOs[i].nickName+"님의 계정삭제를 진행하겠습니다.");
				if(loginState == memberDTOs[i]) {
					loginState = null;
				}
				memberDTOs[i] = null;
			} // if문 종료
		} // for문 종료
		System.out.println("계정삭제가 완료되었습니다.");
	} // delete 메서드 종료

	public void modify(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		MemberDTO modifyMember = new MemberDTO();
		
		System.out.println("비밀번호 수정메뉴입니다.");
		System.out.println("수정하실 회원님의 id와 pw를 입력해주세요.");
		System.out.print("id : ");
		modifyMember.id = input.next();
		System.out.print("pw : ");
		modifyMember.pw = input.next();
		
		if(loginState.id.equals(modifyMember.id) && loginState.pw.equals(modifyMember.pw)) {
			System.out.println("수정하고싶은 pw를 입력해주세요.");
			System.out.print(">>> ");
			loginState.pw = input.next();
		} // if문 종료
		System.out.println("pw변경이 완료되었습니다.");
	} // modify문 종료

	public MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		MemberDTO loginMember = new MemberDTO();
		
		System.out.println("id를 입력하세요.");
		System.out.print(">>> ");
		loginMember.id = input.next();
		
		System.out.println("pw를 입력하세요.");
		System.out.print(">>> ");
		loginMember.pw = input.next();
		
		for(int i=0 ; i<memberDTOs.length ; i++) {
			if(memberDTOs[i] != null && memberDTOs[i].id.equals(loginMember.id) && memberDTOs[i].pw.equals(loginMember.pw)) {
				System.out.println("로그인 성공!!");
				loginState = memberDTOs[i];
			} // if문 종료
		} // for문 종료
		System.out.println(loginState.nickName+"님, 메인메뉴로 돌아가겠습니다.");
		return loginState;
		
	} // login 메서드 종료

	public void create(Scanner input, MemberDTO[] memberDTOs) {
		System.out.println("회원가입용 메서드에 오신걸 환영합니다.");
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("사용할 id를 입력하세요.");
		System.out.print(">>> ");
		memberDTO.id = input.next();
		
		System.out.println("사용할 pw를 입력하세요.");
		System.out.print(">>> ");
		memberDTO.pw = input.next();
		
		System.out.println("사용할 닉네임을 입력하세요.");
		System.out.print(">>> ");
		memberDTO.nickName = input.next();
		
		System.out.println("사용할 이메일을 입력하세요.");
		System.out.print(">>> ");
		memberDTO.email = input.next();
		
		for(int i=0 ; i<memberDTOs.length ; i++) {
			if(memberDTOs[i] == null) {
				memberDTOs[i] = memberDTO;
				break;
			} // if문 종료
		} // for문 종료
	} // create 메서드 종료
} // class 종료


