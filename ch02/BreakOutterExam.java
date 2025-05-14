package ch02;

public class BreakOutterExam {

	public static void main(String[] args) {
		for(char upper='A' ; upper <= 'Z' ; upper++) { // A~Z 반복용코드
			Outter : for(char lower='a' ; lower<='z' ; lower++) { // a~z 반복용코드
				System.out.println(upper+"-"+lower);
				if(lower=='c') {
					break Outter;
				}
				
			} // 소문자 반복문 종료
		} // 대문자 반복문 종료

	}

}
