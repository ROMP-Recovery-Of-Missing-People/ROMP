package dataAccess;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.AlertBoxCtrl;
import model.DNArecord;

public class InsertRelativeQuery {
    public static int insertRelativesData(DNArecord record, File selectedFile) {
        DatabaseConnection dbConnection = new DatabaseConnection("jdbc:mysql://127.0.0.1:3306/romp", "root", "");
        try {
            dbConnection.connect();
            String sql = "INSERT INTO relatives(name1, number1, file_path, details) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, record.getName());
            preparedStatement.setInt(2, record.getNumber());
            preparedStatement.setString(3, record.getDNA());
            preparedStatement.setString(4, record.getDetails());
            
            int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					
					int id = generatedKeys.getInt(1);
                    
					try {
						Files.copy(selectedFile.toPath(), Paths.get("C:\\Users\\SS\\OneDrive\\Desktop\\ROMP\\ROMP\\src\\dataAccess\\rompdb\\relatives\\"+id+".txt"), StandardCopyOption.COPY_ATTRIBUTES);
					} catch (IOException e) {
						AlertBoxCtrl alert = new AlertBoxCtrl(e.getLocalizedMessage(),e.getLocalizedMessage());
						alert.show();
					}

					String updateFilePathQuery = "UPDATE relatives SET file_path = ? WHERE id = ?";
                    int updateSuccessful = dbConnection.executeUpdate(updateFilePathQuery, id + ".txt", id);
                    
                    dbConnection.close();
					return updateSuccessful;
				}
			}
			dbConnection.close();
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
    }
}