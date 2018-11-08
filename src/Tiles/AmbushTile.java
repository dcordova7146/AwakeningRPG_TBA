package Tiles;
import Players.Enemy;
import Players.Player;
import Players.Enemies.Goblin;
import Players.Enemies.Skeleton;
import Players.Enemies.Slime;

import java.util.Scanner;


public class AmbushTile extends Tile {
    Scanner battle = new Scanner(System.in);
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
        Enemy enemy1 = new Enemy("",0,0,0,0);
        if(eRNG == 0){
            enemy1 = new Enemy(Goblin.enemyName,Goblin.healthPoints,Goblin.attackMod,Goblin.defenseMod,Goblin.evadeMod);
        }
        if(eRNG == 1){
            enemy1 = new Enemy(Skeleton.enemyName,Skeleton.healthPoints,Skeleton.attackMod,Skeleton.defenseMod,Skeleton.evadeMod);
        }
        if(eRNG == 2){
            enemy1 = new Enemy(Slime.enemyName,Slime.healthPoints,Slime.attackMod,Slime.defenseMod,Slime.evadeMod);
        }
        System.out.println("You have been AMBUSHED by " + enemy1.enemyName + " prepare to FIGHT");
        boolean ded = false;
        boolean enemyded = false;
        boolean myTurn = false;

        while (ded == false || enemyded == false){
            System.out.println("The " + enemy1.enemyName + " slowly moves towards you");
            System.out.println(enemy1.enemyName + " HP: " + enemy1.healthPoints);
            System.out.println(x.getPlayerName() +  " HP: " + x.getHealthPoints());

            System.out.println(myTurn + " (if false it is the enemies turn if true it is your turn)");
            int diceRoll = (int)((Math.random() * 6) + 1);
            int eAttackRoll = diceRoll + enemy1.attackMod;
            System.out.println("The enemy rolled a " + diceRoll + "+ (Enemy Attack mod: " + enemy1.attackMod + ") = " + eAttackRoll );
            if(myTurn == false){
                System.out.println("Do you wish to defend or evade the incoming attack from " + enemy1.enemyName + "!(Press Q for DEFEND, Press E for EVADE)");
            }
            if(myTurn == true){
                System.out.println("It is now your turn do you wish to run his fade.(Press F for ATTACK, press R for HEAL with a potion from your inventory)");
            }

            String choice = battle.nextLine().toLowerCase().trim();

            switch(choice) {
                case "q":
                    if (myTurn == false) {
                        int pDefendRoll = (int) ((Math.random() * 6) + 1) + x.getDefenseMod();
                        int damageTaken = pDefendRoll - eAttackRoll;
                        System.out.println("You have rolled a " + pDefendRoll + " for defense");
                        if (damageTaken <= 0)
                            damageTaken = 1;
                        x.setHealthPoints(x.getHealthPoints() - damageTaken);
                        System.out.println("You defended part of the damage");
                        if(x.getHealthPoints() <= 0){
                            System.out.println("You have died");
                            ded = true;
                            break;
                        }
                        System.out.println("Your remaining health is " + x.getHealthPoints() + ".");
                        myTurn = true;
                        break;

                    } else if(myTurn == true){
                        System.out.println("The enemy hasnt even swung yet what are you doing, it is your turn to run his fade!");
                        break;
                    }
                case "e":
                    if (myTurn == false) {
                        int pEvadeRoll = (int) ((Math.random() * 6) + 1) + x.getEvadeMod();
                        System.out.println("You have rolled a " + pEvadeRoll + " for evade");
                        if (pEvadeRoll > eAttackRoll) {
                            System.out.println("You were able to avoid the attack!(Since your evade roll was higher than the enemies attack roll");
                            break;
                        } else if (pEvadeRoll <= eAttackRoll) {
                            int damageTaken = eAttackRoll;
                            x.setHealthPoints(x.getHealthPoints() - damageTaken);
                            System.out.println("You failed at avoiding the attack and left yourself open to the full force of the attack");
                            if(x.getHealthPoints() <= 0){
                                System.out.println("You have died");
                                ded = true;
                            }
                            System.out.println("Your remaining health is " + x.getHealthPoints() + ".");
                            myTurn = true;
                            break;
                        }
                    } else if(myTurn == true){
                        System.out.println("The enemy hasnt even swung yet what are you doing, it is your turn to run his fade!");
                        break;
                    }
                case "f":
                    if(myTurn == true){
                        int pAttackRoll = (int)((Math.random() * 6) + 1) + x.getAttackMod();
                        System.out.println("You have rolled a "+ pAttackRoll + " for attack");
                        enemy1.setHealthPoints(enemy1.getHealthPoints() - enemy1.cpu(pAttackRoll));
                        if(enemy1.getHealthPoints() <= 0){
                            System.out.println("You have murdered a defenseless " + enemy1.enemyName + "!");
                            leaveRoom(x);
                            break;
                        }
                        if(enemy1.getHealthPoints() >= 1){
                            System.out.println("You have severely damaged " + enemy1.enemyName + "!");
                            System.out.println("The " + enemy1.enemyName + " remaining health is " + enemy1.getHealthPoints() + ".");
                            myTurn = false;
                            break;
                        }
                    }/**
                case "r":
                    if(myTurn == true){

                    }   **/
                default:
                    System.out.println("Thats not one of the battle buttons please try again(depending on your weather or not its you turn the battle button are limited to Q, E, and F");//add in r
                    // for when i add in potions

            }

        }
    }
    public void leaveRoom(Player x)
    {
        occupant = null;
    }

}


