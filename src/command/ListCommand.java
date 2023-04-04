package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.signdao.SignDAO;
import vo.signvo.SignVO;

public class ListCommand implements ShopCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        SignDAO dao = new SignDAO();
        List<SignVO> voList = dao.clientList();

        request.setAttribute("client", voList);
    }
}
