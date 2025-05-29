package ch05.mbcbank.service;

import java.util.Scanner;

import ch05.mbcbank.dto.AccountDTO;

public class HanaBankService {
	
	public void menu(Scanner inputStr, Scanner inputInt, AccountDTO[] hanaBank, AccountDTO[] wooriBank, AccountDTO[] nhBank) {
		boolean subRun = true;
		while(subRun) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.이체 | 6.종료");
			System.out.println("---------------------------------------------------------");
			System.out.print(">>> ");
			String select = inputStr.next();
			
			switch(select) {
			case "1" :
				create(inputStr, inputInt, hanaBank);
				break;
				
			case "2" :
				accountLists(hanaBank);
				break;
				
			case "3" :
				deposit(hanaBank, inputStr, inputInt);
				break;
				
			case "4" :
				withdraw(hanaBank, inputStr, inputInt);
				break;
				
			case "5" :
				transfer(hanaBank, wooriBank, nhBank, inputInt, inputStr);
				break;
				
			case "6" :
				System.out.println("하나은행 금융 프로그램을 종료하고 메인메뉴로 돌아갑니다.");
				subRun = false;
				break;
			}
		}
	}

	private void transfer(AccountDTO[] hanaBank, AccountDTO[] wooriBank, AccountDTO[] nhBank, Scanner inputInt, Scanner inputStr) {
		System.out.println("----------------------------------");
		System.out.println("이체하실 분의 계좌번호를 입력하세요.");
		System.out.print(">>> ");
		String hanaAno = inputStr.next();
		System.out.println("-----------------------");
		AccountDTO transAccount1 = findAccount(hanaBank, hanaAno);
		if(transAccount1 == null) {
			System.out.println("찾는 계좌가 없습니다.");
			System.out.println("다시한번 확인해주세요.");
			return;
		}
		System.out.println("이체할 은행명을 입력해주세요.(oo은행)");
		System.out.print(">>> ");
		String transBankName = inputStr.next();
		System.out.println("-----------------------");
		if(transBankName.equals("하나은행")) {
			System.out.println("이체할 계좌번호를 입력하세요.");
			String hanaAno1 = inputStr.next();
			System.out.println("-----------------------");
			AccountDTO transAccount2 = findAccount(hanaBank, hanaAno1);
			if(transAccount2 == null) {
				System.out.println("찾는 계좌가 없습니다.");
				System.out.println("다시한번 확인해주세요.");
				return;
			}
			System.out.println("이체할 금액을 입력하세요.");
			System.out.print(">>> ");
			int transBal1 = inputInt.nextInt();
			System.out.println(transBal1+"원을 이체하겠습니다.");
			System.out.println("......");
			transAccount1.setBalance(transAccount1.getBalance()-transBal1);
			transAccount2.setBalance(transAccount2.getBalance()+transBal1);
			System.out.println("이체가 완료되었습니다.");
			
		} else if(transBankName.equals("우리은행")) {
			System.out.println("이체할 계좌번호를 입력하세요.");
			String wooriAno = inputStr.next();
			System.out.println("-----------------------");
			AccountDTO transAccount3 = findAccount(wooriBank, wooriAno);
			if(transAccount3 == null) {
				System.out.println("찾는 계좌가 없습니다.");
				System.out.println("다시한번 확인해주세요.");
				return;
			}
			System.out.println("이체할 금액을 입력하세요.");
			System.out.print(">>> ");
			int transBal2 = inputInt.nextInt();
			System.out.println(transBal2+"원을 이체하겠습니다.");
			System.out.println("......");
			transAccount1.setBalance(transAccount1.getBalance()-transBal2);
			transAccount3.setBalance(transAccount3.getBalance()+transBal2);
			System.out.println("이체가 완료되었습니다.");
			
		}else if(transBankName.equals("농협은행")) {
			System.out.println("이체할 계좌번호를 입력하세요.");
			String nhAno = inputStr.next();
			System.out.println("-----------------------");
			AccountDTO transAccount4 = findAccount(nhBank, nhAno);
			if(transAccount4 == null) {
				System.out.println("찾는 계좌가 없습니다.");
				System.out.println("다시한번 확인해주세요.");
				return;
			}
			System.out.println("이체할 금액을 입력하세요.");
			System.out.print(">>> ");
			int transBal3 = inputInt.nextInt();
			System.out.println(transBal3+"원을 이체하겠습니다.");
			System.out.println("......");
			transAccount1.setBalance(transAccount1.getBalance()-transBal3);
			transAccount4.setBalance(transAccount4.getBalance()+transBal3);
			System.out.println("이체가 완료되었습니다.");		
		}else {
			System.out.println("은행이름을 정확히 입력해주세요.(우리은행, 하나은행 등...");
		}
	} // tranfer

	private void withdraw(AccountDTO[] hanaBank, Scanner inputStr, Scanner inputInt) {
		System.out.println("----------------------------------");
		System.out.println("출금을 진행할 계좌번호를 입력하세요.");
		System.out.print(">>> ");
		String ano = inputStr.next();
		System.out.println("-----------------------");
		AccountDTO inputAccount = findAccount(hanaBank, ano);
		if(inputAccount == null) {
			System.out.println("찾는 계좌가 없습니다.");
			System.out.println("다시한번 확인해주세요.");
			return;
		}
		System.out.println("출금액을 입력해주세요.");
		System.out.print(">>> ");
		int money = inputInt.nextInt();
		if(inputAccount.getBalance() < money) {
			System.out.println("-----------------------");
			System.out.println("출금액이 계좌잔액("+inputAccount.getBalance()+"원)보다 많습니다.");
			System.out.println("출금액을 다시 확인해주세요.");
			return;
		}
		System.out.println("-----------------------");
		System.out.println("계좌에서 "+money+"원을 출금합니다.");
		inputAccount.setBalance(inputAccount.getBalance()-money);
		System.out.println(".........");
		System.out.println(inputAccount.getOwner()+"님, 출금이 완료되었습니다.");
		System.out.println("잔액 : "+inputAccount.getBalance()+"원");
		System.out.println();
		
	}

	private void deposit(AccountDTO[] hanaBank, Scanner inputStr, Scanner inputInt) {
		System.out.println("----------------------------------");
		System.out.println("예금을 진행할 계좌번호를 입력하세요.");
		System.out.print(">>> ");
		String ano = inputStr.next();
		System.out.println("-----------------------");
		AccountDTO inputAccount = findAccount(hanaBank, ano);
		if(inputAccount == null) {
			System.out.println("찾는 계좌가 없습니다.");
			System.out.println("다시한번 확인해주세요.");
			return;
		}
		System.out.println("예금액을 입력해주세요.");
		System.out.print(">>> ");
		int money = inputInt.nextInt();
		System.out.println("-----------------------");
		System.out.println("계좌에 "+money+"원을 예금합니다.");
		inputAccount.setBalance(inputAccount.getBalance()+money);
		System.out.println(".........");
		System.out.println(inputAccount.getOwner()+"님, 예금이 완료되었습니다.");
		System.out.println("잔액 : "+inputAccount.getBalance()+"원");
		System.out.println();
		
	}

	private AccountDTO findAccount(AccountDTO[] hanaBank, String ano) {
		AccountDTO account = null;
		for(int i=0 ; i<hanaBank.length ; i++) {
			String dbAno = hanaBank[i].getAno();
			if(dbAno != null) {
				if(dbAno.equals(ano)) {
					account = hanaBank[i];
					break;
				}
			}
		}
		return account;
	}

	private void accountLists(AccountDTO[] hanaBank) {
		System.out.println("-----------------------");
		System.out.println("(직원용)계좌목록 입니다.");
		System.out.println("---------------------------------");
		for(int i=0 ; i<hanaBank.length ; i++) {
			AccountDTO accountlist = new AccountDTO();
			if(hanaBank[i] != null) {
				accountlist = hanaBank[i];
				System.out.println(accountlist.getOwner()+"   "+accountlist.getAno()+"   "+accountlist.getBalance()+"원");
				System.out.println("------------------------------");
			} // if
		} // for
		System.out.println("메뉴로 돌아갑니다.");
		
	}

	private void create(Scanner inputStr, Scanner inputInt, AccountDTO[] hanaBank) {
		AccountDTO myAccount = new AccountDTO();
		System.out.println("-----------------------");
		System.out.println("계좌를 생성합니다.");
		System.out.println("-----------------------");
		System.out.print("계좌번호> ");
		myAccount.setAno(inputStr.next());
		System.out.println("-----------------------");
		System.out.print("계좌주> ");
		myAccount.setOwner(inputStr.next());
		System.out.println("-----------------------");
		System.out.print("초기 입금액> ");
		myAccount.setBalance(inputInt.nextInt());
		myAccount.setBankName("하나은행");
		
		for(int i=0 ; i<hanaBank.length ; i++) {
			if(hanaBank[i] == null) {
				hanaBank[i] = myAccount;
				break;
			}
		} // for
		System.out.println("계좌생성이 완료되었습니다.");
		System.out.println("메뉴로 돌아갑니다.");
		
	} // create

} // class
