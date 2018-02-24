package game.battleship.utility;


public interface ValidationConstant extends BattleShipConstant {

	String AREA_PATTERN = "[1-9],[A-Z]";
	String TYPE_PATTERN = "[PQ]";
	
	//Messages
	String areaValidationMessage = "Battle are in first line should be in format of Width(1..9),height(A..Z) ex 5,E ";
	String areaInvalidHeight = "Battler area in first line : height should be between A..Z";
	String areaInvalidwidth = "Battler area in first line : width should be between 1..9";
	
	String battleshipNumberMessage = "Total number of battle ship in line 2 should be number and not max than height*width of battle area";
	String battleshipTypeMessage = "Ship type should be in P or Q";
	String battleshipTypeDimensionMessage = ": shiptype has invalid dimension it should be less than battle area.";
	String battleshipPlaceMessage = ": shiptype has invalid location to place.";
	
	String typeGenericMessage = "Something went wrong while providing battleship type";
	
	String battleShipTypeInputMissing = "Some input missing while providing ship type. it should be TYPE DIMW DIMH PLAYER1POS PLAYER2POS";
	
	String battleshipTargetMessage = "Player should have atlest one target.";
	
}
