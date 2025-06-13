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
			System.out.println("\t\t�Խ��� �����Դϴ�~");
			System.out.println("====================================================");
			System.out.println("1. ȸ�������޴�  2.��ȸ����Խ���  3. ȸ����Խ���  4.���α׷� ����");
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
					System.out.println("�α��� �ؾ� �����ִ� �޴��Դϴ�.");
					System.out.println("�α���ȭ������ �̵��մϴ�.");
					MemberService memberService1 = new MemberService();
					memberService1.mLogin(inputStr, session, memberDAO);
				}else {	
					System.out.println("ȸ���� �Խ��� �޴��Դϴ�.");
					MBoardService mBoardService = new MBoardService();
					mBoardService.subMenu(inputStr, session);
				}
				break;
				
			case "4" :
				System.out.println("�Խ��� ���� �����մϴ�.");
				run = false;
				break;
				
			default :
				System.out.println("1~4�� ������ �ϳ��� �Է����ּ���.");
				break;
			}
		}

	}

}
