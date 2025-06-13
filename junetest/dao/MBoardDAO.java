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
			System.out.println("����̹� �̸� Ȥ�� ojdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
			System.exit(0);
		}catch(SQLException e) {
			System.out.println("URL, ID, PW �� Ȯ�����ּ���.");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	public void selectAll() throws SQLException {
		try {
			String sql = "select mbno, mbtitle, mbcontent, mbwriter, mbdate from mboard order by mbdate desc";
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			System.out.println("��ȣ\t ����\t\t ����\t\t �ۼ���\t �ۼ���");
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("mbno")+"\t");
				System.out.print(resultSet.getString("mbtitle") + "\t");
				System.out.print(resultSet.getString("mbcontent") + "\t");
				System.out.print(resultSet.getString("mbwriter") + "\t");
				System.out.println(resultSet.getDate("mbdate"));
			} // while
		}catch(SQLException e) {
			System.out.println("selectAll() �޼����� �������� �߸��Ǿ����ϴ�.");
			e.printStackTrace();
		}finally { // �׻� ���๮
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
				System.out.println(result + "���� �Խù��� �ۼ��Ǿ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("���� ���� ��� : " + result);
				System.out.println("�Խù��ۼ� ����~~");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : insertBoard() �޼��� �������� Ȯ���ϼ���.");
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
			
			if(resultSet.next()) { // �˻������ �ִٸ�
				MBoardDTO mboardDTO = new MBoardDTO(); // �� ��ü ����
				mboardDTO.setMbno(resultSet.getInt("mbno"));
				mboardDTO.setMbtitle(resultSet.getString("mbtitle"));
				mboardDTO.setMbcontent(resultSet.getString("mbcontent"));
				mboardDTO.setMbwriter(resultSet.getString("mbwriter"));
				mboardDTO.setMbdate(resultSet.getDate("mbdate"));
				mboardDTO.setMbid(resultSet.getString("mbid"));
				
				System.out.println("=================================");
				System.out.println("��ȣ : " + mboardDTO.getMbno());
				System.out.println("���� : " + mboardDTO.getMbtitle());
				System.out.println("���� : " + mboardDTO.getMbcontent());
				System.out.println("�ۼ��� : " + mboardDTO.getMbwriter());
				System.out.println("�ۼ��� : " + mboardDTO.getMbdate());
				System.out.println("id : " + mboardDTO.getMbid());
				System.out.println("=================================");
			}else { // �˻������ ������
				System.out.println("�˻������ �����ϴ�.");
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : readOne() �޼��带 Ȯ���ϼ���.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
		
	}
	
	
	public void modify(String title, Scanner inputStr) throws SQLException {
		MBoardDTO mboardDTO = new MBoardDTO();
		System.out.println("������ ������ �Է��ϼ���.");
		System.out.println("---------------");
		System.out.print("���� : ");
		mboardDTO.setMbtitle(inputStr.next());
		System.out.println("---------------");
		System.out.print("���� : ");
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
	
	
	public void deleteOne(String title) throws SQLException {
		try {
			String sql = "delete from mboard where mbtitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
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
		
	}
	
	
	
	
}
