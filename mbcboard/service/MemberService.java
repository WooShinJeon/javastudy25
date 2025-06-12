package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.MemberDAO;
import mbcboard.dto.MemberDTO;

public class MemberService {
	public MemberDAO memberDAO = new MemberDAO();

	public MemberDTO subMenu(Scanner inputStr, MemberDTO session) throws SQLException {
		boolean subRun = true;
		
		while(subRun) {
			System.out.println("MBC 아카데미 회원용 서비스입니다.");
			System.out.println("=================================");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 보기");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원정보 삭제");
			System.out.println("6. 로그아웃");
			System.out.println("7. 나가기");
			System.out.println("==================");
			System.out.print(">>> ");
			String subSelect = inputStr.next();
			System.out.println("=================================");
			
			switch(subSelect) {
			case "1" :
				System.out.println("회원가입을 시작합니다.");
				mbCreate(memberDAO, inputStr);
				break;
				
			case "2" :
				System.out.println("로그인을 시작합니다.");
				session = mbLogin(inputStr, memberDAO, session);
				break;
				
			case "3" :
				System.out.println("회원들의 정보를 조회합니다.");
				mbReadAll(memberDAO);
				break;
				
			case "4" :
				System.out.println("회원정보를 수정합니다.");
				mbModify(memberDAO, inputStr);
				break;
				
			case "5" :
				System.out.println("회원정보를 삭제합니다.");
				mbDelete(memberDAO, inputStr);
				break;
				
			case "6" :
				session = mbLogout(session);
				break;
				
			case "7" :
				System.out.println("회원용 서비스를 종료합니다.");
				subRun = false;
				break;
				
			default :
				System.out.println("1~7까지의 숫자중 하나를 입력하세요.");
				break;
			} // switch
		} // while
		return session;
	} // subMenu

	private void mbDelete(MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		System.out.println("=================================");
		System.out.println("========삭제할 회원의 id를 입력하세요.========");
		System.out.println("=================================");
		System.out.print("ID : ");
		String id = inputStr.next();
		System.out.println("=================================");
		System.out.println("========삭제할 회원의 pw를 입력하세요.========");
		System.out.println("=================================");
		System.out.print("pw : ");
		String pw = inputStr.next();
		
		memberDAO.mbDelete(id, pw);
		System.out.println("=================================");
		System.out.println("==========회원용 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
	} // mbDelete

	private void mbModify(MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		System.out.println("=================================");
		System.out.println("========수정할 회원의 id를 입력하세요.========");
		System.out.println("=================================");
		System.out.print("ID : ");
		String id = inputStr.next();
		
		memberDAO.mbModify(id, inputStr);
		System.out.println("=================================");
		System.out.println("==========회원용 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
	} // mbModify

	private void mbReadAll(MemberDAO memberDAO) throws SQLException {
		System.out.println("=================================");
		System.out.println("====모든 회원의 정보를 암호를 제외하고 보여드립니다.=====");
		
		memberDAO.mbReadAll();
		System.out.println("=================================");
		System.out.println("==========회원용 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
	} // mbReadAll

	private MemberDTO mbLogout(MemberDTO session) {
		if (session == null || session.getMno() == 0) {
			System.out.println("=================================");
		    System.out.println("로그인 상태가 아닙니다.");
		} else {
			System.out.println("=================================");
		    System.out.println("로그아웃하겠습니다.");
		    session.setMno(0);
		    session.setBwriter(null);
		    session.setId(null);
		    session.setPw(null);
		    session.setRegidate(null);
		    System.out.println(".........");
		    System.out.println("로그아웃이 완료되었습니다.");
		}
		System.out.println("=================================");
		System.out.println("==========회원용 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		return session;
	} // mbLogout

	private MemberDTO mbLogin(Scanner inputStr, MemberDAO memberDAO, MemberDTO session) throws SQLException {
		if(session == null || session.getMno() == 0) {
			System.out.println("=================================");
			System.out.print("ID : ");
			String id = inputStr.next();
			System.out.println("=================================");
			
			System.out.print("PW : ");
			String pw = inputStr.next();
			System.out.println("=================================");
			
			session = memberDAO.mbLogin(id, pw, session);
		}else {
			System.out.println("=================================");
			System.out.println("이미 로그인 상태입니다.");
		}
			System.out.println("=================================");
			System.out.println("==========회원용 메뉴로 돌아갑니다.==========");
			System.out.println("=================================");
		return session;
	} // mbLogin

	private void mbCreate(MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		System.out.println("=================================");
		System.out.print("이름 : ");
		String name = inputStr.next();
		System.out.println("=================================");
		
		System.out.print("ID : ");
		String id = inputStr.next();
		System.out.println("=================================");
		
		System.out.print("PW : ");
		String pw = inputStr.next();
		System.out.println("=================================");
		
		memberDAO.mbCreate(id, pw, name);
		System.out.println("=================================");
		System.out.println("==========회원용 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
	} // mbCreate
	
	

} // class
