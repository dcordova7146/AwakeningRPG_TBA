package Rooms;
import Players.Player;

public class Ambush extends Room{

    public Ambush(int x, int y)
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
        System.out.println("You Have been ambushed by PLACEHOLDER prepare to fight");
    }

}
