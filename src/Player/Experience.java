package src.Player;

public class Experience {
    String xpBar = "[----------------------------------------------------------------------------------------------------]";
    
    public void renderXpBar (int maxXp, int actualXp) 
    {
        String xpBar = "";
        //Xp in prozent ausrechnen
        //100% = maxXP
        //x = actualxp

        //maxxp = 100%
        //actualXP = x

        // x = actualxp * 100 / maxxp

        int percent = Math.round(percent = actualXp * 100 / maxXp);
        int tempPercent = percent;
        xpBar += "[";
        for (int i = 1; i <= 100; i++) {
            if (tempPercent > 0) {
                xpBar += "+";
                tempPercent--;
            } else {
                xpBar += "-";
            }
        }
        xpBar += "]";
        System.out.println(xpBar);
    }

}
