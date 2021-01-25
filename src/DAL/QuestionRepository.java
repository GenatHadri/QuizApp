/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Categories;
import BLL.Questions;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ccks
 */
public class QuestionRepository extends EntityClass implements QuestionInterface {
    @Override
    public void create(Questions q) throws QuizException {
        try{
            em.getTransaction().begin();
            em.persist(q);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg\n" + e.getMessage());
        }
    }

    @Override
    public void edit(Questions q) throws QuizException {
        try{
            em.getTransaction().begin();
            em.merge(q);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg\n" + e.getMessage());
        }
    }
    @Override
    public void delete(Questions q) throws QuizException {
         try{
           em.getTransaction().begin();
           em.remove(q);
           em.getTransaction().commit();
      
       }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
       }
    }

    @Override
    public List<Questions> findAll() throws QuizException {
        try {
           return em.createNamedQuery("Questions.findAll").getResultList();
            
        
            }catch (Exception e) {
                throw new QuizException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Questions findByIdQuiz(Integer IdQuiz) throws QuizException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Questions> questionByCategoryId(Categories id){
        Query query = em.createQuery("Select q from Questions q where q.idcategories = :q_id");
        query.setParameter("q_id", id);
        return  query.getResultList();
    }
}
