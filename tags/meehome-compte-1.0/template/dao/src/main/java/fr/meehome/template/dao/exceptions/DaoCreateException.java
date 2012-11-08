package fr.meehome.template.dao.exceptions;

@SuppressWarnings("serial")
public class DaoCreateException extends TechnicalException {

    public DaoCreateException() {
        super();
    }

    public DaoCreateException(String aMessage) {
        super(aMessage);
    }
}
