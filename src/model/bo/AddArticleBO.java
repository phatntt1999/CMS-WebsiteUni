package model.bo;

import common.StringCommon;
import model.dao.AddArticleDAO;

public class AddArticleBO {
	AddArticleDAO addArticleDAO = new AddArticleDAO();

	public String insertProduct(String role, String articleName, String dateUpload, String fileUpload) {
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
			String returnedString = null;
			String id_Faculty = null;
			String id_Author = null;
			String id_Coordinator = null;
			int Published = 0;
			int isNow = 1;
			// Truyền mã hàng hóa mới vào trong CreateProductDAO.insertProduct
			String returnedMessage = AddArticleDAO.insertProduct
					(lastestId_Article, articleName, dateUpload, 
							id_Faculty, id_Author, id_Coordinator, Published, isNow,fileUpload);

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
