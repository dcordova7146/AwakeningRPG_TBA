package Players;
import Players.Enemy;

/**
 * Player represents the player as they move through the game.
 */
public class Player {
	Consumable[] inventory = new Consumable[10];
	String playerName;
	private int healthPoints;
	private int attackMod;
	private int defenseMod;
	private int evadeMod;
	private int prayers;
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

	public Player(String playerName, int healthPoints, int attackMod, int defenseMod, int evadeMod, int xLoc, int yLoc, int prayers)
	{
		this.playerName = playerName;
		this.attackMod = attackMod;
		this.defenseMod = defenseMod;
		this.evadeMod = evadeMod;
		this.healthPoints = healthPoints;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.prayers = prayers;
	}
	/**
	public int defend(Player player){
		int defendRoll = 0;
		defendRoll = rollDice() + enemy.defenseMod;
		return defendRoll;
	}
	public int evade(Player player){
		int evadeRoll = 0;
		evadeRoll = rollDice() + enemy.evadeMod;
		return evadeRoll;
	}
	public int rollDice(){
		int roll = 0;
		roll = (int)((Math.random() * 6) + 1);
		return roll;
	}
	**/
	public void heal(int howMuch){
		//update so you cant go overboard
		//maybe include a max health points var
		healthPoints += 5;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getAttackMod() {
		return attackMod;
	}

	public void setAttackMod(int attackMod) {
		this.attackMod = attackMod;
	}

	public int getDefenseMod() {
		return defenseMod;
	}

	public void setDefenseMod(int defenseMod) {
		this.defenseMod = defenseMod;
	}

	public int getEvadeMod() {
		return evadeMod;
	}

	public void setEvadeMod(int evadeMod) {
		this.evadeMod = evadeMod;
	}
	public int getPrayers() {
		return prayers;
	}

	public void setPrayers(int prayers) {
		this.prayers = prayers;
	}


	//eat is confusing ask for help should the param for eat be the item or the person it is being used on maybe both?
	public void consume(int itemIndex){
		if(!(inventory[itemIndex] == null)){
			inventory[itemIndex].eat(this);
			inventory[itemIndex] = null;
		}
	}




}
