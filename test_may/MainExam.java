package test_may;

import java.util.Scanner;

import test_may.dto.StudentDTO;
import test_may.dto.SubjectsDTO;
import test_may.service.AdminService;
import test_may.service.StudentService;
import test_may.service.SubjectService;

public class MainExam {
	public static Scanner input = new Scanner(System.in);
	public static StudentDTO[] studentDTOs = new StudentDTO[30]; // 학생 최대 30명
	public static SubjectsDTO[] subjectsDTOs = new SubjectsDTO[30]; // 학생수 따라 성적도 30명분

	public static void main(String[] args) {
		System.out.println("======성적처리 프로그램입니다.======");
		boolean run = true;
		while (run) {
			System.out.println("1.학생관리 | 2.성적관리 | 3.통계 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print(">> ");
			int select = input.nextInt();
			System.out.println("---------------------");
			switch (select) {
			case 1:
				System.out.println("학생관리메뉴에 진입합니다.");
				StudentService.menu(input, studentDTOs);
				break;

			case 2:
				System.out.println("성적관리메뉴에 진입합니다.");
				SubjectService.menu(input, studentDTOs, subjectsDTOs);
				break;

			case 3:
				System.out.println("통계메뉴에 진입합니다.");
				AdminService.menu(input, studentDTOs, subjectsDTOs);
				break;

			case 4:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;

			default:
				System.out.println("1~4중 한 숫자를 입력해주세요.");
				break;
			} // switch
		} // while
	} // main
} // class
