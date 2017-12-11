/**
 * FILENAME: Monster
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu and Angelina Li
 */

import java.awt.*;
import java.util.Random;

public class Monster extends MyCharacter implements FallingObject {

    // a bunch of nice blues
    private static final Color[] colors = {
        new Color(22, 111, 213),
        new Color(0, 70, 112),
        new Color(10, 164, 255),
        new Color(66, 188, 241),
        new Color(0, 101, 140),
        new Color(38, 196, 255),
        new Color(0, 118, 188),
        new Color(15, 75, 144),
        new Color(0, 157, 216),
        new Color(176, 224, 230)
    };
    
    public Monster(int xPos, int yPos, int size) {
        super(xPos, yPos, size, colors[new Random().nextInt(colors.length - 1)]);
    }

    @Override 
    public String getType() {
        return "monster";
    }

    @Override
    public void moveDown(int speed) {
      this.yPos += speed;
    }

    @Override
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillOval(xPos, yPos, size, size);
    }
}
