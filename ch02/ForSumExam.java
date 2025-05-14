package ch02;

public class ForSumExam {

	public static void main(String[] args) {
		// 1부터 100까지의 합을 구해본다. 1+2+...+100=sum / 5050
		int sum1=0; // 누적합계를 구하는 변수 선언
		
		for(int i=1; i<=100; i++) { // 1~100까지 증가값
			sum1=sum1+i;
		}
		
		System.out.println("1~100까지의 합 : "+sum1);
		
		int sum2=0;
		int j=1;
		for( ; j<=500; j++) {
			sum2=sum2+j;
		}
		
		System.out.println();
		System.out.println("1~"+(j-1)+"까지의 합 : "+sum2);
	}

}
