package adventure.game.obstacles;

public class Obstacle {
    private int id;
    private String name;
    private int health;
    private int damage;
    private int award;

    //constructor starts here
    public Obstacle(int id, String name, int health, int damage, int award) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.award = award;
    }
    //constructor ends here

    //getter - setter starts here
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    //getter - setter ends here
}
