package Players;

public abstract class potion implements Consumable {
    public void eat(Player player){
        player.heal(5);
    }
}
