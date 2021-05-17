/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hienhv
 */
public class DBConnect {

    
    
    Statement sta=null;
     Connection conn=null;
    ResultSet res=null;
    String url="jdbc:sqlserver://localhost;databaseName=QL_diem_SV;user=sa;password=123";
//    public static Connection GetConnection() throws SQLException{
//        
//        if(conn!=null){
//            return conn;
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "Connection fail","ERROR",JOptionPane.ERROR_MESSAGE);
//            
//        }
//        return conn;
//    }
    public DBConnect() {
        try {
            conn=DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Statement getStatement() throws SQLException{
        if(this.sta==null || this.sta.isClosed()){
            this.sta=this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
        }
        return this.sta;
    }
    public ResultSet executeQuery(String sql){
        try{
            this.res=getStatement().executeQuery(sql);
            
        }catch(Exception e){
            e.getMessage();
        }
        return this.res;
    }
    
    
    
}
