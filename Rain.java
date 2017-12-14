/**
 * FILENAME: Monster
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu, Angelina Li, Hunter Sessa
 */

import java.awt.*;
import java.util.Random;

public class Rain extends FallingObject {

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
      
    private int reflectionSize;
    
 /**
 * Constructor - defines what will be contained in Rain instance
 * @param xCoord int- x position of rain drop
 * @param yCoord int- y position of rain drop
 * @param size int size of rain drop
 */ 
    public Rain(int xPos, int yPos, int size) {
        
      super(xPos, yPos);

        this.charColor = COLORS[new Random().nextInt(COLORS.length - 1)];
        this.size = size;
        this.setHeight(size);
        setWidth(size);
    }
 

/**
 * getType() returns type of character 
 * @return String type of character 
 */     
    public String getType() {
        return "rain";
    }

/**
 * moveDown () updates postion of rain drops on y axis  
 * @param speed int to define how much the rain moves 
 */    
    public void moveDown(int speed) {
     int updatedSpeed = getYCoord() + speed;
      setYCoord(updatedSpeed);
    }

   // (((( NOT SURE ABOUT THIS ONE ))))
    @Override
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillOval(getXCoord(), getYCoord(), size, size);

    }
}
