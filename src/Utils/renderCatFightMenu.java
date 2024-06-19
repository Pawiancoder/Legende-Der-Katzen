package src.Utils;

import src.Katze;
import src.Menu.Menu;
import src.Menu.inputOption;
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

public void renderCats (Katze playerKatze) {
    Katze1.HealthPoints = playerKatze.MaxHealthPoints + 1; Katze1.xp = playerKatze.xp + 1;
    Katze2.HealthPoints = playerKatze.MaxHealthPoints; Katze2.xp = playerKatze.xp;
    Katze3.HealthPoints = playerKatze.MaxHealthPoints - 1; Katze3.xp = playerKatze.xp - 1;

    inputOption opt1 = new inputOption();
    inputOption opt2 = new inputOption();
    inputOption opt3 = new inputOption();

    opt1.optNum = 1; opt1.optionText = Katze1.Name + " - " + Katze1.HealthPoints + " HP - " + Katze1.xp + " XP";
    opt2.optNum = 2; opt2.optionText = Katze2.Name + " - " + Katze2.HealthPoints + " HP - " + Katze2.xp + " XP";
    opt3.optNum = 3; opt3.optionText = Katze3.Name + " - " + Katze3.HealthPoints + " HP - " + Katze3.xp + " XP";

    //Funktionen der Katze

    opt1.addFunction(() -> playerKatze.wirdAngegriffenVon(Katze1)); //Spieler greift Katze 1 an
    opt2.addFunction(() -> playerKatze.wirdAngegriffenVon(Katze2)); //Spieler greift Katze 2 an
    opt3.addFunction(() -> playerKatze.wirdAngegriffenVon(Katze3)); //Spieler greift Katze 3 an
    

    Menu kampfMenu = new Menu();
    kampfMenu.header = "Kampfmenü";
    kampfMenu.msg = "Wähle deinen Gegner aus, gegen welchen du Kämpfen willst";
    kampfMenu.addMenuItem(opt1); kampfMenu.addMenuItem(opt2); kampfMenu.addMenuItem(opt3);
    kampfMenu.sendMsg();
}

}
