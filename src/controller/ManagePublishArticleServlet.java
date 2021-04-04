package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ManagePublishArticleBO;

/**
 * Servlet implementation class ManagePublishArticleServlet
 */
public class ManagePublishArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagePublishArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String Arid = request.getParameter("ArId");
		String public1 = request.getParameter("Public");
		boolean Public = false;
		if (public1 == null) {
			Public = false;
		} else {
			Public = true;
		}
		ManagePublishArticleBO managePublishArticleBO = new ManagePublishArticleBO();
		managePublishArticleBO.PublishArticle(Arid, Public);

		response.sendRedirect("ShowManagePublishArServlet?message=1");
	}

}
