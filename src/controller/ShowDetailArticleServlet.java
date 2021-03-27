package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Comment;
import model.bean.Article;
import model.bo.showListCommentBO;

/**
 * Servlet implementation class ShowProductListServlet
 */
public class ShowDetailArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDetailArticleServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("text/html; charset=UTF-8");

		HttpSession session = request.getSession();

		String arId = request.getParameter("arId");
		showListCommentBO showCommentBO = new showListCommentBO();

		ArrayList<Article> detailArticle = showCommentBO.GetDetailArticle(arId);
		request.setAttribute("detailArticle", detailArticle);

		ArrayList<Comment> listComment = showCommentBO.getListComment(arId);
		request.setAttribute("listComment", listComment);

		/* String proid = proId ; */
		//session.setAttribute("arId", arId);

		long checkday = 0;
		checkday = showCommentBO.CheckDay(arId);

		session.setAttribute("checkday", checkday);

		if (checkday >= 14) {
			showCommentBO.BlockComment(arId);
		}

		RequestDispatcher rd = request.getRequestDispatcher("detailArticle.jsp");
		rd.forward(request, response);
	}

}