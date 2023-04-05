package com.gelato.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gelato.db.*;

public class UpdateViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	    String custno = request.getParameter("custno");
	
		GelatoDAO dao = new GelatoDAO();		
		MemberDTO member = dao.getMember(custno);
		request.setAttribute("updateMember", member);
	}

}
