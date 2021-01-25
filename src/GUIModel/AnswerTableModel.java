/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIModel;

import BLL.Answer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ccks
 */
public class AnswerTableModel extends AbstractTableModel{
    
    List <Answer> list;
    String [] cols = {"idanswer" , "answer"};
    
    public AnswerTableModel(){}
    
    public AnswerTableModel(List<Answer> list){
        this.list = list;
    }
    
    public void addList(List<Answer> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Answer getAnswer(int index){
        return list.get(index);
    }
    
    @Override
    public int getColumnCount() {
       return cols.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Answer a = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return a.getIdanswer();
            case 1:
                return a.getAnswer();
            default:
                return null;
        }
    }
}
