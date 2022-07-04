package adventure.game;

import adventure.game.locations.Location;
import adventure.game.locations.battle.Cave;
import adventure.game.locations.battle.Forest;
import adventure.game.locations.battle.River;
import adventure.game.locations.safe.SafeHouse;
import adventure.game.locations.safe.Shop;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hos geldin!");
        System.out.print("Karakter adini giriniz : ");
        //String playerName = input.next();

        Player player = new Player("playerName");
        System.out.println("Hosgeldin, " + player.getName() + " Bu issiz adadan kurtulmak icin karakterini seç!");

        player.selectChar();

        //change location
        while (true) {
            //Location[] locations = {new SafeHouse(this), new Shop(this)};
            Location location = null;
            System.out.println("---------------------------------------------------");
            System.out.println("Bolgeler : ");
            System.out.println("1 - Guvenli Ev");
            System.out.println("2 - Magaza");
            System.out.println("3 - Magara");
            System.out.println("4 - Orman");
            System.out.println("5 - Nehir");
            System.out.print("Gitmek istediginiz yeri seciniz : ");
            int choosenLocation = input.nextInt();
            System.out.println("---------------------------------------------------");

            switch (choosenLocation){
                case 1 :
                    location = new SafeHouse(player);
                    player.printInfo();
                    break;
                case 2 :
                    location = new Shop(player);
                    break;
                case 3 :
                    location = new Cave(player);
                    break;
                case 4 :
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;
                default:
                    System.out.println("---------------------------------------------------");
                    System.out.println("Gecersiz bir konum sectiniz guvenli eve geri donuyorsunuz...");
                    location = new SafeHouse(player);
                }
            if(!location.onLocation()){
                System.out.println("Karakteriniz öldü!");
                break;
            }
        }

    }
}

