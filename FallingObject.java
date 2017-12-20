/**
 * FILENAME: FallingObject
 * DESCRIPTION: Abstract class that extends the Character interface. This class is afterwards extended by new classes - RainDrop (rain 
 * drops that decrease the number of lives of the player) and PowerUp (power-ups that offer the player special abilities - e.g. speed,
 * shield against the rain drops). The current class includes the main characteristics and behaviors of all falling objects (rain drops,
 * umbrella, health, and speed power-ups).
 * @author Mara Steiu, Hunter Sessa, Angelina Li
 */

import java.awt.*;

// A FallingObject is a Character's child
public abstract class FallingObject extends Character {
    
    // Instance variables to be inherited by RainDrop and PowerUp
    private int xCoord, yCoord, height, width;
    private int leftEdge, rightEdge;
    
    /**
     * Constructor - defines what will be passed to extensions. The left and right edges are constants, and the x and y coordinates that
     * define location are variables.
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
     * @return new Rectangle object with inputted (x,y) coordinates location of rectangle and dimensions (width, height).
     */
    public Rectangle getBounds() {
        return new Rectangle(xCoord, yCoord, width, height);
    }

    /**
     * getType() abstract method that will be overriden by RainDrop and PowerUp(s); the method returns the type of an object as a String 
     * @return String name of object type
     */       
    public abstract String getType();
    
    /**
     * moveDown() abstract method that will be defined by RainDrop and PowerUp(s); the method moves the object down the panel (objects
     * are falling) by the speed which is given as an integer parameter
     * @param speed int with which falling object will move down
     */     
    public abstract void moveDown(int speed);
    
    //Getter methods 
    
    /** 
     * getRightEdge() method that returns the right edge value as an integer
     * @return int rightEdge value
     */
    public int getRightEdge() {
        return rightEdge;
    }

    /** 
     * getLeftEdge() method that returns the left edge value as an integer
     * @return int leftEdge value
     */
    public int getLeftEdge() {
        return leftEdge;
    }
    
    /**
     * getX() returns the X coordinate of object's location 
     * @return int xCoord value of location
     */       
    public int getX() {
        return xCoord;
    }
    
    /**
     * getY() returns the Y coordinate of object's location
     * @return int yCoord value of location
     */       
    public int getY() {
        return yCoord;
    }
    
    //Setter methods
    
    /**
     * setWidth() sets width of object by offering it the int width inputted as parameter
     * @param int width value that represents new width
     */     
    public void setWidth(int width) {
        this.width = width;
        this.rightEdge = RRConstants.getRightEdge(width);
    }

    /**
     * setHeight() sets height of object by offering it the int height inputted as parameter
     * @param int height value that represents new height
     */         
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * setX() sets x position of object location by using the new x coord. value offered as parameter 
     * @param int xCoord value that represents new x coord. of object location
     */     
    public void setX(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * setY() sets y position of object location by using the new y coord. value offered as parameter 
     * @param int yCoord value that represents new y coord. of object location
     */ 
    public void setY(int yCoord) {
        this.yCoord = yCoord;
    }
}
