package junetest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import junetest.dto.MBoardDTO;
import junetest.dto.MemberDTO;

public class MBoardDAO {
	
	public MBoardDTO mBoardDTO = new MBoardDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	public int result = 0;
	
	
	public MBoardDAO() {
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
	
	
	public void selectAll() throws SQLException {
		try {
			String sql = "select mbno, mbtitle, mbcontent, mbwriter, mbdate from mboard order by mbdate desc";
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			System.out.println("번호\t 제목\t\t 내용\t\t 작성자\t 작성일");
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("mbno")+"\t");
				System.out.print(resultSet.getString("mbtitle") + "\t");
				System.out.print(resultSet.getString("mbcontent") + "\t");
				System.out.print(resultSet.getString("mbwriter") + "\t");
				System.out.println(resultSet.getDate("mbdate"));
			} // while
		}catch(SQLException e) {
			System.out.println("selectAll() 메서드의 쿼리문이 잘못되었습니다.");
			e.printStackTrace();
		}finally { // 항상 실행문
			resultSet.close();
			statement.close();
		}
		
	}
	
	
	
	public void insertMBoard(MBoardDTO mboardDTO, MemberDTO session) throws SQLException {

		try {
			String sql = "insert into mboard(mbno, mbtitle, mbcontent, mbwriter, mbid) values (mb_seq.nextval, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mboardDTO.getMbtitle());
			preparedStatement.setString(2, mboardDTO.getMbcontent());
			preparedStatement.setString(3, session.getMname());
			preparedStatement.setString(4, session.getMid());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "개의 게시물이 작성되었습니다.");
				connection.commit();
			}else {
				System.out.println("쿼리 실행 결과 : " + result);
				System.out.println("게시물작성 실패~~");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : insertBoard() 메서드 쿼리문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
	}
	
	
	public void readOne(String title) throws SQLException {
		try {
			String sql = "select mbno, mbtitle, mbcontent, mbwriter, mbdate, mbid from mboard where mbtitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { // 검색결과가 있다면
				MBoardDTO mboardDTO = new MBoardDTO(); // 빈 객체 생성
				mboardDTO.setMbno(resultSet.getInt("mbno"));
				mboardDTO.setMbtitle(resultSet.getString("mbtitle"));
				mboardDTO.setMbcontent(resultSet.getString("mbcontent"));
				mboardDTO.setMbwriter(resultSet.getString("mbwriter"));
				mboardDTO.setMbdate(resultSet.getDate("mbdate"));
				mboardDTO.setMbid(resultSet.getString("mbid"));
				
				System.out.println("=================================");
				System.out.println("번호 : " + mboardDTO.getMbno());
				System.out.println("제목 : " + mboardDTO.getMbtitle());
				System.out.println("내용 : " + mboardDTO.getMbcontent());
				System.out.println("작성자 : " + mboardDTO.getMbwriter());
				System.out.println("작성일 : " + mboardDTO.getMbdate());
				System.out.println("id : " + mboardDTO.getMbid());
				System.out.println("=================================");
			}else { // 검색결과가 없으면
				System.out.println("검색결과가 없습니다.");
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : readOne() 메서드를 확인하세요.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		
	}
	
	
	public void modify(String title, Scanner inputStr) throws SQLException {
		MBoardDTO mboardDTO = new MBoardDTO();
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("---------------");
		System.out.print("제목 : ");
		mboardDTO.setMbtitle(inputStr.next());
		System.out.println("---------------");
		System.out.print("내용 : ");
		mboardDTO.setMbcontent(inputStr.next());
		System.out.println("---------------");
		
		try {
			String sql = "update mboard set mbtitle = ?, mbcontent = ? where mbtitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mboardDTO.getMbtitle());
			preparedStatement.setString(2, mboardDTO.getMbcontent());
			preparedStatement.setString(3, title);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "개의 데이터가 수정되었습니다.");
				connection.commit();
			}else {
				System.out.println("수정이 되지 않았습니다.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("예외발생 : modify() 메서드와 sql문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
	} // modify
	
	
	public void deleteOne(String title) throws SQLException {
		try {
			String sql = "delete from mboard where mbtitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			result = preparedStatement.executeUpdate();
			
			if(result >0) {
				System.out.println(result + " 게시물이 삭제되었습니다.");
				connection.commit();
			}else {
				System.out.println("게시물이 삭제되지 않았습니다.");
				connection.rollback();
			}
			
			System.out.println("=================================");
			selectAll();
		}catch(SQLException e) {
			System.out.println("예외발생 : deleteOne() 메서드와 sql문을 확인하세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
		
	}
	
	
	
	
}
