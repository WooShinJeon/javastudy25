package ch01;

public class CastingExam {

	public static void main(String[] args) {
		int intValue = 123456789 ;
		byte byteValue = (byte)intValue ;
		
		System.out.println("int Ÿ�� �� ��� : " + intValue);
		System.out.println("byte Ÿ�� �� ��� : " + byteValue);
		// 123456789 -> 0111 0101 1011 1100 1101 0001 0101
		//                                       0001 0101 -> 21
		
		
		int kor = 98 ;
		int mat = 93 ;
		int eng = 87 ;
		int total = kor + mat + eng ;
		System.out.println("===== ����ǥ =====");
		System.out.println("���� + ���� + ���� = ���� : " +total);
		
		double avg = total / 3 ;
		System.out.println("���(�ڵ�Ÿ�Ժ�ȯ) : " +avg);
		
		avg = (double)total / 3 ;
		System.out.println("���(����Ÿ�Ժ�ȯ) : " +avg);

	}

}
