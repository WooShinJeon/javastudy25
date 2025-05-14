package ch02;

import java.util.Scanner;

public class DoWhileTest01 {

	public static void main(String[] args) {
		int input = 0, answer = 0;
		answer = (int)(Math.random()*31)+1; // 1~31까지의 랜덤정수를 넣는다.
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("1과 31사이의 정수를 입력하세요 : ");
			input = sc.nextInt();
			
			if(input > answer) {
				System.out.println("down");
			} else if(input<answer) {
				System.out.println("up");
			}
				
		} while(input!=answer);
		System.out.println("정답입니다! "+answer);

	} // main 메서드 종료

} // class 종료
