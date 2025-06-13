package junetest;

import java.sql.SQLException;
import java.util.Scanner;

import junetest.dao.MemberDAO;
import junetest.dto.MemberDTO;
import junetest.service.BoardService;
import junetest.service.MBoardService;
import junetest.service.MemberService;

public class MainExam {
	
	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);
	public static MemberDTO session = new MemberDTO();
	public static MemberDAO memberDAO = new MemberDAO();

	public static void main(String[] args) throws SQLException {
		boolean run = true;
		while(run) {
			System.out.println("====================================================");
			System.out.println("\t\t게시판 서비스입니다~");
			System.out.println("====================================================");
			System.out.println("1. 회원관리메뉴  2.비회원용게시판  3. 회원용게시판  4.프로그램 종료");
			System.out.println("==============");
			System.out.print(">> ");
			String select = inputStr.next();
			System.out.println("==============");
			
			switch(select) {
			case "1" :
				MemberService memberService = new MemberService();
				memberService.subMenu(inputStr, inputInt, session);
				break;
				
			case "2" :
				BoardService boardService = new BoardService();
				boardService.subMenu(inputStr);
				break;
				
			case "3" :
				if(session == null || session.getMno() == 0) {
					System.out.println("로그인 해야 들어갈수있는 메뉴입니다.");
					System.out.println("로그인화면으로 이동합니다.");
					MemberService memberService1 = new MemberService();
					memberService1.mLogin(inputStr, session, memberDAO);
				}else {	
					System.out.println("회원용 게시판 메뉴입니다.");
					MBoardService mBoardService = new MBoardService();
					mBoardService.subMenu(inputStr, session);
				}
				break;
				
			case "4" :
				System.out.println("게시판 서비스 종료합니다.");
				run = false;
				break;
				
			default :
				System.out.println("1~4의 숫자중 하나만 입력해주세요.");
				break;
			}
		}

	}

}
