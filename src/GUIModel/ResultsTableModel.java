/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIModel;

import BLL.Results;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ccks
 */
public class ResultsTableModel extends AbstractTableModel{
    
    List <Results> list;
    String [] cols = {"idresults" , "quiz_idquiz","time","correct_answer","user_iduser"};
    
    public ResultsTableModel(){}
    
    public ResultsTableModel(List<Results> list){
        this.list = list;
    }
    
    public void addList(List<Results> list){
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
    
    public Results getResults(int index){
        return list.get(index);
    }
    
    @Override
    public int getColumnCount() {
       return cols.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Results r = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return r.getIdresults();
            case 1:
                return r.getQuizIdquiz();
			case 2:
                return r.getTime();
			case 3:
                return r.getCorrectAnswer();
			case 4:
                return r.getUserIduser();
            default:
                return null;
        }
    }
}
