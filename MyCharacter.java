/**
 * FILENAME: MyCharacter
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu and Angelina Li
 */

import java.awt.*;

public class MyCharacter implements Character {
    protected Color charColor;
    protected int xPos, yPos, size;
    protected int leftEdge, rightEdge;
    protected boolean hasShield; //optional (not all instances will have shields)
    protected String[] powerups; //optional (not all instances will have powerups)
    protected int countPowerups; //optional (used to check for powerups array's size)
    
    public MyCharacter(int xPos, int yPos, int size, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.size = size;
        this.charColor = color;
        this.hasShield = false;
        // this.powerups = new String[1];
        // this.countPowerups = 0;
        
        this.leftEdge = RainRunPanel.BORDER;
        this.rightEdge = RainRunPanel.WIDTH - size - RainRunPanel.BORDER;
    }
    
    //getters (location)
    public int getX() {
        return xPos;
    }
    
    public int getY() {
        return yPos;
    }

    public boolean getHasShield() {
        return hasShield;
    }

    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }
    
    //moving character
    public void moveRight() {
        if ( (xPos + size) <= rightEdge) {
            xPos += size;
        }
    }
    
    public void moveLeft() {
        if ( (xPos - size) >= leftEdge) {
            xPos -= size;
        }
    }

    // Character interface's methods implementation
    public String getType() {
        return "mycharacter";
    }
    
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillRect(xPos, yPos, size, size);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, size, size);
    }
    
}
