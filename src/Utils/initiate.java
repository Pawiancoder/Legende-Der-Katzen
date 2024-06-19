package src.Utils;

import java.util.Random;

import src.Katze;
import src.Player.Player;

public class initiate {
    /**
     * @author EgoBlack, Pawianberater
     * @param katze
     */
    public void leonTest (String text) {
        if (text.equalsIgnoreCase("susi.rosi")) {
            System.out.println("Verpiss dich, Leon!");
            System.exit(0);
        }
    }

    public void setupCat (Katze katze, Player spieler) {
        katze.HealthPoints = 10;
        katze.MaxHealthPoints = katze.HealthPoints;
        katze.level = 1; katze.xp = 0;
        spieler.level = 1; spieler.xp = 0;
    }

    /**
     * @author EgoBlack, Pawianberater
     * @param max
     * @return 
     */
    public int randomNum(int max) {
        int returnInt = 0;
        Random random = new Random();
        returnInt = random.nextInt(max) - 1;
        return returnInt;
    }
}
