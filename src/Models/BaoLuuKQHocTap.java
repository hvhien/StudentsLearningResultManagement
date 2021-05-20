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
public class BaoLuuKQHocTap extends SinhVien{
    String LyDo;

    public BaoLuuKQHocTap() {
    }

    public BaoLuuKQHocTap(String LyDo, String MaSV, String TenSV, String NgaySinh, String GioiTinh, String DiaChi,String LopCoDinh) {
        super(MaSV, TenSV, NgaySinh, GioiTinh, DiaChi,LopCoDinh);
        this.LyDo = LyDo;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }

    
}
