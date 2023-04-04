package dao.signup;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.signvo.SignVO;

public class SignDAO {
	// private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// private String uid = "scott";
	// private String upw = "TIGER";
	private DataSource datasource;

	public SignDAO() {
		// try {
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SignVO> signupSelect() {
		List<SignVO> vos = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM MEMBER_TBL_02, MEMBER_TBL_02 WHERE MEMBER_TBL_02.CUSTNO = MONEY_TBL_02.CUSTNO";

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
}
