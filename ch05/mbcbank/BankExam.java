package ch05.mbcbank;

import java.util.Scanner;

import ch05.mbcbank.dto.AccountDTO;
import ch05.mbcbank.service.HanaBankService;
import ch05.mbcbank.service.NhBankService;
import ch05.mbcbank.service.WooriBankService;

public class BankExam {
	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputStr = new Scanner(System.in);
	
	public static AccountDTO[] hanaBank = new AccountDTO[100];
	public static AccountDTO[] wooriBank = new AccountDTO[100];
	public static AccountDTO[] nhBank = new AccountDTO[100];
	public static AccountDTO session;

	public static void main(String[] args) {
		boolean run = true;
		System.out.println("---------------------------------------------------------");
		System.out.println("---------MBC금융관리시스템에 오신것을 환영합니다.---------");
		while(run) {
			System.out.println("---------------------------------------------------------");
			System.out.println(" 1. 하나은행 | 2. 우리은행 | 3. 농협은행 | 4. 프로그램 종료 ");
			System.out.println("---------------------------------------------------------");
			System.out.print(">>> ");
			String select = inputStr.next();
			
			switch(select) {
			case "1" :
				System.out.println();
				System.out.println("하나은행 금융관리 시스템입니다.");
				HanaBankService hanaBankService = new HanaBankService();
				hanaBankService.menu(inputStr, inputInt, hanaBank, wooriBank, nhBank);
				break;
				
			case "2" :
				System.out.println();
				System.out.println("우리은행 금융관리 시스템입니다.");
				WooriBankService wooriBankService = new WooriBankService();
				wooriBankService.menu(inputStr, inputInt, hanaBank, wooriBank, nhBank);
				break;
				
			case "3" :
				System.out.println();
				System.out.println("농협은행 금융관리 시스템입니다.");
				NhBankService nhBankService = new NhBankService();
				nhBankService.menu(inputStr, inputInt, hanaBank, wooriBank, nhBank);
				break;
	
			case "4" :
				System.out.println();
				System.out.println("MBC금융관리시스템을 종료합니다.");
				run = false;
				break;
			}
		}

	}

}
