package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteArticleDAO extends BaseDAO{

	public void deleteProduct(String arId) {
		Connection connection = getConnection();
		String sql = "DELETE FROM Articles WHERE id_Articles = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,arId);
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
