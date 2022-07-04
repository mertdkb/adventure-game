package adventure.game;

import adventure.game.item.armors.Armor;
import adventure.game.item.weapons.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;

    //constructor starts here
    public Inventory() {
        this.weapon = new Weapon(0, "Yumruk", 0, 0);
        this.armor = new Armor(0, "Yelek", 0, 0);
    }
    //constructor ends here

    //getter - setter starts here
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    //getter - setter ends here
}