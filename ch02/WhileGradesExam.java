package ch02;

import java.util.Scanner;

public class WhileGradesExam {

	public static void main(String[] args) {
		
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		boolean runKor = true;
		boolean runMat = true;
		boolean runEng = true;
		boolean run1 = true;
		int kor, mat, eng;
		
		System.out.println("성적처리 시스템에 오신것을 환영합니다.");
		System.out.print("성함을 입력하세요 : ");
		String name = inputStr.nextLine();
		System.out.println(name+"님, 성적을 입력해주세요.");
		while(runKor) {
			System.out.print("국어 점수 : ");
			kor = inputInt.nextInt();
			if(kor<0 || kor>100) {
				System.out.println("다시 입력해주세요.");
			} else if(kor>=0 && kor<=100) {
				runKor = false;
				
				while(runMat) {
					System.out.print("수학 점수 : ");
					mat = inputInt.nextInt();
					if(mat<0 || mat>100) {
						System.out.println("다시 입력해주세요.");
					} else if(mat>=0 && mat<=100) {
						runMat = false;
						
						while(runEng) {
							System.out.print("영어 점수 : ");
							eng = inputInt.nextInt();
							if(eng<0 || eng>100) {
								System.out.println("다시 입력해주세요.");
							} else if(eng>=0 && eng<=100) {
								runEng = false;
								
								int total = kor+mat+eng;
								double avg = (double)total/3;
								
								System.out.println("성적 입력이 완료되었습니다.");
								System.out.println("총점 및 평균점수를 보시겠습니까?");
								
								while (run1) {
									System.out.print("(y/n)>>> ");
									String ans1 = inputStr.nextLine();
									if (ans1.equalsIgnoreCase("y")) {
										System.out.println("총점 : " + total);
										System.out.println("평균 : " + avg);
										System.out.println(" ");
										System.out.println("각 과목의 등급을 보여드리겠습니다.");
										System.out.println("국어 : "+kor+"점 -> "+getGrade(kor)+"등급");
										System.out.println("수학 : "+mat+"점 -> "+getGrade(mat)+"등급");
										System.out.println("영어 : "+eng+"점 -> "+getGrade(eng)+"등급");
										System.out.println("  ");
										System.out.println("평균점수로 계산된 학점을 보여드리겠습니다.");
										System.out.println("평균점수 : "+avg);
										System.out.println("학점 : "+getGPA(avg));
										System.out.println("전체과목의 평균점수에 따라 A+ ~ F 로 학점이 나뉨을 알려드립니다.");
										run1 = false;
									} else if (ans1.equalsIgnoreCase("n")) {
										System.out.println("감사합니다. 안녕히가세요.");
										run1 = false;
									} else {
										System.out.println("y,n를 정확히 입력해주세요.");
									}
								} // while(run1)
							}
						} // while(runEng)
					}
				} // while(runMat)
			}
		} // while(runKor)
	} // main 메서드 종료
	static String getGrade(int score) {
		if(score>=95) return "A+";
		else if(score>=90) return "A";
		else if(score>=80) return "B";
		else if(score>=70) return "C";
		else if(score>=60) return "D";
		else return "F";
	} // getGrade 메서드 종료
	static String getGPA(double avg) {
		if(avg>=95) return "A+";
		else if(avg>=90) return "A";
		else if(avg>=80) return "B";
		else if(avg>=70) return "C";
		else if(avg>=60) return "D";
		else return "F";
	} // getGPA 메서드 종료
} // class 종료
