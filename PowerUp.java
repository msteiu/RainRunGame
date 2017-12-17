/**
 * FILENAME: PowerUp
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Hunter Sessa, Angelina Li
 */

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import java.util.Random;

public abstract class PowerUp extends FallingObject {
    
    protected String powerType;
    private int time;
    private boolean movingLeft;
    private BufferedImage img;
    
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
            this.setWidth(img.getWidth());
            this.setHeight(img.getHeight());
        } catch (IOException e) {
            System.out.println("Couldn't open image " + imagePath);
        }

        this.time = 0;
        this.movingLeft = new Random().nextBoolean();
    }

    /**
     * getType() returns type of powerup 
     * @return String type of powerup 
     */     
    public String getType() {
        return powerType;
    }
    
    /**
     * drawCharacter() creates graphical representation of the PowerUp 
     */ 
    public void drawCharacter(Graphics g) {
        g.drawImage(img, getX(), getY(), new ImgObserver());
    }


    public class ImgObserver implements ImageObserver {

        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
            return false;
        }
    }

    /**
     * moveRight (int Speed)
     * @param speed int value to regulate speed with which the powerUp moves right
     * ensures powerup will not travel beyond the screen 
     */  
    private void moveRight(int speed) {
        int moveAmt = Math.max(speed/2, 1);
        int newxCoord = this.getX() + moveAmt;
        if (newxCoord <= getRightEdge()) {
            setX(newxCoord);
        } else {
            movingLeft = true;
        }
    }

    /**
     * moveLeft (int Speed)
     * @param speed int value to regulate speed with which the powerUp moves left
     * ensures powerup will not travel beyond the screen 
     */     
    private void moveLeft(int speed) {
        int moveAmt = Math.max(speed/2, 1);
        int newxCoord = this.getX() - moveAmt;
        if (newxCoord >= getLeftEdge()) {
            setX(newxCoord);
        } else {
            movingLeft = false;
        }
    }

    /**
     * moveDown (int Speed)
     * @param speed int value to regulate speed with which the powerUp moves down
     * fulfills one of FallingObject's abstract methods
     */      
    public void moveDown(int speed) {
        setY(speed + getY());
        if (movingLeft) {
            moveLeft(speed); 
        } else {
            moveRight(speed);
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