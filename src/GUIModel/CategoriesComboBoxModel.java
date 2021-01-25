/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIModel;

import BLL.Categories;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ccks
 */
public class CategoriesComboBoxModel extends AbstractListModel<Categories> implements ComboBoxModel<Categories>{
    private List<Categories> data;
    private Categories selectedItem;
    
    public CategoriesComboBoxModel(){}
    
    public CategoriesComboBoxModel(List<Categories> data){
        this.data = data;
    }
    
    public void add(List<Categories> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Categories getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Categories)anItem;
    }

    @Override
    public Categories getSelectedItem() {
        return selectedItem;
    }
}
