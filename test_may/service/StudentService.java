package test_may.service;

import java.util.Scanner;

import test_may.dto.StudentDTO;

public class StudentService {

	public static void menu(Scanner input, StudentDTO[] studentDTOs) {
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.학생등록 | 2.정보수정 | 3.정보삭제 | 4.정보보기 | 5.이전메뉴");
			System.out.print(">> ");
			int select = input.nextInt();
			System.out.println("----------------------");
			switch (select) {
			case 1 :
				System.out.println("학생정보등록메뉴입니다.");
				create(input, studentDTOs);
				break;

			case 2 :
				System.out.println("학생정보수정메뉴입니다.");
				modify(input, studentDTOs);
				break;

			case 3 :
				System.out.println("학생정보삭제메뉴입니다.");
				delete(input, studentDTOs);
				break;
				
			case 4 :
				System.out.println("학생정보보기메뉴입니다.");
				read(input, studentDTOs);

			case 5 :
				System.out.println("이전메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("1~4중 한 숫자를 입력해주세요.");
				break;
			} // switch
		} // while
	} // menu

	private static void read(Scanner input, StudentDTO[] studentDTOs) {
		boolean run = true;
		while (run) {
			System.out.println("1.한명의 정보보기 | 2.모두의 정보보기 | 3.돌아가기");
			System.out.println("------------------");
			System.out.print(">> ");
			int select = input.nextInt();
			System.out.println("------------------");
			switch (select) {
			case 1:
				System.out.println("보고싶은 학생의 학번을 입력하세요.");
				System.out.print(">> ");
				String answer = input.next();
				System.out.println("------------------");

				for (int i = 0; i < studentDTOs.length; i++) {
					if (studentDTOs[i] != null) {
						if (studentDTOs[i].getStudentID().equals(answer)) {
							System.out.println("이름 : " + studentDTOs[i].getName() + " | 학번 : "
									+ studentDTOs[i].getStudentID() + " | 성별 : " + studentDTOs[i].getSex() + " | 학년 : "
									+ studentDTOs[i].getGrade() + "학년 | 반 : " + studentDTOs[i].getClassNo() + "반");
							break;
						} // if
					} // if
				} // for
				break;

			case 2:
				for (int i = 0; i < studentDTOs.length; i++) {
					if (studentDTOs[i] != null) {
						System.out.println(studentDTOs[i].getName() + " 학생");
						System.out.println("이름 : " + studentDTOs[i].getName() + " | 학번 : "
								+ studentDTOs[i].getStudentID() + " | 성별 : " + studentDTOs[i].getSex() + " | 학년 : "
								+ studentDTOs[i].getGrade() + "학년 | 반 : " + studentDTOs[i].getClassNo() + "반");
						System.out.println("--------------------------------------------------------------------");
					} // if
				} // for
				break;

			case 3:
				System.out.println("이전메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("1~3의 숫자중 하나만 입력하세요.");
				break;
			} // switch
		} // while
	} // read

	private static void delete(Scanner input, StudentDTO[] studentDTOs) {
		System.out.println("삭제할 학생의 학번을 입력하세요.");
		System.out.println("------------------");
		System.out.print(">> ");
		String answer = input.next();
		System.out.println("------------------");
		
		for(int i=0 ; i<studentDTOs.length ; i++) {
			if(studentDTOs[i] != null) {
				if(studentDTOs[i].getStudentID().equals(answer)) {
					System.out.println(studentDTOs[i].getName()+"님의 정보를 삭제합니다.");
					System.out.println(".........");
					studentDTOs[i] = null;
					System.out.println("학생정보삭제가 완료되었습니다.");
					break;
				} // if
			} // if
		} // for
	} // delete

	private static void modify(Scanner input, StudentDTO[] studentDTOs) {
		System.out.println("수정할 학생의 학번을 입력하세요.");
		System.out.println("------------------");
		System.out.print(">> ");
		String answer = input.next();
		System.out.println("------------------");
		
		for(int i=0 ; i<studentDTOs.length ; i++) {
			if(studentDTOs[i] != null) {
				if(studentDTOs[i].getStudentID().equals(answer)) {
					System.out.println("수정할 정보를 골라주세요.");
					boolean run = true;
					while (run) {
						System.out.println("--------------------------------------------");
						System.out.println("1.이름 | 2.학번 | 3.성별 | 4.학년 | 5.반 | 6.수정완료");
						System.out.print(">> ");
						int select = input.nextInt();
						System.out.println("-----------------");
						switch (select) {
						case 1:
							System.out.print("이름 : ");
							studentDTOs[i].setName(input.next());
							break;

						case 2:
							System.out.print("학번 : ");
							studentDTOs[i].setStudentID(input.next());
							break;

						case 3:
							System.out.print("성별 : ");
							studentDTOs[i].setSex(input.next());
							break;

						case 4:
							System.out.print("학년 : ");
							studentDTOs[i].setGrade(input.nextInt());
							break;

						case 5:
							System.out.print("반 : ");
							studentDTOs[i].setClassNo(input.nextInt());
							break;

						case 6:
							System.out.println("회원정보수정이 완료되었습니다.");
							System.out.println("이전메뉴로 돌아갑니다.");
							run = false;
							break;

						default:
							System.out.println("1~6중 한 숫자를 입력하세요.");
							break;
						} // switch
					} // while
				} // if
			} // if
		} // for
	} // modify

	private static void create(Scanner input, StudentDTO[] studentDTOs) {
		StudentDTO studentDTO = new StudentDTO();
		
		System.out.println("------------------");
		System.out.print("이름 : ");
		studentDTO.setName(input.next());
		System.out.println("------------------");
		System.out.print("학번 : ");
		studentDTO.setStudentID(input.next());
		System.out.println("------------------");
		System.out.print("성별(남/여) : ");
		studentDTO.setSex(input.next());
		System.out.println("------------------");
		System.out.print("학년 : ");
		studentDTO.setGrade(input.nextInt());
		System.out.println("------------------");
		System.out.print("반 : ");
		studentDTO.setClassNo(input.nextInt());
		System.out.println("------------------");
		
		for(int i=0 ; i<studentDTOs.length ; i++) {
			if(studentDTOs[i] == null) {
				studentDTOs[i] = studentDTO;
				System.out.println("학생정보등록이 완료되었습니다.");
				break;
			} // if
		} // for
	} // create
} // class
