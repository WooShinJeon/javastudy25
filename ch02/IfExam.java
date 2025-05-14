package ch02;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("귀하의 성함을 입력해주세요 : ");
		String name = input.next();
		System.out.print("국어 점수를 입력해주세요 : ");
		int kor = input.nextInt();
		if (kor>=0 && kor<=100) {
			System.out.print("수학 점수를 입력해주세요 : ");
			int mat = input.nextInt();
			if (mat>=0 && mat<=100) {
				System.out.print("영어 점수를 입력해주세요 : ");
				int eng = input.nextInt();
				if (eng>=0 && eng<=100) {
					int total = kor + mat + eng;
					double avg = (double)total / 3;
					System.out.println("총점 및 평균 점수를 보고싶으면 yes 를, 아니면 no 를 입력해주세요.");
					System.out.print(">>> ");
					String ans1 = input.next();
					if (ans1.equalsIgnoreCase("yes")) {
						System.out.println(name + "님의 3과목 점수의 총점은 " + total + "입니다.");
						System.out.println(name + "님의 평균 점수는 " + avg + "입니다.");
					} else if (ans1.equalsIgnoreCase("no")) {
						System.out.println("넘어가겠습니다.");
					} else {
						System.out.println("yes 혹은 no 를 정확하게 입력해주세요.");
					}
					System.out.println("각 과목의 등급을 보고싶으면 yes 를, 아니면 no 를 입력해주세요.");
					System.out.print(">>> ");
					String ans2 = input.next();
					if (ans2.equalsIgnoreCase("yes")) {
						if (kor >= 95) {
							System.out.println(name + "님의 국어 점수는 " + kor + "점이고, 등급은 A+입니다.");
						} else if (kor >= 90) {
							System.out.println(name + "님의 국어 점수는 " + kor + "점이고, 등급은 A입니다.");
						} else if (kor >= 80) {
							System.out.println(name + "님의 국어 점수는 " + kor + "점이고, 등급은 B입니다.");
						} else if (kor >= 70) {
							System.out.println(name + "님의 국어 점수는 " + kor + "점이고, 등급은 C입니다.");
						} else if (kor >= 60) {
							System.out.println(name + "님의 국어 점수는 " + kor + "점이고, 등급은 D입니다.");
						} else {
							System.out.println(name + "님의 국어 점수는 " + kor + "점이고, 등급은 F입니다.");
						}
						
						if (mat >= 95) {
							System.out.println(name + "님의 수학 점수는 " + mat + "점이고, 등급은 A+입니다.");
						} else if (mat >= 90) {
							System.out.println(name + "님의 수학 점수는 " + mat + "점이고, 등급은 A입니다.");
						} else if (mat >= 80) {
							System.out.println(name + "님의 수학 점수는 " + mat + "점이고, 등급은 B입니다.");
						} else if (mat >= 70) {
							System.out.println(name + "님의 수학 점수는 " + mat + "점이고, 등급은 C입니다.");
						} else if (mat >= 60) {
							System.out.println(name + "님의 수학 점수는 " + mat + "점이고, 등급은 D입니다.");
						} else {
							System.out.println(name + "님의 수학 점수는 " + mat + "점이고, 등급은 F입니다.");
						}
						
						if (eng >= 95) {
							System.out.println(name + "님의 영어 점수는 " + eng + "점이고, 등급은 A+입니다.");
						} else if (eng >= 90) {
							System.out.println(name + "님의 영어 점수는 " + eng + "점이고, 등급은 A입니다.");
						} else if (eng >= 80) {
							System.out.println(name + "님의 영어 점수는 " + eng + "점이고, 등급은 B입니다.");
						} else if (eng >= 70) {
							System.out.println(name + "님의 영어 점수는 " + eng + "점이고, 등급은 C입니다.");
						} else if (eng >= 60) {
							System.out.println(name + "님의 영어 점수는 " + eng + "점이고, 등급은 D입니다.");
						} else {
							System.out.println(name + "님의 영어 점수는 " + eng + "점이고, 등급은 F입니다.");
						}
					} else if (ans2.equalsIgnoreCase("no")) {
						System.out.println("넘어가겠습니다.");
					} else {
						System.out.println("yes 혹은 no 를 정확하게 입력해주세요.");
					}
					
					System.out.println(name + "님의 성적확인이 완료되었습니다.");
				} else {
					System.out.println(name + "님, 영어점수를 다시 확인해주세요."); // eng
				}
			} else {
				System.out.println(name + "님, 수학점수를 다시 확인해주세요."); // mat
			}
		} else {
			System.out.println(name + "님, 국어점수를 다시 확인해주세요.");
		}
		
		
	}

}
