/**
 * FILENAME: RainDrop
 * DESCRIPTION: Implementation of a rain drop (player has to try not to be hit by rain drops, because they decrease the health score), 
 * which is a falling object type; therefore, RainDrop extends FallingObject.
 * @author Mara Steiu, Hunter Sessa
 */

import java.awt.*;
import java.util.Random;

public class RainDrop extends FallingObject {

    // Variety of blue colors that rain drops might take on
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
    
    // Private instance variable of rain drop objects
    private Color charColor;
    private int size;
    
    /**
     * Constructor - defines what will be contained in RainDrop instance. Each rain drop is defined by having (x,y) coordinates location
     * and a size.
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
     * getType() returns type of RainDrop character
     * @return String type of character ("raindrop")
     */     
    public String getType() {
        return "raindrop";
    }

    /**
     * moveDown() updates postion of rain drops on y axis, moving rain drops down at a speed that updates itself based on the speed param.
     * @param speed int which defines how fast the rain drop moves 
     */    
    public void moveDown(int speed) {
        int updatedSpeed = getY() + speed;
        setY(updatedSpeed);
    }

    /**
     * drawCharacter() draws a RainDrop character by using the Graphics package. Method sets color and fills Oval that contains
     * rain drop element within bounds.
     * @param Graphics g representing Graphics rain drop character (created by using Graphics package)
     */
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillOval(getX(), getY(), size, size);

    }
}
