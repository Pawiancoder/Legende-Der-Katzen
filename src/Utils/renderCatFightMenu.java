package src.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.Katze;
import src.Menu.Menu;
import src.Menu.inputOption;
import src.Player.Player;
import src.Player.Weapons.Waffe;

public class renderCatFightMenu {
private inputOption inputOption;
private Menu Menu;
private Katze Katze;
private Waffe Waffe;

public Katze[] katzenSpeicher = new Katze[3];
Katze Katze1 = new Katze();
Katze Katze2 = new Katze();
Katze Katze3 = new Katze();
//Katze1: 1 Level drüber (Kampfkraft höher)
//Katze2: gleiches Level / Kampfkraft
//Katze3: 1 Level drunter / Kampfkraft geringer

public void renderCats (Katze playerKatze, Scanner scanner, Player player) {
    Katze1.HealthPoints = playerKatze.MaxHealthPoints + 1; Katze1.xp = playerKatze.xp + 1;
    Katze2.HealthPoints = playerKatze.MaxHealthPoints; Katze2.xp = playerKatze.xp;
    Katze3.HealthPoints = playerKatze.MaxHealthPoints - 1; Katze3.xp = playerKatze.xp - 1;

    inputOption opt1 = new inputOption();
    inputOption opt2 = new inputOption();
    inputOption opt3 = new inputOption();

    opt1.optNum = 1; opt1.optionText = "Katze 1:" + " - " + Katze1.HealthPoints + " HP - " + Katze1.xp + " XP";
    opt2.optNum = 2; opt2.optionText = "Katze 2:" + " - " + Katze2.HealthPoints + " HP - " + Katze2.xp + " XP";
    opt3.optNum = 3; opt3.optionText = "Katze 3:" + " - " + Katze3.HealthPoints + " HP - " + Katze3.xp + " XP";

    //Waffen reinstopfen
    int damage1 = Math.round(Katze1.HealthPoints / 3); 
    int damage2 = Math.round(Katze2.HealthPoints / 3);
    int damage3 = Math.round(Katze3.HealthPoints / 3);

    Waffe waffe1 = new Waffe();
    waffe1.Schaden = damage1; waffe1.coolDown = 0;    





    Waffe waffe2 = new Waffe();
    waffe2.Schaden = 2;
    waffe2.coolDown = 1;
    

    Waffe waffe3 = new Waffe();
    waffe3.Schaden = damage3; 
    waffe3.coolDown = 2;
    //Funktionen der Katze

    //Waffe an Katzen zuweisen

    Katze1.waffe = waffe1;
    Katze2.waffe = waffe2;
    Katze3.waffe = waffe3;

    opt1.addFunction(() -> playerKatze.wirdAngegriffenVon(Katze1, player)); //Spieler greift Katze 1 an
    opt2.addFunction(() -> playerKatze.wirdAngegriffenVon(Katze2, player)); //Spieler greift Katze 2 an
    opt3.addFunction(() -> playerKatze.wirdAngegriffenVon(Katze3, player)); //Spieler greift Katze 3 an
    

    Menu kampfMenu = new Menu();
    kampfMenu.header = "Kampfmenü";
    kampfMenu.msg = "Wähle deinen Gegner aus, gegen welchen du Kämpfen willst";
    kampfMenu.addMenuItem(opt1); kampfMenu.addMenuItem(opt2); kampfMenu.addMenuItem(opt3);
    kampfMenu.sendMsg();
    boolean breakUp = false;
    while (!breakUp) {
        try {
            int nextInt = scanner.nextInt();
            if (nextInt > 3 || nextInt <= 0) { //Zahl testen
                System.out.println("Bitte eine Zahl zwischen 1 und 3 eingeben!");
            } else {
                int userIn = nextInt;
                kampfMenu.menuInput(userIn);
                breakUp = true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Bitti nur Zahli eingebi!"); //TODO: KURWA KAFFEE mitnehmen
        }
        scanner.next();
    }
} //Klasse

}
