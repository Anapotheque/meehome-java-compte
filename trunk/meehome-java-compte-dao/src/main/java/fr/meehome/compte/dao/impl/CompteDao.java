package fr.meehome.compte.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Search;

import fr.meehome.compte.dao.ICompteDao;
import fr.meehome.compte.dao.domain.Compte;
import fr.meehome.compte.dao.domain.User;

@Repository
public class CompteDao extends SessionFactoryDao<Compte, Long> implements ICompteDao {

    @Override
    public List<Compte> findByUser(User user) {
        return search(new Search().addFilterEqual("user", user));
    }

    @Override
    public List<Compte> findByLibelle(String libelle) {
        return search(new Search().addFilterEqual("libelle", libelle));
    }
}
