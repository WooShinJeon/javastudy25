package ch04.finaltest;

public class PersonExam {

	public static void main(String[] args) {
		Person p1 = new Person("123456-1234567", "김기원");
		
		System.out.println(p1.nation);
		System.out.println(p1.name);
		System.out.println(p1.ssn);
		
		// nation과 ssn은 final 필드이기 때문에 변경 불가능
		p1.name = "닌니눤";
		
		System.out.println(p1.nation);
		System.out.println(p1.name);
		System.out.println(p1.ssn);
	}

}
