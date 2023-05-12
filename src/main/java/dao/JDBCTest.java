package dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    public static List <String> getAuthorNames() {
        List<String> authorNames = new ArrayList<>();

        try {
//        Establish Connnection
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/codeup_test_db?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "codeup"
            );
//            Create Statement
            Statement statement = connection.createStatement();
//            Execute statement
            ResultSet resultSet = statement.executeQuery("SELECT name FROM codeup_test_db.authors");
            while (resultSet.next()) {
                authorNames.add(resultSet.getString("name"));
            }
        } catch (SQLException sqlx) {
            sqlx.printStackTrace();
        }
        return authorNames;
    }

    public static void main(String[] args) {
        for (String name : getAuthorNames()){
            System.out.println(name);
        }
    }

}