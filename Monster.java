/**
 * FILENAME: Monster
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu
 */

import java.awt.*;

public class Monster extends MyCharacter implements Character {
    
    public Monster(int xPos, int yPos, int size, Color color) {
        super(xPos, yPos, size, color);
    }

    @Override
    public String getType() {
        return "monster";
    }

    // @Override
    // public void drawCharacter(Graphics g) {}

    // @Override
    // public Rectangle getBounds() {}
}