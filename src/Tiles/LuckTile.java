package Tiles;

import Players.Player;

public class LuckTile extends Tile {

    public LuckTile(int x, int y)
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

        int randLuckEvent = (int)(Math.random() * 10) + 1;
        if(1 <= randLuckEvent && randLuckEvent <= 5){
            //50% the luck event is a trap
            // randomly set off a trap losing 25% of your health
            x.setHealthPoints(x.getHealthPoints() - ((int)(x.getHealthPoints()*.75)));
            System.out.println("Unfortunately you have stepped on a spike trap you managed to not be completely impaled but you suffer damage");
            System.out.println("Your remaining health is " + x.getHealthPoints() + ".");
            leaveRoom(x);
        }
        if(randLuckEvent == 2){
           if(randLuckEvent == 6){
               //place holder for holy altar that sets off awakening after 3 prayers
               if(x.getPrayers() > 3){
                   int rng = (int)((Math.random() * 5));
                   System.out.println("You are starting to annoy the divine god DEGO for praying too much in one day take some divine punishment");
                   System.out.println("You have been struck by the divine punishment of the all Righteous god DEGO. It did " + rng + " damage" );
                   x.setHealthPoints(x.getHealthPoints() - rng);
                   if(x.getHealthPoints() <= 0){
                       x.setHealthPoints(2);
                       System.out.println("The divine god DEGO has spared your life his divine punishment would have killed you had he not been merciless and sparred you and left your hp at 2");
                   }
                   System.out.println("Your remaining health is "+ x.getHealthPoints() + ".");
               }
               if(x.getPrayers() == 3){
                   //activate awakening basically hardcode all stat buffs in by using get stat mod set stat mod etc
                   System.out.println("You have prayed to the holy god DEGO enough times that the holy god DEGO has blessed upon you an awakening");
               }
               if(x.getPrayers() < 3){
                   x.setPrayers(x.getPrayers() + 1);
                   System.out.println("You pray to the divine god DEGO!");
                   System.out.println("Something special will happen if you pray enough times for the diving god DEGO to notice your call(you have prayed " + x.getPrayers() + "time(s))");
               }

           }
        }

    }
}
