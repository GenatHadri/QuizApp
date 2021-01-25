/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Categories;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ccks
 */
public class CategoriesRepository extends EntityClass implements CategoriesInterface{

    @Override
    public void create(Categories c) throws QuizException {
           try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg " + e.getMessage());
        } 
    }

    @Override
    public void edit(Categories c) throws QuizException {
        try{
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg " + e.getMessage());
        }
    }

    @Override
    public void delete(Categories c) throws QuizException {
         try{
           em.getTransaction().begin();
           em.remove(c);
           em.getTransaction().commit();
      
       }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
       }
    }

    @Override
    public List<Categories> findAll() throws QuizException {
        try{
            return em.createNamedQuery("Categories.findAll").getResultList();
        }catch(Exception e){
            throw new QuizException("Msg " + e.getMessage());
        }
    }

    @Override
    public Categories findById(Integer ID) throws QuizException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
