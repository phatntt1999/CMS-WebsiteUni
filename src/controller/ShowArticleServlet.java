package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Article;
import model.bo.CheckLoginBO;
import model.bo.ShowArticleBO;

/**
 * Servlet implementation class ShowArticleServlet
 */
public class ShowArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticleServlet() {
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
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			ShowArticleBO showProductListBO = new ShowArticleBO();
			
			
			int role = (int)session.getAttribute("role"); 
			String userName = (String)session.getAttribute("userName");
			/* String departUser = (String)session.getAttribute("departUser"); */
			
			String departUser = checkLoginBO.getDepartUser(userName);
			ArrayList<Article> listArticleUser = showProductListBO.getListArticleUser(departUser);
			ArrayList<Article> listArticle = showProductListBO.getListArticle();
			ArrayList<Article> listArticleAdmin = showProductListBO.getListArticleAdmin();
			RequestDispatcher rd = null;
			
			if(role == 1)	{
				request.setAttribute("listArticle", listArticleAdmin);
				rd = request.getRequestDispatcher("showListAdmin.jsp");
			} //Admin role
			else if (role == 2){
				request.setAttribute("listArticle", listArticle);
				rd = request.getRequestDispatcher("welcomeManager.jsp");
			} //Manager role
			else if (role == 3){
				request.setAttribute("listArticleUser", listArticleUser);
				rd = request.getRequestDispatcher("welcomeCoordinator.jsp");
			} //Coordinator role
			else if (role == 4){
				request.setAttribute("listArticle", listArticle);
				rd = request.getRequestDispatcher("welcomeGuest.jsp");
			} //Coordinator IT role
			else {
				request.setAttribute("listArticleUser", listArticleUser);
				rd = request.getRequestDispatcher("welcomeUser.jsp");
			} //Coordinator User role

			rd.forward(request, response);
		}
	}

}
