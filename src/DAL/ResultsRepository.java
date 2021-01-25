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
public class ResultsRepository extends EntityClass implements ResultsInterface{
    @Override
    public void create(Results r) throws QuizException {
        try{
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg\n" + e.getMessage());
        }
    }
    @Override
    public void edit(Results r) throws QuizException {
        try{
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg\n" + e.getMessage());
        }
    }
    @Override
    public void delete(Results r) throws QuizException {
         try{
           em.getTransaction().begin();
           em.remove(r);
           em.getTransaction().commit();
     
       }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
       }
    }

   
    @Override
    public List<Results> findAll() throws QuizException {
       try{
            return em.createNamedQuery("Results.findAll").getResultList();
        }catch(Exception e){
            throw new QuizException("Msg\n" + e.getMessage());
        }
    }

    @Override
    public Results findByResultsID(Integer ResultsID) throws QuizException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
