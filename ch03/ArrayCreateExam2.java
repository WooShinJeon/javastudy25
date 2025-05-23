package ch03;

public class ArrayCreateExam2 {

	public static void main(String[] args) {
		int total1 = add(new int[] {70, 80, 90});
		int total2 = add(new int[] {70, 80, 60});
		int total3 = add(new int[] {70, 50, 60});
		System.out.println("1반의 총합 : "+total1);
		System.out.println("2반의 총합 : "+total2);
		System.out.println("3반의 총합 : "+total3);

	}

	static int add(int[] scores) {
		int sum = 0;
		for(int i=0; i<=2; i++) {
			sum += scores[i];
		}
		return sum;
	}

}
