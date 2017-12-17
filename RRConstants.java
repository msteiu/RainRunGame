/**
 * FILENAME: RRConstants
 * DESCRIPTION: Class that contains main constants used within the game.
 * @author Angelina Li
 */

import java.awt.*;

public class RRConstants {

    protected static final int HEIGHT = 550; // how high the overall game frame is
    protected static final int WIDTH = 300; // how wide the overall game frame is
    protected static final int BORDER = 40; // thickness of border
    protected static final int MAX_HEALTH = 3;
    protected static final int NUM_TOPSCORES = 5;
    protected static final int DELAY = 25;
    protected static final String DELIMITER = "#";

    protected static final Color BORDER_COLOR = new Color(75, 0, 130);
    protected static final Color BACKGROUND_COLOR = new Color(233, 223, 239);
    protected static final Color CHAR_DEFAULT_COLOR = new Color(255, 215, 0);
    protected static final Color RULE_BUTTON_COLOR = Color.CYAN;
    protected static final String FONT_NAME = "Courier";
    
    /*
     * Method that resturns the font given a specific size.
     * @param int size of element
     */
    protected static Font getFont(int size) {
        return new Font(FONT_NAME, Font.BOLD, size);
    }
    
    /*
     * Method that resturns the font given specific size and style.
     * @param int style of element
     * @param int size of element
     */
    protected static Font getFont(int style, int size) {
        return new Font(FONT_NAME, style, size);
    }

    /*
     * Method that returns left edge of panel. 
     */
    protected static int getLeftEdge() {
        return BORDER;
    }
    
    /*
     * Method that returns the right page of panel.
     */
    protected static int getRightEdge(int width) {
        return WIDTH - BORDER - width;
    }

}
