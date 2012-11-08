package fr.meehome.template.dao;

import java.util.List;

import fr.meehome.template.dao.domain.User;

public interface IUserDao {

    public void saveUser(String login, String password);

    public User getUser(String login, String password);

    public List<User> getAllUser();

}
