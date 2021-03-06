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

	public static final String SAVE_DIRECTORY = "Linkfile";

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
				
				part.write("E:\\Eclipse-PythonIDE\\Workplace\\WebBlogUni\\WebContent\\Linkfile\\"+fileName);

				Part partImage = request.getPart("imageUpload");
				String imageName = partImage.getSubmittedFileName();
				
				partImage.write("E:\\Eclipse-PythonIDE\\Workplace\\WebBlogUni\\WebContent\\Linkfile\\"+imageName);

				String userName = (String) session.getAttribute("userName");
				String articleName = request.getParameter("articleName");

				// B???t L???i t??? DAO g???i sang BO th??ng qua String
				String returnedMessage = addArticleBO.insertProduct(userName, articleName, fileName, imageName);

				RequestDispatcher rd = null;

				// X??t c??c tr?????ng h???p l???i m?? DAO g???i v???
				if ("No error.".equals(returnedMessage)) { // Th??m m???i th??nh c??ng

					rd = request.getRequestDispatcher("ShowArticleServlet?message=2");

				} else if ("Duplicate ID Error".equals(returnedMessage)) {
					// L???i tr??ng m?? h??ng h??a

					rd = request.getRequestDispatcher("ShowAddingServlet?message=1");

				} else if ("Required Fields error.".equals(returnedMessage)) {
					// L???i thi???u th??ng tin c??c field b???t bu???c nh???p

					rd = request.getRequestDispatcher("ShowAddingServlet?message=3");
				} else

				if ("Invalid DGTK error.".equals(returnedMessage)) {
					rd = request.getRequestDispatcher("ShowAddingServlet?message=4");
				} else {
					// L???i kh??ng x??c ?????nh

					rd = request.getRequestDispatcher("ShowAddingServlet?message=2");
				}
				rd.forward(request, response);

			} catch (Exception ex) {
				System.out.println(ex);
			}

		}

	}

}
