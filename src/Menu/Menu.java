/**
 * @author EgoBlack, Pawianberater
 */
package src.Menu;

public class Menu {
    public String header;
    public String msg;
    public inputOption[] options = new inputOption[10];
    

    public void sendMsg () {
        System.out.println("-----" + header + "-----");
        for (int i = 0; i <= options.length - 1; i++) {
            //System.out.println("Testnum: " + options[i]); 
            if (options[i] != null) {
                System.out.println(options[i].optNum + " - " + options[i].optionText);
            }
        }
        System.out.println("-----" + header + "-----");
    }

    public void menuInput (int inputNum) {
        for (inputOption option : options) {
            if (option != null && option.optNum == inputNum) {
                option.executeFunction(); //function wird ausgeführt
                break;
            }
        }
    }

    public boolean addMenuItem (inputOption option) {
        for (int i = 0; i <= options.length - 1; i++) {
            if (options[i] == null) {
                options[i] = option;
                return true;
            }
        }
        return false;
    }
}
