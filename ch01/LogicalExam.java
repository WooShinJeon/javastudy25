package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		
		
		
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.print("ȸ�������� id�� �Է����ּ��� : ");
		String loginid = input.nextLine();
		
		System.out.print("ȸ�������� ��ȣ�� �Է����ּ��� : ");
		String loginpw1 = input.nextLine();
		System.out.print("��ȣ Ȯ�� : ");
		String loginpw2 = input.nextLine();
		
		if(loginpw1.equals(loginpw2)) {
			System.out.println("��ȣ�� ��ġ�մϴ�.");
			System.out.println("ȸ�������� �Ϸ�Ǽ̽��ϴ�.");
			
			System.out.print("�α����� id�� �Է��ϼ��� : ");
			String id = input.nextLine();
			
			System.out.print("�α����� ��ȣ�� �Է��ϼ��� : ");
			String pw = input.nextLine();
			System.out.println("===== ���� ���Դϴ�. =====");
			
			if( (loginid.equals(id)) & loginpw2.equals(pw) ) {
				System.out.println("id�� ��ȣ�� ��ġ�մϴ�.");
				System.out.println("�α��� ����!!!!!!");
			}else { 
				System.out.println("id�� ��ȣ�� ��ġ���� �ʽ��ϴ�.");
				System.out.println("�α��� ����!!!!!!");
			
			}
			
		}else {
			System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			System.out.println("id�� ��ȣ�� �ٽ� �Է����ּ���.");
			
		}
		
		
		
		

	}

}
