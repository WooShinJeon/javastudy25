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
			System.out.println("����̹� �̸� Ȥ�� ojdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
			System.exit(0);
		}catch(SQLException e) {
			System.out.println("URL, ID, PW �� Ȯ�����ּ���.");
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
				System.out.println(result + "���� �����Է��� �Ϸ�Ǿ����ϴ�.");
				System.out.println(memberDTO.getMname() + "��, ȸ�����ԵǾ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("ȸ������ �����Դϴ�.");
				System.out.println("�����޴��� ���ư��ϴ�.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : mCreate() �޼��� �������� Ȯ���ϼ���.");
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
			
			System.out.println("���Թ�ȣ\t�̸�\tID\t��ȭ��ȣ\t\t�̸���\t\t���Գ�¥");
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("mno")+"\t");
				System.out.print(resultSet.getString("mname")+"\t");
				System.out.print(resultSet.getString("mid")+"\t");
				System.out.print(resultSet.getString("mphone")+"\t");
				System.out.print(resultSet.getString("memail")+"\t");
				System.out.println(resultSet.getDate("mdate"));
			} // while
		} catch (SQLException e) {
			System.out.println("���ܹ߻� : mReadAll() �޼��� �������� Ȯ���ϼ���.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			statement.close();
		}
		
	} // mReadAll



	public void mModify(String id, Scanner inputStr) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("�̸�, PW, ��ȭ��ȣ, �̸����� ���������մϴ�.");
		System.out.println("---------------");
		System.out.print("�̸� : ");
		memberDTO.setMname(inputStr.next());
		System.out.println("---------------");
		System.out.print("PW : ");
		memberDTO.setMpw(inputStr.next());
		System.out.println("---------------");
		System.out.println("��ȭ��ȣ( - �� ����ؼ� �������ּ���.)");
		System.out.print(" : ");
		memberDTO.setMphone(inputStr.next());
		System.out.println("---------------");
		System.out.print("�̸��� : ");
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
				System.out.println("ID : " + id +" ���� ���������� �޷�Ǿ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("������ ���� �ʾҽ��ϴ�. �Է��� ID�� Ȯ�����ּ���.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : mModify() �޼��� �������� Ȯ���ϼ���.");
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
				System.out.println("ȸ�������� ������ �Ϸ�Ǿ����ϴ�.");
				connection.commit();
			}else {
				System.out.println("�����Ϸ��� ȸ�������� ã�� �� �����ϴ�.");
				connection.rollback();
			}
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : mDelete() �޼��� �������� Ȯ���ϼ���.");
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
				
				System.out.println(session.getMname() + "��, �α��� �ƽ��ϴ�.");
				connection.commit();
			}else {
				System.out.println("ID�� PW�� �ٽ� Ȯ�����ּ���.");
				connection.rollback();
			}
			
		}catch(SQLException e) {
			System.out.println("���ܹ߻� : mLogin() �޼��� �������� Ȯ���ϼ���.");
			e.printStackTrace();
		}finally {
			resultSet.close();
			preparedStatement.close();
		}
	} // mLogin

}
