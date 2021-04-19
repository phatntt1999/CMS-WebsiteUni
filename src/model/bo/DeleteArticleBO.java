package model.bo;

import model.dao.DeleteArticleDAO;

public class DeleteArticleBO {
	DeleteArticleDAO deleteArticleDAO = new DeleteArticleDAO();
	public void deleteProduct(String arId) {
		deleteArticleDAO.deleteProduct(arId);
	}

	public void deleteCommentOfProduct(String arId) {
		deleteArticleDAO.deleteCommentOfProduct(arId);
	}

}
