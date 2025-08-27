package com.worknestapp.dao;

import com.worknestapp.model.Task;
import com.worknestapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Override
    public void save(Task task){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.save(task);
            tx.commit();
        } catch(Exception ex){ if(tx!=null) tx.rollback(); ex.printStackTrace(); }
    }

    @Override
    public void update(Task task){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.update(task);
            tx.commit();
        } catch(Exception ex){ if(tx!=null) tx.rollback(); ex.printStackTrace(); }
    }

    @Override
    public Task findById(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Task.class, id);
        }
    }

    @Override
    public List<Task> findAll(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Task", Task.class).list();
        }
    }

    @Override
    public List<Task> findByUserId(Long userId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Task> q = session.createQuery("from Task where assignedTo.id = :uid", Task.class);
            q.setParameter("uid", userId);
            return q.list();
        }
    }
}
