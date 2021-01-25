/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Categories;
import java.util.List;

/**
 *
 * @author ccks
 */
public interface CategoriesInterface {
    void create(Categories c) throws QuizException;
    void edit(Categories c) throws QuizException;
    void delete(Categories c) throws QuizException;
    List <Categories> findAll() throws QuizException;
    Categories findById(Integer ID) throws QuizException;
}
