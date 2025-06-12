package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.BoardDTO;

public class BoardDAO {
	// 게시판과 DB의 연동을 담당
	// jdbc 5단계를 사용
	// 1단계 : Connect 객체를 사용하여 ojdbc6.jar을 생성
	// 2단계 : url, id, pw, sql 쿼리문을 작성한다.
	// 3단계 : 쿼리문을 실행한다.
	// 4단계 : 쿼리문 실행 결과를 받는다.
	// 5단계 : 연결 종료를 진행한다.
	
	// 필드
	public BoardDTO boardDTO = new BoardDTO();
	public Connection connection = null;				// 1단계에서 사용하는 객체
	public Statement statement = null;					// 3단계에서 사용하는 객체(구형), 변수 직접처리 '" + name + "'
	public PreparedStatement preparedStatement = null;	// 3단계에서 사용하는 객체(신형), '?' -> 인파라미터 사용
	public ResultSet resultSet = null;					// 4단계에서 결과받는 표 객체 executeQuery (select 결과)
	public int result = 0;								// 4단계에서 결과받는 정수 executeUpdate (insert, update, delete)
	
	// 기본생성자
	public BoardDAO() {
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
	} // BoardDAO
	
	// 메서드
	public void selectAll() throws SQLException {
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board order by bdate desc";
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			System.out.println("번호\t 제목\t 작성자\t 작성일");
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("bno")+"\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
			} // while
		}catch(SQLException e) {
			System.out.println("selectAll() 메서드의 쿼리문이 잘못되었습니다.");
			e.printStackTrace();
		}finally { // 항상 실행문
			resultSet.close();
			statement.close();
		}
	} // selectAll

	public void insertBoard(BoardDTO boardDTO) throws SQLException {
		// preparedStatement 문을 사용
		
		try {
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bdate) values (board_seq.nextval, ?, ?, ?, sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());	// 첫번째 ?에 DTO객체에 있는 제목을 넣음
			preparedStatement.setString(2, boardDTO.getBcontent());	// 두번째 ?에 DTO객체에 있는 내용을 넣음
			preparedStatement.setString(3, boardDTO.getBwriter());	// 세번째 ?에 DTO객체에 있는 작성자를 넣음
			
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
			System.out.println("예외발생 : insertBoard() 메서드의 쿼리문을 확인해주세요.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
	} // insertBoard

	public void readOne(String title) throws SQLException {
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board where btitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { // 검색결과가 있다면
				BoardDTO boardDTO = new BoardDTO(); // 빈 객체 생성
				boardDTO.setBno(resultSet.getInt("bno"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBwriter(resultSet.getString("bwriter"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
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
	} // readOne

	public void modify(String title, Scanner inputStr) throws SQLException {
		BoardDTO boardDTO = new BoardDTO();
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("=================================");
		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		
		System.out.println("=================================");
		System.out.print("내용 : ");
		boardDTO.setBcontent(inputStr.next());
		System.out.println("=================================");
		
		try {
			String sql = "update board set btitle = ?, bcontent = ?, bdate = sysdate where btitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
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

	public void deleteOne(int selectBno) throws SQLException {
		try {
			String sql = "delete from board where bno = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, selectBno);
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
	} // deleteOne

} // class
