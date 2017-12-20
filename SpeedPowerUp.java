/**
 * FILENAME: SpeedPowerUp
 * DESCRIPTION: Speed power-up which extends PowerUp abstract class. The current power-up increases the speed of the player.
 * @author Angelina Li
 */

public class SpeedPowerUp extends PowerUp {
    /**
     * Constructor of speed power-up. It uses PowerUp's constructor, adding the specific type of the current power-up.
     * @param int X coordinate of location 
     * @param int Y coordinate of location 
     * @param int size to define which icon to use
     */
    public SpeedPowerUp(int xCoord, int yCoord, int size) {
        super(xCoord, yCoord, getImagePath(size));
        powerType = "speed";
    }

    /*
     * Static method that returns the String location of the speed image used within the game.
     * @param int size represents size of icon
     * @return String location of image
     */
    private static String getImagePath(int size) {
        return "images/speed" + size + ".png";
    }
}
