/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author hienhv
 */
public class Lop {
    String MaLop;
    String TenLop;
    String KhoaHoc;

    public Lop() {
    }

    public Lop(String MaLop, String TenLop, String KhoaHoc) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
        this.KhoaHoc = KhoaHoc;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String KhoaHoc) {
        this.KhoaHoc = KhoaHoc;
    }
    
}
