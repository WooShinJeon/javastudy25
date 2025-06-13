package junetest.service;

import java.sql.SQLException;
import java.util.Scanner;

import junetest.dao.MemberDAO;
import junetest.dto.MemberDTO;

public class MemberService {
	public MemberDAO memberDAO = new MemberDAO();

	public void subMenu(Scanner inputStr, Scanner inputInt, MemberDTO session) throws SQLException {
		boolean subRun = true;
		System.out.println("ȸ�������޴��� ���Ű� ȯ���մϴ�.");
		
		while(subRun) {
			System.out.println("====================================================");
			System.out.println("1. ȸ������\t2. �α���\t\t3. ȸ�����");
			System.out.println("4. ȸ����������\t5. ȸ����������\t6. �α׾ƿ�");
			System.out.println("7. ȸ�������޴� ����");
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
				System.out.println("�����޴��� ���ư��ϴ�.");
				subRun = false;
				break;
				
			default :
				System.out.println("1~7�� ������ �ϳ��� �Է��ϼ���.");
				break;
			} // switch
			
		} // while
		
	} // subMenu

	private void mbLogout(MemberDTO session) {
		if (session == null || session.getMno() == 0) {
			System.out.println("=================================");
		    System.out.println("�α��� ���°� �ƴմϴ�.");
		} else {
			System.out.println("=================================");
		    System.out.println("�α׾ƿ��ϰڽ��ϴ�.");
		    session.setMno(0);
		    session.setMname(null);
		    session.setMid(null);
		    session.setMpw(null);
		    session.setMphone(null);
		    session.setMemail(null);
		    session.setMdate(null);
		    System.out.println(".........");
		    System.out.println("�α׾ƿ��� �Ϸ�Ǿ����ϴ�.");
		}
		System.out.println("=================================");
		System.out.println("==========ȸ���� �޴��� ���ư��ϴ�.==========");
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
			System.out.println("�̹� �α��� �����Դϴ�.");
		}
		
	}

	private void mDelete(Scanner inputStr, MemberDAO memberDAO) throws SQLException {
		System.out.println("������ ȸ���� ID�� PW�� �Է��ϼ���.");
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
		System.out.println("������ ȸ���� ID�� �Է��ϼ���.");
		System.out.println("---------------");
		System.out.print("ID : ");
		String id = inputStr.next();
		System.out.println("---------------");
		
		memberDAO.mModify(id, inputStr);
		
		System.out.println("---------------");
		System.out.println("�����޴��� ���ư��ϴ�.");
	} // mModify

	private void mReadAll(MemberDAO memberDAO) throws SQLException {
		System.out.println("��ȣ�� ������ ȸ������ ���");
		System.out.println("====================================================");
		
		memberDAO.mReadAll();
		
	} // mReadAll

	private void mCreate(Scanner inputStr, MemberDAO memberDAO) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("ȸ�������� �����մϴ�.");
		System.out.println("---------------");
		System.out.print("�̸� : ");
		memberDTO.setMname(inputStr.next());
		System.out.println("---------------");
		System.out.print("ID : ");
		memberDTO.setMid(inputStr.next());
		System.out.println("---------------");
		System.out.print("PW : ");
		memberDTO.setMpw(inputStr.next());
		System.out.println("---------------");
		System.out.println("��ȭ��ȣ( - �� ����ؼ� �������ּ���.)");
		System.out.print(" : ");
		memberDTO.setMphone(inputStr.next());
		System.out.println("---------------");
		System.out.print("�̸��� : ");
		memberDTO.setMemail(inputStr.next());
		System.out.println("---------------");
		
		memberDAO.mCreate(memberDTO, inputStr);
		
		System.out.println("---------------");
		System.out.println("�����޴��� ���ư��ϴ�.");
	} // mCreate

} // class
