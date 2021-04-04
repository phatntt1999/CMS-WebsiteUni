package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagePublishArticleDAO extends BaseDAO{
	public void PublishArticle(String Arid, boolean Public) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		String sql = "UPDATE Articles SET Published = ? WHERE id_Articles = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setBoolean(1, Public);
			pstmt.setString(2,Arid);
			
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, null);
		}
		
	}
}


	

