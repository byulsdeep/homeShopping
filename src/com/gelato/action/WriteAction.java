package com.gelato.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gelato.db.*;

public class WriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	    String custname = request.getParameter("custname");
	    String phone = request.getParameter("phone");
	    String address = request.getParameter("address");
	    String joindate = request.getParameter("joindate");
	    String grade = request.getParameter("grade");
	    String city = request.getParameter("city");
	    
		GelatoDAO dao = new GelatoDAO();
		if(dao.memberWrite(custname, phone, address, joindate, grade, city)) {
			System.out.println("등록 완료");
		};
	}

}
