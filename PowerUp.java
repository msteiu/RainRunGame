/**
 * FILENAME: PowerUp
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Hunter Sessa, Angelina Li
 */

import java.awt.*;
import javax.swing.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class PowerUp extends FallingObject {
    
  
    protected String powerType;
    private int height, width, speed, time;
    private int leftEdge, rightEdge;
    private boolean movingLeft;
    private BufferedImage img;
    private int moveAmt = Math.max(speed / 2, 1);
    
  /**
 * Constructor - defines what will be contained in PowerUp instance
 * @param xCoord int- x position of character
 * @param yCoord int- y position of character
 * @param String imagePath for icon used
 * inherits from FallingObject
 */ 
    public PowerUp(int xCoord, int yCoord, String imagePath) {
        
        super(xCoord, yCoord);

        try {
            img = ImageIO.read(new File(imagePath));
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (IOException e) {
            System.out.println("Couldn't open image " + imagePath);
        }

        this.leftEdge = RRConstants.BORDER;
        this.rightEdge = RRConstants.WIDTH - width - RRConstants.BORDER;
        this.movingLeft = true;
        this.time = 0;
    }

/**
 * getType() returns type of powerup 
 * @return String type of powerup 
 */     
    public String getType() {
        return powerType;
    }
    

    // (((( NOT SURE )))))
    public void drawCharacter(Graphics g) {
        g.drawImage(img, getXCoord(), getYCoord(), new ImgObserver());
    }


/**
 * getBounds()
 * @return new Rectangle object with inputted postion and dimensions 
 */      
    public Rectangle getBounds() {
        return new Rectangle(getXCoord(), getYCoord(), width, height);
    }

 // ((( NOT SURE ABOUT THIS ONE ))))
    public class ImgObserver implements ImageObserver {
        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
            return false;
        }
    }

 
/**
 * moveDown (int Speed)
 * @param speed int value to regulate speed with which the powerUp moves down
 * fulfills one of FallingObject's abstract methods
 */      
    public void moveDown(int speed) {
      
      int yPos = getYCoord();
      setYCoord(speed + yPos);
       if (movingLeft) {
            moveLeft(speed); 
        } else {
            moveRight(speed);
        }
    }
    
    
/**
 * moveRight (int Speed)
 * @param speed int value to regulate speed with which the powerUp moves right
 * ensures powerup will not travel beyond the screen 
 */  
    public void moveRight(int speed) {
      int xPos = getXCoord();
        if ( (xPos + (moveAmt*speed)) <= rightEdge) {
            xPos += (moveAmt*speed);
            setXCoord(xPos);
        } else {
            movingLeft = true;
        }
    }

/**
 * moveLeft (int Speed)
 * @param speed int value to regulate speed with which the powerUp moves left
 * ensures powerup will not travel beyond the screen 
 */     
    public void moveLeft(int speed) {
      int xPos = getXCoord();
        if ( (xPos - (moveAmt*speed)) >= leftEdge) {
            xPos -= (moveAmt*speed);
            setXCoord(xPos);
        } else {
            movingLeft = false;
        }
    }
    
 /**
 * getTime() returns time value 
 * @return int value of time 
 */    
    public int getTime() {
     return time; 
    }
   
    
 /**
 * increaseTime(int increment) adds to time by a certain value
 * @param increment int value to add to previous time  
 */     
    public void increaseTime(int increment) {
      time += increment;
    }
   
    
}