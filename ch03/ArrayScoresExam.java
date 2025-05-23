package ch03;

import java.util.Scanner;

public class ArrayScoresExam {

	public static void main(String[] args) {
		// 배열을 아용해서 성적표를 만들어 보자.
		// 학생 수를 파악한다.
		// 점수를 입력한다.
		// 총점과 평균을 구하여 출력한다.
		Scanner input = new Scanner(System.in);
		
		System.out.println("======성적표======");
		System.out.println("학생수를 입력하세요.");
		System.out.print(">>> ");
		int count = input.nextInt();
		
		int[] scores = new int[count]; // 키보드로 입력받은 값을 토대로 배열길이 생성
		
		System.out.println("배열의 길이 : "+scores.length);
		
		for(int i=0; i<scores.length; i++) {
			System.out.print((i+1)+"번째 학생의 점수를 입력하세요 : ");
			scores[i] = input.nextInt();
		} // 학생 수 만큼 배열에 점수를 입력한다.
		
		System.out.println("======입력된 점수 확인======");
		
		for(int i=0 ; i<scores.length; i++) {
			System.out.println((i+1)+"번째 학생의 점수 : "+scores[i]);
		}
		System.out.println();
		System.out.println("======수정할 번호 입력======");
		System.out.print(">>> ");
		int select = input.nextInt();
		System.out.println("======수정할 점수 입력======");
		System.out.print(">>> ");
		int score = input.nextInt();
		
		scores[select-1] = score;
		System.out.println("수정한 결과 확인");
		System.out.println(select+"번의 점수는 : "+score+"점으로 수정완료!!");
		
		int sum = total(scores);
		System.out.println("총점 : "+sum+"점입니다.");
		
		double avg = average(sum, count);
		System.out.println("평균 : "+avg+"점입니다.");

	}

	static double average(int sum, int count) {
		double avg = 0;
		avg = (double)sum/count;
		return avg;
	}

	static int total(int[] scores) {
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		return sum;
	}

}
