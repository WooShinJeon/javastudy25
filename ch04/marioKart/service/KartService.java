package ch04.marioKart.service;

import java.util.Scanner;

import ch04.marioKart.dto.GliderDTO;
import ch04.marioKart.dto.KartDTO;
import ch04.marioKart.dto.MemberDTO;
import ch04.marioKart.dto.TireDTO;

public class KartService {
	
	public void menu(Scanner input, MemberDTO loginState, KartDTO[] kartDTOs, GliderDTO[] gliderDTOs, TireDTO[] tireDTOs) {
		System.out.println("이 메뉴는 게임 시작전 타야하는 카트, 타이어, 글라이더를 고르는 메뉴입니다.");
		System.out.println("각 카트, 타이어, 글라이더의 종류를 보여드리겠습니다.");
		boolean kartRun = true;
		while (kartRun) {
			System.out.println("1.카트 | 2.타이어 | 3.글라이더 | 4.선택메뉴로 넘어가기");
			System.out.print(">>> ");
			String select = input.next();
			switch (select) {
			case "1":
				System.out.println("현재 등록되어있는 카트의 종류입니다.");
				for (int i = 0; i < kartDTOs.length; i++) {
					if (kartDTOs[i] != null) {
						System.out.print("카트의 이름 : " + kartDTOs[i].name + " | 무게 : " + kartDTOs[i].weight + " | 속도 : "
								+ kartDTOs[i].speed + " | 가속 : " + kartDTOs[i].acceleration + " | 핸들링 : "
								+ kartDTOs[i].handling + " | 마찰력 : " + kartDTOs[i].friction);
					}
				}
				break;

			case "2":
				System.out.println("현재 등록되어있는 타이어의 종류입니다.");
				for (int i = 0; i < tireDTOs.length; i++) {
					if (tireDTOs[i] != null) {
						System.out.print("타이어의 이름 : " + tireDTOs[i].name + " | 무게 : " + tireDTOs[i].weight + " | 속도 : "
								+ tireDTOs[i].speed + " | 가속 : " + tireDTOs[i].acceleration + " | 핸들링 : "
								+ tireDTOs[i].handling + " | 마찰력 : " + tireDTOs[i].friction);
					} // if문 종료
				} // for문 종료
				break;

			case "3":
				System.out.println("현재 등록되어있는 글라이더의 종류입니다.");
				for (int i = 0; i < gliderDTOs.length; i++) {
					if (gliderDTOs[i] != null) {
						System.out.print("글라이더의 이름 : " + gliderDTOs[i].name + " | 무게 : " + gliderDTOs[i].weight
								+ " | 속도 : " + gliderDTOs[i].speed + " | 가속 : " + gliderDTOs[i].acceleration
								+ " | 핸들링 : " + gliderDTOs[i].handling + " | 마찰력 : " + gliderDTOs[i].friction);
					}
				}
				break;

			case "4":
				System.out.println("카트 선택메뉴로 넘어가겠습니다.");
				kartRun = false;
				break;

			default:
				System.out.println("1~4의 숫자중 하나를 입력해주세요.");
				break;
			} // switch문 종료
		}
		
		System.out.println("사용할 카트를 입력하세요.");
		System.out.print(">>> ");
		String selectKart = input.next();
		
		for(int i=0 ; i<kartDTOs.length ; i++) {
			if(kartDTOs[i] != null && kartDTOs[i].equals(selectKart)) {
				loginState.kartDTO = kartDTOs[i];
			} // if문 종료
		} // for문 종료
		
		System.out.println("카트에 장착할 타이어를 입력하세요.");
		System.out.print(">>> ");
		String selectTire = input.next();
		
		for(int i=0 ; i<tireDTOs.length ; i++) {
			if(tireDTOs[i] != null && tireDTOs[i].equals(selectTire)) {
				loginState.tireDTO = tireDTOs[i];
			} // if문 종료
		} // for문 종료
		
		System.out.println("카트에 장착할 글라이더를 입력하세요.");
		System.out.print(">>> ");
		String selectGlid = input.next();
		
		for(int i=0 ; i<gliderDTOs.length ; i++) {
			if(gliderDTOs[i] != null && gliderDTOs[i].equals(selectGlid)) {
				loginState.gliderDTO= gliderDTOs[i];
			} // if문 종료
		} // for문 종료
		
		System.out.println(loginState.nickName+"님이 선택한 카트는 "+loginState.kartDTO+"이고, "+loginState.tireDTO+"와 "+loginState.gliderDTO+"(을)를 장착했습니다.");
		System.out.println("메인메뉴로 돌아가겠습니다.");
		
		
	} // menu메서드 종료

} // class 종료
