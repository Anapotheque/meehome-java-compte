package fr.meehome.compte.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.meehome.user.dao.IUserDao;
import fr.meehome.user.dao.domain.RoleEnum;
import fr.meehome.user.dao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/fr/meehome/compte/dao/applicationContext-test.xml" })
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IUserDao userDao;

    @Test
    public void should_return_all_users() {
        List<User> listUsers = userDao.findAll();
        Assert.assertEquals(2, listUsers.size());
    }

    @Test
    public void should_return_one_user_by_login() {
        List<User> listUsers = userDao.findByLogin("login1");
        Assert.assertEquals(1, listUsers.size());
    }

    @Test
    public void should_return_one_user_by_role() {
        List<User> listUsers = userDao.findByRole(RoleEnum.ADMINISTRATEUR);
        Assert.assertEquals(1, listUsers.size());
    }

    @Test
    public void should_update_one_user_by_login() {
        List<User> listUsers = userDao.findByLogin("login1");
        listUsers.get(0).setLogin("login3");
        userDao.save(listUsers.get(0));
        listUsers = userDao.findByLogin("login3");
        Assert.assertEquals(1, listUsers.size());
    }

    @Test
    public void should_delete_one_user_by_login() {
        userDao.remove(userDao.findByLogin("login1").get(0));
        Assert.assertEquals(1, userDao.findAll().size());
    }

    @Test
    public void should_delete_all_users() {
        for (User user : userDao.findAll()) {
            userDao.remove(user);
        }
        Assert.assertEquals(0, userDao.findAll().size());
    }

    @Test
    public void should_insert_one_user() {
        User user = new User();
        user.setLogin("login3");
        userDao.save(user);
        Assert.assertEquals(3, userDao.findAll().size());
    }
}
