package game.battleship.app;

import game.battleship.exceptions.WrongInputException;
import game.battleship.players.BattleField;
import game.battleship.players.Player;
import game.battleship.utility.BattleShipConstant;
import game.battleship.utility.ReadWriteInputOutput;
import game.battleship.utility.ValidationUtility;

/**
 * @author Jay Gohel
 * Main class for this game 
 */
public class BattleShipGame {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		BattleShipGame game = new BattleShipGame();
		//Reading input from input.txt - should be in classpath
		String[] input = game.getInputFromFile("input.txt");
		
		if(input == null)
		{
			ReadWriteInputOutput.writeOutput("output.txt","Some issue while reading input file");
			return;
		}
		//Validation start
		System.out.println("Validation Start");
		try
		{
			ValidationUtility.validateInput(input);
		}
		catch(WrongInputException e)
		{
			ReadWriteInputOutput.writeOutput("output.txt","Wrong input :" + e.getMessage());
			e.printStackTrace();
			return;
		}
		System.out.println("Validation End");
		//Validation End
		//Setup Start
		System.out.println("Setup Start");
		Player player1 = game.createSetupForPlayer(BattleShipConstant.PLAYER_1,input,3,4);
		Player player2 = game.createSetupForPlayer(BattleShipConstant.PLAYER_2,input,4,5);
		
		System.out.println("player1 Battle Area : " + player1);
		System.out.println("player2 Battle Area : " + player2);
		System.out.println("setup done:");
//		Setup End
		
		//Game Start
		String output = game.start(player1,player2);
		System.out.println("Player 1:" + player1);
		System.out.println("Player 2:" + player2);
		ReadWriteInputOutput.writeOutput("output.txt", output);
		System.out.println("End of the Battle");
		
		System.out.println("End Battle:");
	}

	/**
	 * @param player1
	 * @param player2
	 * @return output of the game
	 */
	private String start(Player player1, Player player2) {
		boolean isResult = false;
		BattleField.addPlayers(player1);
		BattleField.addPlayers(player2);
		System.out.println("Start battle:");
		
		//Player 1 always get first chance to shoot
		player1.setPlaying(true);
		
//		Start shooting missile untill any one player won or both player finished the missile.
		while(player1.hasMoreMissiles() || player2.hasMoreMissiles())
		{
			if(player1.isPlaying())
			{
				String status = BattleField.play(player1);
				if(BattleShipConstant.WON.equals(status))
				{
					isResult = true;
					break;
				}				
			}
			if(player2.isPlaying())
			{
				String status = BattleField.play(player2);
				if(BattleShipConstant.WON.equals(status))
				{
					isResult = true;
					break;
				}				
			}
		}
		System.out.println("-------------------------------");
		System.out.println("Output");
		System.out.println("-------------------------------");
		
		String result = "";
		if(!isResult)
		{
			result = "Game Draw";
		}
		System.out.println(BattleField.getOutput() + "\n" + result);
		return BattleField.getOutput() + "\n" + result;
	}

	/**
	 * @param playerName
	 * @param input
	 * @param typeIndex
	 * @param missileIndex
	 * @return Player object
	 */
	private Player createSetupForPlayer(String playerName, String[] input, int typeIndex, int missileIndex) {
		Player player = new Player(playerName,input[0]);		
		String[] typeInput = new String(input[2]).split("\\s+");
		player.placeBattleShip(typeInput[0], Integer.parseInt(typeInput[1]), Integer.parseInt(typeInput[2]), typeInput[typeIndex]);
		typeInput = new String(input[3]).split("\\s+");
		player.placeBattleShip(typeInput[0], Integer.parseInt(typeInput[1]), Integer.parseInt(typeInput[2]), typeInput[typeIndex]);
		String[] missileTarget = new String(input[missileIndex]).split("\\s+");		
		player.setMissileSequence(missileTarget);			
		return player;
	}

	/**
	 * @param inFile
	 * @return input[] for the game
	 */
	private String[] getInputFromFile(String inFile) {
		String[] inputLines;
		try {
			inputLines = ReadWriteInputOutput.readInput(inFile);
			System.out.println("inputs:");
			for(String line : inputLines)
			{
				System.out.println(line);
			}
			return inputLines;
		} catch (Exception e) {
		
		}
		return null;
	}
	
}
