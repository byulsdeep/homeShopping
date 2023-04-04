package dao.signdao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

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
			String sql = "SELECT * FROM MEMBER_TBL_02";

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

    public int signup(String custno, String custname, String phone, String address, String joindate, String grade,
            String city) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int rn = 0;

		try {
            String sql = "INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(?,?,?,?,?,?,?)";
			con = datasource.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(custno));
            ps.setString(2, custname);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setDate(5, Date.valueOf(joindate));
            ps.setString(6, grade);
            ps.setString(7, city);

			rn = ps.executeUpdate();
		} catch (Exception e) {
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
