package ch05.lineage.service;

import java.util.Scanner;

import ch05.lineage.dto.Account;

public class LoginService {

	public static Account menu(Scanner input, Account[] accounts, Account loginAccount) {
		boolean loginRun = true;
		while(loginRun) {
			System.out.println("----------------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3. 회원수정 | 4.이전으로 돌아가기");
			System.out.print("선택> ");
			int select = input.nextInt();
			System.out.println("---------------");
			switch(select) {
			case 1 :
				signIn(input, accounts, loginAccount);
				break;
			case 2 :
				create(input, accounts);
				break;
			case 3 :
				modify(input, accounts);
				break;
			case 4 :
				System.out.println("이전메뉴로 돌아갑니다.");
				System.out.println("----------------------------------------");
				loginRun = false;
				break;
			default :
				System.out.println("1~4의 숫자만 입력해주세요.");
			}
		
		
		
		}
		return loginAccount;
	}

	private static void modify(Scanner input, Account[] accounts) {
		Account account = new Account();
		System.out.println("회원수정 메뉴입니다.");
		System.out.print("id : ");
		String id = input.next();
		System.out.println("---------------");
		
		for(int i=0 ; i<accounts.length ; i++) {
			if(accounts[i] != null) {
				if(accounts[i].getId().equals(id)) {
					System.out.println("수정할 정보를 입력하세요.");
					System.out.print("id : ");
					account.setId(input.next());
					System.out.println("---------------");
					System.out.print("pw :" );
					account.setPw(input.next());
					System.out.println("---------------");
					System.out.print("닉네임 :" );
					account.setNickName(input.next());
					System.out.println("---------------");
					accounts[i] = account;
					System.out.println("회원정보가 수정되었습니다.");
					break;
				}else {
					System.out.println("일치하는 회원정보가 없습니다.");
				}
			}
			break;
		}
	}

	private static void create(Scanner input, Account[] accounts) {
		Account account = new Account();
		System.out.println("회원가입 메뉴입니다.");
		System.out.print("id : ");
		account.setId(input.next());
		System.out.println("---------------");
		System.out.print("pw :" );
		account.setPw(input.next());
		System.out.println("---------------");
		System.out.print("닉네임 :" );
		account.setNickName(input.next());
		System.out.println("---------------");
		
		for(int i=0 ; i<accounts.length ; i++) {
			if(accounts[i] == null) {
				accounts[i] = account;
				System.out.println(accounts[i].getNickName()+"님, 회원가입 완료되었습니다.");
				break;
			}
		}
	}
	
	

	private static void signIn(Scanner input, Account[] accounts, Account loginAccount) {
		Account account = new Account();
		System.out.println("로그인 메뉴입니다.");
		System.out.print("id : ");
		account.setId(input.next());
		System.out.println("---------------");
		System.out.print("pw :" );
		account.setPw(input.next());
		System.out.println("---------------");
		
		for(int i=0 ; i<accounts.length ; i++) {
			if(accounts[i] != null) {
				if(accounts[i].getId().equals(account.getId())) {
					System.out.println("해당하는 id가 있습니다.");
					if(accounts[i].getPw().equals(account.getPw())) {
						System.out.println("해당하는 pw가 있습니다.");
						loginAccount = accounts[i];
						System.out.println(accounts[i].getNickName()+"님, 로그인 성공!");
						break;
					}else {
						System.out.println("해당하는 pw가 없습니다.");
						System.out.println("다시 로그인해주세요.");
					}
				}else {
					System.out.println("해당하는 id가 없습니다.");
					System.out.println("다시 로그인해주세요.");
				}
				break;
			}
		}		
		
		
	}

}
