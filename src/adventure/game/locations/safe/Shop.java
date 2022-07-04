package adventure.game.locations.safe;

import adventure.game.Player;
import adventure.game.item.armors.*;
import adventure.game.item.weapons.*;


public class Shop extends NormalLocation {
    Weapon[] weapons = {new Pistol(), new Sword(), new Rifle()};
    Armor[] armors = {new LightArmor(), new MiddleArmor(), new HeavyArmor()};

    public Shop(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Magazaya hos geldiniz");
        System.out.println("1 ) Silahlar ");
        System.out.println("2 ) Zirhlar ");
        System.out.println("3 ) Magazadan cik ");
        System.out.print("Seciminiz : ");
        int selectCase = input.nextInt();


        switch (selectCase){
            case 1 :
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3 :
                break;
            default:
                System.out.println("Gecersiz bir islem secitiniz lütfen tekrar deneyiniz!");
                onLocation();
        }
        return true;
    }


    private void printWeapon() {
        for(Weapon w : weapons){
            System.out.println(w.getId() + ")\t" + w.getName() + "\t Hasar : " + w.getDamage() + "\t Fiyat : " + w.getPrice());
        }
    }

    public void buyWeapon(){
        System.out.print("Almak istediginiz silahi seciniz : ");
        int selectWeapon = input.nextInt() - 1;
        while (selectWeapon < 0 || selectWeapon > weapons.length + 1){
            System.out.print("Gecersiz bir deger girdiniz tekrar deneyiniz : ");
            selectWeapon = input.nextInt();
        }

        Weapon selectedWeapon = weapons[selectWeapon];
        if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
            System.out.println("Yeterli paraniz bulunmamaktadir");
        }
        else {
            System.out.println("Silah basariyla alindi");
            //set damage
            getPlayer().setDamage(getPlayer().getDamage() + selectedWeapon.getDamage());
            //set balance
            int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
            getPlayer().setMoney(balance);

            System.out.println("Mevcut silah : " + getPlayer().getInventory().getWeapon().getName());
            System.out.println("Kalan para : " + getPlayer().getMoney());

            this.getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println("Yeni silah : " + getPlayer().getInventory().getWeapon().getName());
        }
    }


    private void printArmor(){

        for(Armor a : armors){
            System.out.println(a.getName() + "\t Koruma : " +a.getProtection() + "\t Fiyat : " + a.getPrice());
        }
    }

    public void buyArmor(){
        System.out.print("Almak istediginiz zirhi seciniz : ");
        int selectArmor = input.nextInt() - 1;
        while (selectArmor < 0 || selectArmor > armors.length + 1){
            System.out.print("Gecersiz bir deger girdiniz tekrar deneyiniz : ");
            selectArmor = input.nextInt();
        }

        Armor selectedArmor = armors[selectArmor];
        if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
            System.out.println("Yeterli paraniz bulunmamaktadir");
        }
        else {
            System.out.println("Zirh basariyla alindi");
            //set protection
            getPlayer().setProtection(getPlayer().getProtection() + selectedArmor.getProtection());
            //set balance
            int balance = getPlayer().getMoney() - selectedArmor.getPrice();
            getPlayer().setMoney(balance);

            System.out.println("Mevcut zirh : " + getPlayer().getInventory().getArmor().getName());
            System.out.println("Kalan para : " + getPlayer().getMoney());

            this.getPlayer().getInventory().setArmor(selectedArmor);
            System.out.println("Yeni zirh : " + getPlayer().getInventory().getArmor().getName());
        }
    }
}
