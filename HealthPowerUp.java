/**
 * FILENAME: HealthPowerUp
 * DESCRIPTION: Powerup child representing health (heart symbol) which increases the number of hearts the player has. It is extending the
 * PowerUp abstract class. 
 * @author Angelina Li
 */

public class HealthPowerUp extends PowerUp {
    /**
     * Constructor of a health power-up
     * @param int X coordinate of location 
     * @param int Y coordinate of location 
     * @param int size to define the size of the icon to use
     */
    public HealthPowerUp (int xCoord, int yCoord, int size) {
        super(xCoord, yCoord, getImagePath(size));
        powerType = "health";
    }
    
    /*
     * Static method that returns the location of the image use for the representation of the health power-up (heart image).
     * @param size int which represents the size of the image
     * @return String representation of the image location
     */
    private static String getImagePath(int size) {
        return "images/heart" + size + ".png";
    }
}
