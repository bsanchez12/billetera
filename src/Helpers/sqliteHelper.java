/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class sqliteHelper {
    
    public Connection connect(){
      // SQLite connection string
        String url = "jdbc:sqlite:D://billetera.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void closeConnection(Connection conn)
    {  
        try {
            if(conn != null) {
                conn.close();
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
}
    
