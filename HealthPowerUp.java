/**
 * FILENAME: HealthPowerUp
 * DESCRIPTION: Powerup child implementing PowerUp abstract class. 
 * @author Angelina Li
 */

public class HealthPowerUp extends PowerUp {
    /**
     * Constructor of health power-up
     * @param int X coordinate of location 
     * @param int Y coordinate of location 
     * @param int size to define which icon to use
     */
    public HealthPowerUp (int xCoord, int yCoord, int size) {
        super(xCoord, yCoord, getImagePath(size));
        powerType = "health";
    }

    private static String getImagePath(int size) {
        return "images/heart" + size + ".png";
    }
}
