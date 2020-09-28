package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {

        // get driver - preferable way
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
////         option 2.1
//        try {
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        } catch (SQLException e) {
//            System.out.println("Unable to load driver class.");
//            e.printStackTrace();
//        }
////         option 2.2
//        try {
//            Driver driver = new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {
//            System.out.println("Unable to load driver class.");
//            e.printStackTrace();
//        }

        // get connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&serverTimezone=Europe/Moscow", "root", "root");
            if (!connection.isClosed()) System.out.println("Connection is OK.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}