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
		
		String accountInfor = null;
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		
		if(checkLoginBO.getAccountRole(userName, passWord) == INVALID_ACCOUNT)	{
			rd = request.getRequestDispatcher("login.jsp?error=2");
		}
		else if(checkLoginBO.getAccountRole(userName, passWord) == ADMIN_ACCOUNT)	{
			accountInfor = userName + " (admin)";
			session.setAttribute("accountInfor", accountInfor);
			rd = request.getRequestDispatcher("welcomeAdmin.jsp");
		}
		else if (checkLoginBO.getAccountRole(userName, passWord) == MANAGER_ACCOUNT){
			accountInfor = userName + " (manager)";
			session.setAttribute("accountInfor", accountInfor);	
			rd = request.getRequestDispatcher("welcomeManager.jsp");
		}
		else {
			accountInfor = userName + " (coordinator)";
			session.setAttribute("accountInfor", accountInfor);	
			rd = request.getRequestDispatcher("welcomeCoordinator.jsp");
		}
		
		rd.forward(request, response);
	}

}
