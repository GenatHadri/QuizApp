/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIModel;

import BLL.QuestionChoice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ccks
 */

public class QuestionChoiceTableModel extends AbstractTableModel{

    List <QuestionChoice> questionChoice;
    String [] cols = {"choiceId" , "optionA", "optionB", "optionC" ,"optionD","questionId"};
   
    public QuestionChoiceTableModel(){}
   
    public QuestionChoiceTableModel(List <QuestionChoice> questionChoice){
        this.questionChoice = questionChoice;                                  
    }
   
    public void addList(List <QuestionChoice> list){
        this.questionChoice = list;
    }
   
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
   
    @Override
    public int getRowCount() {
        return questionChoice.size();                         
    }
   
    public void remove(int row){
        questionChoice.remove(row);
    }
   
    public QuestionChoice getQuestionChoice(int index){
        return questionChoice.get(index);
    }

    @Override
    public int getColumnCount() {
        return cols.length;                        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        QuestionChoice qc = questionChoice.get(rowIndex);
        switch(columnIndex){
            case 0:
                return qc.getChoiceId();                  
            case 1:
                return qc.getOptionA();
            case 2:
                return qc.getOptionB();
            case 3:
                return qc.getOptionC();
            case 4:
                return qc.getOptionD();
            case 5:
                return qc.getIdquestions();
            default:
                return null;
        }
    }    
}

