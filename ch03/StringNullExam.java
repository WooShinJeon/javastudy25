package ch03;

public class StringNullExam {

	public static void main(String[] args) {
		
		String name = null;
		String hobby = "볼링";
		
		// System.out.println("name 총 문자수 : "+name.length()); -> NullPointException(예외) 프로그램이 정상적이지 않음.
		System.out.println("hobby 총 문자수 : "+hobby.length()); // 2
		
		
		String StrVal1 = "김기원";
		String StrVal2 = "김기원";
		String StrVal3 = "김기원";
		String StrVal4 = new String("김기원");
		
		if(StrVal1 == StrVal4) {
			System.out.println("StrVal1과 StrVal4는 참조가 같습니다.");
		}else {
			System.out.println("StrVal1과 StrVal4는 참조가 다릅니다.");
		}
		if(StrVal1.equals(StrVal4)) {
			System.out.println("StrVal1과 StrVal4는 문자열이 같습니다.");
		}else {
			System.out.println("StrVal1과 StrVal4는 문자열이 다릅니다.");
		}

	}

}

