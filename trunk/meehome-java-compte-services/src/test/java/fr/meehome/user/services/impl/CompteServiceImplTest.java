package fr.meehome.compte.services.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.meehome.compte.dao.ICompteDao;
import fr.meehome.compte.dao.domain.Compte;
import fr.meehome.compte.dao.domain.User;
import fr.meehome.compte.services.dto.CompteDto;

@RunWith(MockitoJUnitRunner.class)
public class CompteServiceImplTest {

    @InjectMocks
    private CompteServiceImpl compteService;

    @Mock
    private Mapper mapperMock;

    @Mock
    private ICompteDao compteDaoMock;

    User user;

    @Before
    public void setup() {
        user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setPrenom("prenom");
        when(compteDaoMock.findAll()).thenReturn(populate_comptes_dao_mock());
        when(compteDaoMock.findByUser(user)).thenReturn(populate_comptes_dao_mock());
    }

    private List<Compte> populate_comptes_dao_mock() {
        List<Compte> listCompte = new ArrayList<Compte>();
        Compte compte1 = new Compte();
        compte1.setLibelle("Livret A");
        compte1.setUser(user);
        Compte compte2 = new Compte();
        compte2.setLibelle("Livret B");
        listCompte.add(compte1);
        listCompte.add(compte2);
        return listCompte;
    }

    @Test
    public void should_return_all_comptes() {
        List<CompteDto> listCompte = compteService.getAll();
        Assert.assertEquals(false, listCompte == null);
        Assert.assertEquals(false, listCompte.isEmpty());
        Assert.assertEquals(2, listCompte.size());
    }
}
