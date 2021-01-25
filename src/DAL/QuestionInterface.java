/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Questions;
import java.util.List;

/**
 *
 * @author ccks
 */
public interface QuestionInterface {
    void create (Questions q) throws QuizException;
    void edit (Questions q) throws QuizException;
    void delete (Questions q) throws QuizException;
    List <Questions> findAll() throws QuizException;
    Questions findByIdQuiz (Integer IdQuiz) throws QuizException;
}


