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
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sai trong connection cóntructor");
        }
    }
//    public Connection getConnection(){
//        try {
//            conn=DriverManager.getConnection(url);
//        } catch (SQLException ex) {
////            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("sai trong connection cóntructor");
//        }
//        return conn;
//    }
    public Statement getStatement() throws SQLException{
        this.sta=this.conn.createStatement();
        return this.sta;
    }
    public ResultSet executeQuery(String sql){
        try{
            this.res=getStatement().executeQuery(sql);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "sai thoong tin");
        }
        return this.res;
    }
    public ResultSet getResultSet(String sql) throws SQLException{
        ResultSet kq=null;
        Statement sta=conn.createStatement();
        kq=sta.executeQuery(sql);
        
        
        return kq;
    }
    
    
    
}
