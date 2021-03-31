package model.bo;

import common.StringCommon;
import model.dao.AddCommentDAO;


public class AddCommentBO {
	AddCommentDAO addcommentDAO = new AddCommentDAO();
	public String addcoment( String contentComment, String id_Author, String id_Article) {
		
		String lastestIDComment = addcommentDAO.getLastestIDcomment();
		String returnedMessage = null;
		
		if(lastestIDComment == null) {
			lastestIDComment ="CM01";
		}
		else {
			long orderNumber = Long.valueOf(lastestIDComment.substring(2, 4));
			orderNumber++;
			lastestIDComment = "CM" + StringCommon.convertNumberToString(orderNumber, 2);
		}
		returnedMessage = addcommentDAO.addcomment(lastestIDComment, contentComment, id_Author, id_Article);
		
		return returnedMessage;
		
	}
}