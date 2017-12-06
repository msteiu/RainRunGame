import javax.swing.*;
import java.util.Random;

public class SpeedPowerUp extends PowerUp {
  
    public SpeedPowerUp(int xCoord, int yCoord, String pathdir) {
        super(xCoord, yCoord, pathdir);
        powerType = "speed";
    }
}