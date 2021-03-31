package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.AddCommentBO;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

		AddCommentBO addCommentBO = new AddCommentBO();

		String contentComment = request.getParameter("comment");
		String id_Author = request.getParameter("id_Author");
		String id_Article = request.getParameter("arId");

		String returnedMessage = addCommentBO.addcoment(contentComment, id_Author, id_Article);

		request.setAttribute("arId", id_Article);
		RequestDispatcher rd = null;

		if ("No Error".equals(returnedMessage)) {
			System.out.println("Add comment successful!");
			rd = request.getRequestDispatcher("ShowDetailArticleServlet?message=1");
			rd.forward(request, response);
		} else {
			System.out.println("Add comment not successful.");
			rd = request.getRequestDispatcher("ShowArticleServlet?message=1");

			rd.forward(request, response);
		}

	}

}
