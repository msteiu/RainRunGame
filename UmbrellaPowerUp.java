/**
 * FILENAME: UmbrellaPowerUp
 * DESCRIPTION: Powerup child implementing PowerUp abstract class. 
 */

public class UmbrellaPowerUp extends PowerUp {
    /*
     * Constructor of umbrella power-up
     * @ param int X coordinate of location 
     * @ param int Y coordinate of location 
     * @ param String pathdir for icon used
     */
    public UmbrellaPowerUp(int xCoord, int yCoord, String pathdir) {
        super(xCoord, yCoord, pathdir);
        powerType = "umbrella";
    }

}
