/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author ccks
 */
public class QuizException extends Exception{
    
    public QuizException(){
        
    }
    
    public QuizException(String msg){
        super(msg);
    }
}
