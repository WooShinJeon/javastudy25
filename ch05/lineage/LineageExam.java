package ch05.lineage;

import java.util.Scanner;

import ch05.lineage.dto.Account;
import ch05.lineage.dto.ElfDTO;
import ch05.lineage.dto.KnightDTO;
import ch05.lineage.service.CharacterService;
import ch05.lineage.service.LoginService;

public class LineageExam {
	public static Scanner input = new Scanner(System.in);
	public static Account[] accounts = new Account[10];
	public static Account loginAccount;
	public static KnightDTO knightDTO = new KnightDTO();
	public static ElfDTO elfDTO = new ElfDTO();
	
	static {
		knightDTO.setSword("양손검");
		knightDTO.setArmor("징박힌갑옷");
		knightDTO.setShield("징박힌방패");
		knightDTO.setName("양기사");
		knightDTO.setSex("남");
		knightDTO.setLevel("1");
		knightDTO.setHp(5000);
		knightDTO.setMp(50);
		knightDTO.setMoney(500000);
		
		elfDTO.setBow("양손활");
		elfDTO.setDress("천사드레스");
		elfDTO.setArrow("크리티컬화살");
		elfDTO.setName("저요정");
		elfDTO.setSex("여");
		elfDTO.setLevel("1");
		elfDTO.setHp(3000);
		elfDTO.setMp(2000);
		elfDTO.setMoney(1000000);
		
		Account account = new Account();
		account.setId("kkk");
		account.setPw("kkk");
		account.setNickName("kkk");
		accounts[0] = account;
	}

	public static void main(String[] args) {
		System.out.println("=======리니지 게임 시작메뉴입니다.=======");
		boolean run = true;
		while(run) {
			System.out.println("1.계정관리 | 2.캐릭터 선택 | 3.게임실행 | 4.종료");
			System.out.println("----------------------------------------");
			System.out.print("선택> ");
			int select = input.nextInt();
			System.out.println("------------------");
			switch(select) {
			case 1 :
				System.out.println("계정관리 메뉴로 진입합니다.");
				loginAccount = LoginService.menu(input, accounts, loginAccount);
				break;
			case 2 :
				if(loginAccount == null) {
					System.out.println("로그인을 해야 들어갈수있는 메뉴입니다.");
				}else{
					System.out.println("캐릭터를 선택합니다.");
					CharacterService.menu(input, loginAccount, knightDTO, elfDTO);
				}
				break;
			case 3 :
				System.out.println("게임을 실행합니다.");
				break;
			case 4 :
				System.out.println("게임을 종료합니다.");
				run = false;
				break;
			default :
				System.out.println("1~4의 숫자만 입력해주세요.");
			}
		}
		
		
		
		
		

	}

}
