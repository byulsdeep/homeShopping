package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.signdao.SignDAO;

public class GetClientInfoCommand implements ShopCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("client", new SignDAO().getClientInfo(request.getParameter("custno")));
	}
}
