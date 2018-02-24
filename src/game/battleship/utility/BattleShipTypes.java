package game.battleship.utility;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jay Gohel
 * All types of ship and its strength should be created here
 */
public class BattleShipTypes {

	private static Map<String,Integer> TYPE = new HashMap<String, Integer>();
	
	static{
		if(TYPE.size() == 0)
		{
			TYPE.put("P", 1);
			TYPE.put("Q", 2);
		}
	}
	
	public static int get(String type)
	{
		return TYPE.get(type);
	}
	
}
