package Tiles;
import Players.Player;
import Players.Enemies.Goblin;
import Players.Enemies.Skeleton;
import Players.Enemies.Slime;



public class AmbushTile extends Tile {
    public AmbushTile(int x, int y)
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
        int eRNG = (int)(Math.random() * 3);
        if(eRNG == 0){

        }
        System.out.println("You have been AMBUSHED by " +  randomEnemy + " prepare to FIGHT");
    }

}
