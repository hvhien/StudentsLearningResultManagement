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
import java.util.Iterator;
/**
 *
 * @author hienhv
 */
public class SinhvienControler extends DBConnect {
    static DBConnect conn=new DBConnect();
//    static Statement sta = null;
    static ResultSet res = null;
    static ResultSet res2 = null;
    public static ArrayList KetQuaSinhVien(String sql) throws SQLException{
//        String url="select MaMonHoc,(select TenMonHoc from MONHOC where MaMonHoc=DIEM.MaMonHoc) as 'Ten mon hoc',(select SoTinChi from MONHOC where MaMonHoc=DIEM.MaMonHoc) as 'so tin chi',DiemHS1,DiemHS2,DiemThi,SoBuoiVang from DIEM where MaSV='"+login.Username+"'";
        ArrayList<Diem> list=new ArrayList<Diem>();
        
        
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
    public static ArrayList KetQuaTheoKy(String sql) throws SQLException{
        
        ArrayList farther=new ArrayList();
        String sql_1="select DISTINCT   HocKy  from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc where  MaSV='2018604963'";
        Statement sta=conn.getStatement();
        res=conn.getResultSet(sql_1);
        while(res.next()){
            String sql_2="select DIEM.MaMonHoc,TenMonHoc,SoTinChi,HocKy,DiemHS1,DiemHS2,DiemThi,SoBuoiVang  "
                        + "from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc where  MaSV='2018604963' and HocKy="+res.getInt("HocKy");
            res2=conn.getResultSet(sql_2);
            ArrayList<Diem> list=new ArrayList<Diem>();
            while(res2.next()){
                
                Diem d=new Diem();
                d.setDiemHS1(res2.getFloat("DiemHS1"));
                d.setDiemHS2(res2.getFloat("DiemHS2"));
                d.setDiemThi(res2.getFloat("DiemThi"));
                list.add(d);
                
            }
            farther.add(list);
            
        }
        
        return farther;
        

    }
    public static SinhVien getInforSinhVien(String sql) throws SQLException{
        SinhVien sv=new SinhVien();
        Statement sta=conn.getStatement();
        res=conn.executeQuery(sql);
        while(res.next()){
            sv.setTenSV(res.getString("TenSV"));
            sv.setNgaySinh(res.getString("NgaySinh"));
            sv.setGioiTinh(res.getString("GioiTinh"));
            sv.setDiaChi(res.getString("DiaChi"));
            sv.setLopCoDinh(res.getString("MaLop"));
        }
        return sv;
    }
    public static void main(String[] args) throws SQLException {
        ArrayList listMom=KetQuaTheoKy("");
        Iterator it=listMom.iterator();
        int i=0;
        while(it.hasNext()){
            System.out.println("đây là hoc ki thu"+i++);
            ArrayList<Diem> list=(ArrayList<Diem>) it.next();
            Iterator<Diem>it2=list.iterator();
            while(it2.hasNext()){
                Diem next=it2.next();
                System.out.println(next.getTongTBCTheoKy());
                
            }
        }
        
    }
    
}
