package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddArticleDAO extends BaseDAO {

	public String getLastestIdArticle() {

		String lastestId_Article = null;

		Connection connection = getConnection();
		String sql = "SELECT * FROM Articles where id_Articles = (select max(id_Articles) from Articles)";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				lastestId_Article = rs.getString("id_Articles");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return lastestId_Article;
	}

	public String getUserDepartment(String username) {
		String Department = null;

		Connection connection = getConnection();
		String sql = "SELECT * FROM AccountRole where AccUsername = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Department = rs.getString("Department");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return Department;
	}

	public String insertArticle(String lastestId_Article, String articleName, String id_Faculty, String id_Author,
			String id_Coordinator, boolean published, boolean isNow, String fileUpload, boolean statusComment) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Articles (id_Articles,ArticleName,id_Faculty"
				+ ",id_Author, id_Coordinator, Published, isNow, FileUpload, StatusComment) VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, lastestId_Article);
			pstmt.setString(2, articleName);
			pstmt.setString(3, id_Faculty);
			pstmt.setString(4, id_Author);
			pstmt.setString(5, id_Coordinator);
			pstmt.setBoolean(6, published);
			pstmt.setBoolean(7, isNow);
			pstmt.setString(8, fileUpload);
			pstmt.setBoolean(9, statusComment);
			

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record: " + x);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String errorMessage = e.getMessage();
			if (errorMessage != null && errorMessage.contains("Duplicate entry")) {
				return "Duplicate ID Error.";
			}
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return "No error.";
	}

}
