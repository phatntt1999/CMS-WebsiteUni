package model.bo;

import model.dao.CheckLoginDAO;

public class CheckLoginBO {

	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	
	public int getAccountRole(String userName, String passWord) {
		return checkLoginDAO.getAccountRole(userName, passWord);
	}

	
}
