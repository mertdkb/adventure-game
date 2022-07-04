package adventure.game.item.armors;

public class Armor {
    private int id;
    private String name;
    private int protection;
    private int price;

    public Armor(int id, String name, int protection, int price) {
        this.id = id;
        this.name = name;
        this.protection = protection;
        this.price = price;
    }

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

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
