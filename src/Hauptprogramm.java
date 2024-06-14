package src;
import java.util.Random;
import java.util.Scanner;

import src.Menu.Menu;
import src.Menu.inputOption; 
import src.Player.Player;
import src.Player.Inventory.Inventory;
import src.Player.Inventory.Item;
import src.Player.Weapons.Potions;
import src.Player.Weapons.Waffe;
/** 
 * @author EgoBlack, Pawianberater
 */
public class Hauptprogramm extends Katze {
    private static double versionNum = 1.0;
    private Waffe Waffen;
    private Potions Potions;
    private Inventory Inventory;
    private static Player Player;
    private Menu Menu;

    //Singleplayer => nur ein Spieler

    /**
     * @author EgoBlack, Pawianberater
     * @param args
     */
    public static void main(String[] args) {
        
        // init
        Inventory Inv = new Inventory(10);
        Player Spieler = new Player();
        Katze Katze = new Katze();

        //init(Spieler, Katze);
        Menu Menu1 = new Menu();
        Menu1.header = "Testmenü";
        Menu1.msg = "Das ist ein Testmenü! :D HARRALD";
        inputOption opt1 = new inputOption();
        inputOption opt2 = new inputOption();
        opt1.optNum = 1; opt1.optionText = "Kämpfen";
        opt2.optNum = 2; opt2.optionText = "Inventar öffnen";
        opt1.addFunction(() -> {
            System.out.println("Hallo du affe!");
        });
        opt2.addFunction(() -> {
            System.out.println("RAUSCH");
        });

        Menu1.addMenuItem(opt1); Menu1.addMenuItem(opt2);
        Menu1.sendMsg();
        Menu1.menuInput(2);

        Menu1.sendMsg();

        Potions Trank1 = new Potions(); // Potion1 => erste Healpotion
        Trank1.name = "Einfacher Heiltrank";
        Trank1.effectType = "Heilungstrank"; // Name vom Effekt
        Trank1.duration = 1; // 1 runde healing
        Trank1.value = 3; // +3 HP pro Runde

        Potions Trank2 = new Potions();
        Trank2.name = "einfacher Schadenstrank";
        Trank2.effectType = "Schadenstrank";
        Trank2.duration = 1; // 1 runde damage (Zeit)
        Trank2.value = 3; // -3 HP an Gegner pro Runde

        Potions Trank3 = new Potions();
        Trank3.name = "Trank der Staerkung";
        Trank3.effectType = "Verstaerkt Waffen Angriffe";
        Trank3.duration = 1; // 1 runde Schadens staerkung fuer die Waffe
        Trank3.damageBuff = true; // Setzt effekt auf Waffe

        // Attribute Babajaga(Waffe1)
        Waffe waffe1 = new Waffe();
        waffe1.name = "Babajaga";
        waffe1.Waffentyp = "MP";
        waffe1.Schaden = 4;

        // Attribute AK-47(Waffe2)
        Waffe waffe2 = new Waffe();
        waffe2.name = "AK-47";
        waffe2.Waffentyp = "AK";
        waffe2.Schaden = 6;
        waffe2.coolDown = 1;

        // Attribute Stichi's Nuke(Waffe3)
        Waffe waffe3 = new Waffe();
        waffe3.name = "Stichi's Nuke";
        waffe3.Waffentyp = "Bombe";
        waffe3.Schaden = 8;
        waffe3.coolDown = 1;

        Item item1 = new Item(); //Item wird erzeugt
        item1.name = "stichis nuke"; //
        item1.waffe = waffe3;
        Inv.addItem(item1);
        //Inv.displayInventory();
        

        Katze katze1 = new Katze();
        katze1.HealthPoints = 5;
        katze1.waffe = waffe1;

        // Attribute Balschid
        Katze Katze2 = new Katze();
        Katze2.MiauAnzahl = 2;
        Katze2.Name = "Balschid";
        Katze2.Stimmung = 6;
        Katze2.istHungrig = true;
        Katze2.HealthPoints = 15;
        Katze2.waffe = waffe2;

        // Attribute HABICHT
        Katze Katze3 = new Katze();
        Katze3.MiauAnzahl = 20;
        Katze3.Name = "HABICHT";
        Katze3.Stimmung = 3;
        Katze3.istHungrig = false;
        Katze3.HealthPoints = 30;
        Katze3.waffe = waffe3;

    }

    /**
     * @author EgoBlack, Pawianberater
     * @param Character
     * @param Tier
     */
    public static void init(Player Character, Katze Tier) {
        //Game Setup - Player && Katze
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Die Legende der Katzen! Version: " + versionNum + " -----");
        System.out.println("----- SETUP -----");
        System.out.println("Willkommen zu unserem Kampfspiel! Bevor es losgeht,  \n müssen ein paar " +
        "Dinge eingerichtet werden!");
        System.out.println("Gib deinen namen ein: ");
        String textName = scanner.nextLine();
        leonTest(textName);
        Character.name = textName;
        System.out.println("Hallo, " + Character.name + "! Gib noch den Namen deiner Katze ein:");
        String text = scanner.nextLine();
        leonTest(text);
        Tier.Name = text;
        System.out.println(Tier.Name + " ist eine gute Wahl!"); 
        
        scanner.close();
        setupCat(Tier, Character);
        System.out.println("Katze: " + Tier.HealthPoints + " HP - " + Tier.Name);
    }

    public static void helloWorld () {
        System.out.println("Hello World!");
    }

    /**
     * @author EgoBlack, Pawianberater
     * @param katze
     */
    public static void leonTest (String text) {
        if (text.equalsIgnoreCase("susi.rosi")) {
            System.out.println("Verpiss dich, Leon!");
            System.exit(0);
        }
    }

    public static void setupCat (Katze katze, Player spieler) {
        katze.HealthPoints = 10;
        katze.level = 1; katze.xp = 0;
        spieler.level = 1; spieler.xp = 0;
        //TODO: !addExp(spieler, katze);
    }

    /**
     * @author EgoBlack, Pawianberater
     * @param max
     * @return 
     */
    public static int randomNum(int max) {
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
