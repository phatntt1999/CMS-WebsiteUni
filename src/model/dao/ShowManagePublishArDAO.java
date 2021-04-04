package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import model.bean.Article;

public class ShowManagePublishArDAO extends BaseDAO{

	public ArrayList<Article> getPublishAr(String departUser) {
		ArrayList<Article> returnedPublic = new ArrayList<Article>(); // Khoi tao ArrayList Article

		Connection connection = getConnection();
		String sql = "Select * from Articles WHERE Published = 'FALSE' AND id_Faculty = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, departUser);
			rs = pstmt.executeQuery();

			Article item = null;

			while (rs.next()) {
				item = new Article();
				item.setid_Articles(rs.getString("id_Articles"));
				item.setArticleName(rs.getString("ArticleName"));
				item.setId_Faculty(rs.getString("id_Faculty"));
				item.setId_Author(rs.getString("id_Author"));
				item.setId_Coordinator(rs.getString("id_Coordinator"));

				returnedPublic.add(item);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedPublic;
	}

}
