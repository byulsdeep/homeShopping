package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.signdao.SignDAO;

public class UpdateCommand implements ShopCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String custno = request.getParameter("custno");
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		SignDAO dao = new SignDAO();
		int result = dao.update(custno, custname, phone, address, joindate, grade, city);

		String message = "회원정보수정이 실패하였습니다";
		if (result == 1)
			message = "회원정보수정이 완료 되었습니다!";

		request.setAttribute("message", message);
		
		new GetClientInfoCommand().execute(request, response);
	}
}
