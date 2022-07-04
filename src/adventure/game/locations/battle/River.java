package adventure.game.locations.battle;

import adventure.game.Player;
import adventure.game.obstacles.Bear;
import adventure.game.obstacles.Obstacle;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "Nehir", new Bear(), "Su", 2);
    }
}
