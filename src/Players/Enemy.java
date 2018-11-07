package Players;


public class Enemy implements Battle {
    String enemyName;
    int healthPoints;
    int attackMod;
    int defenseMod;
    int evadeMod;
    public Enemy(String enemyName,int healthPoints, int attackMod, int defenseMod, int evadeMod)
    {
        this.enemyName = enemyName;
        this.attackMod = attackMod;
        this.defenseMod = defenseMod;
        this.evadeMod = evadeMod;
        this.healthPoints = healthPoints;
    }
    public void cpu(Player player){
        int rand = 0;
        rand = (int)((Math.random() * 2) + 1);
        if(rand == 1){
            //how get attack mod of the other character

        }
    }

    public int rollDice(){
        int roll = 0;
        roll = (int)((Math.random() * 6) + 1);
        return roll;
    }

    public int defend(Player player){
        int defendRoll = 0;
        defendRoll = rollDice() + this.defenseMod;
        return defendRoll;
    }
    public int evade(Player player){
        int evadeRoll = 0;
        evadeRoll = rollDice() + this.evadeMod;
        return evadeRoll;
    }

}
