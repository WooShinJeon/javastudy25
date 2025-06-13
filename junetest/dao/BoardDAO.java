package junetest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import junetest.dto.BoardDTO;

public class BoardDAO {
	
	public BoardDTO boardDTO = new BoardDTO();
	public Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;
	public int result = 0;
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.176:1521:xe", "junetest", "junetest");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �̸� Ȥ��, ojdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
			System.exit(0); // ��������
		}catch(SQLException e) {
			System.out.println("URL, ID, PW�� Ȯ�����ּ���.");
			e.printStackTrace();
			System.exit(0);
		}
	} // BoardDAO
	
	
	public void selectAll() throws SQLException {
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board order by bdate desc";
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			System.out.println("��ȣ\t ����\t �ۼ���\t �ۼ���");
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("bno")+"\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
			} // while
		}catch(SQLException e) {
			System.out.println("selectAll() �޼����� �������� �߸��Ǿ����ϴ�.");
			e.printStackTrace();
		}finally { // �׻� ���๮
			resultSet.close();
			statement.close();
		}
	} // selectAll
	
	
	public void insertBoard(BoardDTO boardDTO) throws SQLException {
		// preparedStatement ���� ���
		
		try {
			String sql = "insert into board(bno, btitle, bcontent, bwriter) values (mb_seq.nextval, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, boardDTO.getBwriter());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "���� �Խù��� �ۼ��Ǿ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("���� ���� ��� : " + result);
				System.out.println("�Խù��ۼ� ����~~");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : insertBoard() �޼����� �������� Ȯ�����ּ���.");
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
			
			if(resultSet.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setBno(resultSet.getInt("bno"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBwriter(resultSet.getString("bwriter"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
				
				System.out.println("=================================");
				System.out.println("��ȣ : " + boardDTO.getBno());
				System.out.println("���� : " + boardDTO.getBtitle());
				System.out.println("���� : " + boardDTO.getBcontent());
				System.out.println("�ۼ��� : " + boardDTO.getBwriter());
				System.out.println("�ۼ��� : " + boardDTO.getBdate());
				System.out.println("=================================");
			}else {
				System.out.println("�˻������ �����ϴ�.");
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : readOne() �޼��带 Ȯ���ϼ���.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
	} // readOne
	
	
	public void modify(String title, Scanner inputStr) throws SQLException {
		BoardDTO boardDTO = new BoardDTO();
		System.out.println("������ ������ �Է��ϼ���.");
		System.out.println("=================================");
		System.out.print("���� : ");
		boardDTO.setBtitle(inputStr.next());
		
		System.out.println("=================================");
		System.out.print("���� : ");
		boardDTO.setBcontent(inputStr.next());
		System.out.println("=================================");
		
		try {
			String sql = "update board set btitle = ?, bcontent = ? where btitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, title);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "���� �����Ͱ� �����Ǿ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("������ ���� �ʾҽ��ϴ�.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : modify() �޼���� sql���� Ȯ���ϼ���.");
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
				System.out.println(result + " �Խù��� �����Ǿ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("�Խù��� �������� �ʾҽ��ϴ�.");
				connection.rollback();
			}
			
			System.out.println("=================================");
			selectAll();
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : deleteOne() �޼���� sql���� Ȯ���ϼ���.");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
	} // deleteOne
	
	
	
}
