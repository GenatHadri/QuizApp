/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIModel;

import BLL.Categories;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ccks
 */
public class CategoriesTableModel extends AbstractTableModel{
    
    List<Categories> categories;
    String [] cols = {"idcategories","categorie_name"};
    
    public CategoriesTableModel(){}
    
    public CategoriesTableModel(List<Categories> categories){
        this.categories = categories;
    }
    
    public void addList(List<Categories> list){
        this.categories=list;
    }
    
     public Categories getCategory(int index){
        return categories.get(index);
    }
     
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    @Override
    public int getRowCount() {
        return categories.size();
    }
    
      public void remove (int row){
        categories.remove(row);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Categories c = categories.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getIdcategories();
            case 1:
                return c.getCategorieName();
            default:
                return null;
        }
    }
    
}
