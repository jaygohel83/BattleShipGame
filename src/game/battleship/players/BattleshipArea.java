package game.battleship.players;

import game.battleship.utility.BattleShipConstant;
import game.battleship.utility.BattleShipTypes;
import game.battleship.utility.CommonUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jay Gohel
 * this class contains area of the battle field for player
 */
public class BattleshipArea implements BattleShipConstant{
	
	String[] targets;
	private Map<String,Integer> areaMap = new TreeMap<String, Integer>();
	
	public BattleshipArea(String area) {		
		createBattleShipArea(area);
	}

	/**
	 * @param area pobably first line e.g. 5,E 
	 * 
	 */
	private void createBattleShipArea(String area)
	{	
		String[] areaWH = area.split(",");
		for(String dw :defaultWidth)
		{
			for(String dh:defaultHeight)
			{
				areaMap.put(dh+dw, 0);				
				if(dh.equalsIgnoreCase(areaWH[1]))
					break;
			}
			if(dw.equalsIgnoreCase(areaWH[0]))
				break;
		}	
	}
	
	/**
	 * @param type
	 * @param dimW
	 * @param dimH
	 * @param origin
	 * placing battleship on perticilar location
	 */
	public void placeBattleShip(String type, int dimW, int dimH,  String origin)
	{
		System.out.println("type,w,h,origin:" + type + "," + dimW+ "," + dimH+ "," + origin);
		String startPointH = origin.substring(0,1);
		String startPointW = origin.substring(1,2);
		
		int startHeight = CommonUtils.getIndexOfHeigth(startPointH);
		int startWidth = CommonUtils.getIndexOfWidth(startPointW);
		
		int h = startHeight;
		int w = startWidth;
		System.out.println("h/w :" + h + ":" + w);
		for(int i=0;i<dimH;i++)
		{
			if(h >= defaultHeight.length)
				continue;
			String hc = defaultHeight[h-1];
			for(int j=0;j<dimW;j++)
			{	
				if(w >= defaultWidth.length)
					continue;
				String wc = defaultWidth[w-1];
				String areaKey = hc+wc;
				
				if(areaMap.containsKey(areaKey))
				{
					areaMap.put(areaKey, BattleShipTypes.get(type));
					System.out.println("Placing ship at :" + areaKey);
				}
				else
				{
					System.out.println("outside area key found :" + areaKey);
				}
				w++;
			}
			h++;
			w = startWidth;
		}
				
	}

	/**
	 * @param target
	 * @return hit or miss flag
	 */
	public boolean isCorrectTarget(String target)
	{
		System.out.println("areamap :" + areaMap);
		System.out.println("value found :" + areaMap.get(target));
		if(areaMap.get(target) != null && areaMap.get(target) > 0 )
		{
			
			int targetValue = areaMap.get(target);
			
			areaMap.put(target, targetValue-1);
			return true;
		}
		return false;
	}
	
	
	
	public void setMissileSequence(String[] missileTarget) {		
		targets = missileTarget;
	}

	public boolean isAnyShipLeft()
	{
		return areaMap.containsValue(1) || areaMap.containsValue(2); 
	}

	@Override
	public String toString() {
		return "BattleshipArea [areaMap=" + areaMap + ", targets="
				+ Arrays.toString(targets) + "]";
	}
	
	
}
