/**
 * FILENAME: MyCharacter
 * DESCRIPTION: This class represents the character of the player in the game. The class extends the Character interface, which is shared
 * by all game objects (player, rain drops, power-ups), but is more specific in that it offers characteristics and behaviors only shared
 * by the player's character.
 * @author Mara Steiu, Angelina Li, Hunter Sessa
 */

import java.awt.*;

public class MyCharacter extends Character {
    
    // Private instance variables 
    private Color charColor;
    private int xCoord, yCoord, size, health;
    private int leftEdge, rightEdge;
    private boolean died;

    /**
     * Constructor - defines what will be contained in MyCharacter objects. The main characteristics of every player object are: location
     * defined by (x,y) coordinates, size and color of objects, health status (died/still has some hearts), left and right edge constants.
     * The four parameters of constructor can vary, while the other four are constants.
     * @param xCoord int - x coord in location of character
     * @param yCoord int - y coord in location of character
     * @param size int - size of character
     * @param color Color - color of character
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
     * getX() returns x coord. in location of player character
     * @return xCoord int value representing x location 
     */
    public int getX() {
        return xCoord;
    }

    /**
     * moveRight() method that moves the character to the right on the panel. Ensures that movement would keep character in bounds.
     */
    public void moveRight() {
        int newxCoord = xCoord + size;
        if ( newxCoord <= rightEdge) {
            xCoord = newxCoord;
        }
    }
    
    /**
     * moveLeft() method that moves the character to the left. Ensures that movement would keep character in bounds.
     */    
    public void moveLeft() {
        int newxCoord = xCoord - size;
        if ( newxCoord >= leftEdge) {
            xCoord = newxCoord;
        }
    }

    /**
    * getType() method that returns String that represents the type of character to be used in RainRun main controls
    * @return String mycharacter type
    */    
    public String getType() {
        return "mycharacter";
    }
    
    
    /*
     * drawCharacter() method that draws a character by using the Graphics package. Method sets color and fills Rectangle that contains the element
     * within bounds.
     * @param Graphics g representing Graphics character (created by using Graphics package)
     */
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillRect(xCoord, yCoord, size, size);
    }
    
    /**
     * getBounds() method that returns the Rectangle surrounding an object of type MyCharacter
     * @return new Rectangle object which has the (xCoord, yCoord) location and size width and height.
     */     
    public Rectangle getBounds() {
        return new Rectangle(xCoord, yCoord, size, size);
    }
    
    /*
     * getDied() method that checks whether MyCharacter object has died or not.
     * @return boolean which is true if character died, false otherwise
     */
    public boolean getDied() {
        return died;
    }
    
    /*
     * setDied() method that sets player (MyCharacter) character dead or not, based on boolean param 
     * @param - boolean showing whether character is dead or not (true - dead; false - not dead)
     */
    public void setDied(boolean died) {
        this.died = died;
    }

    /*
     * getHealth() method that returns the health score of the player (MyCharacter)
     * @return int health (hearts score) of player character
     */
    public int getHealth() {
        return health;
    }

    /*
     * setHealth() method that sets health score by using int health given as param
     * @param int health to which player's health is set
     */
    public void setHealth(int health) {
        this.health = health;
    }

}
