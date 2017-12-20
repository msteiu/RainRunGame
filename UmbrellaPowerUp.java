/**
 * FILENAME: UmbrellaPowerUp
 * DESCRIPTION: Powerup child implementing PowerUp abstract class. 
 * @author Angelina Li
 */

public class UmbrellaPowerUp extends PowerUp {
    /**
     * Constructor of umbrella power-up
     * @param int X coordinate of location 
     * @param int Y coordinate of location 
     * @param int size to define which icon to use
     */
    public UmbrellaPowerUp(int xCoord, int yCoord, int size) {
        super(xCoord, yCoord, getImagePath(size));
        powerType = "umbrella";
    }

    private static String getImagePath(int size) {
        return "images/umbrella" + size + ".png";
    }

}
