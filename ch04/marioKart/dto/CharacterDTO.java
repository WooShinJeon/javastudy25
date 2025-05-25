package ch04.marioKart.dto;

public class CharacterDTO {
	// 필드
		public String name ; // 캐릭터명
		public double weight ; // 무게
		public double speed ; // 속도
		public double acceleration ; // 가속
		public double handling ; // 핸들링
		public double friction ; // 마찰력

	public CharacterDTO(String name, double weight, double speed, double acceleration, double handling, double friction) {
		this.name = name;
		this.weight = weight;
		this.speed = speed;
		this.acceleration = acceleration;
		this.handling = handling;
		this.friction = friction;
	}

}
