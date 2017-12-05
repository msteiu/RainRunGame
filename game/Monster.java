/**
 * FILENAME: Monster
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * Monster interface - implemented by RainMonster
 * @author Angelina
 */

import java.awt.Graphics;

public interface Monster {

    // starting position
    public Monster(int xPos, int yPos, int size);

    public int getXPos();

    public int setXPos();

    public int getYPos();

    public int setYPos();gr

    // move character position by set amount to the right
    public void moveRight();

    // move character position by set amount to the left
    public void moveLeft();

    // will draw character using Graphics package
    // see Car example
    // in graphics, x and y position are where the top left corner of
    // an object is drawn.
    public void drawMonster(Graphics g);
}