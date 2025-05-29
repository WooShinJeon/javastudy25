package ch05.promotion;

public class Tire { // 부모클래스
	// 필드
	public int maxRotation;
	public int accRotation;
	public String location;
	
	// 생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// 메소드
	public boolean roll() {
		++accRotation;
		if(accRotation < maxRotation) {
			System.out.println(location+" 타이어 수명 : "+(maxRotation-accRotation)+"마일리지");
			return true;
		}else {
			System.out.println("****경고 : "+location+" 타이어 펑크****");
			return false;
		}
	}

}
