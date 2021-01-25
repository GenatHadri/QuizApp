/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIModel;

import BLL.Questions;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ccks
 */
public class QuestionTableModel extends AbstractTableModel {

    List <Questions> questions;
    String [] cols ={"idquestions" , "content","idanswer","idcategories"};
    
    public QuestionTableModel(){}
    
    public QuestionTableModel(List <Questions> questions){
        this.questions = questions;
    }
    
    public void addList (List <Questions> questions){
        this.questions = questions;
    }
    
    @Override
    public String getColumnName (int col) {
        return cols[col];
    }
    
    
    @Override
    public int getRowCount() {
         return questions.size();
    }
    
    public void remove(int row){
        questions.remove(row);
    }

    public Questions getQuestions(int index){
        return questions.get(index);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Questions q = questions.get(rowIndex);
        switch (columnIndex){
            case 0:
                return q.getIdquestions();
            case 1:
                return q.getContent();
            case 2:
                return q.getIdanswer();
            case 3:
                return q.getIdcategories();
            default:
                return null;
        }
    }
    
}

