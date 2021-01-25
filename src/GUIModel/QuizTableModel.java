/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIModel;

import BLL.Quiz;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ccks
 */
public class QuizTableModel extends AbstractTableModel {

    List<Quiz> quiz;
    String [] cols = {"idquiz","quiz_name","created_at","categories_idcategories"};
    
    public QuizTableModel(){}
    
    public QuizTableModel(List<Quiz> quiz){
        this.quiz = quiz;
    }
    
    public void addList(List<Quiz> list){
        this.quiz=list;
    }
    
     public Quiz getQuiz(int index){
        return quiz.get(index);
    }
     
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    @Override
    public int getRowCount() {
        return quiz.size();
    }
    
     public void remove (int row){
        quiz.remove(row);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Quiz q = quiz.get(rowIndex);
        switch(columnIndex){
            case 0:
                return q.getIdquiz();
            case 1:
                return q.getQuizName();
            case 2:
                return q.getCreatedAt();
            case 3:
                return q.getCategoriesIdcategories();
            default:
                return null;
        }
    }
    
    public String getDateToString(Date d){
       DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
       return da.format(d);
    }

    
}
