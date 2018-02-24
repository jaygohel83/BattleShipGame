package game.battleship.utility;


public interface BattleShipConstant {
	
	String[] defaultHeight = new String("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z").split(",");
	String[] defaultWidth = new String("1,2,3,4,5,6,7,8,9").split(",");
	
	String PLAYER_1 = "Player1";
	String PLAYER_2 = "Player2";
	
	String NEW_LINE = "\n";
	
	//Status of the game
	String MISS = "MISS";
	String HIT = "HIT";
	String FINISHED = "FINISHED";
	String WON = "WON";
}
