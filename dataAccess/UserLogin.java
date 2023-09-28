package dataAccess;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
    private DatabaseConnection databaseConnection;

    public UserLogin(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean login(String username, String password) throws SQLException, NoSuchAlgorithmException {
        String hashedPassword = hashSHA1(password).trim();

        String query = "SELECT * FROM login WHERE username = ? AND passwd = ?";
        ResultSet resultSet = databaseConnection.executeQuery(query, username, hashedPassword);

        if (resultSet.next()) {
            return true; // Login successful
        } else {
            return false; // Login failed
        }
    }

    private String hashSHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] messageDigest = md.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}

