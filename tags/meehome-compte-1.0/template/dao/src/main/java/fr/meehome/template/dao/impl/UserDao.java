package fr.meehome.template.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.meehome.template.dao.domain.User;

@Transactional
@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() throws HibernateException {
        List<User> list = sessionFactory.getCurrentSession().createCriteria(User.class).list();
        return list;
    }

    public void createPersonne(User user) throws HibernateException {
        sessionFactory.getCurrentSession().persist("User", user);
    }

    public void removePersonne(User user) throws HibernateException {
        sessionFactory.getCurrentSession().delete(user);
    }
}
