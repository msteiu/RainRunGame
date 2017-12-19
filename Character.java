/**
 * FILENAME: Character
 * DESCRIPTION: Character abstract class which is implemented by the main character classes of our game - MyCharacter and FallingObject.
 * All the characters appearing in the game (player, power-ups - umbrella, speed, health; rain drops) are considered to be instances of
 * Character, each having subsequently new characteristics and behaviours added through more specific classes such as MyCharacter or 
 * FallingObject.
 * @author Angelina Li, Mara Steiu
 */

import java.awt.*;

public abstract class Character {

    /**
     * Abstract method that returns a String representation of the type of a Character object.
     * @return String variable representing character type
     */
    public abstract String getType();

    /**
     * Given a Graphics object, this abstract method will draw a graphical representation of this Character on the game panel. 
     * @param Graphics object used to draw the character
     */
    public abstract void drawCharacter(Graphics g);

    /**
     * Will return a Rectangle object that represents the smallest possible Rectangle needed to enclose the graphical representation of 
     * the Character in its entirety.
     * @return Rectangle that has the bounds
     */
    public abstract Rectangle getBounds();

    /**
     * Will check whether or not the bounds of this character intersect with
     * the bounds of another character. This method of checking for intersection
     * will sometimes be slightly inaccurate - particularly for shapes that
     * don't fit nicely into rectangles.
     * @param another Character object to check for intersection
     * @return whether or not this Character intersects with the specified Character
     */
    public boolean intersects(Character obj) {
        return getBounds().intersects(obj.getBounds());
    }
}
