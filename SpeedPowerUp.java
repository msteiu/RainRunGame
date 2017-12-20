/**
 * FILENAME: SoeedPowerUp
 * DESCRIPTION: Powerup child implementing PowerUp abstract class. 
 * @author Angelina Li
 */

public class SpeedPowerUp extends PowerUp {
    /**
     * Constructor of speed power-up
     * @param int X coordinate of location 
     * @param int Y coordinate of location 
     * @param int size to define which icon to use
     */
    public SpeedPowerUp(int xCoord, int yCoord, int size) {
        super(xCoord, yCoord, getImagePath(size));
        powerType = "speed";
    }

    private static String getImagePath(int size) {
        return "images/speed" + size + ".png";
    }
}
