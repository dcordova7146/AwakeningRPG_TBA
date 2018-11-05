package Game;

import Players.Hero;
import Players.Player;
import Players.Villager;
import Rooms.Ambush;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Room[][] building = new Room[10][10];
		
		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}
		
		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);

		//Creates a random Ambush tile
		int xCoorMR = (int)(Math.random()*building.length);
		int yCoorMR = (int)(Math.random()*building.length);
		if(x == xCoorMR){
			xCoorMR = (int)(Math.random()*building.length);
		}
		if(y == yCoorMR){
			yCoorMR = (int)(Math.random()*building.length);
		}
		building[xCoorMR][yCoorMR] = new Ambush(xCoorMR,yCoorMR);

		//Creates a random Shop tile


		 //Setup player 1 and the input scanner
		System.out.println("Which class are you?(Type in the full name as seen to receive their respective stats and a description of that class.");
		System.out.print("There are 5 classes to choose \n Villager, Hero, Thief, Mage, Knight");
		Scanner in = new Scanner(System.in);
		String chosenClass = in.nextLine();
		if(chosenClass.contains("villager")) {
			System.out.println("The villager class is the most basic of all 5 classes, with no decent armor or strong weapon the villagers only good quality is his speed. \n Stats: \n HP: 8 \n ATTK: 0 \n DEF: 0 \n EVA: +1 \n The villagers awakening is a bonus 5 Health points");
			System.out.println("Are you sure you want to choose the villager?(Type in yes if so, no if no)");
			if (in.nextLine().contains("yes")) {
				Player player = new Player("Villager", Villager.healthPoints, Villager.attackMod, Villager.defenseMod, Villager.evadeMod, );
			}
		}
		if(chosenClass.contains("hero")) {
			System.out.println("The hero class is all about strength with more hp and strength than the rest of the classes however his huge sword denies him the mobility to evade most attacks. \n Stats: \n HP: 9 \n ATTK: +3 \n DEF: +1 \n EVA: -3 \n The heroes awakening is a buff to his attack and defend modifiers at the cost of more evade loss");
			System.out.println("Are you sure you want to choose the Hero?(Type in yes if so, no if no)");
			if (in.nextLine().contains("yes")) {
				Player player = new Player("Hero", Hero.healthPoints, Hero.attackMod, Hero.defenseMod, Hero.evadeMod, );
			}
		}
		if(chosenClass.contains("thief")){
			System.out.println("The thief class is not very heroic but is much faster than the rest of the classes however to move that fast he sacrifices heavy armor so dont expect him to take to many hits. \n Stats: \n HP: 6 \n ATTK: -1 \n DEF: 0 \n EVA: +4 \n The thief's awakening is a buff to his attack and evade modifiers");
			System.out.println("Are you sure you want to choose the Thief?(Type in yes if so, no if no");
			if(in.nextLine().contains("yes")){
				Player player = new Player("Thief",)
			}
		}
		Player player = new Player("FirstName", "FamilyName", 0,0);
		building[0][0].enterRoom(player1);

		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
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
			case "n":
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
			case "e":
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

			case "w":
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
