/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.QuestionChoice;
import java.util.List;

/**
 *
 * @author ccks
 */
public interface QuestionChoiceInterface {
    void create(QuestionChoice qc) throws QuizException;
    void edit(QuestionChoice qc) throws QuizException;
    void delete(QuestionChoice qc)throws QuizException;
    List <QuestionChoice> findAll() throws QuizException;
    QuestionChoice findByID(Integer ID) throws QuizException;

}
