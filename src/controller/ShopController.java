package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.GetClientInfoCommand;
import command.GetNextCustNoCommand;
import command.GetSalesCommand;
import command.ListCommand;
import command.ShopCommand;
import command.SignupCommand;
import command.UpdateCommand;

@WebServlet({"*.do"})
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
		String page = "view/index.jsp";
		ShopCommand cmd = null;

		req.setCharacterEncoding("UTF-8");

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String com = uri.substring(contextPath.length());

		if (com.equals("/list.do")) {
			cmd = new ListCommand();
			cmd.execute(req, resp);
			page = "view/list.jsp";
		} else if (com.equals("/signup.do")) {
			cmd = new SignupCommand();
			cmd.execute(req, resp);
			page = "/moveSignUp.do";
		} else if (com.equals("/moveSignUp.do")) {
			cmd = new GetNextCustNoCommand();
			cmd.execute(req, resp);
			page = "view/signup.jsp";
		} else if (com.equals("/moveUpdate.do")) {
			cmd = new GetClientInfoCommand();
			cmd.execute(req, resp);
			page = "view/update.jsp";
		} else if (com.equals("/update.do")) {
			cmd = new UpdateCommand();
			cmd.execute(req, resp);
			page = "moveUpdate.do";
		} else if (com.equals("/sales.do")) {
			cmd = new GetSalesCommand();
			cmd.execute(req, resp);
			page = "view/sales.jsp";
		} else if (com.equals("/home.do")) {
			page = "view/index.jsp";
		} 
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
	}
}
