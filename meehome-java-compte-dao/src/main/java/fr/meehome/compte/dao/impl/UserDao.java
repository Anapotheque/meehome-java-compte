package fr.meehome.compte.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Search;

import fr.meehome.compte.dao.IUserDao;
import fr.meehome.compte.dao.domain.RoleEnum;
import fr.meehome.compte.dao.domain.User;

@Repository
public class UserDao extends SessionFactoryDao<User, Long> implements IUserDao {

    @Override
    public List<User> findByLoginAndPwd(String login, String password) {
        return search(new Search().addFilterEqual("login", login).addFilterEqual("pwd", password));
    }

    @Override
    public List<User> findByLogin(String login) {
        return search(new Search().addFilterEqual("login", login));
    }

    @Override
    public List<User> findByRole(RoleEnum roleEnum) {
        return search(new Search().addFilterEqual("roleEnum", roleEnum));
    }
}
