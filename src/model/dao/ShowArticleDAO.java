package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import model.bean.Article;

public class ShowArticleDAO extends BaseDAO {

	public ArrayList<Article> getListArticle() {
		ArrayList<Article> returnedList = new ArrayList<Article>(); // Khoi tao ArrayList Article

		Connection connection = getConnection();
		String sql = "SELECT Articles.id_Articles, Articles.ArticleName, Articles.Date_upload, Articles.id_Author, Articles.id_Coordinator, Articles.FileUpload, Articles.ArticleImage, AccountRole.Avatar FROM Articles INNER JOIN AccountRole ON Articles.id_Author = AccountRole.AccUsername ORDER BY id_Articles DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Article item = null;

			while (rs.next()) {
				item = new Article();
				item.setid_Articles(rs.getString("id_Articles"));
				item.setArticleName(rs.getString("ArticleName"));
				item.setDate_upload(rs.getString("Date_upload"));
				item.setId_Author(rs.getString("id_Author"));
				item.setId_Coordinator(rs.getString("id_Coordinator"));
				item.setFileUpload(rs.getString("FileUpload"));
				item.setArImage(rs.getString("ArticleImage"));
				item.setAvatarUser(rs.getString("Avatar"));

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

	public ArrayList<Article> getListArticleUser(String departUser) {
		// TODO Auto-generated method stub
		ArrayList<Article> returnedList = new ArrayList<Article>(); // Khoi tao ArrayList Article

		Connection connection = getConnection();
		String sql = "SELECT * FROM Articles INNER JOIN AccountRole ON Articles.id_Author = AccountRole.AccUsername WHERE id_Faculty = ? ORDER BY id_Articles DESC";
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
				item.setDate_upload(rs.getString("Date_upload"));
				item.setId_Author(rs.getString("id_Author"));
				item.setId_Coordinator(rs.getString("id_Coordinator"));
				item.setFileUpload(rs.getString("FileUpload"));
				item.setArImage(rs.getString("ArticleImage"));
				item.setAvatarUser(rs.getString("Avatar"));

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
