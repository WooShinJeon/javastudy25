package test_may.dto;

public class StudentDTO {
	
	private String name; // 이름
	private String studentID; // 학번
	private String sex; // 성별
	private int grade; // 학년
	private int classNo; // 반
	
	
	public String getName() {
		return name;
	}
	public String getStudentID() {
		return studentID;
	}
	public String getSex() {
		return sex;
	}
	public int getGrade() {
		return grade;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
}
