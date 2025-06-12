package mbcboard;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dto.MemberDTO;
import mbcboard.service.BoardService;
import mbcboard.service.MBoardService;
import mbcboard.service.MemberService;

public class BoardExam {
	// 필드
	public static Scanner inputStr = new Scanner(System.in);
	public static MemberDTO session = new MemberDTO();
	// 생성자
	
	// 매서드
	public static void main(String[] args) throws SQLException{
		// MBC 게시판용 JDBC 테스트
		// DTO : 객체를 담당
		// DAO : 데이터베이스와의 연동을 담당
		// SERVICE : 부메뉴와 서비스를 담당
		boolean run = true;
		
		while(run) {
			System.out.println("=================================");
			System.out.println("===========MBC자유게시판입니다===========");
			System.out.println("=================================");
			System.out.println("1. 회원\t 2. 비회원용 게시판\t 3. 회원용 게시판\t 4. 종료");
			System.out.print(">>> ");
			String select = inputStr.next();
			System.out.println("=================================");
			
			switch(select) {
			case "1" :
				System.out.println("회원용 메뉴입니다.");
				MemberService memberService = new MemberService();
				session = memberService.subMenu(inputStr, session);
				break;
				
			case "2" :
				System.out.println("비회원용 게시판 메뉴입니다.");
				BoardService boardService = new BoardService();
				boardService.subMenu(inputStr);
				break;
				
			case "3" :
				if(session == null || session.getMno() == 0) {
					System.out.println("로그인 해야 들어갈수있는 메뉴입니다.");
				}else {	
					System.out.println("회원용 게시판 메뉴입니다.");
					MBoardService mBoardService = new MBoardService();
					mBoardService.subMenu(inputStr, session);
				}
				break;
			case "4" :
				System.out.println("게시판 프로그램을 종료합니다.");
				run = false;
				break;
				
			default :
				System.out.println("1~4까지의 숫자만 입력해주세요.");
				break;
				
			} // switch
			
		} // while
		
	} // main
	
} // class
