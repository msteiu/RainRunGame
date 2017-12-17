/**
 * FILENAME: MyCharacter
 * DESCRIPTION: Represents the character of the player in the game
 * @author Mara Steiu, Angelina Li, Hunter Sessa
 */

import java.awt.*;

public class MyCharacter extends Character {
    
    // instance variables 
    private Color charColor;
    private int xCoord, yCoord, size, health;
    private int leftEdge, rightEdge;
    private boolean died;

    /**
     * Constructor - defines what will be contained in MyCharacter instance
     * @param xCoord int- x position of character
     * @param yCoord int- y position of character
     * @param size int- size of character
     * @param color Color- color of character
     */    
    public MyCharacter(int xCoord, int yCoord, int size, Color color) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.size = size;
        this.charColor = color;
        this.died = false;
        this.health = RRConstants.MAX_HEALTH;

        this.leftEdge = RRConstants.getLeftEdge();
        this.rightEdge = RRConstants.getRightEdge(size);
    }
    
    /**
     * getX() returns x position of character
     * @return xCoord int value of x position 
     */
    public int getX() {
        return xCoord;
    }

    /**
     * moveRight() moves the character right
     * Ensures that movement would keep character in bounds
     */
    public void moveRight() {
        int newxCoord = xCoord + size;
        if ( newxCoord <= rightEdge) {
            xCoord = newxCoord;
        }
    }
    
    /**
     * moveLeft() moves the character left
     * Ensures that movement would keep character in bounds
     */    
    public void moveLeft() {
        int newxCoord = xCoord - size;
        if ( newxCoord >= leftEdge) {
            xCoord = newxCoord;
        }
    }

    /**
    * getType() returns String type of character to be used in RainRun main controls
    * @return String mycharacter
    */    
    public String getType() {
        return "mycharacter";
    }
    
    
    /*
     * drawCharacter() draws a character by using the Graphics package
     * @param Graphics package used
     */
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillRect(xCoord, yCoord, size, size);
    }
    
    /**
     * getBounds()
     * @return new Rectangle object with inputted postion and dimensions 
     */     
    public Rectangle getBounds() {
        return new Rectangle(xCoord, yCoord, size, size);
    }
    
    /*
     * getDied()
     * @return boolean check if character died
     */
    public boolean getDied() {
        return died;
    }
    
    /*
     * setDied() - sets character dead or not, based on boolean param
     * @param - boolean showing whether character died or not
     */
    public void setDied(boolean died) {
        this.died = died;
    }

    /*
     * getHealth()
     * @return int health (hearts score) of character
     */
    public int getHealth() {
        return health;
    }

    /*
     * setHealth() by using health given as param
     * @param int health to which it's set
     */
    public void setHealth(int health) {
        this.health = health;
    }

}
