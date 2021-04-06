package model.bo;

import java.util.ArrayList;

import model.bean.AccountInfor;
import model.dao.ShowAccountInforDAO;

public class ShowAccountInforBO {
	ShowAccountInforDAO showAccountInforDAO = new ShowAccountInforDAO();
	public ArrayList<AccountInfor> getAccountInfor(String userName) {
		// TODO Auto-generated method stub
		ArrayList<AccountInfor> returnedList = showAccountInforDAO.getAccountInfor(userName);
		return returnedList;
	}

	public int getAmountContributions(String userName) {
		// TODO Auto-generated method stub
		int amountContribution = showAccountInforDAO.getAmountContributions(userName);
		return amountContribution;
	}
	

}
