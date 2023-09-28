package dataAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DNArecord;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchByNameQuery {
	public static ObservableList<DNArecord> searchByName(String name) {
		ObservableList<DNArecord> dataList = FXCollections.observableArrayList();

		DatabaseConnection dbConnection = new DatabaseConnection("jdbc:mysql://127.0.0.1:3306/romp", "root", "");
		try {
			dbConnection.connect();
			String query = "SELECT * FROM relatives WHERE name1 = ?";

			
			ResultSet resultSet = dbConnection.executeQuery(query, name);

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String name1 = resultSet.getString("name1");
				int number1 = resultSet.getInt("number1");
				String filePath = resultSet.getString("file_path");
				String details = resultSet.getString("details");

				DNArecord record = new DNArecord(id, name1, number1, filePath, details);
				dataList.add(record);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}
}
