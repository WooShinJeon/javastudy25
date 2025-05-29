package ch05.extended.phone;

public class CellPhone { // 부모클래스
	String model;
	String color; // 부모필드
	
	// 생성자 (디폴트로 활용)
	void powerOn() {System.out.println("전원을 켭니다.");}
	void powerOff() {System.out.println("전원을 끕니다.");}
	void bell() {System.out.println("벨이 울립니다.");}
	void sendVoice(String message) {System.out.println("본인 : "+message);}
	void recieveVoice(String message) {System.out.println("상대방 : "+message);}
	void hangUp() {System.out.println("전화를 끊습니다.");}
	
}
