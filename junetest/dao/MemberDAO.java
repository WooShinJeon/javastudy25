package junetest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import junetest.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	public int result = 0;
	
	
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.176:1521:xe", "junetest", "junetest");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 이름 혹은 ojdbc6.jar 파일이 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}catch(SQLException e) {
			System.out.println("URL, ID, PW 를 확인해주세요.");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	
	public void mCreate(MemberDTO memberDTO, Scanner inputStr) throws SQLException {
		try {
			String sql = "insert into member (mno, mname, mid, mpw, mphone, memail) values (m_seq.nextval, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMname());
			preparedStatement.setString(2, memberDTO.getMid());
			preparedStatement.setString(3, memberDTO.getMpw());
			preparedStatement.setString(4, memberDTO.getMphone());
			preparedStatement.setString(5, memberDTO.getMemail());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "명의 정보입력이 완료되었습니다.");
				System.out.println(memberDTO.getMname() + "님, 회원가입되었습니다.");
				connection.commit();
			}else {
				System.out.println("회원가입 실패입니다.");
				System.out.println("상위메뉴로 돌아갑니다.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : mCreate() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
	} // mCreate



	public void mReadAll() throws SQLException {
		try {
			String sql = "select mno, mname, mid, mphone, memail, mdate from member order by mdate desc";
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			System.out.println("가입번호\t이름\tID\t전화번호\t\t이메일\t\t가입날짜");
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("mno")+"\t");
				System.out.print(resultSet.getString("mname")+"\t");
				System.out.print(resultSet.getString("mid")+"\t");
				System.out.print(resultSet.getString("mphone")+"\t");
				System.out.print(resultSet.getString("memail")+"\t");
				System.out.println(resultSet.getDate("mdate"));
			} // while
		} catch (SQLException e) {
			System.out.println("예외발생 : mReadAll() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			statement.close();
		}
		
	} // mReadAll



	public void mModify(String id, Scanner inputStr) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("이름, PW, 전화번호, 이메일을 수정가능합니다.");
		System.out.println("---------------");
		System.out.print("이름 : ");
		memberDTO.setMname(inputStr.next());
		System.out.println("---------------");
		System.out.print("PW : ");
		memberDTO.setMpw(inputStr.next());
		System.out.println("---------------");
		System.out.println("전화번호( - 을 사용해서 기입해주세요.)");
		System.out.print(" : ");
		memberDTO.setMphone(inputStr.next());
		System.out.println("---------------");
		System.out.print("이메일 : ");
		memberDTO.setMemail(inputStr.next());
		System.out.println("---------------");
		
		try {
			String sql = "update member set mname=?, mpw=?, mphone=?, memail=? where mid=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMname());
			preparedStatement.setString(2, memberDTO.getMpw());
			preparedStatement.setString(3, memberDTO.getMphone());
			preparedStatement.setString(4, memberDTO.getMemail());
			preparedStatement.setString(5, id);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println("ID : " + id +" 님의 정보수정이 왼료되었습니다.");
				connection.commit();
			}else {
				System.out.println("수정이 되지 않았습니다. 입력한 ID를 확인해주세요.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : mModify() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
	} // mModify



	public void mDelete(String id, String pw) throws SQLException {
		try {
			String sql = "delete from member where mid = ? and mpw = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원정보의 삭제가 완료되었습니다.");
				connection.commit();
			}else {
				System.out.println("삭제하려는 회원정보를 찾을 수 없습니다.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : mDelete() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
	} // mDelete



	public void mLogin(String id, String pw, MemberDTO session) throws SQLException {
		try {
			String sql = "select mno, mname, mid, mpw, mphone, memail, mdate from member where mid = ? and mpw = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				session.setMno(resultSet.getInt("mno"));
				session.setMname(resultSet.getString("mname"));
				session.setMid(resultSet.getString("mid"));
				session.setMpw(resultSet.getString("mpw"));
				session.setMphone(resultSet.getString("mphone"));
				session.setMemail(resultSet.getString("memail"));
				session.setMdate(resultSet.getDate("mdate"));
				
				System.out.println(session.getMname() + "님, 로그인 됐습니다.");
				connection.commit();
			}else {
				System.out.println("ID와 PW를 다시 확인해주세요.");
				connection.rollback();
			}
			
		}catch(SQLException e) {
			System.out.println("예외발생 : mLogin() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
	} // mLogin

}
