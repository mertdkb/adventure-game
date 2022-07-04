package adventure.game;

import adventure.game.characthers.Archer;
import adventure.game.characthers.GameCharacther;
import adventure.game.characthers.Knight;
import adventure.game.characthers.Samurai;
import adventure.game.item.weapons.Weapon;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int protection;
    private int money;
    private String name;
    private String charName;
    Scanner input = new Scanner(System.in);
    private Inventory inventory = new Inventory();
    private int baseHealth;

    //constructor starts here
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }
    //constructor ends here

    //methods starts here
    public void selectChar(){
        GameCharacther[] charactherList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("---------------------------------------------------");
        for (GameCharacther gameCharacther : charactherList) {
            System.out.println(gameCharacther.getId() +
                    ")\t" + gameCharacther.getName() +
                    "\t Hasar : " + gameCharacther.getDamage() +
                    "\t Saglik : " + gameCharacther.getHealth() +
                    "\t Para : " + gameCharacther.getMoney());
        }
        System.out.println("---------------------------------------------------");
        System.out.print("Karakter seciniz : ");
        int charSelection = input.nextInt();

        switch (charSelection){
            case 1 :
                initPlayer(new Samurai());
                break;
            case 2 :
                initPlayer(new Archer());
                break;
            case 3 :
                initPlayer(new Knight());
                break;
            default:
                System.out.println("---------------------------------------------------");
                System.out.println("Gecersiz karakter secimi! tekrar karakter seciniz");
                selectChar();
        }
        //choosen characther check
        //System.out.println("Karakter : " + this.getCharName() + " Hasarın " + this.getDamage() + " Sağlığın : " + this.getHealth() + " Paran" + this.getMoney());
    }

    public void initPlayer(GameCharacther gameCharacther){
        setCharName(gameCharacther.getName());
        setDamage(gameCharacther.getDamage());
        setHealth(gameCharacther.getHealth());
        setMoney(gameCharacther.getMoney());
        setProtection(inventory.getArmor().getProtection());
        setBaseHealth(gameCharacther.getHealth());
    }

    public void printInfo(){
        System.out.println("Karakter adi : " + this.name +
                            "\tSilahiniz : " + this.getInventory().getWeapon().getName() +
                            "\tHasar : " + this.getDamage() +
                            "\tSaglik : " + this.getHealth() +
                            "\tKoruma : " + this.getProtection() +
                            "\tPara : " + this.getMoney());
    }


    //methods ends here

    //getter - setter starts here

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    //getter - setter ends here
}
