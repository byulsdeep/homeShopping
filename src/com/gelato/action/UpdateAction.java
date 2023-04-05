package com.gelato.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gelato.db.*;

public class UpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	    String custno = request.getParameter("custno");
	    String custname = request.getParameter("custname");
	    String phone = request.getParameter("phone");
	    String address = request.getParameter("address");
	    String joindate = request.getParameter("joindate");
	    String grade = request.getParameter("grade");
	    String city = request.getParameter("city");
	
		GelatoDAO dao = new GelatoDAO();		
		if(dao.modifyMember(custno, custname, phone, address, joindate, grade, city)) {
			System.out.println("수정 완료");
		};
		
	}

}
