/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Christian
 * This class manages connections to a MySQL database. You can connect to it and
 * execute querys and receive the results.
 */
public class DatabaseManager {
    
    private Connection myConnection;
    private Statement statement;
    private String host, user, pw, db;
    
    public DatabaseManager(String host, String user, String pw, String db) {
        //The constructor is taking the necessary information to connect to the
        //database
        this.host = host;
        this.user = user;
        this.pw = pw;
        this.db = db;
    }
    
    public boolean connect() {
        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pw);
            statement = myConnection.createStatement();
            return true;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean insert(String table, String columns[], String data[]) {
        //INSERT INTO table (column1, column2, column3) VALUES (value1, value2, value3)
        String query = "INSERT INTO " + table + " (";
        
        //Spalten einfügen
        int i = 1;
        for(String s : columns) {
            if(i++ == columns.length) {
                query += s;
            }
            else {
                query += s + ", ";
            }
        }
        
        //Daten einfügen
        query += ") VALUES (";
        i = 1;
        for(String s : data) {
            if(i++ == data.length) {
                query += s;
            }
            else {
                query += s + ", ";
            }
        }
        query += ")";
        System.out.println("query = " + query);
        return true;
    }
}
