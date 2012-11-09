package fr.meehome.template.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;

import fr.meehome.template.dao.IUserDao;
import fr.meehome.template.dao.domain.User;

@Transactional
@Repository
public class UserDao extends GenericDAOImpl<User, Long> implements IUserDao {

    @Override
    public User searchById(int id) {
        return (User ) search(new Search().addFilterEqual("id", id));
    }
}
