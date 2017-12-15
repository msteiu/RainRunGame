/**
 * FILENAME: RainDrop
 * DESCRIPTION: Implementation of a rain drop (monster for player), which is a falling object type. 
 * @author Mara Steiu, Angelina Li, Hunter Sessa
 */

import java.awt.*;
import java.util.Random;

public class RainDrop extends FallingObject {

    // a bunch of nice blues
    private static final Color[] COLORS = {
        new Color(22, 111, 213),
        new Color(0, 70, 112),
        new Color(10, 164, 255),
        new Color(66, 188, 241),
        new Color(0, 101, 140),
        new Color(38, 196, 255),
        new Color(0, 118, 188),
        new Color(15, 75, 144),
        new Color(0, 157, 216),
        new Color(176, 224, 230)
    };

    private Color charColor;
    private int size;
    
    /**
     * Constructor - defines what will be contained in RainDrop instance
     * @param xCoord int- x position of rain drop
     * @param yCoord int- y position of rain drop
     * @param size int size of rain drop
     */ 
    public RainDrop(int xCoord, int yCoord, int size) {
        super(xCoord, yCoord);
        this.charColor = COLORS[new Random().nextInt(COLORS.length - 1)];
        this.size = size;
        this.setHeight(size);
        this.setWidth(size);
    }

    /**
     * getType() returns type of character 
     * @return String type of character 
     */     
    public String getType() {
        return "raindrop";
    }

    /**
     * moveDown() updates postion of rain drops on y axis  
     * @param speed int to define how much the rain drop moves 
     */    
    public void moveDown(int speed) {
        int updatedSpeed = getY() + speed;
        setY(updatedSpeed);
    }

    /**
     * drawCharacter() creates new graphics object   
     * sets aesthetic characteristic of the rain drops  
     */  
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillOval(getX(), getY(), size, size);

    }
}
