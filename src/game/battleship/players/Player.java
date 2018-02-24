package game.battleship.players;

import game.battleship.utility.BattleShipConstant;

import java.util.Arrays;


/**
 * @author Jay Gohel
 * player of the game
 */
public class Player {
	
	private String playerName;
	private BattleshipArea area;
	private String[] missileSequence;
	private int hitCounter = 0;
	private boolean playing = false;
		
	public Player(String pName, String battleArea)
	{
		playerName = pName;
		area = new BattleshipArea(battleArea);		
	}
	
	/**
	 * @param type
	 * @param dimW
	 * @param dimH
	 * @param origin
	 */
	public void placeBattleShip(String type, int dimW, int dimH,  String origin)
	{
		area.placeBattleShip(type, dimW, dimH, origin);
	}

	/**
	 * @return missleSquenceArraylist
	 */
	public String[] getMissileSequence() {
		return missileSequence;
	}

	public void setMissileSequence(String[] missileSequence) {
		this.missileSequence = missileSequence;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	
	public BattleshipArea getBattleArea() {
		return area;
	}

	public int getHitCounter() {
		return hitCounter;
	}

	/**
	 * updating hit counter once player shoot missile
	 */
	public void updateHitCounter()
	{
		if(hasMoreMissiles())
		{
			hitCounter = hitCounter+1;
			System.out.println(playerName + " hitcounter update " + hitCounter);
		}
		else
		{
			System.out.println(playerName + " hit counter not updated");
		}
	}
			
	/**
	 * @return flag if player has missile to shot or not
	 */
	public boolean hasMoreMissiles()
	{
		return(hitCounter < missileSequence.length);
	}

	/**
	 * @return target
	 */
	public String getNextTarget()
	{
		String target = BattleShipConstant.FINISHED;
		if(hasMoreMissiles())
		{
			target = missileSequence[hitCounter];
			updateHitCounter();
		}
		return target;
	}
	
	/**
	 * @return flag if player is playing or not
	 */
	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	@Override
	public String toString() {
		return "Player [area=" + area + ", hitCounter=" + hitCounter
				+ ", missileSequence=" + Arrays.toString(missileSequence)
				+ ", playerName=" + playerName + "]";
	}
	
	
}
