/**
 * FILENAME: Monster
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu and Angelina Li
 */

import java.awt.*;
import java.util.Random;

public class Monster extends MyCharacter implements FallingObject {
    
    public Monster(int xPos, int yPos, int size, Color color) {
        super(xPos, yPos, size, color, false);
    }

    @Override 
    public String getType() {
        return "monster";
    }

    @Override
    public void moveDown(int speed) {
      this.yPos += speed;
    }
}
