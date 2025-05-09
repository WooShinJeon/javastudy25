package ch01;

public class LocalVariableExam {

	public static void main(String[] args) {
		
		
		int v1 = 5 ;
		int v2 = 0 ;
		if(v1>10) {
			v2 = v1 + 10 ;
		}
		if(v1<10) {
			v2 = v1 + 20 ;
		}
		
		int v3 = v1 + v2 + 5 ;
		
		System.out.println("v1의 값 : " + v1);
		System.out.println("v2의 값 : " + v2);
		System.out.println("v3의 값 : " + v3);
		
		
		

	}

}
