package fr.meehome.template.dao.exceptions;

@SuppressWarnings("serial")
public class DaoFindException extends TechnicalException {

	public DaoFindException() {
        super();
    }
    
	public DaoFindException(String aMessage) {
        super(aMessage);
    }
}
