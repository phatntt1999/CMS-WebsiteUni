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
import model.bo.ShowManagePublishArBO;

/**
 * Servlet implementation class ShowManagePublishArServlet
 */
public class ShowManagePublishArServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowManagePublishArServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("accountInfor") == null) {
		     	   response.sendRedirect("login.jsp?error=1");
		}
		
		else {
			ShowManagePublishArBO showManagePublishArBO = new ShowManagePublishArBO();
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			
			
			//int totalPageNumber = showProductListBO.getTotalPageNumber();
			String userName = (String)session.getAttribute("userName");
			String departUser = checkLoginBO.getDepartUser(userName);
			
			ArrayList<Article> publishArticle = showManagePublishArBO.getPublishAr(departUser);
			request.setAttribute("publicArticle", publishArticle);
			
			
			RequestDispatcher rd = null;
			rd = request.getServletContext()
					.getRequestDispatcher("/managePublishAr.jsp");
			rd.forward(request, response);
		}
	}

}
