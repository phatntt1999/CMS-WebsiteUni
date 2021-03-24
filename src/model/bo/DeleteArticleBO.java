package model.bo;

import model.dao.DeleteArticleDAO;

public class DeleteArticleBO {

	public void deleteProduct(String arId) {
		DeleteArticleDAO deleteArticleDAO = new DeleteArticleDAO();
		deleteArticleDAO.deleteProduct(arId);
	}

}
