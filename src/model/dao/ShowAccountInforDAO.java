package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.AccountInfor;

public class ShowAccountInforDAO extends BaseDAO{

	public ArrayList<AccountInfor> getAccountInfor(String userName) {
		// TODO Auto-generated method stub
		ArrayList<AccountInfor> returnedList = new ArrayList<AccountInfor>(); // Khoi tao ArrayList Article

		Connection connection = getConnection();
		String sql = "SELECT AccountRole.NameUser, AccountRole.Email, AccountRole.Avatar, AccountRole.Department, Articles.id_Articles, Articles.Published, Articles.ArticleName, Articles.Date_upload \r\n" + 
				"FROM Articles\r\n" + 
				"INNER JOIN AccountRole ON Articles.id_Author = AccountRole.AccUsername \r\n" + 
				"where  AccountRole.AccUsername = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();

			AccountInfor item = null;

			while (rs.next()) {
				item = new AccountInfor();
				item.setNameUser(rs.getString("NameUser"));
				item.setEmail(rs.getString("Email"));
				item.setFaculty(rs.getString("Department"));
				item.setAvatar(rs.getString("Avatar"));
				item.setArticleName(rs.getString("ArticleName"));
				item.setDate_upload(rs.getString("Date_upload"));
				item.getPublished(rs.getBoolean("Published"));
				returnedList.add(item);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList; // invalid account
	}

	public int getAmountContributions(String userName) {
		// TODO Auto-generated method stub
		int returnedAmount = 0; // Khoi tao ArrayList Article

		Connection connection = getConnection();
		String sql = "Select COUNT(id_Articles) as AmountContributions\r\n" + 
				"from Articles\r\n" + 
				"where id_Author = ?";
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();

			rs.next();
			returnedAmount = rs.getInt("AmountContributions");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedAmount; // invalid account
	}

}
