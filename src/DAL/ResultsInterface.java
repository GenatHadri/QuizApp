/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Results;
import java.util.List;

/**
 *
 * @author ccks
 */
public interface ResultsInterface {
    void create (Results r) throws QuizException;
    void edit (Results r) throws QuizException;
    void delete (Results r) throws QuizException;
    List <Results> findAll() throws QuizException;
    Results findByResultsID (Integer ResultsID) throws QuizException;

}

