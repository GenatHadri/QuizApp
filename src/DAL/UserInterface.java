/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Users;
import java.util.List;

/**
 *
 * @author ccks
 */
public interface UserInterface {
    void create(Users u) throws QuizException;
    void edit(Users u) throws QuizException;
    void delete(Users u) throws QuizException;
    List <Users> findAll() throws QuizException;
    Users findById(Integer ID) throws QuizException;
    Users loginByUsernameAndPassword(String u,String pw) throws QuizException;
}
