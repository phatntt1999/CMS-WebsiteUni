package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SendEmailDAO extends BaseDAO {

	public String SelectAccout(String accId) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		String sql = "Select * FROM AccountRole WHERE AccUsername = ? ";
		PreparedStatement pstmt = null;
		String Email = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accId);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
								
				Email= rs.getString("Email");

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return Email;
	}

	
}
