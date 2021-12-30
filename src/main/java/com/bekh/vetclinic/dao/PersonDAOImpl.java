package com.bekh.vetclinic.dao;

import com.bekh.vetclinic.config.HibernateSessionFactoryUtil;
import com.bekh.vetclinic.model.PersonEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public PersonEntity findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PersonEntity.class, id);
    }

    @Override
    public PersonEntity findByEmail(String email) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM PersonEntity p WHERE p.email = :email");
        query.setParameter("email", email);
        return (PersonEntity) query.list().get(0);
    }

    @Override
    public void save(PersonEntity person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(PersonEntity person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(PersonEntity person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session.get(PersonEntity.class, person.getId()));
        tx1.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PersonEntity> findAll() {
        return (List<PersonEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From PersonEntity").list();
    }
}
