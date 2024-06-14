package src.Player;

public class Menu {
    public String header;
    public String msg;
    public String[] options;
    public inputOption eingabeOption;

    public void sendMsg () {
        System.out.println("-----" + header + "-----");
        System.out.println(msg); //Content
        System.out.println("-----" + header + "-----");
    }

    public void checkInput (String input) {
        for (String option : this.options) {
            if (input.equalsIgnoreCase(option)) {
                
            }
        }
    }
}
