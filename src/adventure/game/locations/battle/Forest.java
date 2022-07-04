package adventure.game.locations.battle;

import adventure.game.Player;
import adventure.game.obstacles.Obstacle;
import adventure.game.obstacles.Vampire;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Odun", 3);
    }
}
