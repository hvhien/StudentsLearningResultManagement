/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import connection.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hienhv
 */
public class adminControler extends DBConnect{
    static DBConnect conn=new DBConnect();
//    static Statement sta=null;
    static ResultSet res=null;
    public static Map<String,Object[]> getSinhVienCanXetTotNghiep(int tongtinchiYeuCau) throws SQLException{
        String sql="select SINHVIEN.MaSV,TenSV,TenMonHoc,SoTinChi,HocKy,DiemHS1,DiemHS2,DiemThi,SoBuoiVang  "
                    + "from DIEM inner join MONHOC on DIEM.MaMonHoc=MONHOC.MaMonHoc inner join SINHVIEN on DIEM.MaSV =SINHVIEN.MaSV";
//        List list=new ArrayList();
        Map<String,Object[]> map=new HashMap<String,Object[]>();
        
        Statement sta=conn.getStatement();
        res=conn.executeQuery(sql);
        while(res.next()){
            
            Object[] result=SinhvienControler.getTichLuy(res.getString("MaSV"));
            if((Float)result[1]>2.0 & (Integer)result[0]>=tongtinchiYeuCau){
                map.put(res.getString("MaSV"),result);
            }
            
        }
        return map;
    }
//    public static void main(String[] args) throws SQLException {
//        Map<String,Object[]> map=getSinhVienCanXetTotNghiep(6);
//        for(String key: map.keySet()){
//            System.out.println("masv:"+key+" co tong tin chi la "+map.get(key)[0]+" va co diem tic luy chun la "+map.get(key)[1]);
//        }
//    }
}
