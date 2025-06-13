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
		System.out.println("ȸ�� �Խ��� �޴��Դϴ�.");
		
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
				selectAll(mBoardDAO);
				break;
				
			case "2" :
				System.out.println("�Խñ� �ۼ��ϱ�");
				insertMBoard(mBoardDAO, inputStr, session);
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
				deleteOne(inputStr);
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
		
	}
	
	
	private void deleteOne(Scanner inputStr) throws SQLException {
		System.out.println("=======������ �Խñ��� ������ �Է��ϼ���.=======");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		mBoardDAO.deleteOne(title);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
		
	}


	private void modify(Scanner inputStr) throws SQLException {
		System.out.println("=======������ �Խñ��� ������ �Է��ϼ���.=======");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		mBoardDAO.modify(title, inputStr);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
		
	}


	private void readOne(Scanner inputStr) throws SQLException {
		System.out.println("========�� �Խñ��� ������ �Է��ϼ���.========");
		System.out.print(">>> ");
		String title = inputStr.next();
		System.out.println("=================================");
		
		mBoardDAO.readOne(title);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
		
	}


	private void insertMBoard(MBoardDAO mBoardDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		System.out.println("===========�Խñ��� �ۼ��մϴ�.============");
		MBoardDTO mboardDTO = new MBoardDTO();
		System.out.print("���� : ");
		mboardDTO.setMbtitle(inputStr.next());
		System.out.println("=================================");
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("���� : ");
		mboardDTO.setMbcontent(inputLine.nextLine());
		System.out.println("=================================");
		
		mBoardDAO.insertMBoard(mboardDTO ,session);
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
		
	}


	private void selectAll(MBoardDAO mBoardDAO) throws SQLException {
		System.out.println("==========MBC �Խ��� ����Դϴ�.==========");
		mBoardDAO.selectAll();
		System.out.println("=================================");
		System.out.println("==========�Խ��� �޴��� ���ư��ϴ�.==========");
		System.out.println("=================================");
		
	} // selectAll
	
	
	
	
	
	
	

}
