package Game;

import Players.*;
import Players.PlayerClasses.*;
import Tiles.*;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args) {
		Tile[][] dungeon = new Tile[5][5];
		for (int x = 0; x < dungeon.length; x++) {
			for (int y = 0; y < dungeon[x].length; y++) {
				dungeon[x][y] = new Tile(x, y);
			}
		}
		// generates a random tile onto each tile of the dungeon Map
		int rng = 0;
		for(int i = 0; i < dungeon.length; i++){
			for(int j = 0; j < dungeon[i].length; j++){
				rng = (int)(Math.random() * 101);
				if(0 <= rng && rng <= 66)
					dungeon[i][j] = new AmbushTile(i,j);
				if(67 <= rng && rng <= 76)
					dungeon[i][j] = new ShopTile(i,j);
				if(77 <= rng && rng <= 100)
					dungeon[i][j] = new LuckTile(i,j);
			}
		}
		// Swap method
		Tile[] specificTile = new Tile[3];
		specificTile[0] = new BossTile();


		//Setup player 1 and the input scanner
		System.out.println("Which class are you?(Type in the full name as seen to receive their respective stats and a description of that class.");
		System.out.print("There are 5 classes to choose \n Villager, Hero, Thief, Mage, Knight");
		Boolean characterCreationSuccessful = false;
		Scanner in = new Scanner(System.in);
		String possibleClass = in.nextLine();
		while (characterCreationSuccessful != true) {
			if (possibleClass.contains("villager")) {
				System.out.println("The villager class is the most basic of all 5 classes, with no decent armor or strong weapon the villagers only good quality is his speed. \n Stats: \n HP: 8 \n " +
						"ATTK: 0 \n DEF: 0 \n EVA: +1 \n The villagers awakening is a bonus 5 Health points");
				System.out.println("Are you sure you want to choose the villager?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Villager", Villager.healthPoints, Villager.attackMod, Villager.defenseMod, Villager.evadeMod, 0, 0);
					dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("hero")) {
				System.out.println("The hero class is all about strength with more hp and strength than the rest of the classes however his huge sword denies him the mobility to evade most attacks. \n " +
						"Stats: \n HP: 9 \n ATTK: +3 \n DEF: +1 \n EVA: -3 \n The heroes awakening is a buff to his attack and defend modifiers at the cost of more evade loss");
				System.out.println("Are you sure you want to choose the Hero?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Hero", Hero.healthPoints, Hero.attackMod, Hero.defenseMod, Hero.evadeMod, 0, 0);
					dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("thief")) {
				System.out.println("The thief class is not very heroic but is much faster than the rest of the classes however to move that fast he sacrifices heavy armor so dont expect him to take to " +
						"many hits. \n Stats: \n HP: 6 \n ATTK: -1 \n DEF: 0 \n EVA: +4 \n The thief's awakening is a buff to his attack and evade modifiers.");
				System.out.println("Are you sure you want to choose the Thief?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Thief", Thief.healthPoints, Thief.attackMod, Thief.defenseMod, Thief.evadeMod, 0, 0);
					dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("mage")) {
				System.out.println("The mage class is a user that specializes in magic in this game however it means they are a glass cannon with extremely high attack mods but very low defenseive " +
						"stats and hp. \n Stats: \n HP: 6 \n ATTK: +4 \n DEF: -2 \n EVA: +1 \n The mage's awakening is a buff to attack and a debuff to defense.");
				System.out.println("Are you sure you want to choose the Mage?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Mage", Mage.healthPoints, Mage.attackMod, Mage.defenseMod, Mage.evadeMod, 0, 0);
					dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("knight")) {
				System.out.println("The knight class is the most defensive of all the classes with high defense modifiers but middling attack and evade mods \n Stats: \n HP: 10 \n ATTK: +1 \n DEF: +3 " +
						"\n EVA: -2 \n The knights awakening is a major buff to his evade mod");
				System.out.println("Are you sure you want to choose the Knight?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Knight", Knight.healthPoints, Knight.attackMod, Knight.defenseMod, Knight.evadeMod, 0, 0);
					dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
		}
		/* find fix for player */

		while (gameOn) {
			System.out.println("Where would you like to move? (WASD commands type in help for help");
			String move = in.nextLine();
			if (validMove(move, player , dungeon)) {
				System.out.println("Your coordinates: row = " + player.getxLoc() + " col = " + player.getyLoc());

			}
			else {
				System.out.println("Please choose a valid move.");
			}


		}
		in.close();
	}
	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Player p, Tile[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "w":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "d":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "a":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
	


}
