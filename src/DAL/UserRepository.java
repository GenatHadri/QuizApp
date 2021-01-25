/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Users;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ccks
 */
public class UserRepository extends EntityClass implements UserInterface{
     public void create (Users u) throws QuizException{
        try{
           em.getTransaction().begin();
           em.persist(u);
           em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg \n" + e.getMessage());
         }
    }
     
     @Override
    public Users loginByUsernameAndPassword(String u, String p) throws QuizException {
        try {
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.firstname = :us AND u.password=:psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Users) query.getSingleResult();
        } catch (Exception e) {
            throw new QuizException("Msg! \n" + e.getMessage());
        }
    }

   @Override
    public void edit(Users u) throws QuizException {
        try{
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new QuizException("Msg\n" + e.getMessage());
        }
    }
    @Override
    public void delete(Users u) throws QuizException {
         try{
           em.getTransaction().begin();
           em.remove(u);
           em.getTransaction().commit();
     
       }catch(Exception e){
           throw new QuizException("Msg \n" + e.getMessage());
       }
    }

   
    @Override
    public List<Users> findAll() throws QuizException {
       try{
            return em.createNamedQuery("Users.findAll").getResultList();
        }catch(Exception e){
            throw new QuizException("Msg\n" + e.getMessage());
        }
    }

    @Override
    public Users findById(Integer ID) throws QuizException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
