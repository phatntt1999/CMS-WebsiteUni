package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.HeartBO;
import model.dao.showListCommentDAO;

/**
 * Servlet implementation class HeartServlet
 */
@WebServlet("/HeartServlet")
public class HeartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeartServlet() {
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
		String id_Author = request.getParameter("auId");
		String id_Article = request.getParameter("arId");
		HeartBO heartBO = new HeartBO();
		
		/*
		 * boolean Heartstatus=heartBO.StatusHeart(id_Author,id_Article);
		 * request.setAttribute("heartstatus", Heartstatus);
		 */
		if(heartBO.StatusHeart(id_Author,id_Article)==true) {
			heartBO.deleteLike(id_Author,id_Article);
			
		}
		else {
			heartBO.addLike(id_Author,id_Article);
		}
		showListCommentDAO showlist = new showListCommentDAO();
		int x =showlist.CountHeart(id_Article);
		try(PrintWriter out = response.getWriter()){
			out.print(x);
		}
		
	}
	

}
