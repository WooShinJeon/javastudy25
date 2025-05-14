package ch02;

public class ContinueExam {

	public static void main(String[] args) {
		for(int i=1 ; i<=10 ; i++) {
			if(i%2 !=0) { // 짝수가 아님
				continue;
			}
			System.out.println(i);
		}

	}

}
