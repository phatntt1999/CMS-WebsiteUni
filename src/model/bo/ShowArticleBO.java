package model.bo;

import java.util.ArrayList;

import model.bean.Article;
import model.dao.ShowArticleDAO;

public class ShowArticleBO {
	
	ShowArticleDAO showArticleDAO = new ShowArticleDAO();

	public ArrayList<Article> getListArticle() {	
		return showArticleDAO.getListArticle();
	}

	public ArrayList<Article> getListArticleUser(String departUser) {
		// TODO Auto-generated method stub
		return showArticleDAO.getListArticleUser(departUser);
	}

}
