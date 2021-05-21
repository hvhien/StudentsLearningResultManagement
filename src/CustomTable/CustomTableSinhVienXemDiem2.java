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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hienhv
 */
public class CustomTableSinhVienXemDiem2 extends AbstractTableModel{
    String names[]={"Học kỳ","Tổng tín chỉ theo kỳ","TBC học kỳ","Xét học bổng"};
    Class classes[]={Integer.class,Integer.class,float.class,String.class};
//    ArrayList<Diem> list=new ArrayList<Diem>();
    List<Map<Integer,Float>> list=new ArrayList<>();

    public CustomTableSinhVienXemDiem2(List<Map<Integer,Float>> arr) {
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

    private Object a(float x){
        if(x>8.5){
            return "Có học bổng";
        }else{
            return "Không có";
        }
    }
   
    public DefaultTableModel fillTable(JTable table_2 ,List list_tongTinChi){
        DefaultTableModel model=(DefaultTableModel) table_2.getModel();
        model.setRowCount(0);
        Iterator it=list.iterator();
        int i=0;
        while(it.hasNext()){
            Map<Integer,Float> hm=(Map<Integer,Float>) it.next();
            
            for(Integer key : hm.keySet()){

                model.addRow(new Object[]{
                    key,list_tongTinChi.get(i),hm.get(key),a(hm.get(key))
                });
                i++;
            }
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
