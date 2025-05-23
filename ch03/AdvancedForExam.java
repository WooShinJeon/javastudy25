package ch03;

public class AdvancedForExam {

	public static void main(String[] args) {
		int[] scores = {95, 71, 84, 93, 87};
		
		int sum = 0;
		for(int i : scores) {
			sum += i;
		}
		System.out.println("점수의 총합 : "+sum);
		
		String[] name = new String[] {"엠비씨", "아카데미", "컴퓨터", "교육센터"};
		
		for(String i : name) {
			System.out.print(i+" ");
		}
	}

}
