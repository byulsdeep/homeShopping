package dao.signdao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.signvo.SignVO;

public class SignDAO {
	private DataSource datasource;

	public SignDAO() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SignVO> clientList() {
		List<SignVO> vos = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, CASE WHEN GRADE = 'A' THEN 'VIP' WHEN GRADE = 'B' THEN '일반' WHEN GRADE = 'C' THEN '직원' END AS GRADE, CITY FROM MEM";

			// con = DriverManager.getConnection(url, uid, upw);
			con = datasource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int custno = rs.getInt("CUSTNO");
				String custname = rs.getString("CUSTNAME");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				Date joindate = rs.getDate("JOINDATE");
				String grade = rs.getString("GRADE");
				String city = rs.getString("CITY");

				SignVO vo = new SignVO(custno, custname, phone, address, joindate, grade, city);
				vos.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vos;
	}
	public String getNextCustNo() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "오류";
		
		try {
			String sql = "SELECT CUSTNO_SEQ.NEXTVAL FROM DUAL";

			con = datasource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getString("NEXTVAL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

    public int signup(String custno, String custname, String phone, String address, String joindate, String grade,
            String city) {
    	
		Connection con = null;
		PreparedStatement ps = null;
		int rn = 0;

		try {
            String sql = "INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(?,?,?,?, TO_DATE(?, 'YYYYMMDD'),?,?)";
			con = datasource.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(custno));
            ps.setString(2, custname);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, joindate);
            ps.setString(6, grade);
            ps.setString(7, city);
            
			rn = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con!= null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rn;
    }
    public SignVO getClientInfo(String custnoo) {
    	SignVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM MEM WHERE CUSTNO = ?";

			// con = DriverManager.getConnection(url, uid, upw);
			con = datasource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(custnoo));
			rs = ps.executeQuery();

			while (rs.next()) {
				int custno = rs.getInt("CUSTNO");
				String custname = rs.getString("CUSTNAME");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				Date joindate = rs.getDate("JOINDATE");
				String grade = rs.getString("GRADE");
				String city = rs.getString("CITY");

				vo = new SignVO(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
    public int update(String custno, String custname, String phone, String address, String joindate, String grade,
            String city) {
    	
		Connection con = null;
		PreparedStatement ps = null;
		int rn = 0;

		try {
            String sql = "UPDATE MEM SET CUSTNO = ?, CUSTNAME = ?, PHONE = ?, ADDRESS = ?, JOINDATE = TO_DATE(?, 'YYYY-MM-DD'), GRADE = ?, CITY = ? WHERE CUSTNO = ?";
			con = datasource.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(custno));
            ps.setString(2, custname);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, joindate);
            ps.setString(6, grade);
            ps.setString(7, city);
            ps.setInt(8, Integer.parseInt(custno));
            
			rn = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con!= null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rn;
    }
}
