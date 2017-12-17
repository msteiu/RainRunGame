/**
 * FILENAME: Character
 * DESCRIPTION: Character abstract class which is implemented by the main objects
 * that appear in our game - MyCharacter and the FallingObjects.
 * @author Angelina Li, Mara
 */

import java.awt.*;

public abstract class Character {

    /**
     * Returns a String representation of the type of this Character
     * @return String variable representing character type
     */
    public abstract String getType();

    /**
     * Given a Graphics object, will draw a graphical representation
     * of this Character
     * @param Graphics object used to draw the character
     */
    public abstract void drawCharacter(Graphics g);

    /**
     * Will return a Rectangle object that represents the smallest possible
     * Rectangle needed to enclose the graphical representation of the Character
     * in its entirety.
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
