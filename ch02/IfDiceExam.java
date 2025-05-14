package ch02;

public class IfDiceExam {

	public static void main(String[] args) {
		int num = (int)(Math.random()*6)+1;
		System.out.println("주사위의 값 : "+num);
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		}else if(num==2) {
			System.out.println("2번이 나왔습니다.");
		}else if(num==3) {
			System.out.println("3번이 나왔습니다.");
		}else if(num==4) {
			System.out.println("4번이 나왔습니다.");
		}else if(num==5) {
			System.out.println("5번이 나왔습니다.");
		}else if(num==6) {
			System.out.println("6번이 나왔습니다.");
		}else {
			System.out.println("시스템 오류로 프로그램 점검이 필요합니다.");
		}
		
		int num1 = (int)(Math.random()*45)+1;
		int num2 = (int)(Math.random()*45)+1;
		int num3 = (int)(Math.random()*45)+1;
		int num4 = (int)(Math.random()*45)+1;
		int num5 = (int)(Math.random()*45)+1;
		int num6 = (int)(Math.random()*45)+1;
		System.out.println("  ");
		System.out.println("이번주 로또 당첨 번호는~~~");
		System.out.println(num1+" "+num2+" "+num3+" "+num4+" "+num5+" "+num6);

	}

}
