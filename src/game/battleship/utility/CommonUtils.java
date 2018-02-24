package game.battleship.utility;


public class CommonUtils implements BattleShipConstant{
	
	/**
	 * @param height
	 * @return possition
	 */
	public static int getIndexOfHeigth(String height) {
		int possition = 1;
		for(String dh:defaultHeight)
		{
			if(dh.equalsIgnoreCase(height))
			{
				return possition;
			}	
			possition++;
		}
		return possition;
	}
	/**
	 * @param width
	 * @return possition
	 */
	public static int getIndexOfWidth(String width) {
		int possition = 1;
		for(String dw:defaultWidth)
		{
			if(dw.equalsIgnoreCase(width))
			{
				return possition;
			}	
			possition++;
		}
		return possition;
	}


}
