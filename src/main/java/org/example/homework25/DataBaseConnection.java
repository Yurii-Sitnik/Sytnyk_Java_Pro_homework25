package org.example.homework25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/homework25";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "nk299359";
    private static Connection connection;


    public static Connection getConnection() throws SQLException {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с базой данных установлено");
            }
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера");
        }
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        DataBaseConnection.connection.close();
        if (DataBaseConnection.connection.isClosed()) {
            System.out.println("Соединение с базой данных закрыто");
        }
    }
}

