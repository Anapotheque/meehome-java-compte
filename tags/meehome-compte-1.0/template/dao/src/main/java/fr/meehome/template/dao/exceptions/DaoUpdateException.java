package fr.meehome.template.dao.exceptions;

@SuppressWarnings("serial")
public class DaoUpdateException extends TechnicalException {
    
    public DaoUpdateException() {
        super();
    }

    public DaoUpdateException(String aMessage) {
        super(aMessage);
    }
}
