package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.inquirydao.InquiryDAO;

public class GetSalesCommand implements ShopCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("sales", new InquiryDAO().getSales());
	}
}
