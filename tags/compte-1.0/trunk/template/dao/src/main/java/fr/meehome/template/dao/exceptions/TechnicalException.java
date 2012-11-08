package fr.meehome.template.dao.exceptions;

@SuppressWarnings("serial")
public class TechnicalException extends Exception {

	public TechnicalException() {
		super();
	}
	public TechnicalException(String aMessage) {
		super(aMessage);
	}
}
