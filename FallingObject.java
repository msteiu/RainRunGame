/**
 * FILENAME: FallingObject
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li, Hunter Sessa
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

// a FallingObject is a Character interface's child

public abstract class FallingObject implements Character {
    
    // instance variables to be inherited by Rain and PowerUp
    private int xCoord, yCoord, height, width;
    private int leftEdge, rightEdge;
    private boolean movingLeft;
    private BufferedImage img;
    
    
 /**
 * Constructor - defines what will be passed to children
 * @param xCoord int, x position of image
 * @param yCoord int, y position of image
 */
    public FallingObject(int xCoord, int yCoord) {
        
        this.xCoord = xCoord;
        this.yCoord = yCoord;

        this.leftEdge = RRConstants.BORDER;
        this.rightEdge = RRConstants.WIDTH - width - RRConstants.BORDER;
        this.movingLeft = true;
    }  


 /**
 * drawCharacter(Graphics g)
 * @param Graphics g            (((Not sure about this method))))
 */
    public void drawCharacter(Graphics g) {
        g.drawImage(img, xCoord, yCoord, new ImgObserver());
    }

    
 /**
 * getBounds()
 * @return new Rectangle object with inputted postion and dimensions 
 */    
    public Rectangle getBounds() {
        return new Rectangle(xCoord, yCoord, width, height);
    }

  //((((NOT SURE ABOUT THIS INNER CLASS)))
    public class ImgObserver implements ImageObserver {
        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
            return false;
        }
    }
    
    
 /**
 * getWidth() returns width value 
 * @return int value of width 
 */
    public int getWidth() {
        return width;
    }

    
 /**
 * getHeight() returns height value 
 * @return int value of height 
 */    
    public int getHeight() {
        return height;
    }
    
    
 /**
 * setWidth(int width) sets width as inputted value 
 * @param int value to be set as width
 */     
    public void setWidth(int width) {
        this.width = width;
    }

 /**
 * setHeight(int height) sets height as inputted value 
 * @param int value to be set as height
 */         
    public void setHeight(int height) {
        this.height = height;
    }
    
 /**
 * getXCoord() returns x position value 
 * @return int value of x position 
 */       
    public int getXCoord() {
        return xCoord;
    }
    
 /**
 * getYCoord() returns y position value 
 * @return int value of y position 
 */       
    public int getYCoord() {
        return yCoord;
    }
    
    
 /**
 * setXCoord(int xCoord) sets x position as inputted value 
 * @param int value to be set as x position
 */     
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    
 /**
 * setYCoord(int yCoord) sets y position as inputted value 
 * @param int value to be set as y position
 */     
    public void setYCoord (int yCoord) {
        this.yCoord = yCoord;
    }
    
 /**
 * getType() abstract, will return type value 
 * @return String name of type 
 */       
    public abstract String getType();
    
 /**
 * moveDown() abstract, to be defined by children 
 * @param speed with which falling object will move down
 */     
    public abstract void moveDown(int speed);
}
