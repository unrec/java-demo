package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseDemo {
    private static String url = "jdbc:mysql://localhost:3306/jdbc_test";
    private static Properties properties = new Properties();

    public static void main(String[] args) {
        // get driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // set properties
        properties.put("user", "root");
        properties.put("password", "root");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("serverTimezone", "Europe/Moscow");

        // print before update
        System.out.println("Before update:");
        printAllData();
        printAllData();

        // set random rating for random user
//        int userID = ThreadLocalRandom.current().nextInt(4);
//        int newRating = ThreadLocalRandom.current().nextInt(100);
//        System.out.println("\nSetting new rating " + newRating + " for user with id = " + userID);
//        updateRatingForUser(userID, newRating);

        // add new users with different approaches
//        System.out.println("\nTrying to add users... ");
//        addNewUserViaResultSet(5, "Timo", 38);
//        addNewUserViaPreparedStatement(6, "Roma", 79);

        // print after update
//        System.out.println("\nAfter update:");
//        printAllData();

        // call SQL procedure
//        final String SQL = "{call findbyid(?, ?)}";
//        System.out.println(runProcedure(SQL));

//        printMetaData();

    } // end of main

    private static void printAllData() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT user_id, user_name, rating FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int rating = resultSet.getInt(3);
                users.add(new User(id, name, rating));
            }
            users.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printMetaData() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT user_id, user_name, rating FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int rating = resultSet.getInt(3);
                users.add(new User(id, name, rating));
            }
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            System.out.println("Columns: " + rsMetaData.getColumnCount());
            System.out.println("2nd column name - " + rsMetaData.getColumnName(2));
            System.out.println("2nd column type name - " + rsMetaData.getColumnTypeName(2));
            System.out.println("2nd column is nullable - " + rsMetaData.isNullable(2));
            System.out.println();
            DatabaseMetaData dbMetaData = connection.getMetaData();
            System.out.println("DB User Name: " + dbMetaData.getUserName());
            System.out.println("DB URL: " + dbMetaData.getURL());
            System.out.println("DB Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("DB Product Version: " + dbMetaData.getDatabaseProductVersion());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateRatingForUser(int userID, int newRating) {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            String sql = "SELECT user_id, user_name, rating FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                if (id == userID) {
                    resultSet.updateInt("rating", newRating);
                    resultSet.updateRow();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addNewUserViaResultSet(int userID, String name, int rating) {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            String sql = "SELECT user_id, user_name, rating FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.moveToInsertRow();
            resultSet.updateInt("user_id", userID);
            resultSet.updateString("user_name", name);
            resultSet.updateInt("rating", rating);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addNewUserViaPreparedStatement(int userID, String name, int rating) {
        try (Connection connection = DriverManager.getConnection(url, properties)) {
            String sql = "INSERT INTO users (user_id, user_name, rating) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userID);
            statement.setString(2, name);
            statement.setInt(3, rating);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String runProcedure(String SQL) {
        try (Connection connection = DriverManager.getConnection(url, properties)) {
            CallableStatement statement = connection.prepareCall(SQL);
            statement.setInt(1, 1);
            statement.registerOutParameter(2, Types.VARCHAR);
//            statement.registerOutParameter(3, Types.INTEGER);
            statement.execute();
            return statement.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

} // end of class