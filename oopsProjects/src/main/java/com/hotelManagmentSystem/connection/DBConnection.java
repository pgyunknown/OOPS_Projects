package com.hotelManagmentSystem.connection;


import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/HotelManagmentSystem";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "pgyjavac";

//    public Connection getConnection(){
//        try{
//            Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            return connection;
//        }catch (Exception e){
//            System.err.println("Failed to connect to the database: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connection built");
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
        System.out.println("Connection closed");

    }
}
