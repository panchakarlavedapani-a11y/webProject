package com.worknestapp.dao;

import com.worknestapp.model.User;
import com.worknestapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void save(User user){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch(Exception ex){ if(tx!=null) tx.rollback(); ex.printStackTrace(); }
    }

    @Override
    public void update(User user){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch(Exception ex){ if(tx!=null) tx.rollback(); ex.printStackTrace(); }
    }

    @Override
    public User findById(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(User.class, id);
        }
    }

    @Override
    public User findByUsername(String username){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<User> q = session.createQuery("from User where username = :u", User.class);
            q.setParameter("u", username);
            return q.uniqueResult();
        }
    }

    @Override
    public List<User> findAll(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void delete(Long id){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            User u = session.get(User.class, id);
            if(u!=null) session.delete(u);
            tx.commit();
        } catch(Exception ex){ if(tx!=null) tx.rollback(); ex.printStackTrace(); }
    }
}
