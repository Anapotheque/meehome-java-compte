package fr.meehome.template.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import fr.meehome.template.dao.domain.User;

public interface IUserDao extends GenericDAO<User, Long> {

    public User searchById(int id);

}
