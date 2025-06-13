package junetest.service;

import java.sql.SQLException;
import java.util.Scanner;

import junetest.dao.BoardDAO;
import junetest.dto.BoardDTO;

public class BoardService {
	public BoardDAO boardDAO = new BoardDAO();

	public void subMenu(Scanner inputStr) throws SQLException {
		boolean subRun = true;
		System.out.println("��ȸ�� �Խ��� �޴��Դϴ�.");
		
		while(subRun) {
			System.out.println("====================================================");
			System.out.println("1. ��κ���\t2. �Խñ��ۼ�\t3. �Խñۺ���");
			System.out.println("4. �Խñۼ���\t5. �Խñۻ���\t6. �Խ�������");
			System.out.println("==============");
			System.out.print(">> ");
			String subSelect = inputStr.next();
			System.out.println("==============");
			
			switch(subSelect) {
			case "1" :
				System.out.println("��� �Խñ� ����");
				selectAll(boardDAO);
				break;
				
			case "2" :
				System.out.println("�Խñ� �ۼ��ϱ�");
				insertBoard(boardDAO, inputStr);
				break;
				
			case "3" :
				System.out.println("�Խñ� �ڼ��� ����");
				readOne(inputStr);
				break;
				
			case "4" :
				System.out.println("�Խñ� �����ϱ�");
				modify(inputStr);
				break;
				
			case "5" :
				System.out.println("�Խñ� �����ϱ�");
				deleteOne();
				break;
				
			case "6" :
				System.out.println("�Խñ� ���� ����");
				subRun = false;
				break;
				
			default :
				System.out.println("1~6������ ���ڸ� �Է����ּ���.");
				break;
			} // switch
		} // while
	} // subMenu
	
	private void deleteOne() throws SQLException {
		Scanner inputInt = new Scanner(System.in);
		System.out.println("=======������ �Խñ��� ��ȣ�� �Է��ϼ���.=======");
		System.out.print(">>> ");
		int selectBno = inputInt.nextInt();
		System.out.println("=================================");
		
		boardDAO.deleteOne(selectBno);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
	} // deleteOne

	private void modify(Scanner inputStr) throws SQLException {
		System.out.println("=======������ �Խñ��� ������ �Է��ϼ���.=======");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		boardDAO.modify(title, inputStr);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
	} // modify

	private void readOne(Scanner inputStr) throws SQLException {
		System.out.println("========�� �Խñ��� ������ �Է��ϼ���.========");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		boardDAO.readOne(title);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
	} // readOne

	private void insertBoard(BoardDAO boardDAO, Scanner inputStr) throws SQLException {
		System.out.println("===========�Խñ��� �ۼ��մϴ�.============");
		BoardDTO boardDTO = new BoardDTO();
		System.out.print("�ۼ��� : ");
		boardDTO.setBwriter(inputStr.next());
		System.out.println("=================================");
		
		System.out.print("���� : ");
		boardDTO.setBtitle(inputStr.next());
		System.out.println("=================================");
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("���� : ");
		boardDTO.setBcontent(inputLine.nextLine());
		System.out.println("=================================");
		
		boardDAO.insertBoard(boardDTO);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
		
	} // insertBoard

	private void selectAll(BoardDAO boardDAO) throws SQLException {
		System.out.println("==========MBC �Խ��� ����Դϴ�.==========");
		boardDAO.selectAll();
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
		
	} // selectAll
	
	
	
}
