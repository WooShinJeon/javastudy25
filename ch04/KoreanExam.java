package ch04;

public class KoreanExam {

	public static void main(String[] args) {
		Korean k1 = new Korean("김기원", "012345-1234567");
		System.out.println("k1.name : "+k1.name);
		System.out.println("k1.nation : "+k1.nation);
		System.out.println("k1.ssn : "+k1.ssn);
		
		
		Korean k2 = new Korean("전우신", "000128-3213213");
		System.out.println("k2.name : "+k2.name);
		System.out.println("k2.nation : "+k2.nation);
		System.out.println("k2.ssn : "+k2.ssn);

	}

}
