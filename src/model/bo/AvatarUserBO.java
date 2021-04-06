package model.bo;

import model.dao.AvatarUserDAO;

public class AvatarUserBO {
	AvatarUserDAO avatarUserDAO = new AvatarUserDAO();
	public String getAvatarUser(String userName) {
		// TODO Auto-generated method stub
		return avatarUserDAO.getAvatarUser(userName);
	}
	
}
