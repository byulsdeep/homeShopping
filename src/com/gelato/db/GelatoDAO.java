package com.gelato.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GelatoDAO {
	
	private DataSource dataSource;

	public GelatoDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean memberWrite(String custname, String phone, String address, String joindate, String grade, String city) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println("memberWrite");

		try {
			String query = "insert into member_tbl_02 values (custno_seq.nextval, ?, ?, ?, ?, ?, ?)";

			connection = dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, custname);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, joindate);
			preparedStatement.setString(5, grade);
			preparedStatement.setString(6, city);

			int result = preparedStatement.executeUpdate();
			
			if(result == 0) return false;
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	public List<MemberDTO> getMembers() {
		List<MemberDTO> members = new ArrayList<MemberDTO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("getMembers");

		try {
			String query = "select * from member_tbl_02";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int custno = resultSet.getInt("custno");
				String custname = resultSet.getString("custname");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				Date joindate = resultSet.getDate("joindate");
				String grade = resultSet.getString("grade");
				String city = resultSet.getString("city");

				MemberDTO dto = new MemberDTO(custno, custname, phone, address, joindate, grade, city);
				members.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return members;
	}
	
	public MemberDTO getMember(String custno) {
		MemberDTO member = null;
		System.out.println("getMember");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "select * from member_tbl_02 where custno=?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(custno));
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				String custname = resultSet.getString("custname");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				Date joindate = resultSet.getDate("joindate");
				String grade = resultSet.getString("grade");
				String city = resultSet.getString("city");
				
				member = new MemberDTO(Integer.valueOf(custno), custname, phone, address, joindate, grade, city);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return member;
	}
	
	public boolean modifyMember(String custno, String custname, String phone, String address, String joindate, String grade, String city) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println("modifyMember");

		try {
			String query = "update member_tbl_02 set custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ? where custno = ?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, custname);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, joindate);
			preparedStatement.setString(5, grade);
			preparedStatement.setString(6, city);
			preparedStatement.setInt(7, Integer.valueOf(custno));

			int result = preparedStatement.executeUpdate();
			if(result == 0) return true;
			
			return false;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	public List<MoneyDTO> getSales(){
		List<MoneyDTO> sales = new ArrayList<MoneyDTO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("getSales");

		try {
			String query = "SELECT m.CUSTNO, m.CUSTNAME, m.grade , SUM(amount * pcost) AS TOTAL FROM MEMBER_TBL_02 m INNER JOIN MONEY_TBL_02 o ON m.CUSTNO = o.CUSTNO GROUP BY m.CUSTNO, m.CUSTNAME, m.grade ORDER BY m.CUSTNO";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int custno = resultSet.getInt("custno");
				String custname = resultSet.getString("custname");
				String grade = resultSet.getString("grade");
				int total = resultSet.getInt("total");

				MoneyDTO dto = new MoneyDTO(custno, custname, grade, total);
				sales.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sales;
	}
}
