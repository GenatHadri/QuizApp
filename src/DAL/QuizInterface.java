/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Quiz;
import java.util.List;

/**
 *
 * @author ccks
 */
public interface QuizInterface {
    void create(Quiz q) throws QuizException;
    void edit(Quiz q) throws QuizException;
    void delete(Quiz q) throws QuizException;
    List <Quiz> findAll() throws QuizException;
    Quiz findById(Integer ID) throws QuizException;
}
