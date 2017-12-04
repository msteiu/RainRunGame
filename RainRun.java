/**
 * FILENAME: RainRun
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Hunter Sessa
 */

import java.awt.Color;

public class RainRun {
    protected static final int WIDTH = 300; // how wide the overall game frame is
    protected static final int HEIGHT = 600; // how high the overall game frame is
    private Color backgroundColor = new Color(148, 0, 211); // purple RGB
    
    public RainRun() {}

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public static void main(String[] args) {}
}