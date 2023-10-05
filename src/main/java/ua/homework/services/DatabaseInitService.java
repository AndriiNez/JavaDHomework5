package ua.homework.services;

import ua.homework.database.Database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class DatabaseInitService {
    private static final String PATH_INIT_DB_SQL = "./sql files/init_db.sql";

    public static void main(String[] args) {
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(PATH_INIT_DB_SQL)));
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);


            pst.executeUpdate();


            pst.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


