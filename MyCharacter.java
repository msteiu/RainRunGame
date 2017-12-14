/**
 * FILENAME: MyCharacter
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu, Angelina Li, Hunter Sessa
 */

import java.awt.*;

public class MyCharacter implements Character {
    
  // instance variables 
    protected Color charColor;
    protected int xPos, yPos, size, speed, health;
    protected int leftEdge, rightEdge;
    protected boolean hasShield; //optional (not all instances will have shields)
    protected int countPowerups; //optional (used to check for powerups array's size)
    private boolean died;

    
    
 /**
 * Constructor - defines what will be contained in MyCharacter instance
 * @param xCoord int- x position of character
 * @param yCoord int- y position of character
 * @param size int- size of character
 * @param color Color- color of character
 */    
    public MyCharacter(int xPos, int yPos, int size, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.size = size;
        this.died = false;
        this.speed = 1;
        this.health = RainRun.MAX_HEALTH;
        this.charColor = color;
       // this.hasShield = false;
        
        this.leftEdge = RRConstants.BORDER;
        this.rightEdge = RRConstants.WIDTH - size - RRConstants.BORDER;
    }
    
    
 /**
 * getX() returns x position of character
 * @return xPos int value of x position 
 */
    public int getX() {
        return xPos;
    }


//    public boolean getHasShield() {
//        return hasShield;
//    }
//
//    public void setHasShield(boolean hasShield) {
//        this.hasShield = hasShield;
//    }
    
      
 /**
 * moveRight() moves the character icon right
 * Ensures that movement would keep character in bounds
 */
    public void moveRight() {
        if ( (xPos + size) <= rightEdge) {
            xPos += size;
        }
    }
    
 /**
 * moveLeft() moves the character icon left
 * Ensures that movement would keep character in bounds
 */    
    public void moveLeft() {
        if ( (xPos - size) >= leftEdge) {
            xPos -= size;
        }
    }


 /**
 * getType() returns String type of character to be used in RainRun main controls
 * @return String mycharacter
 */    
    public String getType() {
        return "mycharacter";
    }
    
  // (((( NOT SURE ))))  
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillRect(xPos, yPos, size, size);
    }
    
/**
 * getBounds()
 * @return new Rectangle object with inputted postion and dimensions 
 */     
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, size, size);
    }
    
    
 /**
 * getSpeed() returns speed value 
 * @return int value of speed 
 */    
    public int getSpeed() {
        return speed;
    }

    
 /**
 * setSpeed(int speed) sets speed as inputted value 
 * @param int speed value to be set as new speed
 */     
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
 /**
 * getHealth() returns health value 
 * @return int value of health 
 */    
    public int getHealth() {
        return health;
    }

   
 /**
 * setHealth(int health) sets health as inputted value 
 * @param int health value to be set as new health
 */     
    public void setHealth(int health) {
        this.health = health;
    }

 
 /**
 * getDied() returns true if dead
 * @return boolean whether or not dead
 */    
    public boolean getDied() {
        return died;
    }

    
 /**
 * setDied(boolean died) sets died variable as true or false 
 * @param boolean true or false for the died var to be set as 
 */     
    public void setDied(boolean died) {
        this.died = died;
    }
    
}
