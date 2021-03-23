package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import model.bean.Article;

public class ShowArticleDAO extends BaseDAO{

	public ArrayList<Article> getListArticle() {
		ArrayList<Article> returnedList = new ArrayList<Article>(); //Khoi tao ArrayList Article
		
		Connection connection = getConnection();
		String sql = "SELECT * FROM Articles";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			Article item = null;
			
			while(rs.next())
			{
				item = new Article();
				item.setid_Articles(rs.getString("id_Articles"));
				item.setArticleName(rs.getString("ArticleName"));
				item.setDate_upload(rs.getString("Date_upload"));
				item.setId_Author(rs.getString("id_Author"));
				item.setId_Coordinator(rs.getString("id_Coordinator"));
				
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

}
