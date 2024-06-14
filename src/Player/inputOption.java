package src.Player;

import src.Functions.MenuFunction;

public class inputOption {
    public int optNum;
    public String optionText;
    private MenuFunction function;

    public void addFunction(MenuFunction function) {
        this.function = function;
    }

    public void executeFunction () {
        if (function != null) {
            function.execute();
        }
    }
}
