package com.gelato.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gelato.db.*;

public class ListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		GelatoDAO dao = new GelatoDAO();		
		List<MemberDTO> members = dao.getMembers();
		request.setAttribute("members", members);
		
	}

}
