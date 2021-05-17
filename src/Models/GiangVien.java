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
public class GiangVien {
    String MaGV;
    String TenGV;
    String email;
    String SDT;

    public GiangVien() {
    }

    public GiangVien(String MaGV, String TenGV, String email, String SDT) {
        this.MaGV = MaGV;
        this.TenGV = TenGV;
        this.email = email;
        this.SDT = SDT;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public String getTenGV() {
        return TenGV;
    }

    public void setTenGV(String TenGV) {
        this.TenGV = TenGV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}
