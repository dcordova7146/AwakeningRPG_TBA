package Tiles;

import Players.Player;

public class ShopTile extends Tile {
    public ShopTile(int x, int y)
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
        System.out.println("You have entered the Divine Store");
        System.out.println("This is the Divine store it is organized by a non profit DEGO cult group that worships the divine god DEGO you can spend PRAYERS that you should be collecting along the " +
                "way to purchase things like potions and temporary stat boosting potions");
        if(x.getPrayers() < 1){
            System.out.println("DEGO Cult Memeber: Get your Unholy, non praying, disrespectful, trash out of my divine store. May the holy god DEGO have pity on your soul");
            leaveRoom(x);
        }
        else{
            System.out.println("DEGO Cult Member: Hello and welcome to the divine store what would you like to purchase this store sells: ");
            System.out.println("[0]    +5 hp potion | 1 prayer");
            System.out.println("[1]    +10 hp potion | 2 prayers");
            System.out.println("[2]    +1 to ATTK potion | 2 prayers(used immediately after purchase");
            System.out.println("[3]    +1 to DEF potion | 2 prayers(used immediately after purchase");
            System.out.println("[4]    +1 to EVA potion | 2 prayers(used immediately after purchase");
            System.out.println("[5]    Rotten Meat | 2 prayers(Lets you escape from any non boss fight)");
            System.out.println("[6]    Exit without purchasing anything free scolding by cult member");
            // none of this implemented yet although pretty simple. its 1 in the morning i dont feel like coding this right now
        }
    }
    public void leaveRoom(Player x)
    {
        occupant = null;
    }

}
