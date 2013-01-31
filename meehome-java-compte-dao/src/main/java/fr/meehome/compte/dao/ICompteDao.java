package fr.meehome.compte.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import fr.meehome.compte.dao.domain.Compte;
import fr.meehome.compte.dao.domain.User;

public interface ICompteDao extends GenericDAO<Compte, Long> {

    public List<Compte> findByUser(User user);

    public List<Compte> findByLibelle(String libelle);
}
