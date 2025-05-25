package ch04.marioKart.service;

import java.util.Scanner;

import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.MemberDTO;

public class CharacterService {

	public void menu(Scanner input, MemberDTO loginState, CharacterDTO[] characterDTOs) {
		System.out.println("현재 등록되어있는 캐릭터의 목록입니다.");
		for(int i=0 ; i<characterDTOs.length ; i++) {
			if(characterDTOs[i] != null) {
				System.out.print("캐릭터의 이름 : "+characterDTOs[i].name+" | 무게 : "+characterDTOs[i].weight+" | 속도 : "+characterDTOs[i].speed+" | 가속 : "
						+characterDTOs[i].acceleration+" | 핸들링 : "+characterDTOs[i].handling+" | 마찰력 : "+characterDTOs[i].friction);
			} // if문 종료
		} // for문 종료
		
		System.out.println("원하는 캐릭터를 선택하세요.");
		System.out.print(">>> ");
		String selectChar = input.next();
		
		for(int i=0 ; i<characterDTOs.length ; i++) {
			if(characterDTOs[i] != null && characterDTOs[i].equals(selectChar)) {
				loginState.characterDTO = characterDTOs[i];
				// 키보드로 입력한 캐락터를 로그인한 객체에 연결
			} // if문 종료
		} // for문 종료
		System.out.println(loginState.nickName+"님이 선택한 캐릭터는 "+loginState.characterDTO.name+"입니다.");
		System.out.println("메인메뉴로 돌아가겠습니다.");
		
	}

}
