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
										run1 = false;
									} else if (ans1.equalsIgnoreCase("n")) {
										System.out.println("감사합니다. 안녕히가세요.");
										run1 = false;
									} else {
										System.out.println("y,n를 정확히 입력해주세요.");
									} 
								}
							}
							
						} // runEng
					}
					
				} // runMat
			}
			
		} // runKor
		
		
		
		
		
		
		
		
	}

}
