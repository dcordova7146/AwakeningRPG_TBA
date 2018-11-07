package Tiles;

import Players.Player;

public class BossTile extends Tile{
    public BossTile(int x, int y)
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
        System.out.println("You Encounter a huge DRAGON in a deep slumber atop a mountain of gold you decide its not worth it and try to tip toe in the opposite direction. The dungeon instantly becomes 50 degrees hotter " +
                "you somehow stepped on a stick the Dragon is awake, prepare to FIGHT.");
    }
}
