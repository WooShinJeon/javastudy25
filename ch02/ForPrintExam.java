package ch02;

public class ForPrintExam {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			System.out.println("1~10까지 출력 : "+i);
		}
		
		System.out.println();
		
		for(int j=2; j<=10; j=j+2) {
			System.out.println("1~10까지 짝수만 출력 : "+j);
		}
		
		for(int k=0, l=100; k<=10 && l>=90; k++, l--) {
			System.out.println("k값의 증가 : "+k+" // l값의 감소 : "+l);
		}

	}

}
