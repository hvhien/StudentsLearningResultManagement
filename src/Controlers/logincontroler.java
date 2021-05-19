/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Models.TaiKhoan;
import connection.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hienhv
 */
public class logincontroler {
    DBConnect conn=new DBConnect();
    public ArrayList<TaiKhoan> showTaiKhoan() throws SQLException{
        ArrayList<TaiKhoan> list=new ArrayList<TaiKhoan>();
        ResultSet res=null;
        String sql="Select * from TAIKHOAN";
        res=conn.getResultSet(sql);
        while(res.next()){
            TaiKhoan tk=new TaiKhoan(res.getString(1).trim(), res.getString(2),res.getInt(4));
            list.add(tk);
        }
        return list;
    }
    
    
}
