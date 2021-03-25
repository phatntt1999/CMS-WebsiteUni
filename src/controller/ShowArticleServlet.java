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
			ShowArticleBO showProductListBO = new ShowArticleBO();
			
			ArrayList<Article> listArticle = showProductListBO.getListArticle();
			//int totalPageNumber = showProductListBO.getTotalPageNumber();
			
			request.setAttribute("listArticle", listArticle);
			//request.setAttribute("currentPageNumer", pageNumber);
			//request.setAttribute("totalPageNumber", totalPageNumber);
			
			RequestDispatcher rd = null;
			rd = request.getServletContext()
					.getRequestDispatcher("/homePage.jsp");
			rd.forward(request, response);
		}
	}

}
