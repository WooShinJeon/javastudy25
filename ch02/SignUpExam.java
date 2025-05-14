package ch02;

import java.util.Scanner;

public class SignUpExam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("OO쇼핑몰에 어서오세요!");
		System.out.println("회원가입을 진행하시겠습니까? (y/n)");
		System.out.print(">>> ");
		String ans = input.nextLine();
		
		if(ans.equalsIgnoreCase("y")) {
			System.out.print("성함을 입력해주세요 : ");
			String name = input.nextLine();
			
			System.out.print("ID를 입력해주세요 : ");
			String id = input.nextLine();
			
			System.out.print("PW를 입력해주세요 : ");
			String pw = input.nextLine();
			
			System.out.print("PW를 확인해주세요 : ");
			String pw1 = input.nextLine();
			
			if(pw.equals(pw1)) {
				System.out.println(name+"님, ID와 PW 확인이 완료되었습니다.");
				System.out.println("회원 정보 확인");
				System.out.println(name+"님의 ID : "+id);
				System.out.println(name+"님의 PW : "+pw);
				System.out.println(name+"님의 OO쇼핑몰 회원가입을 축하합니다!");
				System.out.println("  ");
				System.out.println("바로 로그인 하시겠습니까? (y/n)");
				System.out.print(">>> ");
				String ans1 = input.nextLine();
				
				switch(ans1) {
				case "y": case "Y":
					System.out.print("ID를 입력해주세요 : ");
					String id1 = input.nextLine();
					System.out.print("PW를 입력해주세요 : ");
					String pw2 = input.nextLine();
					
					if(id1.equals(id)&&pw2.equals(pw)) {
						System.out.println(name + "님, 로그인이 완료되었습니다!");
						System.out.println("  ");
						System.out.println("신규가입자 대상으로 뽑기이벤트를 진행하고 있습니다.");
						System.out.println("당첨되시면 20% 할인쿠폰을 드립니다.");
						System.out.println("이벤트에 참여하시겠습니까? (y/n)");
						System.out.print(">>> ");
						String ans2 = input.nextLine();
						
						if(ans2.equalsIgnoreCase("y")){
							System.out.println("1에서 6사이의 숫자중 랜덤으로 뽑힌 숫자를 맞추시면 당첨입니다.");
							System.out.print("1에서 6사이의 숫자중 하나를 입력해주세요 : ");
							int myNum = input.nextInt();
							int num = (int)(Math.random()*6)+1;
							if(myNum==num) {
								System.out.println("당첨 축하드립니다!");
								System.out.println(name+"님이 뽑으신 숫자와 랜덤숫자가 "+num+"(으)로 똑같습니다!");
								System.out.println("쿠폰함으로 20% 할인쿠폰을 넣어드렸습니다.");
							}else {
								System.out.println("안타깝군요ㅠ");
								System.out.println(name+"님이 입력하신 숫자는 "+myNum+"이고, 랜덤으로 뽑힌 숫자는 "+num+"입니다.");
								System.out.println("안타깝지만, 다음 기회를 노려보세요!");
							}
							
						}else {
							System.out.println("감사합니다! 재밌는 쇼핑 되세요!!");
						}
					}else {
						System.out.println("id와 pw를 다시 한번 확인해주세요.");
					}
					break;
				case "n": case "N":
					System.out.println("회원가입 감사합니다. 안녕히가세요!");
					break;
				default:
					System.out.println("y/n를 정확히 입력해주세요.");
				
				}
			}else {
				System.out.println("PW를 다시 확인해주세요.");
			}
		}
		
	}

}
