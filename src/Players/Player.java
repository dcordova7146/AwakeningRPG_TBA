package Players;

/**
 * Player represents the player as they move through the game.
 */
public class Player {
	Consumable[] inventory = new Consumable[10];
	String playerName;
	int healthPoints;
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
		this.healthPoints = healthPoints;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}

	public void heal(int howMuch){
		//update so you cant go overboard
		//maybe include a max health points var
		healthPoints += 5;
	}
	//eat is confusing ask for help should the param for eat be the item or the person it is being used on maybe both?
	public void consume(int itemIndex){
		if(!(inventory[itemIndex] == null)){
			inventory[itemIndex].eat(this);
			inventory[itemIndex] = null;
		}
	}




}
