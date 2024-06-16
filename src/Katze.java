package src;
import src.Player.Weapons.Potions; //TODO: Potions richtig implementieren
import src.Player.Weapons.Waffe;

/**
 * 
 * @author EgoBlack, Pawianberater
 */
public class Katze extends Waffe {
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
