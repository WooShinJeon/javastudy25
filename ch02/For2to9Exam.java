package ch02;

public class For2to9Exam {

	public static void main(String[] args) {
		for(int m=2; m<=9; m++) {
			System.out.println("===== "+m+"단 ======");
			for(int n=1; n<=9; n++) {
				System.out.println(m+" X "+n+" = "+(m*n));
			}
		}

	}

}
