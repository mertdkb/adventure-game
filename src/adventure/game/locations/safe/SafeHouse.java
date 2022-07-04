package adventure.game.locations.safe;

import adventure.game.Player;
import adventure.game.characthers.GameCharacther;
import adventure.game.locations.safe.NormalLocation;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(player, "Guvenli ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Guvenli evdesiniz, saglik yükseldi!");
        getPlayer().setHealth(getPlayer().getBaseHealth());
        return true;
    }
}
