/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;
import  connection.DBConnect;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Diem;
import Views.login;
import Models.SinhVien;
import Models.MonHoc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author hienhv
 */
public class SinhvienControler extends DBConnect {
    static Statement sta = null;
    static ResultSet res = null;
    public static ArrayList KetQuaSinhVien(String sql) throws SQLException{
//        String url="select MaMonHoc,(select TenMonHoc from MONHOC where MaMonHoc=DIEM.MaMonHoc) as 'Ten mon hoc',(select SoTinChi from MONHOC where MaMonHoc=DIEM.MaMonHoc) as 'so tin chi',DiemHS1,DiemHS2,DiemThi,SoBuoiVang from DIEM where MaSV='"+login.Username+"'";
        ArrayList<Diem> list=new ArrayList<Diem>();
        
        DBConnect conn=new DBConnect();
        Statement sta=conn.getStatement();
        res=conn.executeQuery(sql);
        while(res.next()){
            SinhVien sv=new SinhVien();
            MonHoc mh=new MonHoc(res.getString("MaMonHoc"), res.getString("TenMonHoc"), res.getInt("SoTinChi"), res.getInt("HocKy"));
            
            Diem d=new Diem(sv, mh, res.getFloat("DiemHS1"),res.getFloat("DiemHS2"),res.getFloat("DiemThi"),res.getInt("SoBuoiVang"));
            list.add(d);
        }
        
        return list;
    }
}
