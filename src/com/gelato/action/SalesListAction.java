package com.gelato.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gelato.db.*;

public class SalesListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		GelatoDAO dao = new GelatoDAO();
		List<MoneyDTO> sales = dao.getSales();
		request.setAttribute("sales", sales);
	}

}
