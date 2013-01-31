package fr.meehome.compte.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;

import fr.meehome.compte.dao.ICompteDao;
import fr.meehome.compte.dao.IUserDao;
import fr.meehome.compte.dao.domain.Compte;
import fr.meehome.compte.dao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/fr/meehome/compte/dao/applicationContext-test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(value = "compteDao.xml")
public class CompteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ICompteDao compteDao;

    @Autowired
    private IUserDao userDao;

    @Before
    public void init() {
        List<User> listUsers = userDao.findAll();
        Assert.assertEquals(true, listUsers != null && !listUsers.isEmpty() && listUsers.size() == 2);

        Compte livretA = new Compte();
        livretA.setLibelle("Livret A");
        livretA.setUser(listUsers.get(0));

        compteDao.save(livretA);
        Assert.assertEquals(1, compteDao.findAll().size());

        Compte ldd = new Compte();
        ldd.setLibelle("LDD");
        ldd.setUser(listUsers.get(1));

        compteDao.save(ldd);
        Assert.assertEquals(2, compteDao.findAll().size());
    }

    @Test
    public void should_return_one_compte_by_user() {
        List<User> listUsers = userDao.findAll();
        Assert.assertEquals(true, listUsers != null && !listUsers.isEmpty() && listUsers.size() == 2);
        List<Compte> listComptes = compteDao.findByUser(listUsers.get(0));
        Assert.assertEquals(1, listComptes.size());
        Assert.assertEquals("Livret A", listComptes.get(0).getLibelle());
    }

    @Test
    public void should_return_one_compte_by_libelle() {
        List<Compte> listComptes = compteDao.findByLibelle("Livret A");
        Assert.assertEquals(1, listComptes.size());
        Assert.assertEquals("Livret A", listComptes.get(0).getLibelle());
    }

    @Test
    public void should_update_one_compte_by_libelle() {
        List<Compte> listComptes = compteDao.findByLibelle("Livret A");
        listComptes.get(0).setLibelle("Livret B");
        compteDao.save(listComptes.get(0));
        listComptes = compteDao.findByLibelle("Livret B");
        Assert.assertEquals(1, listComptes.size());
        Assert.assertEquals("Livret B", listComptes.get(0).getLibelle());
    }

    @Test
    public void should_delete_one_compte_by_libelle() {
        compteDao.remove(compteDao.findByLibelle("Livret A").get(0));
        Assert.assertEquals(1, compteDao.findAll().size());
    }

    @Test
    public void should_delete_all_comptes() {
        for (Compte compte : compteDao.findAll()) {
            compteDao.remove(compte);
        }
        Assert.assertEquals(0, compteDao.findAll().size());
    }
}
