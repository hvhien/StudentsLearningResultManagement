/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.Diem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hienhv
 */
public class CustomeTableSinhVien extends AbstractTableModel{
    
    // khai baó các cột của bảng
    private String name_cols[]={"Mã môn học","Tên môn học","Số tín chỉ","Học kỳ","Điểm số 1","Điểm số 2","Điểm thi","Số buổi nghỉ"};
    // khai báo kiểu dữ liệu của các cột
    private Class classes[]={String.class,String.class,Integer.class,Integer.class,float.class,float.class,float.class,Integer.class};
    // khởi tạo arraylist chứa thông tin kết quả môn học của sinh viên
    ArrayList<Diem> list=new ArrayList<Diem>();

    public CustomeTableSinhVien(ArrayList<Diem> arr) {
        this.list=arr;
    }
    
    
    
    //Lấy số phần tử của danh sách
    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return list.size();
    }
    //lấy số cột trong danh sách
    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return name_cols.length;
    }
    //push thông tin của danh sách lên table
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch(columnIndex){
            case 0: return list.get(rowIndex).getMonhoc().getMaMH();
            case 1: return list.get(rowIndex).getMonhoc().getTenMH();
            case 2: return list.get(rowIndex).getMonhoc().getSoTinChi();
            case 3: return list.get(rowIndex).getMonhoc().getHocKy();
            case 4: return list.get(rowIndex).getDiemHS1();
            case 5: return list.get(rowIndex).getDiemHS2();
            case 6: return list.get(rowIndex).getDiemThi();
            case 7: return list.get(rowIndex).getSoBuoiNghi();
            default: return null;
            
        }
    }
    //lấy vị trí của cột
    @Override
    public Class<?> getColumnClass(int columnIndex) {
//        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
//        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
        return name_cols[column];
    }
    
    
}
