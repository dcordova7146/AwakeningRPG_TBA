package Tiles;
import Players.Enemy;
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
        Enemy enemy = new Enemy("",0,0,0,0);
        if(eRNG == 0){
            enemy = new Enemy(Goblin.enemyName,Goblin.healthPoints,Goblin.attackMod,Goblin.defenseMod,Goblin.evadeMod);
        }
        if(eRNG == 1){
            enemy = new Enemy(Skeleton.enemyName,Skeleton.healthPoints,Skeleton.attackMod,Skeleton.defenseMod,Skeleton.evadeMod);
        }
        if(eRNG == 2){
            enemy = new Enemy(Slime.enemyName,Slime.healthPoints,Slime.attackMod,Slime.defenseMod,Slime.evadeMod);
        }
        System.out.println("You have been AMBUSHED by " + ENEMYNAME PLACE HOLDER  + " prepare to FIGHT");
    }

}
