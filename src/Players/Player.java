package Players;

/**
 * Player represents the player as they move through the game.
 */
public class Player {
	String playerName;
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

	public Player(String playerName,int healthPoints, int attackMod, int defenseMod, int evadeMod,int xLoc, int yLoc)
	{
		this.playerName = playerName;
		this.attackMod = attackMod;
		this.defenseMod = defenseMod;
		this.evadeMod = evadeMod;
		this.heatlhPoints = healthPoints;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}


}
