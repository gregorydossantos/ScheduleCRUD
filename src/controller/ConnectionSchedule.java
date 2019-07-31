package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSchedule {
    
    //Connection Method...
    public Connection getConnect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/schedule", "root", "");//Here we put the path to connect on DB with the user and password...
        } catch (Exception error){
            throw new RuntimeException("Error 1: " + error);
        }
    }
    
}
