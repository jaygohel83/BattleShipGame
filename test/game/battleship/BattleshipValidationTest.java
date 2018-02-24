package game.battleship;

import game.battleship.exceptions.WrongInputException;
import game.battleship.utility.CommonUtils;
import game.battleship.utility.ValidationConstant;
import game.battleship.utility.ValidationUtility;
import junit.framework.TestCase;

public class BattleshipValidationTest extends TestCase implements ValidationConstant{
	
	public BattleshipValidationTest(String testName)
	{
		super(testName);
		
	}

	public void testValidateTargetsfailed()
	{
		String msg = "";
		 try {
			ValidationUtility.validateTarget("Player1", "");
		} catch (WrongInputException e) {
			msg = e.getMessage();
		}
		System.out.println(msg);
		assertEquals("Player1 "+battleshipTargetMessage, msg);
	}
	
	public void testvalidateShipTypeInputMissing()
	{
		String msg = "";
		 try {
			 String[] wh2 = "5,E".split(",");
			
			 int[] iwh = new int[2];
			 iwh[0] = CommonUtils.getIndexOfWidth(wh2[0])-1;
			 iwh[1] = CommonUtils.getIndexOfHeigth(wh2[1]);		
				
			 String input = "1 1 A1 B2";
			 ValidationUtility.validateShipType(input, iwh, wh2);
			
		} catch (WrongInputException e) {
			msg = e.getMessage();
		}
		assertEquals(battleShipTypeInputMissing, msg);
		System.out.println("testvalidateShipTypeInputMissing : passed");
	}
	
	public void testInvalideShipType()
	{
		String msg = "";
		 try {
			 String[] wh2 = "5,E".split(",");
			
			 int[] iwh = new int[2];
			 iwh[0] = CommonUtils.getIndexOfWidth(wh2[0])-1;
			 iwh[1] = CommonUtils.getIndexOfHeigth(wh2[1]);		
				
			 String input = "1 1 1  A1 B2";
			 ValidationUtility.validateShipType(input, iwh, wh2);
			
		} catch (WrongInputException e) {
			msg = e.getMessage();
		}		
		assertEquals(battleshipTypeMessage, msg);
		System.out.println("battleshipTypeMessage : passed");
	}
	public void testInvalidBattleshipPlace()
	{
		String msg = "";
		 try {
			 String[] wh2 = "5,E".split(",");
			
			 int[] iwh = new int[2];
			 iwh[0] = CommonUtils.getIndexOfWidth(wh2[0])-1;
			 iwh[1] = CommonUtils.getIndexOfHeigth(wh2[1]);		
				
			 String input = "P 1 1  66 B2";
			 ValidationUtility.validateShipType(input, iwh, wh2);
			
		} catch (WrongInputException e) {
			msg = e.getMessage();
		}		
		
		assertEquals("P"+battleshipPlaceMessage, msg);
		System.out.println("testInvalidBattleshipPlace : passed");
	}
	public void testvalidateNumberOfBattleShipFailed()
	{
		String msg = "";
		 try {
			ValidationUtility.validateNumberOfBattleShip("AB", 25);
		} catch (WrongInputException e) {
			msg = e.getMessage();
		}
		assertEquals(battleshipNumberMessage, msg);
		System.out.println("testvalidateNumberOfBattleShipFailed : passed");
	}	
	public void testBattleAreaFailed()
	{
		String msg = "";
		try {
			ValidationUtility.validateBattleArea("0,0");
		} catch (WrongInputException e) {
			msg = e.getMessage();
		}
		assertEquals(areaValidationMessage, msg);
		System.out.println("testBattleAreaFailed : passed");
		
	}
	public void testValidInput()
	{
		String[] inputs = new String[6];
		inputs[0] = "5,E";
		inputs[1] = "2";
		inputs[2] = "Q 1 1 A1 B2";
		inputs[3] = "P 2 1 D4 C3";
		inputs[4] = "A1 B2 B3 B2";
		inputs[5] = "A1 B2 B3 A1 D1 E1 D4 D4 D5";
		String msg =null;
		try {
			ValidationUtility.validateInput(inputs);
		} catch (WrongInputException e) {
			msg = e.getMessage();
		}
		assertNull(msg);
		
		
	}
	
	public void testGetIndexOfHeightAndWeight()
	{
		int indH = CommonUtils.getIndexOfHeigth("H");
		int indW = CommonUtils.getIndexOfWidth("3");
		assertEquals(indH, 8);
		assertEquals(indW, 3);
		
		indH = CommonUtils.getIndexOfHeigth("ZZ");
		indW = CommonUtils.getIndexOfWidth("10");
		assertEquals(indH, 27);
		assertEquals(indW, 10);
		
		
	}
	
}
