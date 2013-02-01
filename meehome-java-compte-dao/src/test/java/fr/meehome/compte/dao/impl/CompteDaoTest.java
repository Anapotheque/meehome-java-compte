package fr.meehome.compte.dao.impl;

import java.util.List;

import org.junit.Assert;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/fr/meehome/compte/dao/applicationContext-test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(value = "compteDao.xml")
public class CompteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ICompteDao compteDao;

    @Autowired
    private IUserDao userDao;

    @Test
    public void should_return_one_compte_by_user() {
        List<Compte> listComptes = compteDao.findByUser(userDao.findByLogin("login1").get(0));
        Assert.assertEquals(1, listComptes.size());
        Assert.assertEquals("LivretA", listComptes.get(0).getLibelle());
    }

    @Test
    public void should_return_one_compte_by_libelle() {
        List<Compte> listComptes = compteDao.findByLibelle("LivretA");
        Assert.assertEquals(1, listComptes.size());
        Assert.assertEquals("LivretA", listComptes.get(0).getLibelle());
    }

    @Test
    public void should_update_one_compte_by_libelle() {
        List<Compte> listComptes = compteDao.findByLibelle("LivretA");
        listComptes.get(0).setLibelle("LivretB");
        compteDao.save(listComptes.get(0));
        listComptes = compteDao.findByLibelle("LivretB");
        Assert.assertEquals(1, listComptes.size());
        Assert.assertEquals("LivretB", listComptes.get(0).getLibelle());
    }

    @Test
    public void should_delete_one_compte_by_libelle() {
        compteDao.remove(compteDao.findByLibelle("LivretA").get(0));
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
