/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Objects;

/**
 *
 * @author hienhv
 */
public class TaiKhoan {
    String TenDangNhap;
    String MatKhau;
    int LoaiTaiKhoan;

    public TaiKhoan() {
    }

    public TaiKhoan(String TenDangNhap, String MatKhau) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public TaiKhoan(String TenDangNhap, String MatKhau, int LoaiTaiKhoan) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.LoaiTaiKhoan = LoaiTaiKhoan;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.TenDangNhap);
        hash = 53 * hash + Objects.hashCode(this.MatKhau);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoan other = (TaiKhoan) obj;
        if (!Objects.equals(this.TenDangNhap, other.TenDangNhap)) {
            return false;
        }
        if (!Objects.equals(this.MatKhau, other.MatKhau)) {
            return false;
        }
        return true;
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

    public int getLoaiTaiKhoan() {
        return LoaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(int LoaiTaiKhoan) {
        this.LoaiTaiKhoan = LoaiTaiKhoan;
    }

    @Override
    public String toString() {
       return "TaiKhoan{" + "tenTaiKhoan=" + TenDangNhap + ", matKhau=" + MatKhau + ", quyen=" + LoaiTaiKhoan + '}';
    }
    
    
}
