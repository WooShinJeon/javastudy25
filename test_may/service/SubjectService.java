package test_may.service;

import java.util.Scanner;

import test_may.dto.StudentDTO;
import test_may.dto.SubjectsDTO;

public class SubjectService {

	public static void menu(Scanner input, StudentDTO[] studentDTOs, SubjectsDTO[] subjectsDTOs) {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1.성적등록 | 2.성적보기 | 3.성적수정 | 4.성적삭제 | 5.이전메뉴");
			System.out.print(">> ");
			int select = input.nextInt();
			System.out.println("----------------------");
			switch (select) {
			case 1 :
				System.out.println("성적등록메뉴입니다.");
				create(input, studentDTOs, subjectsDTOs);
				break;

			case 2 :
				System.out.println("성적보기메뉴입니다.");
				read(input, studentDTOs, subjectsDTOs);
				break;

			case 3 :
				System.out.println("성적수정메뉴입니다.");
				modify(input, studentDTOs, subjectsDTOs);
				break;
				
			case 4 :
				System.out.println("성적삭제메뉴입니다.");
				delete(input, studentDTOs, subjectsDTOs);
				break;
				
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

	private static void delete(Scanner input, StudentDTO[] studentDTOs, SubjectsDTO[] subjectsDTOs) {
		System.out.println("삭제할 학생의 학번을 입력하세요.");
		System.out.println("------------------");
		System.out.print(">> ");
		String answer = input.next();
		System.out.println("------------------");
		
		for(int i=0 ; i<studentDTOs.length ; i++) {
			if(studentDTOs[i] != null) {
				if(studentDTOs[i].getStudentID().equals(answer)) {
					System.out.println(studentDTOs[i].getName()+"님의 성적을 삭제합니다.");
					System.out.println(".........");
					subjectsDTOs[i] = null;
					System.out.println("성적삭제가 완료되었습니다.");
					break;
				} // if
			} // if
		} // for
	} // delete

	private static void read(Scanner input, StudentDTO[] studentDTOs, SubjectsDTO[] subjectsDTOs) {
		boolean run = true;
		while (run) {
			System.out.println("1.한명의 성적보기 | 2.모두의 성적보기 | 3.돌아가기");
			System.out.println("------------------");
			System.out.print(">> ");
			int select = input.nextInt();
			System.out.println("------------------");
			switch (select) {
			case 1:
				System.out.println("성적 볼 학생의 학번을 입력하세요.");
				System.out.println("------------------");
				System.out.print(">> ");
				String answer = input.next();
				System.out.println("------------------");
				
				for(int i=0 ; i<studentDTOs.length ; i++) {
					if(studentDTOs[i] != null) {
						if(studentDTOs[i].getStudentID().equals(answer)) {
							System.out.println(studentDTOs[i].getName()+"님의 성적을 보여드리겠습니다.");
							System.out.println("-----------------------");
							System.out.println("국어 : "+subjectsDTOs[i].getKor()+"점 | 수학 : "+subjectsDTOs[i].getMat()+
									"점 | 영어 : "+subjectsDTOs[i].getEng()+"점 | 과학 : "+subjectsDTOs[i].getSci()+"점");
							break;
						} // if
					} // if
				} // for
				break;

			case 2:
				System.out.println("전체학생의 성적을 보여드리겠습니다.");
				System.out.println("-------------------------");
				
				for(int i = 0; i<subjectsDTOs.length ; i++) {
					if(subjectsDTOs[i] != null) {
						System.out.println(studentDTOs[i].getName()+" 학생");
						System.out.println("국어 : "+subjectsDTOs[i].getKor()+"점 | 수학 : "+subjectsDTOs[i].getMat()+
								"점 | 영어 : "+subjectsDTOs[i].getEng()+"점 | 과학 : "+subjectsDTOs[i].getSci()+"점");
						System.out.println("----------------------------------------------------------");
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

	private static void modify(Scanner input, StudentDTO[] studentDTOs, SubjectsDTO[] subjectsDTOs) {
		System.out.println("수정할 학생의 학번을 입력하세요.");
		System.out.println("------------------");
		System.out.print(">> ");
		String answer = input.next();
		System.out.println("------------------");
		
		for(int i=0 ; i<studentDTOs.length ; i++) {
			if(studentDTOs[i] != null) {
				if (subjectsDTOs[i] != null) {
					if (studentDTOs[i].getStudentID().equals(answer)) {
						System.out.println("수정할 과목을 골라주세요.");
						boolean run = true;
						while (run) {
							System.out.println("---------------------------------------");
							System.out.println("1.국어 | 2.수학 | 3.영어 | 4.과학 | 5.수정완료");
							System.out.print(">> ");
							int select = input.nextInt();
							System.out.println("-----------------");
							switch (select) {
							case 1:
								System.out.print("국어 : ");
								subjectsDTOs[i].setKor(input.nextInt());
								break;

							case 2:
								System.out.print("수학 : ");
								subjectsDTOs[i].setMat(input.nextInt());
								break;

							case 3:
								System.out.print("영어 : ");
								subjectsDTOs[i].setEng(input.nextInt());
								break;

							case 4:
								System.out.print("과학 : ");
								subjectsDTOs[i].setSci(input.nextInt());
								break;

							case 5:
								System.out.println("회원정보수정이 완료되었습니다.");
								System.out.println("이전메뉴로 돌아갑니다.");
								run = false;
								break;

							default:
								System.out.println("1~5중 한 숫자를 입력하세요.");
								break;
							} // switch
						} // while
					} // if
				} // if
			} // if
		} // for
	} // modify

	private static void create(Scanner input, StudentDTO[] studentDTOs, SubjectsDTO[] subjectsDTOs) {
		SubjectsDTO subjectsDTO = new SubjectsDTO();
		System.out.println("성적등록할 학생의 학번을 입력하세요.");
		System.out.println("------------------");
		System.out.print(">> ");
		String answer = input.next();
		System.out.println("------------------");
		
		for(int i=0 ; i<studentDTOs.length ; i++) {
			if(studentDTOs[i] != null) {
				if(studentDTOs[i].getStudentID().equals(answer)) {
					System.out.println("성적등록을 시작합니다.");
					System.out.println("-----------------");
					System.out.print("국어 : ");
					subjectsDTO.setKor(input.nextInt());
					System.out.println("-----------------");
					System.out.print("수학 : ");
					subjectsDTO.setMat(input.nextInt());
					System.out.println("-----------------");
					System.out.print("영어 : ");
					subjectsDTO.setEng(input.nextInt());
					System.out.println("-----------------");
					System.out.print("과학 : ");
					subjectsDTO.setSci(input.nextInt());
					System.out.println("-----------------");
					subjectsDTOs[i] = subjectsDTO;
					System.out.println(studentDTOs[i].getName()+"님의 성적등록이 완료되었습니다.");
					break;
				} // if
			} // if
		} // for
	} // create
} // class
