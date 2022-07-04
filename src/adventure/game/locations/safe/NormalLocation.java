package adventure.game.locations.safe;

import adventure.game.Player;
import adventure.game.locations.Location;

public abstract class NormalLocation extends Location {
    public NormalLocation(Player player, String name) {
        super(player, name);
    }

    public abstract boolean onLocation();
}
