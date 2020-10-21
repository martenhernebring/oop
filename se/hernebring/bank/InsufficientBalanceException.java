package se.hernebring.bank;

public class InsufficientBalanceException extends Exception {

	/**
	 * Java compiler demands a static final serialVersionUID
	 */
	private static final long serialVersionUID = 1463437811515301258L;

	public InsufficientBalanceException(String message) {
		super(message);
	}

}
