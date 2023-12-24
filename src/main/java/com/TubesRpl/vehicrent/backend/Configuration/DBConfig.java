package com.TubesRpl.vehicrent.backend.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdc:mysql://localhost:3306/tubesrpl";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "daffaadit123";
    
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        try{
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException{
        if(connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
