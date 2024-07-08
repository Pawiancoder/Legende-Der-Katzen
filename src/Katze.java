package src;

import src.Player.Player;
import src.Player.Weapons.Potions;
import src.Player.Weapons.Waffe;
import src.Utils.initiate;
import src.Player.Experience;

/**
 * 
 * @author EgoBlack, Pawianberater
 */
public class Katze {
    
    public Potions potion;
    public String Name;
    public int Stimmung;
    public Waffe waffe; // Waffe von der Katze
    public Potions trank; // Trank der Katze
    public boolean istHungrig;
    // int Kampfkraft; => Die Kampfkraft - abgelößt durch Schaden der Waffe (Weapons/Waffe.java) ==> Waffen-Klasse
    public int MiauAnzahl;
    public int HealthPoints;
    public int MaxHealthPoints;
    public int xp;
    public int level;
    public boolean feeded;

    private Experience experience;

    public void miau() {
        for (int i = 1; i <= this.MiauAnzahl; i++) {
            System.out.println("[" + this.Name + "] Miau!");
        }
    }

    public void fuettern() {
        this.Stimmung += 2;
        this.istHungrig = false;
        //erweiterung => Regenerierung
        if (!this.feeded) {
            this.HealthPoints = this.MaxHealthPoints; //Herzen werden aufgefüllt
            this.feeded = true; //!Nach Kampf wird feeded auf false gesetzt => Katze kann nach dem Kampf
        }
    }

    public void aergern() { //wird nicht genutzt
        this.Stimmung -= 2;
    }

    
    /** 
     * @param gegner
     */

    public void wirdAngegriffenVon(Katze gegner, Player player) {
        System.out.println(
                this.Name + " Waffe: " + this.waffe + ", greift " + gegner.Name + " Waffe: " + gegner.waffe + " an!"); // Zeigt
                                                                                                                                                    // Waffe
                                                                                                                        // an
        System.out.println(".");
        System.out.println("..");
        System.out.println("...");

        final int gegnerTemp = gegner.waffe.coolDown;
        int gegnerCooldown = gegnerTemp; 
        int myTemp = this.waffe.coolDown;
        int myCoolDown = myTemp;
        int round = 0;

        while (this.HealthPoints > 0 && gegner.HealthPoints > 0) {
            round++;
            System.out.println("----------");
            System.out.println("Gegner: " + gegner.HealthPoints);
            System.out.println("Meine Katze:" + this.HealthPoints);
            System.out.println("----------");
            if (gegnerCooldown == 0) {
                this.HealthPoints -= gegner.waffe.Schaden; // Angreifende Katze bekommt schaden
                gegnerCooldown = gegnerTemp + 1;
            }
            if (myCoolDown == 0) {
                gegner.HealthPoints -= this.waffe.Schaden; // Verteidigende Katze bekommt schaden
                myCoolDown = myTemp + 1;
            }
            if (this.HealthPoints <= 0) {
                System.out.println(gegner.Name + " hat gewonnen! Runden: " + round);
                break;
            } else if (gegner.HealthPoints <= 0) {
                System.out.println(this.Name + " hat gewonnen! Runden: " + round);
                break;
            }
            gegnerCooldown--;
            myCoolDown--; // Beides 1 minus
        }
        System.out.println("Hallooooooooo");
        addExp(player, gegner);
    }
    //TODO: Diese funktion (addExp) hängt
    public void addExp(Player spieler, Katze katze) {
        final int MAXXPCAT = (int) Math.round(8.0 * katze.level) + 1; //Maximaele XP Punkte für Levelup
        final int MAXPLAYERLVL = 10 * spieler.level; //Maximaele XP Punkte für Levelup
        int levelUps = 0;
        System.out.println(spieler);
        //40% vom Level
        int newXP = Math.round((katze.level + 1) * 10); //!Hülfee
        System.out.println("Level: " + katze.level);
        katze.xp = (int) newXP;
        for (int i = newXP; newXP <= MAXXPCAT; i = i - MAXXPCAT) {
            
            System.out.println(newXP);
            System.out.println(i);
            katze.level++;
            levelUps++;
        }
        System.out.println("MAXXP: " + MAXXPCAT);
        System.out.println("NewXP: " + newXP);
        System.out.println("Levelups: " + levelUps + ". Level: " + katze.level);
        Experience exp = new Experience();
        for (int i = 0; i <= levelUps; i++) {
            exp.renderXpBar(MAXXPCAT, newXP);
        }
        exp.renderXpBar(MAXPLAYERLVL, newXP);
    }
}
