/**
 * FILENAME: Character
 * DESCRIPTION: Character interface that represents the main interface for player character and falling objects.
 * @author Angelina, Mara
 */

import java.awt.*;

public interface Character {

    /*
     * Returns the type of a character, as a String
     * @ return String variable representing character type
     */
    public String getType();

    /*
     * Drawing character
     * @arg it uses the Graphics package for drawing
     */
    public void drawCharacter(Graphics g);

    /*
     * Gets bounds of character in a rectangle
     * @return Rectangle that has the bounds
     */
    public Rectangle getBounds();
}
