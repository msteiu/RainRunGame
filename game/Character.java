/**
 * FILENAME: Character
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * Character interface
 * @author Angelina
 */

import java.awt.Graphics;

public interface Character {

    public MyCharacter(int xPos, int yPos);

    public int getXPos();

    public int setXPos();

    public int getYPos();

    public int setYPos();

    // move character position by set amount to the right
    public void moveRight();

    // move character position by set amount to the left
    public void moveLeft();

    // will draw character using Graphics package
    public void drawCharacter(Graphics g);
}