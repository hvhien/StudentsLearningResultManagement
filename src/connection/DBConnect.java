/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import Views.url;
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
    String url_View=url.urlText;
    
    
    Statement sta=null;
     Connection conn=null;
    ResultSet res=null;
    String urltxt="jdbc:sqlserver://localhost;databaseName=QL_diem_SV;user=sa;password=123";

    public DBConnect() {
        try {
            if(!url_View.isEmpty()){
                conn=DriverManager.getConnection(url_View);
            }else{
                conn=DriverManager.getConnection(urltxt);
            }
            
        } catch (SQLException ex) {
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Sai thông tin url sql","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

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
    public void updateQuery(String sql) throws SQLException{
        Statement sta=conn.createStatement();
        sta.executeUpdate(sql);
    }
    
    
    
}
