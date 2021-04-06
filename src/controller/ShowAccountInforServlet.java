package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.AccountInfor;
import model.bo.ShowAccountInforBO;


/**
 * Servlet implementation class ShowAccountInforServlet
 */
public class ShowAccountInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAccountInforServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("accountInfor") == null) {
		     	   response.sendRedirect("login.jsp?error=1");
		}
		
		else {
			String userName = (String)session.getAttribute("userName");
			
			ShowAccountInforBO showAccountInforBO = new ShowAccountInforBO();
			ArrayList<AccountInfor> accountInfor = showAccountInforBO.getAccountInfor(userName);
			int amountContribution = showAccountInforBO.getAmountContributions(userName);
			
			
			request.setAttribute("AccInfor", accountInfor);
			request.setAttribute("AmountContribution", amountContribution);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("accountInfor.jsp");

			rd.forward(request, response);
		}
	}

}
