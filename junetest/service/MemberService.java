package junetest.service;

import java.sql.SQLException;
import java.util.Scanner;

import junetest.dao.MemberDAO;
import junetest.dto.MemberDTO;

public class MemberService {
	public MemberDAO memberDAO = new MemberDAO();

	public void subMenu(Scanner inputStr, Scanner inputInt, MemberDTO session) throws SQLException {
		boolean subRun = true;
		System.out.println("회원관리메뉴에 오신걸 환영합니다.");
		
		while(subRun) {
			System.out.println("====================================================");
			System.out.println("1. 회원가입\t2. 로그인\t\t3. 회원목록");
			System.out.println("4. 회원정보수정\t5. 회원정보삭제\t6. 로그아웃");
			System.out.println("7. 회원관리메뉴 종료");
			System.out.println("==============");
			System.out.print(">> ");
			String subSelect = inputStr.next();
			System.out.println("==============");
			
			switch(subSelect) {
			case "1" :
				mCreate(inputStr, memberDAO);
				break;
				
			case "2" :
				mLogin(inputStr, session, memberDAO);
				break;
				
			case "3" :
				mReadAll(memberDAO);
				break;
				
			case "4" :
				mModify(inputStr, memberDAO);
				break;
				
			case "5" :
				mDelete(inputStr, memberDAO);
				break;
				
			case "6" :
				mbLogout(session);
				break;
				
			case "7" :
				System.out.println("상위메뉴로 돌아갑니다.");
				subRun = false;
				break;
				
			default :
				System.out.println("1~7의 숫자중 하나만 입력하세요.");
				break;
			} // switch
			
		} // while
		
	} // subMenu

	private void mbLogout(MemberDTO session) {
		if (session == null || session.getMno() == 0) {
			System.out.println("=================================");
		    System.out.println("로그인 상태가 아닙니다.");
		} else {
			System.out.println("=================================");
		    System.out.println("로그아웃하겠습니다.");
		    session.setMno(0);
		    session.setMname(null);
		    session.setMid(null);
		    session.setMpw(null);
		    session.setMphone(null);
		    session.setMemail(null);
		    session.setMdate(null);
		    System.out.println(".........");
		    System.out.println("로그아웃이 완료되었습니다.");
		}
		System.out.println("=================================");
		System.out.println("==========회원용 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	}

	public void mLogin(Scanner inputStr, MemberDTO session, MemberDAO memberDAO) throws SQLException {
		if(session == null || session.getMno() == 0) {
			System.out.print("ID : ");
			String id = inputStr.next();
			System.out.println("---------------");
			System.out.print("PW : ");
			String pw = inputStr.next();
			System.out.println("---------------");
			memberDAO.mLogin(id, pw, session);
		}else {
			System.out.println("---------------");
			System.out.println("이미 로그인 상태입니다.");
		}
		
	}

	private void mDelete(Scanner inputStr, MemberDAO memberDAO) throws SQLException {
		System.out.println("삭제할 회원의 ID와 PW를 입력하세요.");
		System.out.println("---------------");
		System.out.print("ID : ");
		String id = inputStr.next();
		System.out.println("---------------");
		System.out.print("PW : ");
		String pw = inputStr.next();
		System.out.println("---------------");
		
		memberDAO.mDelete(id, pw);
	}

	private void mModify(Scanner inputStr, MemberDAO memberDAO) throws SQLException {
		System.out.println("수정할 회원의 ID를 입력하세요.");
		System.out.println("---------------");
		System.out.print("ID : ");
		String id = inputStr.next();
		System.out.println("---------------");
		
		memberDAO.mModify(id, inputStr);
		
		System.out.println("---------------");
		System.out.println("상위메뉴로 돌아갑니다.");
	} // mModify

	private void mReadAll(MemberDAO memberDAO) throws SQLException {
		System.out.println("암호를 제외한 회원정보 목록");
		System.out.println("====================================================");
		
		memberDAO.mReadAll();
		
	} // mReadAll

	private void mCreate(Scanner inputStr, MemberDAO memberDAO) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("회원가입을 시작합니다.");
		System.out.println("---------------");
		System.out.print("이름 : ");
		memberDTO.setMname(inputStr.next());
		System.out.println("---------------");
		System.out.print("ID : ");
		memberDTO.setMid(inputStr.next());
		System.out.println("---------------");
		System.out.print("PW : ");
		memberDTO.setMpw(inputStr.next());
		System.out.println("---------------");
		System.out.println("전화번호( - 을 사용해서 기입해주세요.)");
		System.out.print(" : ");
		memberDTO.setMphone(inputStr.next());
		System.out.println("---------------");
		System.out.print("이메일 : ");
		memberDTO.setMemail(inputStr.next());
		System.out.println("---------------");
		
		memberDAO.mCreate(memberDTO, inputStr);
		
		System.out.println("---------------");
		System.out.println("상위메뉴로 돌아갑니다.");
	} // mCreate

} // class
