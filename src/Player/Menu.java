package src.Player;

public class Menu {
    public String header;
    public String msg;
    public inputOption[] options = new inputOption[10];

    public void sendMsg () {
        System.out.println("-----" + header + "-----");
        for (int i = 0; i <= options.length - 1; i++) {
            System.out.println(options[i].optNum + " - " + options[i].optionText);
            break;
        }
        System.out.println("-----" + header + "-----");
    }

    public void menuInput () {
        for (int i = 0; i <= options.length - 1; i++) {
            
        }
    }

    public void addMenuItem (inputOption option) {
        for (int i = 0; i <= options.length - 1; i++) {
            if (options[i] == null) {
                options[i] = option;
            }
        }
    }
}
