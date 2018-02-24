package game.battleship.app;

import game.battleship.exceptions.WrongInputException;
import game.battleship.utility.ReadWriteInputOutput;
import game.battleship.utility.ValidationUtility;

import java.util.List;

/**
 * @author Jay Gohel
 * class is used for running integration test case
 */
public class BattleShipInputTest {

	/**
	 * @param args
	 * @throws Exception 
	 * this will read testinputs.txt file and execute all test cases from it.
	 */
	public static void main(String[] args) {
		try {
		List<String[]> inputList = ReadWriteInputOutput.readInputForTest("testinputs.txt");
		System.out.println("Validation Start");
			int testcase = 1;
			for(String[] input:inputList)
			{
				try{
					ValidationUtility.validateInput(input);
					System.out.println(testcase +" is a valid input");
				}
				catch(WrongInputException e)
				{
					System.out.println("testcase : " +testcase + " is failing b'cos : " + e.getMessage());
				}
				
				testcase++;
			}
		
		System.out.println("Validation End");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
