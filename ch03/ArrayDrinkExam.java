package ch03;

import java.util.Scanner;

public class ArrayDrinkExam {
	
	// 회원로그인 후 구매시 장바구니 기능 아직 미구현
	// 회원가입, 로그인도 임시방편으로 만들었지만 아직 미완(로그인 후 로그인 한 아이디 식별기능 x)

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=======음료등록 프로그램=======");
		System.out.println("등록할 음료가 몇종류인지 입력해주세요.");
		System.out.print(">>> ");
		int count = input.nextInt();
		System.out.println(count+"가지 종류의 음료를 등록하겠습니다.");
		System.out.println();
		
		String[] names = new String[count];
		int[][] drinks = new int[count][2];
		int[] drinksSave = new int [count]; // 음료의 초기수량 저장용 배열
		String[] id = new String[3]; 
		String[][] members = new String[3][2];
		
		Add(names, drinks, count, drinksSave);
		
		boolean run = true;
		boolean runBuy = true;
		boolean runBuy1 = true;
		boolean runAdm = true;
		boolean runLogin = true;
		boolean runStart = true;
		boolean runMember = true;
		boolean runAdm1 = true;
				
		System.out.println();
		System.out.println("=====자판기 프로그램 시작=====");
		while (runStart) {
			System.out.println("1.로그인\n2.회원가입\n3.비회원으로 시작");
			System.out.print(">>> ");
			int num = input.nextInt();
			switch (num) {
			case 1:
				login(id, members, runLogin);
				System.out.println();
				while (runMember) {
					System.out.println("1.음료별 재고 확인하기\n2.음료 구매하기\n3.장바구니 확인하기\n4.관리자 호출하기\n9.자판기 종료하기");
					System.out.print(">>> ");
					int ansBuyMem = input.nextInt();
					switch (ansBuyMem) {
					case 1:
						System.out.println();
						System.out.println("음료별 재고 확인 메뉴입니다.");
						System.out.println();
						System.out.println("각 음료별 재고를 알려드리겠습니다.");
						for (int i = 0; i < count; i++) {
							System.out.println(names[i] + " : " + drinks[i][0] + "개");
						}
						System.out.println("입니다.");
						System.out.println("자판기 초기화면으로 돌아갑니다.");
						System.out.println();
						break;
					case 2:
						buyDrinks(count, names, drinks, runBuy, runBuy1);
						break;
					case 3 :
						break;
					case 4:
						System.out.println("관리자 호출 메뉴를 선택하셨습니다.");
						System.out.println("관리자의 전화번호는 010-xxxx-xxxx 입니다.");
						System.out.println("위의 번호로 전화해주시기 바랍니다.");
						runMember = false;
						break;
					case 9:
						System.out.println("자판기 프로그램을 종료합니다.");
						System.out.println("다음에 다시 이용해주세요!!");
						runMember = false;
						break;
					case 1111:
						System.out.println("관리자 메뉴입니다.");
						System.out.println("관리자 메뉴에 진입하려면 비밀번호를 입력해주세요!!!");
						System.out.print(">>> ");
						int pw = input.nextInt();

						if (pw == 9999) {
							System.out.println("비밀번호가 일치합니다.");
							System.out.println("=====관리자 메뉴에 진입합니다.=====");
							while (runAdm1) {
								System.out.println(
										"1.메뉴변경\n2.가격변경\n3.재고보충\n4.통계\n5.총 매출액 보기\n6.구매자 메뉴로 돌아가기\n9.자판기 종료하기");
								System.out.print(">>> ");
								int ansAdm = input.nextInt();
								switch (ansAdm) {
								case 1:
									ChangeMenu(count, names, drinks);
									break;
								case 2:
									ChangePrice(count, names, drinks);
									break;
								case 3:
									AddMenu(count, names, drinks);
									break;
								case 4:
									System.out.println("통계 메뉴입니다.");
									System.out.println("현재 남아있는 모든 음료의 수량과, 가격의 총합을 알려드리겠습니다.");
									int sum = 0;
									for (int i = 0; i < count; i++) {
										sum = sum + (drinks[i][0] * drinks[i][1]);
										System.out.println(names[i] + "의 남은 수량 : " + drinks[i][0] + "개");
									}
									System.out.println("모든 음료가격의 총합 : " + sum);
									System.out.println("관리자 메뉴로 돌아갑니다.");
									break;
								case 5:
									System.out.println("총 매출액을 확인합니다.");
									System.out.println("현재까지 팔린 음료의 총액을 보여드리겠습니다.");
									int sum1 = 0;
									for (int i = 0; i < count; i++) {
										sum1 = sum1 + ((drinksSave[i] - drinks[i][0]) * drinks[i][1]);
									}
									System.out.println("현재까지 판매된 음료의 총액 : " + sum1);
									System.out.println("관리자 메뉴로 돌아갑니다.");
									break;
								case 6:
									System.out.println("관리자 모드를 종료합니다.");
									System.out.println("구매자 메뉴로 돌아갑니다.");
									runAdm1 = false;
									break;
								case 9:
									System.out.println("자판기 프로그램을 종료합니다.");
									System.out.println("다음에 다시 이용해주세요!!");
									runAdm1 = false;
									runMember = false;
									break;
								default:
									System.out.println("메뉴에 있는 번호로 다시 입력해주세요.");
								} // switch(ansAdm)문 종료
							} // while (runAdm)문 종료

						} else {
							System.out.println("비밀번호를 틀리셨습니다.");
							System.out.println("보안을 위해 비밀번호를 한번이라도 틀리면 프로그램을 종료합니다.");
							run = false;
						}
						break;
					default:
						System.out.println("메뉴에 있는 번호중에 하나를 입력해주세요.");
						break;
					} // switch(ans)문 종료
					runStart = false;
				} // while(run)문 종료
				
				
				runStart = false;
				break;
			case 2:
				signIn(id, members);
				break;
			case 3:
				while (run) {
					System.out.println("1.음료별 재고 확인하기\n2.음료 구매하기\n3.관리자 호출하기\n9.자판기 종료하기");
					System.out.print(">>> ");
					int ansBuy = input.nextInt();
					switch (ansBuy) {
					case 1:
						System.out.println();
						System.out.println("음료별 재고 확인 메뉴입니다.");
						System.out.println();
						System.out.println("각 음료별 재고를 알려드리겠습니다.");
						for (int i = 0; i < count; i++) {
							System.out.println(names[i] + " : " + drinks[i][0] + "개");
						}
						System.out.println("입니다.");
						System.out.println("자판기 초기화면으로 돌아갑니다.");
						System.out.println();
						break;
					case 2:
						buyDrinks(count, names, drinks, runBuy, runBuy1);
						break;
					case 3:
						System.out.println("관리자 호출 메뉴를 선택하셨습니다.");
						System.out.println("관리자의 전화번호는 010-xxxx-xxxx 입니다.");
						System.out.println("위의 번호로 전화해주시기 바랍니다.");
						run = false;
						break;
					case 9:
						System.out.println("자판기 프로그램을 종료합니다.");
						System.out.println("다음에 다시 이용해주세요!!");
						run = false;
						break;
					case 1111:
						System.out.println("관리자 메뉴입니다.");
						System.out.println("관리자 메뉴에 진입하려면 비밀번호를 입력해주세요!!!");
						System.out.print(">>> ");
						int pw = input.nextInt();

						if (pw == 9999) {
							System.out.println("비밀번호가 일치합니다.");
							System.out.println("=====관리자 메뉴에 진입합니다.=====");
							while (runAdm) {
								System.out.println(
										"1.메뉴변경\n2.가격변경\n3.재고보충\n4.통계\n5.총 매출액 보기\n6.구매자 메뉴로 돌아가기\n9.자판기 종료하기");
								System.out.print(">>> ");
								int ansAdm = input.nextInt();
								switch (ansAdm) {
								case 1:
									ChangeMenu(count, names, drinks);
									break;
								case 2:
									ChangePrice(count, names, drinks);
									break;
								case 3:
									AddMenu(count, names, drinks);
									break;
								case 4:
									System.out.println("통계 메뉴입니다.");
									System.out.println("현재 남아있는 모든 음료의 수량과, 가격의 총합을 알려드리겠습니다.");
									int sum = 0;
									for (int i = 0; i < count; i++) {
										sum = sum + (drinks[i][0] * drinks[i][1]);
										System.out.println(names[i] + "의 남은 수량 : " + drinks[i][0] + "개");
									}
									System.out.println("모든 음료가격의 총합 : " + sum);
									System.out.println("관리자 메뉴로 돌아갑니다.");
									break;
								case 5:
									System.out.println("총 매출액을 확인합니다.");
									System.out.println("현재까지 팔린 음료의 총액을 보여드리겠습니다.");
									int sum1 = 0;
									for (int i = 0; i < count; i++) {
										sum1 = sum1 + ((drinksSave[i] - drinks[i][0]) * drinks[i][1]);
									}
									System.out.println("현재까지 판매된 음료의 총액 : " + sum1);
									System.out.println("관리자 메뉴로 돌아갑니다.");
									break;
								case 6:
									System.out.println("관리자 모드를 종료합니다.");
									System.out.println("구매자 메뉴로 돌아갑니다.");
									runAdm = false;
									break;
								case 9:
									System.out.println("자판기 프로그램을 종료합니다.");
									System.out.println("다음에 다시 이용해주세요!!");
									runAdm = false;
									run = false;
									break;
								default:
									System.out.println("메뉴에 있는 번호로 다시 입력해주세요.");
								} // switch(ansAdm)문 종료
							} // while (runAdm)문 종료

						} else {
							System.out.println("비밀번호를 틀리셨습니다.");
							System.out.println("보안을 위해 비밀번호를 한번이라도 틀리면 프로그램을 종료합니다.");
							run = false;
						}
						break;
					default:
						System.out.println("메뉴에 있는 번호중에 하나를 입력해주세요.");
						break;
					} // switch(ans)문 종료
					runStart = false;
				} // while(run)문 종료
				runStart = false;
				break;
			} // switch(num)문 종료
		} // while(runStart)문 종료
		
		
		
		
		
		
		

	} // main 메서드 종료

	
	static void signIn(String[]id, String[][]members) {
		Scanner input = new Scanner(System.in);
		int i=0;
		System.out.print("이용할 ID를 입력하세요 : ");
		if(id[0]==null) {
			id[0] = input.nextLine();
		}else if(id[0]!=null && id[1]==null) {
			id[1] = input.nextLine();
		}else if(id[0]!=null && id[1]!=null && id[2]==null) {
			id[2] = input.nextLine();
		}
		System.out.print("이용할 PW를 입력하세요 : ");
		if(members[0][0]==null) {
			members[0][0] = input.nextLine();
		}else if(members[0][0]!=null && members[1][0]==null) {
			members[1][0] = input.nextLine();
		}else if(members[0][0]!=null && members[1][0]!=null && members[2][0]==null) {
			members[2][0] = input.nextLine();
		}
		
		System.out.println("회원가입이 완료되었습니다.");
		
		
	} // signIn 메서드 종료


	static void login(String[]id, String[][]members, boolean runLogin) {
		while (runLogin) {
			Scanner input = new Scanner(System.in);
			System.out.println("====로그인====");
			System.out.print("ID : ");
			String id1 = input.nextLine();
			System.out.print("PW : ");
			String pw = input.nextLine();
			for (int i = 0; i <= 2; i++) {
				if (id1.equals(id[i]) && pw.equals(members[i][0])) {
					System.out.println("로그인이 완료되었습니다.");
					runLogin = false;
				} else {
					System.out.println("ID 및 PW를 확인해주세요.");
				}
			} 
		} // while(runLogin)문 종료
		
		
	} // login 메서드 종료




	static void buyDrinks(int count, String[] names, int[][] drinks, boolean runBuy, boolean runBuy1) {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("음료의 구매를 진행합니다.");
		System.out.println();
		System.out.println("음료목록을 보시고, 1~"+count+" 사이의 번호를 입력해주세요.");
		System.out.println();
		for(int i = 0; i<count ; i++) {
			System.out.println((i+1)+". "+names[i]);
		}
		while (runBuy) {
			System.out.print(">>> ");
			int num = input.nextInt();
			if (num >= 1 && num <= count) {
				if (drinks[num - 1][0] == 0) {
					System.out.println("재고가 남아있지 않은 음료입니다. 다른 음료를 골라주세요.");
					System.out.println();
				} else {
					System.out.println(num + ". " + names[num - 1] + "을(를) 고르셨습니다.");
					System.out.println(names[num - 1] + "의 가격은 " + drinks[num - 1][1] + "원 입니다.");
					System.out.println("구매하고 싶은 음료의 수량을 입력해주세요.");
					while (runBuy1) {
						System.out.print(">>> ");
						int buyValue = input.nextInt();
						System.out.println();
						if (drinks[num - 1][0] >= buyValue) {
							System.out.println("결제하실 총 금액은 " + (drinks[num - 1][1] * buyValue) + "원 입니다.");
							System.out.println("결제방법은 어떻게 하시겠습니까?");
							System.out.println("1.신용카드\n2.현금\n3.계좌이체");
							System.out.print(">>> ");
							int pay = input.nextInt();
							switch (pay) {
							case 1: // 신용카드 결제
								System.out.println("카드 투입구에 신용카드를 넣어주세요.");
								System.out.println();
								System.out.println("결제중입니다......");
								System.out.println();
								System.out.println((drinks[num - 1][1] * buyValue) + "원 결제 완료되었습니다.");
								drinks[num - 1][0] = drinks[num - 1][0] - buyValue;
								System.out.println("초기메뉴화면으로 돌아가겠습니다.");
								runBuy1 = false;
								break;
							case 2: // 현금결제
								payCash(drinks, num, buyValue);
								runBuy1 = false;
								break;
							case 3: // 계좌이체
								System.out.println("계좌이체를 선택하셨습니다.");
								System.out.println(
										"계좌번호 'xxxxxxxxxxxx'로 " + (drinks[num - 1][1] * buyValue) + "원을 이체해주세요.");
								System.out.println("계좌이체 확인중입니다......");
								System.out.println((drinks[num - 1][1] * buyValue) + "원 계좌이체 확인완료. 결제 완료되었습니다.");
								drinks[num - 1][0] = drinks[num - 1][0] - buyValue;
								System.out.println("초기메뉴화면으로 돌아가겠습니다.");
								runBuy1 = false;
								break;
							} // switch(pay)문 종료
							runBuy = false;
						} else if (drinks[num - 1][0] < buyValue) {
							System.out.println(
									"현재 " + names[num - 1] + "의 재고는 " + drinks[num - 1][0] + "개로, 구매하시려는 수량보다 적습니다.");
							System.out.println("재고를 다시 한번 확인하시고, 구매하실 수량을 다시 입력해주세요.");
						} 
					}
					
					
				}

			} else {
				System.out.println("1~" + count + " 사이의 번호로 다시 입력해주세요.");
				System.out.println();
			}
		} // while(runBuy)문 종료
		
	}


	static void payCash(int[][] drinks, int num, int buyValue) {
		Scanner input = new Scanner(System.in);
		System.out.println("현금결제를 진행하겠습니다.");
		System.out.println("현금 투입구에 넣을 현금의 장수를 입력해주세요.(1000원, 5000원, 10000원권만 인식합니다.)");
		System.out.print("1000원권 >>> ");
		int cash1000 = input.nextInt();
		System.out.print("5000원권 >>> ");
		int cash5000 = input.nextInt();
		System.out.print("10000원권 >>> ");
		int cash10000 = input.nextInt();
		int totalCash = cash1000*1000 + cash5000*5000 + cash10000*10000;
		System.out.println("1000원권은 "+cash1000+"장, 5000원권은 "+cash5000+"장, 1000원권은 "+cash10000+"장으로,");
		System.out.println("총 "+totalCash+"원의 현금을 투입하셨습니다.");
		
		if(drinks[num-1][1]*buyValue == totalCash) {
			System.out.println("투입하신 금액 확인 완료되었습니다.");
			System.out.println("결제 완료되었습니다.");
			drinks[num-1][0] = drinks[num-1][0]-buyValue;
			System.out.println("초기메뉴화면으로 돌아가겠습니다.");
		}else if(drinks[num-1][1]*buyValue < totalCash) {
			System.out.println("투입하신 금액 확인 완료되었습니다.");
			System.out.println("거스름돈 "+(totalCash - (drinks[num-1][1]*buyValue))+"원을 드리겠습니다.");
			System.out.println("슉슉~ 짤랑짤랑~");
			System.out.println("거스름돈 반환 완료되었습니다.");
			System.out.println("결제 완료되었습니다.");
			drinks[num-1][0] = drinks[num-1][0]-buyValue;
			System.out.println("초기메뉴화면으로 돌아가겠습니다.");
		}else if(drinks[num-1][1]*buyValue > totalCash) {
			System.out.println("투입하신 금액이 부족합니다.");
			System.out.println("현금결제를 이어가시겠습니까? (y/n) (n 입력시 초기메뉴화면으로 돌아갑니다.)");
			System.out.print(">>> ");
			String answer = input.next();
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("현금결제를 이어가겠습니다.");
				System.out.println("현재 부족한 금액은 "+((drinks[num-1][1]*buyValue) - totalCash)+"원 입니다.");
				System.out.println("추가로 투입하실 현금의 장수를 입력해주세요.(1000원, 5000원, 10000원권만 인식합니다.)");
				System.out.print("1000원권 >>> ");
				int addCash1000 = input.nextInt();
				System.out.print("5000원권 >>> ");
				int addCash5000 = input.nextInt();
				System.out.print("10000원권 >>> ");
				int addCash10000 = input.nextInt();
				int addTotalCash = addCash1000*1000 + addCash5000*5000 + addCash10000*10000;
				System.out.println("1000원권은 "+addCash1000+"장, 5000원권은 "+addCash5000+"장, 1000원권은 "+addCash10000+"장으로,");
				System.out.println("총 "+addTotalCash+"원의 현금을 추가로 투입하셨습니다.");
				
				if(drinks[num-1][1]*buyValue == (totalCash+addTotalCash)) {
					System.out.println("투입하신 금액 확인 완료되었습니다.");
					System.out.println("결제 완료되었습니다.");
					drinks[num-1][0] = drinks[num-1][0]-buyValue;
					System.out.println("초기메뉴화면으로 돌아가겠습니다.");
				}else if(drinks[num-1][1]*buyValue < (totalCash+addTotalCash)) {
					System.out.println("투입하신 금액 확인 완료되었습니다.");
					System.out.println("거스름돈 "+((totalCash+addTotalCash) - (drinks[num-1][1]*buyValue))+"원을 드리겠습니다.");
					System.out.println("슉슉~ 짤랑짤랑~");
					System.out.println("거스름돈 반환 완료되었습니다.");
					System.out.println("결제 완료되었습니다.");
					drinks[num-1][0] = drinks[num-1][0]-buyValue;
					System.out.println("초기메뉴화면으로 돌아가겠습니다.");
				}else if(drinks[num-1][1]*buyValue > (totalCash+addTotalCash)) {
					System.out.println("추가로 투입하신 현금으로도 부족합니다.");
					System.out.println("시스템적인 한계로 현금결제가 중단됩니다.");
					System.out.println("초기메뉴화면으로 돌아갑니다.");
				}
				
			}else if(answer.equalsIgnoreCase("n")) {
				System.out.println("현금결제를 중단하셨습니다.");
				System.out.println("초기메뉴화면으로 돌아가겠습니다.");
			}
		}
		
	} // payCash 메서드 종료


	static void AddMenu(int count, String[] names, int[][] drinks) {
		Scanner input = new Scanner(System.in);
		System.out.println("재고보충 메뉴입니다.");
		System.out.println("재고보충할 음료의 이름을 입력해주세요.");
		System.out.print(">>> ");
		String name2 = input.next();

		for (int i = 0; i < count; i++) {
			if (name2.equals(names[i])) {
				System.out.print("보충할 " + names[i] + "의 수량을 입력하세요 : ");
				drinks[i][0] = drinks[i][0] + input.nextInt();
				System.out.println("재고보충이 완료되었습니다!");
				System.out.println(names[i] + "의 수량 : " + drinks[i][0] + "개");
				System.out.println("관리자 메뉴로 돌아갑니다.");
			}
		}
		
	} // AddMenu 메서드 종료


	static void ChangePrice(int count, String[] names, int[][] drinks) {
		Scanner input = new Scanner(System.in);
		System.out.println("가격변경하고 싶은 음료의 이름을 입력해주세요.");
		System.out.print(">>> ");
		String name1 = input.next();

		for (int i = 0; i < count; i++) {
			if (name1.equals(names[i])) {									
				System.out.print(names[i] + "의 변경하실 가격을 입력하세요 : ");
				drinks[i][1] = input.nextInt();
				System.out.println("수정이 완료되었습니다!");
				System.out.println(names[i] + "의 가격 : " + drinks[i][1] + "원");
				System.out.println("관리자 메뉴로 돌아갑니다.");
			}
		}		
	} // ChangePrice 메서드 종료


	static void ChangeMenu(int count, String[] names, int[][] drinks) {
		Scanner input = new Scanner(System.in);
		System.out.println("변경할 음료의 이름을 입력해주세요.");
		System.out.print(">>> ");
		String name = input.next();

		for (int i = 0; i < count; i++) {
			if (name.equals(names[i])) {
				System.out.print("수정할 메뉴를 입력해주세요 : ");
				names[i] = input.next();
				System.out.print(names[i] + "의 수량을 입력하세요 : ");
				drinks[i][0] = input.nextInt();
				System.out.print(names[i] + "의 가격을 입력하세요 : ");
				drinks[i][1] = input.nextInt();
				System.out.println("수정이 완료되었습니다!");
				System.out.println(names[i] + "의 수량 : " + drinks[i][0] + "개");
				System.out.println(names[i] + "의 가격 : " + drinks[i][1] + "원");
				System.out.println("관리자 메뉴로 돌아갑니다.");
			}
		}
		
	} // ChangeMenu 메서드 종료


	static void Add(String[] names, int[][] drinks, int count, int[]drinksSave) {
		Scanner input = new Scanner(System.in);
		
		for(int i=0 ; i<count ; i++) {
			System.out.println("음료의 이름을 입력하세요.");
			System.out.print(">>> ");
			names[i] = input.next();
			
			System.out.println(names[i]+"의 수량을 입력하세요.");
			System.out.print(">>> ");
			drinks[i][0] = input.nextInt();
			drinksSave[i] = drinks[i][0];
			
			System.out.println(names[i]+"의 가격을 입력하세요.");
			System.out.print(">>> ");
			drinks[i][1] = input.nextInt();
			
			System.out.println(names[i]+"의 수량 : "+drinks[i][0]+"개");
			System.out.println(names[i]+"의 가격 : "+drinks[i][1]+"원");
			System.out.println();
		}
		System.out.println("각 음료별 수량과 가격 입력이 완료되었습니다.");
		
	} // 음료등록 메서드 종료

}
