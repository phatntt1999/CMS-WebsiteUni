package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddArticleDAO extends BaseDAO{
	
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
}
