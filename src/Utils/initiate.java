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

    public static void addExp(Player spieler, Katze katze) {
        final double MAXXPCAT = 8.0 * katze.level; //Maximaele XP Punkte für Levelup
        final int MAXPLAYERLVL = 10 * spieler.level; //Maximaele XP Punkte für Levelup
        int levelUps = 0;
        //40% vom Level
        double newXP = ((katze.level * 40.0) / 100.0) * 10.0;
        katze.xp = (int) newXP;
        for (double i = newXP; newXP >= MAXXPCAT; i = i - MAXXPCAT) {
            katze.level++;
            levelUps++;
        }
        System.out.println(katze.Name + " ist Level " + katze.level + "! Es gab " + levelUps + " Levelups!");
    }
}
