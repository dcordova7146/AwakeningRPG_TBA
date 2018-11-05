package Players;

/**
 * Player represents the player as they move through the game.
 */
public class Player {
	String firstName;
	String familyName;
	int heatlhPoints;
	int attackMod;
	int defenseMod;
	int evadeMod;
	int xLoc, yLoc;


	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public Player(String firstName, String familyName, int healthPoints, int attackMod, int defenseMod, int evadeMod,int xLoc, int yLoc)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.attackMod = attackMod;
		this.defenseMod = defenseMod;
		this.evadeMod = evadeMod;
		this.heatlhPoints = healthPoints;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}


}
