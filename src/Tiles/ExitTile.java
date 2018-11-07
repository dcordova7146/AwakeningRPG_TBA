package Tiles;

import Game.Runner;
import Players.Player;

public class ExitTile extends Tile
{

	public ExitTile(int x, int y) {
		super(x, y);

	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Player entering
	 */
	@Override
	public void enterRoom(Player x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You found the winning room!");
		Runner.gameOff();
	}
	

}
