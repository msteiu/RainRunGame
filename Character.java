/**
 * FILENAME: Character
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * Character interface
 * @author Angelina
 */

import java.awt.*;

public interface Character {

    // returns type of character
    public String getType();

    // move character position by set amount to the right
    public void moveRight();

    // move character position by set amount to the left
    public void moveLeft();

    // move character by set amount down
    public void moveDown();

    // will draw character using Graphics package
    public void drawCharacter(Graphics g);

    // gets bounds of character in a rectangle
    public Rectangle getBounds();
}