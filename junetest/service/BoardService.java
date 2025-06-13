package junetest.service;

import java.sql.SQLException;
import java.util.Scanner;

import junetest.dao.BoardDAO;
import junetest.dto.BoardDTO;

public class BoardService {
	public BoardDAO boardDAO = new BoardDAO();

	public void subMenu(Scanner inputStr) throws SQLException {
		boolean subRun = true;
		System.out.println("비회원 게시판 메뉴입니다.");
		
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
				selectAll(boardDAO);
				break;
				
			case "2" :
				System.out.println("게시글 작성하기");
				insertBoard(boardDAO, inputStr);
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
				deleteOne();
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
	} // subMenu
	
	private void deleteOne() throws SQLException {
		Scanner inputInt = new Scanner(System.in);
		System.out.println("=======삭제할 게시글의 번호을 입력하세요.=======");
		System.out.print(">>> ");
		int selectBno = inputInt.nextInt();
		System.out.println("=================================");
		
		boardDAO.deleteOne(selectBno);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
	} // deleteOne

	private void modify(Scanner inputStr) throws SQLException {
		System.out.println("=======수정할 게시글의 제목을 입력하세요.=======");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		boardDAO.modify(title, inputStr);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
	} // modify

	private void readOne(Scanner inputStr) throws SQLException {
		System.out.println("========볼 게시글의 제목을 입력하세요.========");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		boardDAO.readOne(title);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
	} // readOne

	private void insertBoard(BoardDAO boardDAO, Scanner inputStr) throws SQLException {
		System.out.println("===========게시글을 작성합니다.============");
		BoardDTO boardDTO = new BoardDTO();
		System.out.print("작성자 : ");
		boardDTO.setBwriter(inputStr.next());
		System.out.println("=================================");
		
		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		System.out.println("=================================");
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine());
		System.out.println("=================================");
		
		boardDAO.insertBoard(boardDTO);
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	} // insertBoard

	private void selectAll(BoardDAO boardDAO) throws SQLException {
		System.out.println("==========MBC 게시판 목록입니다.==========");
		boardDAO.selectAll();
		System.out.println("=================================");
		System.out.println("==========게시판 메뉴로 돌아갑니다.==========");
		System.out.println("=================================");
		
	} // selectAll
	
	
	
}
