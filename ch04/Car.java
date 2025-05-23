package ch04;

import java.util.Scanner;

public class Car {
	// 필드 (객체가 가지고 있어야 하는 값) -> 글로벌변수(GlobalVariable)
	// 고유 데이터
	public String company; // 제작회사(현대, 기아, ...)
	public String model; // 아반떼, 그랜져, ...
	public String color; // 빨간색, 검정색, ...
	public int maxSpeed; // 최고속도
	public String oilType; // 경유, 휘발유, ...
	
	// 상태값(변동가능)
	public int speed;
	public int rpm;
	public int oil;
	
	// 부품 -> 다른 클래스를 생성하여 연결한다.
//	public Body body;
//	public Engine engine;
//	public Tire tire;
	
	// 부품에 필드 사용법
	// Car myCar = new Car(); -> 객체 생성(인스턴스)
	// myCar.maxSpeed = 300; -> 객체에 있는 maxSpeed에 300 정수를 넣는다.
	// -----------------------(필드)--------------------------------
	
	
	// 기본생성자 : 생략가능 (객체가 생성할 때 사용되는 메서드 : 클래스명과 같은 이름)	
	public Car() {
		speed = 0;
		rpm = 50;
		oil = 100;
	} // 객체가 생성되면서 변수에 값이 저장됨.
	
	// 사용자지정 생성자 -> 개발자가 응용하는 기법
	// 사용자지정 생성자가 만들어지면 기본생성자는 자동으로 생성되지 않는다.
	public Car(String company, String model, String color) {
		this.company = company;
		this.model = model;
		this.color = color;
	} // Car MyCar = new Car("벤츠", "e클래스", "빨간색");
	
	
	
	// 매서드 (객체가 수행해야 하는 동작)
	// c(시동시작) r(차량상태, 주행상태) u(가속, 감속, 주차) d(시동종료)
	public void start() {
		System.out.println(this.model+"의 시동이 걸렸습니다.");
		System.out.println("현재속도 : "+this.speed+"km/h");
		System.out.println("현재rpm : "+this.rpm);
		System.out.println("현재 주유량 : "+this.oil+"L");
	}
	
	public void carRun() {
		Scanner input = new Scanner(System.in);
		boolean run = true;
		System.out.println(this.model+"의 주행이 시작됩니다.");
		System.out.println("현재 속도는 "+this.speed+"km/h 입니다.");
		System.out.println("실행하고 싶은 기능을 선택해주세요.");
		
		
		while (run) {
			System.out.println("1. 엑셀밟기(가속)");
			System.out.println("2. 속도유지");
			System.out.println("3. 주행정지준비");
			System.out.print(">>> ");
			int select = input.nextInt();
			switch (select) {
			case 1 :
				if (this.speed >= 0 && this.speed <= this.maxSpeed - 20) {
					System.out.println("엑셀을 밟아서 속도가 20km/h 증가했습니다.");
					this.speed += 20;
					this.oil -= 5;
					System.out.println("현재 " + this.model + "의 속도는 " + this.speed + "km/h 입니다.");
					System.out.println();
					if(this.oil > 0 && this.oil<= 20) {
						System.out.println("차량 내의 기름이 "+this.oil+"L 남았습니다.\n기름을 전부 사용하기 전에 주유소에 들러 기름을 넣어주세요!!");
					}else if(this.oil <= 0) {
						System.out.println("차량 내의 기름이 전부 떨어졌습니다. 시동을 끄고 주행을 종료하겠습니다.");
						run = false;
					}
				} else if (this.speed == this.maxSpeed) {
					System.out.println("현재 " + this.model + "의 최고속도 " + this.maxSpeed + "km/h 에 도달했습니다. 더이상 가속할 수 없습니다.");
					if(this.oil > 0 && this.oil<= 20) {
						System.out.println("차량 내의 기름이 "+this.oil+"L 남았습니다.\n기름을 전부 사용하기 전에 주유소에 들러 기름을 넣어주세요!!");
					}else if(this.oil <= 0) {
						System.out.println("차량 내의 기름이 전부 떨어졌습니다. 시동을 끄고 주행을 종료하겠습니다.");
						run = false;
					}
				}
				break;

			case 2 :
				System.out.println("현재속도를 " + this.speed + "km/h 로 유지하겠습니다.");
				this.oil -= 2;
				if(this.oil > 0 && this.oil<= 20) {
					System.out.println("차량 내의 기름이 "+this.oil+"L 남았습니다.\n기름을 전부 사용하기 전에 주유소에 들러 기름을 넣어주세요!!");
				}else if(this.oil <= 0) {
					System.out.println("차량 내의 기름이 전부 떨어졌습니다. 시동을 끄고 주행을 종료하겠습니다.");
					run = false;
				}
				break;

			case 3 :
				System.out.println("주행을 정지할 준비를 하겠습니다.");
				run = false;
				break;
			} // switch문 종료
		} // while문 종료		
	}
	
	
	public void carStop() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
