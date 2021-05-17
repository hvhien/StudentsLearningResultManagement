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
public class TaiKhoan {
    String TenDangNhap;
    String MatKhau;
    String LoaiTaiKhoan;

    public TaiKhoan() {
    }

    public TaiKhoan(String TenDangNhap, String MatKhau, String LoaiTaiKhoan) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.LoaiTaiKhoan = LoaiTaiKhoan;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getLoaiTaiKhoan() {
        return LoaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String LoaiTaiKhoan) {
        this.LoaiTaiKhoan = LoaiTaiKhoan;
    }
    
}
