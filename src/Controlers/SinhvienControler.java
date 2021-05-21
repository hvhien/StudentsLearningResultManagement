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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    public static List<Map<Integer,Float>> KetQuaTheoKy() throws SQLException{
        
        List<Map<Integer,Float>> farther=new ArrayList();
        List tongtinchi=new ArrayList();
        String sql_1="select DISTINCT   HocKy  from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc where  MaSV='2018604963'";
        Statement sta=conn.getStatement();
        res=conn.getResultSet(sql_1);
        while(res.next()){
            String sql_2="select DIEM.MaMonHoc,TenMonHoc,SoTinChi,HocKy,DiemHS1,DiemHS2,DiemThi,SoBuoiVang  "
                        + "from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc where  MaSV='2018604963' and HocKy="+res.getInt("HocKy");
            res2=conn.getResultSet(sql_2);
            ArrayList<Diem> list=new ArrayList<Diem>();
            Map<Integer,Float> hm=new HashMap<Integer , Float>();
            int tongTinChi=0;
            float a=0;
            float result=0;
            while(res2.next()){
                tongTinChi+=res2.getInt("SoTinChi");
                Diem d=new Diem();
                d.setDiemHS1(res2.getFloat("DiemHS1"));
                d.setDiemHS2(res2.getFloat("DiemHS2"));
                d.setDiemThi(res2.getFloat("DiemThi"));
                a+=d.getTongTBCTheoKy();
                result=a/tongTinChi;
                hm.put(res.getInt("HocKy"), result);
                
                
            }
            tongtinchi.add(tongTinChi);
            
            farther.add(hm);
            
        }
        
        return farther;
        

    }
    public static List getTongTinChiTheoKy(String MaSV) throws SQLException{
        
        
        List tongtinchi=new ArrayList();
        String sql_1="select DISTINCT   HocKy  from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc where  MaSV='"+MaSV+"'";
        Statement sta=conn.getStatement();
        res=conn.getResultSet(sql_1);
        while(res.next()){
            String sql_2="select DIEM.MaMonHoc,TenMonHoc,SoTinChi,HocKy,DiemHS1,DiemHS2,DiemThi,SoBuoiVang  "
                        + "from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc where  MaSV='"+MaSV+"'"+" and HocKy="+res.getInt("HocKy");
            res2=conn.getResultSet(sql_2);
           
            int tongTinChi=0;
            
            while(res2.next()){
                tongTinChi+=res2.getInt("SoTinChi");
                
                
                
            }
            tongtinchi.add(tongTinChi);
            
            
            
        }
        
        return tongtinchi;
        

    }
    public static Object[] getTichLuy(String MaSV) throws SQLException{
        ArrayList<Diem> list=new ArrayList<Diem>();
        Object[] KetQua = new Object[2];
        Statement sta=conn.getStatement();

        String sql_2="select DIEM.MaMonHoc,TenMonHoc,SoTinChi,HocKy,DiemHS1,DiemHS2,DiemThi,SoBuoiVang  "
                    + "from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc where  MaSV='"+MaSV+"'";
        res2=conn.getResultSet(sql_2);

        int tongTinChi=0;
        float a=0;
        float result=0;
        int tinchi=0;
        while(res2.next()){
            tinchi=res2.getInt("SoTinChi");
            tongTinChi+=res2.getInt("SoTinChi");
            Diem d=new Diem();
            d.setDiemHS1(res2.getFloat("DiemHS1"));
            d.setDiemHS2(res2.getFloat("DiemHS2"));
            d.setDiemThi(res2.getFloat("DiemThi"));
            a+=(d.getTongTBCTheoKy()*tinchi);



        }
        result=a/tongTinChi;
        KetQua[0]=tongTinChi;
        KetQua[1]=result;



    return KetQua;
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
    
    public static void updateTinhTrangSinhVien(String sql) throws SQLException{
        Statement sta=conn.getStatement();
        conn.updateQuery(sql);
    }
   
}
