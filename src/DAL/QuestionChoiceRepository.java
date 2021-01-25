/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.QuestionChoice;
import java.util.List;

/**
 *
 * @author ccks
 */
public class QuestionChoiceRepository extends EntityClass implements QuestionChoiceInterface{

    @Override
    public void create(QuestionChoice qc) throws QuizException {
       try{
           em.getTransaction().begin(); // e fillon komunikimin me databaz
           em.persist(qc); // me shtu objektin a psh qe osht autori
           em.getTransaction().commit(); // commit e vulos i qon te dhanta deri ndatabaz
       }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
       }
    }

    @Override
    public void edit(QuestionChoice qc) throws QuizException {
        try{
           em.getTransaction().begin();
           em.merge(qc);
           em.getTransaction().commit();
        }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(QuestionChoice qc) throws QuizException {
        try{
           em.getTransaction().begin();
           em.remove(qc);
           em.getTransaction().commit();
        }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<QuestionChoice> findAll() throws QuizException {
        try{
            return em.createNamedQuery("QuestionChoice.findAll").getResultList();
        }catch(Exception e){
            throw new QuizException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public QuestionChoice findByID(Integer ID) throws QuizException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
   
}

