package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCommentDAO extends BaseDAO {

	public String addcomment(String IDcomment, String ContentComment,String nameAccount, String proid) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Comments(IDcomment,ContentComment,nameAccount,MAHH) VALUES (?,?,?,?)";		
		
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, IDcomment);
			pstmt.setString(2, ContentComment);
			pstmt.setString(3, nameAccount);
			pstmt.setString(4, proid);
			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record: " + x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, null);
		}		
		return "no ERROR";		
	}
	public String getLastestIDcomment() {
		String lastestIDcomment = null;
		Connection connection = getConnection();
		String sql = "SELECT TOP 1 IDcomment FROM Comments ORDER BY IDcomment DESC";		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			if (rs.next()) {
				lastestIDcomment = rs.getString("IDcomment");
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