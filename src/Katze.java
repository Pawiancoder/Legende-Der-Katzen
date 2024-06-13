package src;

import src.Player.Potions;
import src.Player.Waffe;

/**
 * 
 * @author EgoBlack, Pawianberater
 */
public class Katze extends Waffe {
    private Potions potion;
    String Name;
    int Stimmung;
    Waffe waffe; // Waffe von der Katze
    Potions trank; // Trank der Katze
    boolean istHungrig;
    // int Kampfkraft;
    int MiauAnzahl;
    int HealthPoints;
    int xp;
    int level;

    public void miau() {
        for (int i = 1; i <= this.MiauAnzahl; i++) {
            System.out.println("[" + this.Name + "] Miau!");
        }
    }

    public void fuettern() {
        this.Stimmung += 2;
        this.istHungrig = false;
    }

    public void aergern() {
        this.Stimmung -= 2;
    }

    
    /** 
     * @param gegner
     */

    public void wirdAngegriffenVon(Katze gegner) {
        System.out.println(
                this.Name + " Waffe: " + this.waffe + ", greift " + gegner.Name + " Waffe: " + gegner.waffe + " an!"); // Zeigt
                                                                                                                       // Katze
                                                                                                                       // und
                                                                                                                       // Waffe
                                                                                                                       // an
        System.out.println(".");
        System.out.println("..");
        System.out.println("...");

        final int gegnerTemp = gegner.waffe.coolDown;
        int gegnerCooldown = gegnerTemp; // Speichert Cooldown als final und setzt ihn in die TEMP Variable
        final int myTemp = this.waffe.coolDown;
        int myCoolDown = myTemp;
        int round = 0;

        while (this.HealthPoints > 0 && gegner.HealthPoints > 0) {
            round++;
            System.out.println("Gegner: " + gegner.HealthPoints);
            System.out.println("HARRALD: " + this.HealthPoints);
            if (gegnerCooldown == 0) {
                this.HealthPoints -= gegner.waffe.Schaden; // Angreifende Katze bekommt schaden
                gegnerCooldown = gegnerTemp + 1;
            }
            if (myCoolDown == 0) {
                gegner.HealthPoints -= this.waffe.Schaden; // Verteidigende Katze bekommt schaden
                myCoolDown = myTemp + 1;
            }
            if (this.HealthPoints <= 0) {
                System.out.println(gegner.name + " hat gewonnen! Runden: " + round);
                break;
            } else if (gegner.HealthPoints <= 0) {
                System.out.println(this.Name + " hat gewonnen! Runden: " + round);
                break;
            }
            gegnerCooldown--;
            myCoolDown--; // Beides 1 minus
        }
    }
}
