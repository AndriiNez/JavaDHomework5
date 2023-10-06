package ua.homework.services;

import ua.homework.database.Database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class DatabaseInitService {
    private static final String PATH_INIT_DB_SQL = "./sql files/init_db.sql";

    public  void initService() {
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


