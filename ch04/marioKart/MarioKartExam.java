package ch04.marioKart;

import java.util.Scanner;

import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.GliderDTO;
import ch04.marioKart.dto.ItemDTO;
import ch04.marioKart.dto.KartDTO;
import ch04.marioKart.dto.MemberDTO;
import ch04.marioKart.dto.TireDTO;
import ch04.marioKart.service.CharacterService;
import ch04.marioKart.service.KartService;
import ch04.marioKart.service.MemberService;

public class MarioKartExam {
	// 필드 -> main()메서드가 있는 필드는 static용으로 만듬
	public static Scanner input = new Scanner(System.in);
	
	public static MemberDTO[] memberDTOs = new MemberDTO[10];
	// 회원 10명
	public static CharacterDTO[] characterDTOs = new CharacterDTO[10];
	// 캐릭터 10마리
	public static KartDTO[] kartDTOs = new KartDTO[4];
	// 카트 4종류
	public static GliderDTO[] gliderDTOs = new GliderDTO[3];
	// 글라이더 3종류
	public static TireDTO[] tireDTOs = new TireDTO[3];
	// 타이어 3종류
	public static ItemDTO[] itemDTOs = new ItemDTO[7];
	// 아이템 7종류
	
	public static MemberDTO loginState; // 세션과 같은 기능
	// 로그인 성공시 객체를 가지고 있는 용도
	
	// 생성자 -> new MarioKartExam()으로 객체를 생성하지 않는다.
	// static{  } 스태틱블럭을 사용한다. 초기화용
	static {
		CharacterDTO characterDTO0 = new CharacterDTO("마리오", 3.5, 4.5, 3.5, 3.5, 3.5); //
		CharacterDTO characterDTO1 = new CharacterDTO("루이지", 3.5, 4.25, 3.5, 3.75, 3.25); //
		CharacterDTO characterDTO2 = new CharacterDTO("피치", 3.0, 3.75, 3.75, 3.75, 3.75); //
		CharacterDTO characterDTO3 = new CharacterDTO("요시", 3.0, 3.75, 3.75, 3.75, 3.75); //
		CharacterDTO characterDTO4 = new CharacterDTO("키노피오", 2.75, 3.5, 4.0, 4.25, 4.0); //
		CharacterDTO characterDTO5 = new CharacterDTO("엉금엉금", 2.5, 3.25, 4.0, 4.5, 4.25); //
		CharacterDTO characterDTO6 = new CharacterDTO("와리오", 4.25, 5.25, 3.0, 2.5, 3.25); //
		CharacterDTO characterDTO7 = new CharacterDTO("동키콩", 4.0, 4.7, 3.25, 3.0, 3.0); //
		CharacterDTO characterDTO8 = new CharacterDTO("와루이지", 4.0, 4.7, 3.25, 3.0, 3.0); //
		CharacterDTO characterDTO9 = new CharacterDTO("쿠파", 4.5, 5.0, 3.0, 2.5, 3.0); //
		// 객체 생성완료
		
		// 객체를 배열에 넣어서 관리
		characterDTOs[0] = characterDTO0;
		characterDTOs[1] = characterDTO1;
		characterDTOs[2] = characterDTO2;
		characterDTOs[3] = characterDTO3;
		characterDTOs[4] = characterDTO4;
		characterDTOs[5] = characterDTO5;
		characterDTOs[6] = characterDTO6;
		characterDTOs[7] = characterDTO7;
		characterDTOs[8] = characterDTO8;
		characterDTOs[9] = characterDTO9;
	} // static 블럭 종료(main메서드 실행시 초기화값)
	
	static {
		KartDTO kartDTO0 = new KartDTO("스탠다드", 0.0, 0.0, 0.0, 0.0, 0.0);
		KartDTO kartDTO1 = new KartDTO("스켈레톤", -0.25, -0.25, 0.5, 0.25, 0.25);
		KartDTO kartDTO2 = new KartDTO("배드왜건", 0.5, -0.25, 1.0, -0.5, 0.5);
		KartDTO kartDTO3 = new KartDTO("쿠파피에로", 0.25, -0.25, 0.25, 0.25, 1.0);
		
		kartDTOs[0] = kartDTO0;
		kartDTOs[1] = kartDTO1;
		kartDTOs[2] = kartDTO2;
		kartDTOs[3] = kartDTO3;
	}
	
	static {
		TireDTO tireDTO0 = new TireDTO("노멀타이어", 0.0, 0.0, 0.0, 0.0, 0.0);
		TireDTO tireDTO1 = new TireDTO("롤러타이어", -0.5, -0.25, 0.5, 0.25, -0.25);
		TireDTO tireDTO2 = new TireDTO("와일드타이어", 0.5, -0.5, -0.5, -0.75, 0.5);
		
		tireDTOs[0] = tireDTO0;
		tireDTOs[1] = tireDTO1;
		tireDTOs[2] = tireDTO2;
	}
	
	static {
		GliderDTO gliderDTO = new GliderDTO("슈퍼글라이더", 0.0, 0.0, 0.0, 0.0, 0.0);
		GliderDTO gliderDT1 = new GliderDTO("뭉게뭉게글라이더", -0.25, 0.0, 0.25, 0.25, 0.0);
		GliderDTO gliderDT2 = new GliderDTO("피치파라솔", 0.0, -0.25, 0.25, 0.25, -0.25);

		gliderDTOs[0] = gliderDTO;
		gliderDTOs[1] = gliderDT1;
		gliderDTOs[2] = gliderDT2;
	}

	public static void main(String[] args) {
		System.out.println("==========마리오 카트 게임을 시작합니다.==========");
		boolean run = true;
		while(run) {
			System.out.println("1. 회원관리 | 2. 캐릭터관리 | 3.카트관리 | 4. 게임실행 | 5.종료");
			System.out.print(">>> ");
			int select = input.nextInt();
			
			switch(select) {
			case 1 :
				System.out.println("회원관리 메뉴로 진입합니다.");
				MemberService memberService = new MemberService();
				loginState = memberService.menu(input, memberDTOs, loginState);
				if(loginState != null) {
					System.out.println("현재 로그인한 회원은 : "+loginState.nickName+"님 입니다.");
				}else if(loginState == null) {
					System.out.println("현재 로그인 되어있지 않습니다.");
				}
				break;
				
			case 2 :
				if(loginState == null) {
					System.out.println("로그인을 한 후에 진입할 수 있는 메뉴입니다!!");
					System.out.println("먼저 로그인을 해주세요.");
				}else {
					System.out.println("캐릭터관리 메뉴로 진입합니다.");
					CharacterService characterService = new CharacterService();
					characterService.menu(input, loginState, characterDTOs);
				}
				break;
				
			case 3 :
				if(loginState == null) {
					System.out.println("로그인을 한 후에 진입할 수 있는 메뉴입니다!!");
					System.out.println("먼저 로그인을 해주세요.");
				}else {
					System.out.println("카트관리 메뉴로 진입합니다.");
					KartService kartService = new KartService();
					kartService.menu(input, loginState, kartDTOs, gliderDTOs, tireDTOs);
				}
				break;
				
			case 4 :
				if(loginState == null) {
					System.out.println("로그인을 한 후에 진입할 수 있는 메뉴입니다!!");
					System.out.println("먼저 로그인을 해주세요.");
				}else {
					System.out.println("게임을 실행합니다.");
					
				}
				
				break;
				
			case 5 :
				System.out.println("게임을 종료합니다.");
				run = false;
				break;
			}
		} // while(run)문 종료
		

	} // main메서드 종료

} // class 종료
