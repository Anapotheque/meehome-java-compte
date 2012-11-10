package fr.meehome.template.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Search;

import fr.meehome.template.dao.IUserDao;
import fr.meehome.template.dao.domain.RoleEnum;
import fr.meehome.template.dao.domain.User;

@Repository
public class UserDao extends SessionFactoryDao<User, Long> implements IUserDao {

	@Override
	public List<User> findByLogin(String login) {
		return search(new Search().addFilterEqual("login", login));
	}

	@Override
	public List<User> findByRole(RoleEnum roleEnum) {
		return search(new Search().addFilterEqual("roleEnum", roleEnum));
	}
}
