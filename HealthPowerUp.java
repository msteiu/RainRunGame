import javax.swing.*;
import java.util.Random;

public class HealthPowerUp extends PowerUp {
  
    public HealthPowerUp (int xCoord, int yCoord, String pathdir) {
        super(xCoord, yCoord, pathdir);
        powerType = "health";
    }
}