package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Comment;
import model.bean.Article;

public class showListCommentDAO extends BaseDAO {
	public ArrayList<Comment> getListComment(String arId) {

		ArrayList<Comment> returnedList = new ArrayList<Comment>();
		Connection connection = getConnection();
		String sql = "SELECT Comment.id_Comment, Comment.DateComment, Comment.ContentComment, Comment.id_Author, AccountRole.Avatar\r\n" + 
				"FROM Comment\r\n" + 
				"INNER JOIN AccountRole ON Comment.id_Author = AccountRole.AccUsername\r\n" + 
				"WHERE id_Articles = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, arId);
			rs = pstmt.executeQuery();

			Comment item = null;
			while (rs.next()) {
				item = new Comment();
				item.setid_Comment(rs.getString("id_Comment"));
				item.setDateComment(rs.getString("DateComment"));
				item.setContentComment(rs.getString("ContentComment"));
				item.setid_Author(rs.getString("id_Author"));
				item.setAvatarCommenter(rs.getString("Avatar"));
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

	public String getDateTime(String arId) {
		Connection connection = getConnection();
		String date = null;
		String sql = "SELECT Date_upload FROM Articles WHERE id_Articles =?";
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, arId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				date = rs.getString("Date_upload");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection, pstmt, rs);
		}
		return date;
	}

	public void BlockComment(String arId) {
		Connection connection = getConnection();
		String sql = "UPDATE Articles SET StatusComment = 0 WHERE id_Articles = ?";
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, arId);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Article> GetDetailArticle(String arId) {

		ArrayList<Article> returnedList = new ArrayList<Article>();
		Connection connection = getConnection();
		
		String sql = "SELECT Articles.id_Articles, Articles.ArticleName, Articles.id_Author, Articles.Date_upload, Articles.StatusComment, Articles.FileUpload, Articles.ArticleImage, AccountRole.Avatar FROM Articles INNER JOIN AccountRole ON Articles.id_Author = AccountRole.AccUsername WHERE id_Articles = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, arId);
			rs = pstmt.executeQuery();
			Article item = null;
			while (rs.next()) {
				item = new Article();
				item.setid_Articles(rs.getString("id_Articles"));
				item.setArticleName(rs.getString("ArticleName"));
				item.setId_Author(rs.getString("id_Author"));
				item.setDate_upload(rs.getString("Date_upload"));
				item.setStatusComment(rs.getBoolean("StatusComment"));
				item.setFileUpload(rs.getString("FileUpload"));
				item.setAvatarUser(rs.getString("Avatar"));
				item.setArImage(rs.getString("ArticleImage"));
				item.setCountHeart(CountHeart(arId));
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
	public int CountHeart(String arId) {
		int countHeart = 0;
		Connection connection = getConnection();
		String sql = "Select Count(StatusLike) as X from Favorite Where id_Articles=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, arId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				countHeart= rs.getInt("X");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return countHeart;
	}
}