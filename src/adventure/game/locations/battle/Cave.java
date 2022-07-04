package adventure.game.locations.battle;

import adventure.game.Player;
import adventure.game.obstacles.Obstacle;
import adventure.game.obstacles.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Magara", new Zombie(), "Yemek", 3);
    }
}
