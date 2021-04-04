package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoginDAO extends BaseDAO {

	public int getAccountRole(String userName, String passWord) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM AccountRole WHERE AccUsername = ? AND AccPassword = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, passWord);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if ("admin".equals(rs.getString("Rolekey"))) {
					return 1; // Admin
				} else if ("manager".equals(rs.getString("Rolekey"))) {
					return 2; // Manager
				} else if ("coordinator".equals(rs.getString("Rolekey"))) {
					return 3; // Coordinator
				} else if ("guest".equals(rs.getString("Rolekey"))) {
					return 4; // Guest
				} else { 
					return 5; // User
				}
			} else {
				return 0; // invalid account
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}

		return 0; // invalid account
	}
	
	public String getDepartUser(String userName) {
		String department = null;
		Connection connection = getConnection();
		String sql = "SELECT * FROM AccountRole WHERE AccUsername = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			
			rs.next();
			department = rs.getString("Department");
			System.out.print("department" + department);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return department;
	}


}
