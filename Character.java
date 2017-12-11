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

    // will draw character using Graphics package
    public void drawCharacter(Graphics g);

    // gets bounds of character in a rectangle
    public Rectangle getBounds();
    
}