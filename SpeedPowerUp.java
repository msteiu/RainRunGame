/**
 * FILENAME: SoeedPowerUp
 * DESCRIPTION: Powerup child implementing PowerUp abstract class. 
 */

public class SpeedPowerUp extends PowerUp {
    /*
     * Constructor of speed power-up
     * @ param int X coordinate of location 
     * @ param int Y coordinate of location 
     * @ param String pathdir for icon used
     */
    public SpeedPowerUp(int xCoord, int yCoord, String pathdir) {
        super(xCoord, yCoord, pathdir);
        powerType = "speed";
    }
}
