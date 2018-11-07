package Tiles;
import Players.Player;

public class SpawnTile extends Tile{
    public SpawnTile(int x, int y)
    {
        super(x,y);
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Player entering
     */
    @Override
    public void enterRoom(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You wake up in a DUNGEON the air is cold, and its pitch black you have to ESCAPE. who knows what this dungeon has in store for you.");
        System.out.println("You notice you cell door is open its extremely dark but it appears the dungeon is a huge box what a coincidence must have been simpler to code that way.");
    }
}
