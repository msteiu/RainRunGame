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
     * @param String pathdir for icon used
     */
    public HealthPowerUp (int xCoord, int yCoord, String pathdir) {
        super(xCoord, yCoord, pathdir);
        powerType = "health";
    }
}
