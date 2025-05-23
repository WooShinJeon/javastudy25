package ch04;

import java.util.Scanner;

public class CarExam {

	public static void main(String[] args) {
		// 자동차 주 실행 프로그램		
		Scanner input = new Scanner(System.in);
		boolean run = true;
		System.out.println("===차량정보 입력===");
		
		Car myCar = new Car(); // 기본생성자로 객체 생성
		// 생성시 속도와 rpm과 오일량은 기본값으로 생성
		System.out.print("제조회사 : ");
		myCar.company = input.next();
		
		System.out.print("모델 : ");
		myCar.model = input.next();
		
		System.out.print("색상 : ");
		myCar.color = input.next();
		
		System.out.print("최고속도 : ");
		myCar.maxSpeed = input.nextInt();
		
		System.out.print("사용하는 기름종류 : ");
		myCar.oilType = input.next();
		
		
		while(run) {
			System.out.println("1. 차량 정보확인");
			System.out.println("2. 차량 시동걸기");
			System.out.println("3. 차량 주행시작");
			System.out.println("4. 남은 연료보기");
			System.out.println("5. 차량 주행종료");
			System.out.print(">>> ");
			String select = input.next();
			switch(select) {
			case "1" :
				System.out.println("제조회사명 : "+myCar.company);
				System.out.println("모델명 : "+myCar.model);
				System.out.println("색상 : "+myCar.color);
				System.out.println("최고속도 : "+myCar.maxSpeed);
				System.out.println("기름종류 : "+myCar.oilType);
				System.out.println();
				break;
				
			case "2" :
				myCar.start();
				System.out.println();
				break;
				
			case "3" :
				myCar.carRun();
				break;
				
			case "4" :				
				if(myCar.oil > 0 && myCar.oil<= 20) {
					System.out.println("차량 내의 기름이 "+myCar.oil+"L 남았습니다.\n기름을 전부 사용하기 전에 주유소에 들러 기름을 넣어주세요!!");
				}else if(myCar.oil <= 0) {
					System.out.println("차량 내의 기름이 전부 떨어졌습니다. 시동을 끄고 주행을 종료하겠습니다.");
				}else if(myCar.oil > 20) {
					System.out.println("차량 내의 기름이 "+myCar.oil+"L 남았습니다.");
				}
				break;
				
			case "5" :
				myCar.carStop();
				break;
				
			default :
				System.out.println("1~5까지의 숫자중에서 다시 입력해주세요.");
				System.out.println();
				break;
			
			
			
			} // switch문 종료
			
			
		} // while문 종료
		

	} // main메서드 종료

} // class 종료
