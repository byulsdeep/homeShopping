package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.signdao.SignDAO;

public class SignupCommand implements ShopCommand {
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
        dao.signup(custno, custname, phone, address, joindate, grade, city);
    }
}
