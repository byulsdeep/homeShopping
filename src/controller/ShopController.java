package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ListCommand;
import command.ShopCommand;
import command.SignupCommand;

@WebServlet("*.do")
public class ShopController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShopController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        actionDO(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        actionDO(req, resp);
    }

    private void actionDO(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = null;
        ShopCommand cmd = null;

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String com = uri.substring(contextPath.length());


        if (com.equals("/list.do")) {
            cmd = new ListCommand();
            cmd.execute(req, resp);
            page = "/list.jsp";
        }
        else if (com.equals("/signup.do")) {
            cmd = new SignupCommand();
            cmd.execute(req, resp);
            page = "signup.jsp";
        } 
    }
}
