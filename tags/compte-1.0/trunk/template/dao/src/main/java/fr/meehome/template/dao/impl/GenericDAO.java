package fr.meehome.template.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.meehome.template.dao.IGenericDao;
import fr.meehome.template.dao.domain.AbstractTO;
import fr.meehome.template.dao.exceptions.DaoCreateException;
import fr.meehome.template.dao.exceptions.DaoDeleteException;
import fr.meehome.template.dao.exceptions.DaoFindException;
import fr.meehome.template.dao.exceptions.DaoUpdateException;

public class GenericDAO extends HibernateDaoSupport implements IGenericDao {

    protected Log log = LogFactory.getFactory().getInstance(this.getClass());

    public void ajouter(AbstractTO aBean) throws DaoCreateException {
        try {
            getHibernateTemplate().saveOrUpdate(aBean);
        } catch (DataAccessException e) {
            String message = getClass().getName() + ": Pb accès base en création " + e.getMessage();
            throw new DaoCreateException(message);
        }
    }

    public void modifier(AbstractTO aBean) throws DaoUpdateException {
        try {
            getHibernateTemplate().saveOrUpdate(aBean);
        } catch (DataAccessException e) {
            String message = getClass().getName() + ": Pb accès base en modification " + e.getMessage();
            throw new DaoUpdateException(message);
        }
    }

    public void supprimer(AbstractTO aBean) throws DaoDeleteException {
        try {
            getHibernateTemplate().delete(aBean);
        } catch (DataAccessException e) {
            String message = getClass().getName() + ": Pb accès base en suppression " + e.getMessage();
            throw new DaoDeleteException(message);
        }
    }

    @SuppressWarnings("unchecked")
    public List<AbstractTO> rechercher(String aQueryString) throws DaoFindException {
        try {
            return getHibernateTemplate().find(aQueryString);
        } catch (DataAccessException e) {
            String message = "Pb accès base sur recherche " + e.getMessage();
            throw new DaoFindException(message);
        }
    }

    @SuppressWarnings("unchecked")
    public List<AbstractTO> rechercher(Criteria aCriteria) throws DaoFindException {
        try {
            return aCriteria.list();
        } catch (QueryException e) {
            String message = getClass().getName() + ": Pb de syntaxe sur recherche " + e.getMessage();
            throw new DaoFindException(message);
        } catch (ClassCastException e) {
            String message = getClass().getName() + ": Pb de cast de class sur recherche " + e.getMessage();
            throw new DaoFindException(message);
        } catch (HibernateException e) {
            String message = getClass().getName() + ": Pb accès base sur recherche " + e.getMessage();
            throw new DaoFindException(message);
        }
    }
}
