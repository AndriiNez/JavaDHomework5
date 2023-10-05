package ua.homework.services;

import ua.homework.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    private static final String PATH_POPULATE_DB_SQL = "./sql files/populate_db.sql";

    public static void main(String[] args) {
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(PATH_POPULATE_DB_SQL)));
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);


            pst.executeUpdate();


            pst.close();
            conn.close();


        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
