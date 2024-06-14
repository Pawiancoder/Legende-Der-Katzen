package src.Menu;

public class inputOption {
    public int optNum;
    public String optionText;
    private MenuInterface function;

    public void addFunction(MenuInterface function) {
        this.function = function;
    }

    public void executeFunction () {
        if (function != null) {
            function.execute();
        }
    }
}
