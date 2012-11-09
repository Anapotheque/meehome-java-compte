package fr.meehome.template.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import fr.meehome.template.dao.domain.User;

public interface IUserDao extends GenericDAO<User, Long> {

    public List<User> loadall();

    public User searchByLogin(String login);

}
