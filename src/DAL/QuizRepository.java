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
public class QuizRepository  extends EntityClass implements QuizInterface{

    @Override
    public void create(Quiz q) throws QuizException {
        try{
            em.getTransaction().begin();
            em.persist(q);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg " + e.getMessage());
        }    }

    @Override
    public void edit(Quiz q) throws QuizException {
        try{
            em.getTransaction().begin();
            em.merge(q);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg " + e.getMessage());
        }
    }

    @Override
    public void delete(Quiz q) throws QuizException {
        try{
           em.getTransaction().begin();
           em.remove(q);
           em.getTransaction().commit();
      
       }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
       }

    }

    @Override
    public List<Quiz> findAll() throws QuizException {
        try{
            return em.createNamedQuery("Quiz.findAll").getResultList();
        }catch(Exception e){
            throw new QuizException("Msg " + e.getMessage());
        }
    }

    @Override
    public Quiz findById(Integer ID) throws QuizException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
