/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author ralu
 */

public class Conn {
   private String jbdcURL;
   private String user;
   private String password;
   private Connection connection;

    public Conn() {
        this.connection = null;
    }
    
    public Connection getConnPostgresql() {
        this.jbdcURL = "jdbc:postgresql://localhost:5432/toDoList";
        this.user = "postgres";
        this.password = "root";
        
        try {
            this.connection = DriverManager.getConnection(
                    this.jbdcURL, this.user, this.password
            );
            
        } catch(SQLException e) {
            System.err.println(e);
        }
        
        return connection;
    }
    
    /**
     *
     * @return connection
     */
    
    public Connection getConnMysql() {
        this.jbdcURL = "jdbc:mysql://localhost:3306/toDoList";
        this.user = "root";
        this.password = "";
        
        try {
            this.connection = DriverManager.getConnection(
                    this.jbdcURL, this.user, this.password
            );
            
        } catch(SQLException e) {
            System.err.println(e);
        }
        
        return connection;
    }
}
