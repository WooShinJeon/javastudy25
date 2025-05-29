package ch05.promotion;

public class HankookTire extends Tire{
	// 필드 부모활용
	
	// 생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// 오버라이딩 메소드
	@Override
	public boolean roll() {
		++accRotation;
		if(accRotation < maxRotation) {
			System.out.println(location+" 한국타이어 수명 : "+(maxRotation - accRotation)+"마일리지");
			return true;
		}else {
			System.out.println("****경고 : "+location+" 한국타이어 펑크****");
			return false;
		}
	}
	

}
