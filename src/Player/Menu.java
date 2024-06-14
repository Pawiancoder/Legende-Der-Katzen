package src.Player;

public class Menu {
    public String header;
    public String msg;

    public void sendMsg () {
        System.out.println("-----" + header + "-----");
        System.out.println(msg); //Content
        System.out.println("-----" + header + "-----");
    }
}
