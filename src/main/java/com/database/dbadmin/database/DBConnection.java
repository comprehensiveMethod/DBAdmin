package com.database.dbadmin.database;

import java.sql.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DBConnection {
    public static final String url = "jdbc:postgresql://localhost:5432/book_store";
    public static String name;
    public static String password;
    private final Logger WARN_LOGGER = Logger.getLogger(DBConnection.class.getName());

    public DBConnection(String name, String password){
        WARN_LOGGER.setLevel(Level.WARNING);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        WARN_LOGGER.addHandler(handler);
        this.name = name;
        this.password = password;
    }

    public void checkConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(url,name,password);
        connection.close();
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,name,password);
    }




}
