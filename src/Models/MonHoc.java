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
public class MonHoc {
    String MaMH;
    String TenMH;
    int SoTinChi;
    int HocKy;

    public MonHoc() {
    }

    public MonHoc(String MaMH, String TenMH, int SoTinChi, int HocKy) {
        this.MaMH = MaMH;
        this.TenMH = TenMH;
        this.SoTinChi = SoTinChi;
        this.HocKy = HocKy;
    }
    
}
