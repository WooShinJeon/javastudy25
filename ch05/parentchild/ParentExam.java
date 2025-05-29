package ch05.parentchild;

public class ParentExam {

	public static void main(String[] args) {
		Child ch = new Child();
		Parent pr = ch;
		
		pr.method1();
		pr.method2();
		// pr.method3(); 부모타입안에 method3이 없기떄문에 애초에 컴파일이 안됨

	}

}
