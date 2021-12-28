package dao;

import config.HibernateSessionFactoryUtil;
import model.AnimalEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AnimalDAOImpl implements AnimalDAO {
    @Override
    public AnimalEntity findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AnimalEntity.class, id);
    }

    @Override
    public void save(AnimalEntity animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(animal);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(AnimalEntity animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(animal);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(AnimalEntity animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(animal);
        tx1.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AnimalEntity> findAll() {
        return (List<AnimalEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From AnimalEntity ").list();
    }
}
