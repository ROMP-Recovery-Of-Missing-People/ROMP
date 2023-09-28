package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DNArecord;

public class GetRelativeQuery {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/romp";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	public static List<DNArecord> retrieveData() {
		List<DNArecord> data = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String query = "SELECT * FROM relatives";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String name = resultSet.getString("name1");
				int age = resultSet.getInt("number1");
				String relation = resultSet.getString("file_path");
				String address = resultSet.getString("details");

				DNArecord record = new DNArecord(id, name, age, relation, address);
				data.add(record);
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}