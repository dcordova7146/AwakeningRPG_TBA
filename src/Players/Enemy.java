package Players;


public class Enemy implements Battle {
    public String enemyName;
    public int healthPoints;
    public int attackMod;
    public int defenseMod;
    public int evadeMod;
    public Enemy(String enemyName,int healthPoints, int attackMod, int defenseMod, int evadeMod)
    {
        this.enemyName = enemyName;
        this.attackMod = attackMod;
        this.defenseMod = defenseMod;
        this.evadeMod = evadeMod;
        this.healthPoints = healthPoints;
    }
    public int cpu(int pAttackRoll){
        int rand = 0;
        rand = (int)((Math.random() * 2) + 1);
        int enemyDamageTaken = 0;
        if(rand == 1){
            enemyDamageTaken = pAttackRoll - defend();
            return enemyDamageTaken;
        }
        if(rand == 2){
            enemyDamageTaken = pAttackRoll - evade();
            if(enemyDamageTaken < 0){
                System.out.println("You missed!");
                return 0;
            }
            else{
                System.out.println("You were able to attack the enemy while it was vulnerable and it took full damage");
                enemyDamageTaken = pAttackRoll;
                return enemyDamageTaken;
            }
        }
        return enemyDamageTaken;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackMod() {
        return attackMod;
    }

    public void setAttackMod(int attackMod) {
        this.attackMod = attackMod;
    }

    public int getDefenseMod() {
        return defenseMod;
    }

    public void setDefenseMod(int defenseMod) {
        this.defenseMod = defenseMod;
    }

    public int getEvadeMod() {
        return evadeMod;
    }

    public void setEvadeMod(int evadeMod) {
        this.evadeMod = evadeMod;
    }

    public int rollDice(){
        int roll = 0;
        roll = (int)((Math.random() * 6) + 1);
        return roll;
    }

    public int defend(){
        int defendRoll = 0;
        defendRoll = rollDice() + this.defenseMod;
        return defendRoll;
    }
    public int evade(){
        int evadeRoll = 0;
        evadeRoll = rollDice() + this.evadeMod;
        return evadeRoll;
    }

}
