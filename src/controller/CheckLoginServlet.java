package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.CheckLoginBO;

/**
 * Servlet implementation class CheckLoginServlet
 */
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		
		final int INVALID_ACCOUNT = 0;
		final int ADMIN_ACCOUNT = 1;
		final int MANAGER_ACCOUNT = 2;
		final int COORDINATOR = 3;
		final int GUEST = 4;
		final int USER = 5;
		
		String accountInfor = null;
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		accountInfor = "Welcome! " + userName;
		String account = userName;
		/*
		 * String departUser = null; departUser = checkLoginBO.getDepartUser(userName);
		 */
		
		if(checkLoginBO.getAccountRole(userName, passWord) == INVALID_ACCOUNT)	{
			rd = request.getRequestDispatcher("login.jsp?error=2");
		} //Invalid account
		else if(checkLoginBO.getAccountRole(userName, passWord) == ADMIN_ACCOUNT)	{
			session.setAttribute("account", account);
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			session.setAttribute("role", ADMIN_ACCOUNT);
			rd = request.getRequestDispatcher("ShowArticleServlet");
		} //Admin role
		else if (checkLoginBO.getAccountRole(userName, passWord) == MANAGER_ACCOUNT){
			session.setAttribute("account", account);
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			session.setAttribute("role", MANAGER_ACCOUNT);
			rd = request.getRequestDispatcher("ShowArticleServlet");
		} //Manager role
		else if (checkLoginBO.getAccountRole(userName, passWord) == COORDINATOR){
			session.setAttribute("account", account);
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			session.setAttribute("role", COORDINATOR);
			rd = request.getRequestDispatcher("ShowArticleServlet");
		} //Coordinator role
		else if (checkLoginBO.getAccountRole(userName, passWord) == GUEST){
			session.setAttribute("account", account);
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			session.setAttribute("role", GUEST);
			rd = request.getRequestDispatcher("ShowArticleServlet");
		} //Coordinator IT role
		else {
			session.setAttribute("account", account);
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			session.setAttribute("role", USER);
			/* session.setAttribute("departUser", departUser); */
			rd = request.getRequestDispatcher("ShowArticleServlet");
		} //Coordinator User role
		
		rd.forward(request, response);
	}

}
