package adventure.game.locations.battle;

import adventure.game.Player;
import adventure.game.locations.Location;
import adventure.game.locations.safe.SafeHouse;
import adventure.game.obstacles.Obstacle;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obstacleNumber = randomObstacleNumber();

        System.out.println("---------------------------------------------------");
        System.out.println("Suan buradasiniz : " + this.getName());
        System.out.println("Burada " + obstacleNumber + " "+ this.getObstacle().getName() + " var");
        System.out.println("1 - Savas");
        System.out.println("2 - Kac");
        System.out.println("---------------------------------------------------");
        int selectCase = input.nextInt();
        switch (selectCase){
            case 1:
                System.out.println("Savas");
                battle(obstacleNumber);
                break;
            case 2:
                System.out.println("Kac");
                break;
            default:
                System.out.println("Gecersiz deger");
        }
        return true;
    }

    private void escape(){

    }

    public boolean battle(int obstacleNumber){
        for (int i = 1; i <= obstacleNumber; i++){
            eachBattleTour(obstacleNumber);
            getPlayer().setMoney(getObstacle().getAward() + getPlayer().getMoney());
        }

        return false;
    }

    private void eachBattleTour(int obstacleNumber){
        while (getPlayer().getHealth() > 0 &&  getObstacle().getHealth() > 0){
            showPlayerStats();
            showObstacleStats(obstacleNumber);
            System.out.println("1 - Saldir");
            System.out.println("2 - Kac");
            System.out.print("Seciminiz :");
            int battleSelection = input.nextInt();

            switch (battleSelection){
                case 1 :
                    System.out.println("saldir");
                    playerAttackToObstacle();
                    obstacleAttackToPlayer();
                    break;
                case 2 :
                    System.out.println("kac");
                    break;
                default:
                    System.out.println("gecersiz islem");

            }
        }
        showPlayerStats();
        showObstacleStats(obstacleNumber);
    }

    private void playerAttackToObstacle(){
        int playerDamage = getPlayer().getDamage();
        int obstacleHealth = obstacle.getHealth();

        obstacle.setHealth(obstacleHealth - playerDamage);
    }

    private void obstacleAttackToPlayer(){
        int playerHealth = getPlayer().getHealth();
        int obstacleDamage = (obstacle.getDamage() - getPlayer().getProtection());

        if (obstacleDamage < 0){
            obstacleDamage = 0;
        }
        getPlayer().setHealth(playerHealth - obstacleDamage);
    }

    private void showPlayerStats() {
        System.out.println("---------------------------------------------------");
        System.out.println("Oyuncu degerleri");
        System.out.println("---------------------------------------------------");
        System.out.println("\tSaglik : " + getPlayer().getHealth() +
                            "\tHasar : " + getPlayer().getDamage() +
                            "\tKoruma : " + getPlayer().getProtection()
        );
        System.out.println("---------------------------------------------------");
    }

    private void showObstacleStats(int obstacleNumber){
        System.out.println("---------------------------------------------------");
        System.out.println(getObstacle().getName() + " degerleri");
        System.out.println("---------------------------------------------------");
        System.out.println("\tSayi : " + obstacleNumber +
                            "\tHasar : " + getObstacle().getDamage() +
                            "\tSaglik : " + getObstacle().getHealth() +
                            "\tOdul : " + getObstacle().getAward());
        System.out.println("---------------------------------------------------");
    }


    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
