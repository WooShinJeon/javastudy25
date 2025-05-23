package ch03;

public class ArrayCreateExam {

	public static void main(String[] args) {
		
		int[] scores;
		scores = new int[] {83, 90, 87}; // new 연산자를 이용해서 객체 생성
		
		System.out.println("scores[0] : "+scores[0]);
		System.out.println("scores[1] : "+scores[1]);
		System.out.println("scores[2] : "+scores[2]);
		
		int sum = 0;
		for(int i=0 ; i<=2 ; i++) {
			sum = sum + scores[i];
			
		}
		System.out.println("총점 : "+sum);
		double avg = (double)sum/3;
		System.out.println("평균 : "+avg);
		
		
	}

}
