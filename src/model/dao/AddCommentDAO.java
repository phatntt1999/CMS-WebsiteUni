package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCommentDAO extends BaseDAO {

	public String addcomment(String id_Comment, String ContentComment, String id_Author, String id_Articles) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Comment(id_Comment, ContentComment, id_Articles, id_Author) VALUES (?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id_Comment);
			pstmt.setString(2, ContentComment);
			pstmt.setString(3, id_Articles);
			pstmt.setString(4, id_Author);

			int x = pstmt.executeUpdate();
			System.out.println("Insert successful: " + x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return "No Error";
	}

	public String getLastestIDcomment() {
		String lastestIDcomment = null;
		Connection connection = getConnection();
		String sql = "SELECT TOP 1 id_Comment FROM Comment ORDER BY id_Comment DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				lastestIDcomment = rs.getString("id_Comment");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return lastestIDcomment;

	}
}