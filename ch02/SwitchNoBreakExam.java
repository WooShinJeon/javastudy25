package ch02;

public class SwitchNoBreakExam {

	public static void main(String[] args) {
		int time = (int)(Math.random()*12)+7;
		System.out.println("현재시간 : " + time + "시");
		switch(time) {
		case 7 : 
			System.out.println("등원준비를 한다.");
		case 8 :
			System.out.println("등원을 한다.");
		case 9 :
			System.out.println("1교시 수업");
		case 10 :
			System.out.println("2교시 수업");
		case 11 :
			System.out.println("3교시 수업");
		case 12:
			System.out.println("4교시 수업");
		case 13 :
			System.out.println("점심시간");
		case 14 :
			System.out.println("5교시 수업");
		case 15 :
			System.out.println("6교시 수업");
		case 16 :
			System.out.println("7교시 수업");
		case 17 :
			System.out.println("8교시 수업");
		case 18 :
			System.out.println("하원을 한다.");
		}

	}

}
