package game.battleship.utility;

import game.battleship.exceptions.WrongInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtility implements ValidationConstant {
	
	static Pattern pattern;
	static Matcher matcher;
	 
	
	/**
	 * @param inputLines
	 * @throws WrongInputException
	 */
	public static void validateInput(String[] inputLines) throws WrongInputException
	{
		validateBattleArea(inputLines[0]);
		
		String[] wh = inputLines[0].split(",");
		int[] iwh = new int[2];
		iwh[0] = CommonUtils.getIndexOfWidth(wh[0])-1;
		iwh[1] = CommonUtils.getIndexOfHeigth(wh[1]);		
		int totalPlaces = iwh[0] * iwh[1];
		
		validateNumberOfBattleShip(inputLines[1],totalPlaces);
		
		validateShipType(inputLines[2],iwh,wh);
		validateShipType(inputLines[3],iwh,wh);		
		validateTarget("Player1", inputLines[4]);
		validateTarget("Player2", inputLines[5]);
	}

	/**
	 * @param pName
	 * @param target
	 * @throws WrongInputException
	 */
	public static void validateTarget(String pName, String target) throws WrongInputException {
		if(target == null || "".equals(target))
			throw new WrongInputException(pName+" " +battleshipTargetMessage);
	}

	/**
	 * @param typeString
	 * @param wh
	 * @param wh2
	 * @throws WrongInputException
	 */
	public static void validateShipType(String typeString, int[] wh, String[] wh2) throws WrongInputException{
		
			String[] param = new String(typeString).split("\\s+");
			if(param.length != 5)
				throw new WrongInputException(battleShipTypeInputMissing);
			
			pattern = Pattern.compile(TYPE_PATTERN);
			matcher = pattern.matcher(param[0]);
			if(!matcher.matches())
			{
				throw new WrongInputException(battleshipTypeMessage);
			}
			try{
				int dimW = Integer.parseInt(param[1]);
				int dimH = Integer.parseInt(param[2]);
				if(dimW > wh[0] && dimH > wh[1])
				{
					throw new WrongInputException(param[0] + battleshipTypeDimensionMessage);
				}
			}catch(NumberFormatException nfe)
			{
				throw new WrongInputException(param[0] + battleshipTypeDimensionMessage);
			}
			
			if(!isValidPlace(param[3],wh2))
			{
				throw new WrongInputException(param[0] + battleshipPlaceMessage);
			}
			if(!isValidPlace(param[4], wh2))
			{
				throw new WrongInputException(param[0] + battleshipPlaceMessage);
			}
		
	}

	/**
	 * @param place
	 * @param wh2
	 * @return
	 */
	private static boolean isValidPlace(String place, String[] wh2) {
		String shipPlacePattern = "[A-"+wh2[1] + "][1-"+wh2[0]+"]";
		pattern = Pattern.compile(shipPlacePattern);
		matcher = pattern.matcher(place);		
		return matcher.find();
	}

	/**
	 * @param numberOfBattleShip
	 * @param max
	 * @throws WrongInputException
	 */
	public static void validateNumberOfBattleShip(String numberOfBattleShip, int max) throws WrongInputException {
		try
		{
			int battleShips = Integer.parseInt(numberOfBattleShip);
			if(battleShips > max)
			{
				throw new WrongInputException(battleshipNumberMessage);
			}
		}
		catch (Exception e) {
			throw new WrongInputException(battleshipNumberMessage);
		}
		
	}

	/**
	 * @param battleArea
	 * @throws WrongInputException
	 */
	public static void validateBattleArea(String battleArea) throws WrongInputException {
		
		try
		{
			pattern = Pattern.compile(AREA_PATTERN);
			matcher = pattern.matcher(battleArea);
			if(!matcher.matches())
			{
				throw new WrongInputException(areaValidationMessage);
			}
		}
		catch(Exception e)
		{
			throw new WrongInputException(areaValidationMessage);
		}
		
	}
	

}
