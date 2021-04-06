package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvatarUserDAO extends BaseDAO{

	public String getAvatarUser(String userName) {
		// TODO Auto-generated method stub
				String avatar = null;

				Connection connection = getConnection();
				String sql = "SELECT Avatar FROM AccountRole WHERE AccUserName = ?";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, userName);
					rs = pstmt.executeQuery();

					
					rs.next();
					avatar = rs.getString("Avatar");
					
					return avatar;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					closeConnection(connection, pstmt, rs);
				}
				return avatar;
	}

}
