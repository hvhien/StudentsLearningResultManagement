/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hienhv
 */
public class getConnection {
    static String url="jdbc:sqlserver://localhost;databaseName=btlJava;user=sa;password=123";
    public static Connection GetConnection() throws SQLException{
        Connection conn=DriverManager.getConnection(url);
        if(conn!=null){
            return conn;
        }
        else{
            JOptionPane.showMessageDialog(null, "Connection fail","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return conn;
    }
    
}
