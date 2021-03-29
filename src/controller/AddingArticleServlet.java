package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bo.AddArticleBO;

/**
 * Servlet implementation class AddingArticleServlet
 */
@MultipartConfig
public class AddingArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddingArticleServlet() {
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

		HttpSession session = request.getSession();

		if (session.getAttribute("accountInfor") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
			AddArticleBO addArticleBO = new AddArticleBO();
			try (PrintWriter out = response.getWriter()) {
				Part part = request.getPart("fileUpload");
				String fileName = part.getSubmittedFileName();
				String path = getServletContext().getRealPath("/" + "Linkfile" + File.separator + fileName);
				// InputStream is = part.getInputStream();

				String userName = (String) session.getAttribute("userName");
				String articleName = request.getParameter("articleName");

				// Bắt Lỗi từ DAO gửi sang BO thông qua String
				String returnedMessage = addArticleBO.insertProduct(userName, articleName, fileName);

				RequestDispatcher rd = null;

				// Xét các trường hợp lỗi mà DAO gửi về
				if ("No error.".equals(returnedMessage)) { // Thêm mới thành công

					rd = request.getRequestDispatcher("ShowArticleServlet?message=2");

				} else if ("Duplicate ID Error".equals(returnedMessage)) {
					// Lỗi trùng mã hàng hóa

					rd = request.getRequestDispatcher("ShowAddingServlet?message=1");

				} else if ("Required Fields error.".equals(returnedMessage)) {
					// Lỗi thiếu thông tin các field bắt buộc nhập

					rd = request.getRequestDispatcher("ShowAddingServlet?message=3");
				} else

				if ("Invalid DGTK error.".equals(returnedMessage)) {
					rd = request.getRequestDispatcher("ShowAddingServlet?message=4");
				} else {
					// Lỗi không xác định

					rd = request.getRequestDispatcher("ShowAddingServlet?message=2");
				}
				rd.forward(request, response);
				
			} catch (Exception ex) {
				System.out.println(ex);
			}

		}

	}

}
