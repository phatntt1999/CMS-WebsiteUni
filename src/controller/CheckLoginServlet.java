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
		final int COORDINATORBIZ = 3;
		final int COORDINATORIT = 4;
		final int COORDINATORDS = 5;
		
		String accountInfor = null;
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		accountInfor = "Welcome! " + userName;
		
		if(checkLoginBO.getAccountRole(userName, passWord) == INVALID_ACCOUNT)	{
			rd = request.getRequestDispatcher("login.jsp?error=2");
		} //Invalid account
		else if(checkLoginBO.getAccountRole(userName, passWord) == ADMIN_ACCOUNT)	{
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			rd = request.getRequestDispatcher("welcomeAdmin.jsp");
		} //Admin role
		else if (checkLoginBO.getAccountRole(userName, passWord) == MANAGER_ACCOUNT){
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			rd = request.getRequestDispatcher("ShowArticleServlet");
		} //Manager role
		else if (checkLoginBO.getAccountRole(userName, passWord) == COORDINATORBIZ){
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			rd = request.getRequestDispatcher("welcomeCoordinator.jsp");
		} //Coordinator Business role
		else if (checkLoginBO.getAccountRole(userName, passWord) == COORDINATORIT){
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			rd = request.getRequestDispatcher("welcomeCoordinator.jsp");
		} //Coordinator IT role
		else if (checkLoginBO.getAccountRole(userName, passWord) == COORDINATORDS){
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			rd = request.getRequestDispatcher("welcomeCoordinator.jsp");
		} //Coordinator Design role
		else {
			session.setAttribute("accountInfor", accountInfor);
			session.setAttribute("userName", userName);
			rd = request.getRequestDispatcher("welcomeUser.jsp");
		} //Coordinator Design role
		
		rd.forward(request, response);
	}

}
