package ch02;

public class ForFloatExam {

	public static void main(String[] args) {
		for(float x=0.1f; x<=1.0f; x+=0.1f) {
			System.out.println(x);
		} // 초기화식에서 루프 카운트변수를 부동 소수점인 실수방식 사용X
		  // 결과값을 보면 오류가 뜬것을 확인할 수 있다.

	}

}
