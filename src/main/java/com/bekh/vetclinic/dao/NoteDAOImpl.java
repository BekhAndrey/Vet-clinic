package com.bekh.vetclinic.dao;

import com.bekh.vetclinic.config.HibernateSessionFactoryUtil;
import com.bekh.vetclinic.model.NoteEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NoteDAOImpl implements NoteDAO {
    @Override
    public NoteEntity findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(NoteEntity.class, id);
    }

    @Override
    public void save(NoteEntity note) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(note);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(NoteEntity note) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(note);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(NoteEntity note) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(note);
        tx1.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NoteEntity> findAll() {
        return (List<NoteEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From NoteEntity").list();
    }
}
