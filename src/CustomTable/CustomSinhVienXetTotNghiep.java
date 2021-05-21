/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hienhv
 */
public class CustomSinhVienXetTotNghiep extends AbstractTableModel{
    String names[]={"Mã sinh viên","Tên sinh viên","Điểm tích lũy","Số tín chỉ hoàn thành"};
    Class classes[]={String.class,String.class,Float.class,Integer.class};
    Map<String,Object[]> map=new HashMap<String,Object[]>();
    public CustomSinhVienXetTotNghiep(Map<String,Object[]> map) {
        this.map=map;
    }
    
    @Override
    public int getRowCount() {
        return map.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    
    public static DefaultTableModel fillTable(JTable table_2 ,Map<String,Object[]> map){
        DefaultTableModel model=(DefaultTableModel) table_2.getModel();
        for(String key:map.keySet()){
            model.addRow(new Object[]{
            key,"abc xyz",map.get(key)[1],map.get(key)[0]
            });
        }
        return model;
        
    }

    @Override
    public String getColumnName(int column) {
        return names[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
