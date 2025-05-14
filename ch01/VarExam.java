package ch01;

public class VarExam {

	public static void main(String[] args) {
		int x = 1 ;
		char y = 65 ;
		char z = 'A' ;
		
		System.out.println("int x = " + x);
		System.out.println("char y = " + y);
		System.out.println("char z = " + z);
		
		
		int x1 ;
		x1 = 10 ;
		System.out.println(x1);
		
		
		double kor, mat, eng, his, total ,avg ;
		kor = 91.2 ;
		mat = 95.6 ;
		eng = 68.7 ;
		his = 75.4 ;
		total = kor + mat + eng + his ;
		avg = total / 4 ;
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		
		
		char firstname = '김' ;
		char firstName = '이' ;
		
		System.out.println("성 : " + firstname);
		System.out.println("성 : " + firstName);
		
		
		int literal1 = 75 ;
		int literal2 = 075 ;
		int literal3 = 0b0010 ;
		int literal4 = 0xA ;
		
		System.out.println("10진수 75 : " + literal1);
		System.out.println("8진수 75 : " + literal2);
		System.out.println("2진수 0010 : " + literal3);
		System.out.println("16진수 A : " + literal4);
		
		

	}

}
