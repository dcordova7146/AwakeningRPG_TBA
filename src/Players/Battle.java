package Players;

public interface Battle {
    //Users defend and evade methods
    int defend(Player player);
    int evade(Player player);
    //Foes defend and evade methods
    int defend(Enemy enemy);
    int evade(Enemy enemy);
}
