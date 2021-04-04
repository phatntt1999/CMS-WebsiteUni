package model.bo;

import model.dao.ManagePublishArticleDAO;

public class ManagePublishArticleBO {
	ManagePublishArticleDAO managePublishArticleDAO = new ManagePublishArticleDAO();

	public void PublishArticle(String Arid, boolean Public) {
		managePublishArticleDAO.PublishArticle(Arid, Public);
	}
}
