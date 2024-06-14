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
import src.Utils.initiate;
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
    private inputOption inputOption;
    private initiate initiate;
    

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
        initiate initiator = new initiate(); //Instanz der initiate Datei erstellen

        init(Spieler, Katze, initiator);
        startGame();
        Menu Menu1 = new Menu();
        Menu1.header = "Testmenü";
        Menu1.msg = "Das ist ein Testmenü! :D HARRALD";
        inputOption opt1 = new inputOption();
        inputOption opt2 = new inputOption();

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
    public static void init(Player Character, Katze Tier, initiate initiator) {
        //Game Setup - Player && Katze
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Die Legende der Katzen! Version: " + versionNum + " -----");
        System.out.println("----- SETUP -----");
        System.out.println("Willkommen zu unserem Kampfspiel! Bevor es losgeht,  \n müssen ein paar " +
        "Dinge eingerichtet werden!");
        System.out.println("Gib deinen namen ein: ");
        String textName = scanner.nextLine();    
        Character.name = textName;
        System.out.println("Hallo, " + Character.name + "! Gib noch den Namen deiner Katze ein:");
        String text = scanner.nextLine();
        Tier.Name = text;
        System.out.println(Tier.Name + " ist eine gute Wahl!"); 
        
        scanner.close();
        initiator.setupCat(Tier, Character);
        System.out.println("Katze: " + Tier.HealthPoints + " HP - " + Tier.Name);
    }

    public static void startGame () {
        //START
    }

}
