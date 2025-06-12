package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Period;
import java.util.Scanner;

import mbcboard.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null;				// 1단계에서 사용하는 객체
	public Statement statement = null;					// 3단계에서 사용하는 객체(구형), 변수 직접처리 '" + name + "'
	public PreparedStatement preparedStatement = null;	// 3단계에서 사용하는 객체(신형), '?' -> 인파라미터 사용
	public ResultSet resultSet = null;					// 4단계에서 결과받는 표 객체 executeQuery (select 결과)
	public int result = 0;
	
	
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "boardtest", "boardtest");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 이름 혹은, ojdbc6.jar 파일이 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0); // 강제종료
		}catch(SQLException e) {
			System.out.println("URL, ID, PW를 확인해주세요.");
			e.printStackTrace();
			System.exit(0);
		}
	} // MemberDAO

	
	public void mbCreate(String id, String pw, String name) throws SQLException {
		
		try {
			String sql = "insert into member (mno, bwriter, id, pw) values (board_seq.nextval, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, id);
			preparedStatement.setString(3, pw);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "명의 회원정보가 입력되었습니다.");
				System.out.println("회원가입이 완료되었습니다!");
				connection.commit();
			}else {
				System.out.println("회원가입에 실패했습니다.");
				System.out.println("상위메뉴로 돌아갑니다.");
				connection.rollback();
			}
			
		
		}catch(SQLException e) {
			System.out.println("예외발생 : mbCreate() 메서드의 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
	} // mbCreate


	public MemberDTO mbLogin(String id, String pw, MemberDTO session) throws SQLException {
		
		try {
			String sql = "select mno, bwriter, id, pw, regidate from member where id = ? and pw = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				session.setMno(resultSet.getInt("mno"));
				session.setBwriter(resultSet.getString("bwriter"));
				session.setId(resultSet.getString("id"));
				session.setPw(resultSet.getString("pw"));
				session.setRegidate(resultSet.getDate("regidate"));
				
				System.out.println(session.getBwriter() + "님, 로그인 되었습니다.");
			}else {
				System.out.println("입력한 정보가 없습니다.");
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : mbLogin() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		return session;
	} // mbLogin


	public void mbReadAll() throws SQLException {
		
		try {
			String sql = "select mno, bwriter, id, regidate from member order by regidate desc";
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			System.out.println("번호\t 이름\t ID\t 가입날짜");
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("mno")+"\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.print(resultSet.getString("id") + "\t");
				System.out.println(resultSet.getDate("regidate"));
			} // while
		}catch(SQLException e) {
			System.out.println("예외발생 : mbReadAll() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			statement.close();
		}
	} // mbReadAll


	public void mbModify(String id, Scanner inputStr) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("=================================");
		System.out.println("==========새로운 정보를 입력하세요.==========");
		System.out.println("=================================");
		System.out.print("이름 : ");
		memberDTO.setBwriter(inputStr.next());
		System.out.println("=================================");
		System.out.print("ID : ");
		memberDTO.setId(inputStr.next());
		System.out.println("=================================");
		System.out.print("PW : ");
		memberDTO.setPw(inputStr.next());
		System.out.println("=================================");
		
		try {
			String sql1 = "insert into member(mno, bwriter, id, pw) values (board_seq.nextval, memberDTO.getBwriter(), memberDTO.getId(), memberDTO.getPw())";
			String sql2 = "update board set bwriter = memberDTO.getId() where bwriter = ?";
			String sql = "delete from board where where id = ?";
			
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, id);
			
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "명의 정보가 수정되었습니다.");
				connection.commit();
			}else {
				System.out.println("입려한 id는 없는 id입니다.");
				System.out.println("다시 확인헤주세요.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("mbModify() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
	} // mbModify

	
	public void mbDelete(String id, String pw) throws SQLException {
		
		try {
			String deleteSql = "delete from board where bwriter = ?";
	        preparedStatement = connection.prepareStatement(deleteSql);
	        preparedStatement.setString(1, id);
	        
	        int deleteResult = preparedStatement.executeUpdate();
	        preparedStatement.close();
			
			
			String sql = "delete from member where id = ? and pw = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "명의 회원정보가 삭제되었습니다.");
				connection.commit();
			}else {
				System.out.println("회원정보를 찾지 못했습니다.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : mbDelete() 메서드 쿼리를 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
	} // mbDelete
	
} // class
