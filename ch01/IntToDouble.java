package ch01;

public class IntToDouble {

	public static void main(String[] args) {
		int num1 = 123456780;
		int num2 = 123456780;
		
		double num3 = num2; // float 쓰면 num2 = 123456784
							//           num3 = 1.23456784E8
		num2 = (int)num3;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		int result = num1 - num2;
		System.out.println(result);

	}

}
