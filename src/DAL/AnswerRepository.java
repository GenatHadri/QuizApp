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
public class AnswerRepository extends EntityClass implements AnswerInterface{
    
    @Override
    public void create (Answer a) throws QuizException{
        try{
            em.getTransaction().begin();
           em.persist(a);
           em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg \n" + e.getMessage());
         }
    }
    
      @Override
    public void edit(Answer a) throws QuizException {
        try{
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg \n" + e.getMessage());
        }
    }
    
    @Override
     public void delete(Answer a) throws QuizException {
       try{
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg \n" + e.getMessage());
        }
    }
    
    @Override
    public List<Answer> findAll() throws QuizException {
        try{
            return em.createNamedQuery("Answer.findAll").getResultList();
        }catch(Exception e){
            throw new QuizException("Msg \n" + e.getMessage());
        }
    }
    
    @Override
    public Answer findByidanswers(Integer idanswer) throws QuizException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
}
