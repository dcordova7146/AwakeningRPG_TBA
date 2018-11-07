package Game;

import Players.*;
import Players.PlayerClasses.*;
import Rooms.Ambush;
import Rooms.Room;
import Rooms.ExitTile;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args) {
		Room[][] Dungeon = new Room[5][5];
		/*
		ask about if theres a way to iterate for every space in map and generating a room based on a percentage for example every tile should be a certain kind of room i am going for 66% of tiles
		should be fight tiles 10% shop tiles 14% should be luck tiles and the last 10 should be the misc tiles 4 tiles are automatically not in calculation because 1 is the winning tile 2 are boss
		tiles and the final exit tile is a thing
		*/
		//Fill the Dungeon with normal rooms

		for (int x = 0; x < Dungeon.length; x++) {
			for (int y = 0; y < Dungeon[x].length; y++) {
				Dungeon[x][y] = new Room(x, y);
			}
		}

		//Create a random Exit dungeon tile.
		int x = (int) (Math.random() * Dungeon.length);
		int y = (int) (Math.random() * Dungeon.length);
		Dungeon[x][y] = new ExitTile(x, y);

		//Creates a random Ambush tile
		int xCoorMR = (int) (Math.random() * Dungeon.length);
		int yCoorMR = (int) (Math.random() * Dungeon.length);
		if (x == xCoorMR) {
			xCoorMR = (int) (Math.random() * Dungeon.length);
		}
		if (y == yCoorMR) {
			yCoorMR = (int) (Math.random() * Dungeon.length);
		}
		Dungeon[xCoorMR][yCoorMR] = new Ambush(xCoorMR, yCoorMR);

		//Creates a random Shop tile


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
					Dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("hero")) {
				System.out.println("The hero class is all about strength with more hp and strength than the rest of the classes however his huge sword denies him the mobility to evade most attacks. \n " +
						"Stats: \n HP: 9 \n ATTK: +3 \n DEF: +1 \n EVA: -3 \n The heroes awakening is a buff to his attack and defend modifiers at the cost of more evade loss");
				System.out.println("Are you sure you want to choose the Hero?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Hero", Hero.healthPoints, Hero.attackMod, Hero.defenseMod, Hero.evadeMod, 0, 0);
					Dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("thief")) {
				System.out.println("The thief class is not very heroic but is much faster than the rest of the classes however to move that fast he sacrifices heavy armor so dont expect him to take to " +
						"many hits. \n Stats: \n HP: 6 \n ATTK: -1 \n DEF: 0 \n EVA: +4 \n The thief's awakening is a buff to his attack and evade modifiers.");
				System.out.println("Are you sure you want to choose the Thief?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Thief", Thief.healthPoints, Thief.attackMod, Thief.defenseMod, Thief.evadeMod, 0, 0);
					Dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("mage")) {
				System.out.println("The mage class is a user that specializes in magic in this game however it means they are a glass cannon with extremely high attack mods but very low defenseive " +
						"stats and hp. \n Stats: \n HP: 6 \n ATTK: +4 \n DEF: -2 \n EVA: +1 \n The mage's awakening is a buff to attack and a debuff to defense.");
				System.out.println("Are you sure you want to choose the Mage?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Mage", Mage.healthPoints, Mage.attackMod, Mage.defenseMod, Mage.evadeMod, 0, 0);
					Dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
			if (possibleClass.contains("knight")) {
				System.out.println("The knight class is the most defensive of all the classes with high defense modifiers but middling attack and evade mods \n Stats: \n HP: 10 \n ATTK: +1 \n DEF: +3 " +
						"\n EVA: -2 \n The knights awakening is a major buff to his evade mod");
				System.out.println("Are you sure you want to choose the Knight?(Type in yes if so, no if no)");
				if (in.nextLine().contains("yes")) {
					Player player = new Player("Knight", Knight.healthPoints, Knight.attackMod, Knight.defenseMod, Knight.evadeMod, 0, 0);
					Dungeon[0][0].enterRoom(player);
					characterCreationSuccessful = true;
				}
			}
		}
		/* find fix for player */

		while (gameOn) {
			System.out.println("Where would you like to move? (WASD commands type in help for help");
			String move = in.nextLine();
			if (validMove(move, player , Dungeon)) {
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
	public static boolean validMove(String move, Player p, Room[][] map)
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
