package dao.inquirydao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.inquiryvo.InquiryVO;
import vo.inquiryvo.SalesVO;

public class InquiryDAO {
	// private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// private String uid = "scott";
	// private String upw = "TIGER";
	private DataSource datasource;

	public InquiryDAO() {
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

	public List<InquiryVO> InquirySelect() {
		List<InquiryVO> vos = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM MONEY_TBL_02";

			// con = DriverManager.getConnection(url, uid, upw);
			con = datasource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int custno = rs.getInt("CUSTNO");
				int salenol = rs.getInt("SALENOL");
				int pcost = rs.getInt("PCOST");
				int amount = rs.getInt("AMOUNT");
				int price = rs.getInt("PRICE");
				String pcode = rs.getString("PCODE");
				Date sdate = rs.getDate("SDATE");

				InquiryVO vo = new InquiryVO(custno, salenol, pcost, amount, price, pcode, sdate);
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

	public List<SalesVO> getSales() {
		List<SalesVO> vos = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT M.CUSTNO, CUSTNAME, CASE WHEN GRADE = 'A' THEN 'VIP' WHEN GRADE = 'B' THEN '일반' WHEN GRADE = 'C' THEN '직원' END AS GRADE, SUM(PRICE) AS SALES FROM MEM M, MONEY Y WHERE M.CUSTNO = Y.CUSTNO AND PRICE != 0 GROUP BY M.CUSTNO, CUSTNAME, GRADE ORDER BY SUM(PRICE) DESC";

			con = datasource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			SalesVO vo;
			while (rs.next()) {
				vo = new SalesVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setSales(rs.getInt("sales"));
				vos.add(vo);
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
		return vos;
	}
}
