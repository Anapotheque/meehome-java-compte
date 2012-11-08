package fr.meehome.template.dao;

import java.util.List;

import org.hibernate.Criteria;

import fr.meehome.template.dao.domain.AbstractTO;
import fr.meehome.template.dao.exceptions.DaoCreateException;
import fr.meehome.template.dao.exceptions.DaoDeleteException;
import fr.meehome.template.dao.exceptions.DaoFindException;
import fr.meehome.template.dao.exceptions.DaoUpdateException;

public interface IGenericDao {

    void ajouter(AbstractTO aBean) throws DaoCreateException;

    void modifier(AbstractTO aBean) throws DaoUpdateException;

    void supprimer(AbstractTO aBean) throws DaoDeleteException;

    List<AbstractTO> rechercher(String aQueryString) throws DaoFindException;

    List<AbstractTO> rechercher(Criteria aCriteria) throws DaoFindException;
}
