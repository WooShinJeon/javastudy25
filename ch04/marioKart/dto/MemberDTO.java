package ch04.marioKart.dto;

public class MemberDTO {
	// 필드
		public String id ;        // 아이디(로그인용)
		public String pw ;        // 암호(로그인용)
		public String nickName ;  // 별명(게임용)
		public String email ;     // 암호찾기용
		
		public CharacterDTO characterDTO ; // 계정별 캐릭터 객체
		public KartDTO kartDTO;
		public TireDTO tireDTO;
		public GliderDTO gliderDTO;
		
		// 생성자
		
		// 메서드

}
