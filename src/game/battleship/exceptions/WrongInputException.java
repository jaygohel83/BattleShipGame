package game.battleship.exceptions;

/**
 * @author Jay Gohel
 * Exception class for this game
 */
public class WrongInputException extends Exception {

	/**
	 * @param areaValidationMessage
	 * in case invalid parameter provided to Game this exception will thrown.
	 */
	public WrongInputException(String areaValidationMessage) {
		super(areaValidationMessage);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
