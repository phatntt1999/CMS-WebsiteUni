package model.bo;

import java.util.ArrayList;

import model.bean.Article;
import model.dao.ShowArticleDAO;

public class ShowArticleBO {
	
	ShowArticleDAO showArticleDAO = new ShowArticleDAO();

	public ArrayList<Article> getListArticle() {	
		return showArticleDAO.getListArticle();
	}

}
