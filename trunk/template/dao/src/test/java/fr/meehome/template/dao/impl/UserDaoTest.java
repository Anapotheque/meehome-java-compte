package fr.meehome.template.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.meehome.template.dao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/fr/meehome/template/dao/applicationContext-test.xml" })
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void should_return_all_users() {
        Assert.assertEquals(2, userDao.findAll().size());
    }

    @Test
    public void should_return_one_user_by_login() {
        User user = new User();
        user.setId(1);
        user.setNom("nom1");
        user.setPrenom("prenom1");
        user.setLogin("login");
        user.setPassword("password");

        User userTest = userDao.searchById(1);

        Assert.assertTrue(user.equals(userTest));
    }

    @Test
    public void should_return_two_user_by_login() {
        // TODO
    }

    @Test
    public void should_delete_all_users_by_login() {
        // TODO
    }

    @Test
    public void should_delete_one_user_by_login() {
        // TODO
    }

    @Test
    public void should_update_one_user_by_login() {
        // TODO
    }
}
