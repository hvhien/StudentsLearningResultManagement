/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.Diem;
import Models.Lop;
import Models.MonHoc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hienhv
 */
public class CustomTableSinhVienXemDiem2 extends AbstractTableModel{
    String names[]={"Học kỳ","Tổng tín chỉ theo kỳ","TBC học kỳ","Xét học bổng"};
    Class classes[]={Integer.class,Integer.class,float.class,String.class};
    ArrayList<Diem> list=new ArrayList<Diem>();

    public CustomTableSinhVienXemDiem2(ArrayList<Diem> arr) {
        this.list=arr;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getMonhoc().getHocKy();
            case 1: return 1;
            case 2: return list.get(rowIndex).getTongTBCTheoKy();
            default: return null;
        }
       
    }

    @Override
    public String getColumnName(int column) {
        return names[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
