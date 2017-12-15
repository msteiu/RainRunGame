/**
 * FILENAME: FallingObject
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li, Hunter Sessa, Mara Steiu
 */

import java.awt.*;

// a FallingObject is a Character interface's child
public abstract class FallingObject implements Character {
    
    // instance variables to be inherited by Rain and PowerUp
    private int xCoord, yCoord, height, width;
    private int leftEdge, rightEdge;
    
    /**
     * Constructor - defines what will be passed to children
     * @param xCoord int, x position of image
     * @param yCoord int, y position of image
     */
    public FallingObject(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;

        this.leftEdge = RRConstants.getLeftEdge();
        this.rightEdge = RRConstants.getRightEdge(width);
    } 

    /**
     * getBounds()
     * @return new Rectangle object with inputted postion and dimensions 
     */
    public Rectangle getBounds() {
        return new Rectangle(xCoord, yCoord, width, height);
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
    
    /** 
     * getRightEdge() returns right edge value
     */
    public int getRightEdge() {
        return rightEdge;
    }

    /** 
     * getLeftEdge() returns left edge value
     */
    public int getLeftEdge() {
        return leftEdge;
    }
    
    /**
     * setWidth(int width) sets width as inputted value 
     * @param int value to be set as width
     */     
    public void setWidth(int width) {
        this.width = width;
        this.rightEdge = RRConstants.getRightEdge(width);
    }

    /**
     * setHeight(int height) sets height as inputted value 
     * @param int value to be set as height
     */         
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * getX() returns x position value 
     * @return int value of x position 
     */       
    public int getX() {
        return xCoord;
    }
    
    /**
     * getYCoord() returns y position value 
     * @return int value of y position 
     */       
    public int getY() {
        return yCoord;
    }
    
    /**
     * setXCoord(int xCoord) sets x position as inputted value 
     * @param int value to be set as x position
     */     
    public void setX(int xCoord) {
        this.xCoord = xCoord;
    }
    
    /**
     * setYCoord(int yCoord) sets y position as inputted value 
     * @param int value to be set as y position
     */     
    public void setY(int yCoord) {
        this.yCoord = yCoord;
    }

}
