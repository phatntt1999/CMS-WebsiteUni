package model.bo;

import common.StringCommon;
import model.dao.AddCommentDAO;


public class AddCommentBO {
	AddCommentDAO addcommentDAO = new AddCommentDAO();
	public String addcoment( String ContentComment, String nameAccount, String Mahh) {
		
		String lastestIDComment = addcommentDAO.getLastestIDcomment();
		
		if(lastestIDComment == null) {
			lastestIDComment ="CM01";
		}
		else {
			long orderNumber = Long.valueOf(lastestIDComment.substring(2, 4));
			orderNumber++;
			lastestIDComment = "CM" + StringCommon.convertNumberToString(orderNumber, 2);
		}
		addcommentDAO.addcomment(lastestIDComment, ContentComment, nameAccount, Mahh);
		return lastestIDComment;
		
	}
}