package fr.meehome.compte.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import fr.meehome.compte.dao.domain.RoleEnum;
import fr.meehome.compte.dao.domain.User;

public interface IUserDao extends GenericDAO<User, Long> {

    public List<User> findByLoginAndPwd(String login, String password);

    public List<User> findByLogin(String login);

    public List<User> findByRole(RoleEnum roleEnum);

}
