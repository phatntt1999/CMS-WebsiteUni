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
		String sql = "SELECT * FROM Comment WHERE id_Articles = ?";
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
				item.setContentComment(rs.getString("ContentComment"));
				item.setid_Author(rs.getString("id_Author"));
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
		String sql = "SELECT * FROM Articles WHERE id_Articles = ?";
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
				item.setStatusComment(rs.getBoolean("StatusComment"));
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