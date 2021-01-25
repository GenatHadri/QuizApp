/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Answer;
import java.util.List;

/**
 *
 * @author ccks
 */
public interface AnswerInterface {
    void create(Answer a) throws QuizException; 
    void edit(Answer a) throws QuizException;
    void delete(Answer a) throws QuizException;
    List <Answer> findAll() throws QuizException;
    Answer findByidanswers(Integer idanswers) throws QuizException;
}
