package Rooms;

import Game.Runner;
import Players.Player;

public class WinningRoom extends Room
{

	public WinningRoom(int x, int y) {
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
