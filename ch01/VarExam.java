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
		
		System.out.println("���� : " + total);
		System.out.println("��� : " + avg);
		
		
		char firstname = '��' ;
		char firstName = '��' ;
		
		System.out.println("�� : " + firstname);
		System.out.println("�� : " + firstName);
		
		
		int literal1 = 75 ;
		int literal2 = 075 ;
		int literal3 = 0b0010 ;
		int literal4 = 0xA ;
		
		System.out.println("10���� 75 : " + literal1);
		System.out.println("8���� 75 : " + literal2);
		System.out.println("2���� 0010 : " + literal3);
		System.out.println("16���� A : " + literal4);
		
		

	}

}
