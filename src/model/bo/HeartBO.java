package model.bo;

import model.dao.HeartDAO;

public class HeartBO {
	HeartDAO heartDAO= new HeartDAO();
	public boolean StatusHeart(String id_Author,String id_Article)
	{
		 return heartDAO.StatusHeart(id_Author,id_Article);
	}
	public void addLike(String id_Author, String id_Article) {
		// TODO Auto-generated method stub
		heartDAO.addLike(id_Author,id_Article);
	}
	public void deleteLike(String id_Author, String id_Article) {
		// TODO Auto-generated method stub
		heartDAO.deleteLike(id_Author,id_Article);
	}
}
