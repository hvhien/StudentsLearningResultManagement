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
public class Diem{  
    SinhVien sinhvien;
    MonHoc monhoc;
    float DiemHS1;
    float DiemHS2;
    float DiemThi;

    public Diem() {
    }

    public Diem(SinhVien sinhvien, MonHoc monhoc, float DiemHS1, float DiemHS2, float DiemThi) {
        this.sinhvien = sinhvien;
        this.monhoc = monhoc;
        this.DiemHS1 = DiemHS1;
        this.DiemHS2 = DiemHS2;
        this.DiemThi = DiemThi;
    }

    public SinhVien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(SinhVien sinhvien) {
        this.sinhvien = sinhvien;
    }

    public MonHoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(MonHoc monhoc) {
        this.monhoc = monhoc;
    }

    public float getDiemHS1() {
        return DiemHS1;
    }

    public void setDiemHS1(float DiemHS1) {
        this.DiemHS1 = DiemHS1;
    }

    public float getDiemHS2() {
        return DiemHS2;
    }

    public void setDiemHS2(float DiemHS2) {
        this.DiemHS2 = DiemHS2;
    }

    public float getDiemThi() {
        return DiemThi;
    }

    public void setDiemThi(float DiemThi) {
        this.DiemThi = DiemThi;
    }
    
}
