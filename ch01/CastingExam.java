package ch01;

public class CastingExam {

	public static void main(String[] args) {
		int intValue = 123456789 ;
		byte byteValue = (byte)intValue ;
		
		System.out.println("int 타입 값 출력 : " + intValue);
		System.out.println("byte 타입 값 출력 : " + byteValue);
		// 123456789 -> 0111 0101 1011 1100 1101 0001 0101
		//                                       0001 0101 -> 21
		
		
		int kor = 98 ;
		int mat = 93 ;
		int eng = 87 ;
		int total = kor + mat + eng ;
		System.out.println("===== 성적표 =====");
		System.out.println("국어 + 수학 + 영어 = 총점 : " +total);
		
		double avg = total / 3 ;
		System.out.println("평균(자동타입변환) : " +avg);
		
		avg = (double)total / 3 ;
		System.out.println("평균(강제타입변환) : " +avg);

	}

}
