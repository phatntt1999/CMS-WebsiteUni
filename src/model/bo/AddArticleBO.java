package model.bo;

import common.StringCommon;
import model.dao.AddArticleDAO;

public class AddArticleBO {
	AddArticleDAO addArticleDAO = new AddArticleDAO();

	String returnedString = null;
	String id_Faculty = null;
	String id_Author = null;
	String id_Coordinator = null;
	boolean Published = false;
	boolean isNow = true;
	boolean statusComment = true;

	public String getUserDepartment(String username) {

		String getUserDepartment = addArticleDAO.getUserDepartment(username);

		return getUserDepartment;
	}

	public String findid_CoordinatorProcess(String role) {

		return null;
	}

	public String insertProduct(String userName, String articleName, String fileUpload, String imageName) {
		// TODO Auto-generated method stub
		// Lặp tối đa 10 lần để xử lỗi trùng MaHH
		for (int i = 1; i <= 10; i++) {
			// Lấy mã HH mới nhất có trong DB
			String lastestId_Article = addArticleDAO.getLastestIdArticle();

			// Tách HH và số thứ tự ra riêng (eg: HH & 002)
			// Tăng số thứ tự lên 1
			// Gộp số thứ tự mới với HH lại với nhau.
			if (lastestId_Article == null) {
				lastestId_Article = "0000001";
			} else {
//						if(orderNumber >= 10 && orderNumber < 100) {
//							lastestMaHH = "HH0" + ++orderNumber;
//						}
//						else if(orderNumber > 0 && orderNumber < 10) {
//							lastestMaHH = "HH00" + ++orderNumber;
//						}
//						else {
//							orderNumber = Integer.valueOf(lastestMaHH.substring(2, 5));
//							lastestMaHH = "HH" + ++orderNumber;
//						}
				// Cách trên không mang tính tổng quát

				// Dùng thuật toán này trong Hàm StringCommon sẽ mang tinh tổng quát hơn
				long orderNumber = Long.valueOf(lastestId_Article);
				orderNumber++;
				lastestId_Article = StringCommon.convertNumberToString(orderNumber, 7);
			}

			id_Faculty = getUserDepartment(userName);
			id_Author = userName;

			if ("BIZ".equals(id_Faculty)) {
				id_Coordinator = "bizdepartment";
			} else if ("IT".equals(id_Faculty)) {
				id_Coordinator = "itdepartment";
			} else {
				id_Coordinator = "designdepartment";
			}

			// Truyền mã Article mới vào trong AddArticleDAO.insertArticle
			String returnedMessage = addArticleDAO.insertArticle(lastestId_Article, articleName, id_Faculty, id_Author,
					id_Coordinator, Published, isNow, fileUpload, statusComment, imageName);

			if ("Duplicate ID Error.".contentEquals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;
			} else if ("No error.".equals(returnedMessage)) {
				returnedString = "No error.";
				break;
			}
		}
		return returnedString;
	}
}
