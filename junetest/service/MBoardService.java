package junetest.service;

import java.sql.SQLException;
import java.util.Scanner;

import junetest.dao.MBoardDAO;
import junetest.dto.MBoardDTO;
import junetest.dto.MemberDTO;

public class MBoardService {
	
	public MBoardDAO mBoardDAO = new MBoardDAO();

	public void subMenu(Scanner inputStr, MemberDTO session) throws SQLException {
		boolean subRun = true;
		System.out.println("회원 게시판 메뉴입니다.");
		
		while(subRun) {
			System.out.println("====================================================");
			System.out.println("1. 모두보기\t2. 게시글작성\t3. 게시글보기");
			System.out.println("4. 게시글수정\t5. 게시글삭제\t6. 게시판종료");
			System.out.println("==============");
			System.out.print(">> ");
			String subSelect = inputStr.next();
			System.out.println("==============");
			
			switch(subSelect) {
			case "1" :
				System.out.println("모든 게시글 보기");
				selectAll(mBoardDAO);
				break;
				
			case "2" :
				System.out.println("게시글 작성하기");
				insertMBoard(mBoardDAO, inputStr, session);
				break;
				
			case "3" :
				System.out.println("게시글 자세히 보기");
				readOne(inputStr);
				break;
				
			case "4" :
				System.out.println("게시글 수정하기");
				modify(inputStr);
				break;
				
			case "5" :
				System.out.println("게시글 삭제하기");
				deleteOne(inputStr);
				break;
				
			case "6" :
				System.out.println("게시글 보기 종료");
				subRun = false;
				break;
				
			default :
				System.out.println("1~6까지의 숫자만 입력해주세요.");
				break;
			} // switch
			
		} // while
		
	}
	
	
	private void deleteOne(Scanner inputStr) throws SQLException {
		System.out.println("=======삭제할 게시글의 제목을 입력하세요.=======");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		mBoardDAO.deleteOne(title);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	}


	private void modify(Scanner inputStr) throws SQLException {
		System.out.println("=======수정할 게시글의 제목을 입력하세요.=======");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		mBoardDAO.modify(title, inputStr);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	}


	private void readOne(Scanner inputStr) throws SQLException {
		System.out.println("========볼 게시글의 제목을 입력하세요.========");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		mBoardDAO.readOne(title);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	}


	private void insertMBoard(MBoardDAO mBoardDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		System.out.println("===========게시글을 작성합니다.============");
		MBoardDTO mboardDTO = new MBoardDTO();
		System.out.print("제목 : ");
		mboardDTO.setMbtitle(inputStr.next());
		System.out.println("=================================");
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용 : ");
		mboardDTO.setMbcontent(inputLine.nextLine());
		System.out.println("=================================");
		
		mBoardDAO.insertMBoard(mboardDTO ,session);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	}


	private void selectAll(MBoardDAO mBoardDAO) throws SQLException {
		System.out.println("==========MBC 게시판 목록입니다.==========");
		mBoardDAO.selectAll();
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	} // selectAll
	
	
	
	
	
	
	

}
