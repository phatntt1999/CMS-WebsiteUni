package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HeartDAO extends BaseDAO{

	public boolean StatusHeart(String id_Author, String id_Article) {
		// TODO Auto-generated method stub
		boolean StatusHeart= false;
		Connection connection = getConnection();
		String sql = "Select StatusLike from Favorite Where AccUsername=? and id_Articles=?";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id_Author);
			pstmt.setString(2, id_Article);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				StatusHeart= rs.getBoolean("StatusLike");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return StatusHeart;
	}
	
	public String addLike(String id_Author, String id_Article) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		String sql = "INSERT INTO Favorite(AccUsername, id_Articles,StatusLike) VALUES (?,?,1)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
		
			pstmt.setString(1, id_Author);
			
			pstmt.setString(2, id_Article);
			
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
	public String deleteLike(String id_Author, String id_Article) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		String sql = "DELETE FROM  Favorite where AccUsername= ? and id_Articles = ? and StatusLike = 1";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, id_Author);
			
			pstmt.setString(2, id_Article);
			
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
	

}
