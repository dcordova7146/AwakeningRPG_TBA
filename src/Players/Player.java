package Players;

/**
 * Player represents the player as they move through the game.
 */
public class Player implements Battle{
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
	public int defend(Enemy enemy){
		int defendRoll = 0;
		defendRoll = rollDice() + enemy.defenseMod;
		return defendRoll;
	}
	public int evade(Enemy enemy){
		int evadeRoll = 0;
		evadeRoll = rollDice() + enemy.evadeMod;
		return evadeRoll;
	}

	public int rollDice(){
		int roll = 0;
		roll = (int)((Math.random() * 6) + 1);
		return roll;
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
