package com.gelato.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gelato.action.*;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Action action = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length()+5);
			
		if(com.equals("/list.do")) {
			System.out.println("/list.do");
			action = new ListAction();
			action.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/write.do")) {
			System.out.println("/write.do");
			action = new WriteAction();
			action.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/update.do")) {
			System.out.println("/update.do");
			action = new UpdateViewAction();
			action.execute(request, response);
			viewPage = "update.jsp";
		}else if(com.equals("/modify.do")) {
			System.out.println("/modify.do");
			action = new UpdateAction();
			action.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/sales.do")) {
			System.out.println("/sales.do");
			action = new SalesListAction();
			action.execute(request, response);
			viewPage = "sales.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
