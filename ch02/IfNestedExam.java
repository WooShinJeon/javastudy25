package ch02;

public class IfNestedExam {

	public static void main(String[] args) {
		int score = (int)(Math.random()*100)+1;
		
		System.out.println("현재 점수는 : "+score);
		String gra ;
		
		if(score>=95) {
			gra = "A+";
		}else if(score>=90) {
			gra = "A";
		}else if(score>=80) {
			gra = "B";
		}else if(score>=70) {
			gra = "C";
		}else {
			gra = "F";
		}
		System.out.println("현재 학점은 : "+gra);

	}

}
