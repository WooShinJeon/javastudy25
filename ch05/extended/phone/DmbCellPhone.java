package ch05.extended.phone;

public class DmbCellPhone extends CellPhone{ // 자식 라이브러리 클래스
	int channel; // 자식 필드 추가
	
	// 생성자 -> 매개값을 입력받아 초기값을 진행
	DmbCellPhone(String model, String color, int channel){
		this.model = model;       // 부모필드
		this.color = color;		 // 부모
		this.channel = channel; // 자식필드
	}
	
	// 메서드 -> 자식클래스에 추가된 기능
	void turnOnDmb() {System.out.println("채널 "+channel+"번 DBM방송 수신을 시작합니다.");
	} // DMB 방송시작
	void changeChannelDmb(int channel) {
		this.channel = channel; // 채널번호를 입력받아 채널 변경진행
		System.out.println("채널을 "+channel+"번으로 변경합니다.");
	} // DMB 채널 변경
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 중지합니다.");
	} // DMB 방송종료
	

}
