package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.signdao.SignDAO;

public class GetNextCustNoCommand implements ShopCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("nextCustNo", new SignDAO().getNextCustNo());
	}
}
