package dataAccess;

import java.sql.SQLException;

public class DeleteRelQuery {
	public static boolean deleteRelativeRecord(int id) {
		DatabaseConnection dbConnection = new DatabaseConnection("jdbc:mysql://127.0.0.1:3306/romp", "root", "");
		try {
			dbConnection.connect();

			String deleteSQL = "DELETE FROM relatives WHERE id = ?";

			int rowsAffected = dbConnection.executeUpdate(deleteSQL, id);

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}