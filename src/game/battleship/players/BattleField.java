package game.battleship.players;

import game.battleship.utility.BattleShipConstant;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Jay Gohel
 * Class work as battleField where player can play a war
 */
public class BattleField {

	private static StringBuffer output = new StringBuffer();
	private static Map<String,Player> playerMap = new HashMap<String, Player>();
	
	 public static void addPlayers(Player player){
		 playerMap.put(player.getPlayerName(), player);
	 }
	 
	 /**
	 * @param playerName
	 * @param target
	 * @return status
	 */
	static public String  shootMissile(String playerName,String target)
	 {
		 String message = BattleShipConstant.MISS;
//		 System.out.println("--------");
//		 System.out.println("Shooting :" + playerName + ":" + target);
		 Player opponetPlayer = getOpponentPlayer(playerName);
//		 System.out.println("recieve battle area of " + opponetPlayer);
		 if(opponetPlayer.getBattleArea().isCorrectTarget(target))
		 {
			 message = BattleShipConstant.HIT;
			 if(isPlayerWon(opponetPlayer.getPlayerName()))
			 {
				 message =BattleShipConstant.WON;
			 }
		 }
		 return message;
		  
	 }

	/**
	 * @param playerName
	 * @return return oppenent player
	 */
	private static Player getOpponentPlayer(String playerName) {
		Iterator<Entry<String, Player>> itr = playerMap.entrySet().iterator();
		
		while(itr.hasNext())
		{
			Entry<String,Player> emap = itr.next();
			String name = emap.getKey();
			if(!playerName.equalsIgnoreCase(name))
			{
				return emap.getValue();
			}
		}
		return null;
	}
	
	/**
	 * @param playerName
	 * @return flag 
	 */
	public static boolean isPlayerWon(String playerName)
	{
		Player player = playerMap.get(playerName);
		if(player.getBattleArea().isAnyShipLeft())
			return false;
		return true;
	}
	
	/**
	 *  this will switch the player by switching flag of the playing of player
	 */
	public static void switchPlayer()
	{
		Player player1 = playerMap.get("Player1");
		Player player2 = playerMap.get("Player2");
		if(player1.isPlaying())
		{
			player1.setPlaying(false);
			player2.setPlaying(true);
		}
		else
		{
			player1.setPlaying(true);
			player2.setPlaying(false);
		}
	}

	/**
	 * @param player
	 * @return status
	 */
	public static String play(Player player) {
		
		String target = player.getNextTarget();
		System.out.println(player.getPlayerName() + " target " + target);
		if(BattleShipConstant.FINISHED.equals(target))
		{
			switchPlayer();
			output.append( player.getPlayerName() + " has no missile left to shoot " + BattleShipConstant.NEW_LINE);
			return target;
		}
		String status = BattleField.shootMissile(player.getPlayerName(), target);
		if(BattleShipConstant.WON.equals(status))
		{
			output.append( player.getPlayerName() + " fires missile with target " + target + " which got hit" + BattleShipConstant.NEW_LINE);
			output.append(player.getPlayerName() + " Won" +BattleShipConstant.NEW_LINE);
		}
		else 
		{	
			if(BattleShipConstant.MISS.equals(status))
			{
				switchPlayer();
			}
			output.append( player.getPlayerName() + " fires missile with target " + target + " which got " + status + BattleShipConstant.NEW_LINE);
		}
		return status;
		
	}
	
	/**
	 * @return output of the game
	 */
	public static String getOutput()
	{
		return output.toString();
	}

}
