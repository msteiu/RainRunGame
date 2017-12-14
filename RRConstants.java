import java.awt.*;

public class RRConstants {

    protected static final int HEIGHT = 550; // how high the overall game frame is
    protected static final int WIDTH = 300; // how wide the overall game frame is
    protected static final int BORDER = 10; // thickness of border
    protected static final int MAX_HEALTH = 3;

    protected static final Color BORDER_COLOR = new Color(75, 0, 130);
    protected static final Color BACKGROUND_COLOR = new Color(233, 223, 239);
    protected static final Color CHAR_DEFAULT_COLOR = new Color(255, 215, 0);
    protected static final Color RULE_BUTTON_COLOR = Color.CYAN;
    protected static final String FONT_NAME = "Courier";

    
    protected static Font getFont(int size) {
        return new Font(FONT_NAME, Font.BOLD, size);
    }

    protected static Font getFont(int style, int size) {
        return new Font(FONT_NAME, style, size);
    }

    protected static int getLeftEdge() {
        return BORDER;
    }

    protected static int getRightEdge(int width) {
        return WIDTH - BORDER - width;
    }

}