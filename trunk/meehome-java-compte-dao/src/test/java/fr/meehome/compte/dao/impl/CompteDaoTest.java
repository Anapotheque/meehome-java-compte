package fr.meehome.compte.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.meehome.compte.dao.ICompteDao;
import fr.meehome.compte.dao.domain.Compte;
import fr.meehome.user.dao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/fr/meehome/compte/dao/applicationContext-test.xml" })
public class CompteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ICompteDao compteDao;

    @Test
    public void should_return_all_comptes() {
        List<Compte> listUsers = compteDao.findAll();
        Assert.assertEquals(2, listUsers.size());
    }

    @Test
    public void should_return_one_compte_by_user() {
        User user = new User();
        List<Compte> listComptes = compteDao.findByUser(user);
        Assert.assertEquals(1, listComptes.size());
    }

    @Test
    public void should_return_one_compte_by_libelle() {
        List<Compte> listComptes = compteDao.findByLibelle("libelle1");
        Assert.assertEquals(1, listComptes.size());
    }

    @Test
    public void should_update_one_compte_by_libelle() {
        List<Compte> listComptes = compteDao.findByLibelle("libelle1");
        listComptes.get(0).setLibelle("libelle3");
        compteDao.save(listComptes.get(0));
        listComptes = compteDao.findByLibelle("libelle3");
        Assert.assertEquals(1, listComptes.size());
    }

    @Test
    public void should_delete_one_compte_by_libelle() {
        compteDao.remove(compteDao.findByLibelle("libelle1").get(0));
        Assert.assertEquals(1, compteDao.findAll().size());
    }

    @Test
    public void should_delete_all_comptes_by_libelle() {
        for (Compte compte : compteDao.findAll()) {
            compteDao.remove(compte);
        }
        Assert.assertEquals(0, compteDao.findAll().size());
    }

    @Test
    public void should_insert_one_compte() {
        Compte compte = new Compte();
        compte.setLibelle("libelle3");
        compteDao.save(compte);
        Assert.assertEquals(3, compteDao.findAll().size());
    }
}
