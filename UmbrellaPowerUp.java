/**
 * FILENAME: UmbrellaPowerUp
 * DESCRIPTION: Umbrella power-up which extends PowerUp abstract class, using its constructor and adding the specific type of the umbrella
 * power-up. 
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

    /*
     * Static method that returns the String location of the umbrella image used within the game.
     * @param int size represents size of icon
     * @return String location of image
     */
    private static String getImagePath(int size) {
        return "images/umbrella" + size + ".png";
    }

}
