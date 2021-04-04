package model.bo;

import java.util.ArrayList;

import model.bean.Article;
import model.dao.ShowManagePublishArDAO;

public class ShowManagePublishArBO {

	public ArrayList<Article> getPublishAr(String departUser) {
		ShowManagePublishArDAO showManagePublishArDAO = new ShowManagePublishArDAO();
		return showManagePublishArDAO.getPublishAr(departUser);
	}

}
