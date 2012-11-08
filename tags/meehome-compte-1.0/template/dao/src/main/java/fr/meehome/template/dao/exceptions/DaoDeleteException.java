package fr.meehome.template.dao.exceptions;

@SuppressWarnings("serial")
public class DaoDeleteException extends TechnicalException {

    public DaoDeleteException() {
        super();
    }

    public DaoDeleteException(String aMessage) {
        super(aMessage);
    }
}
