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
  
  public MyCharacter(int xPos, int yPos, int size, Color color, boolean shield) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.size = size;
    this.charColor = color;
    this.hasShield = shield;
    this.powerups = new String[1];
    this.countPowerups = 0;
    
    this.leftEdge = RainRunPanel.BORDER;
    this.rightEdge = RainRunPanel.WIDTH - size - RainRunPanel.BORDER;
  }
  
  //power-ups
  public boolean hasPowerUp(){
    return this.powerups.length != 0;
  }
  
  public void applyPowerUp(String powerUp){
    if (countPowerups == this.powerups.length){
      expandCapacity(powerups);
    }      
    powerups[countPowerups] = powerUp;
  }
  
  private void expandCapacity(String[] array){
    String[] newArray = new String[array.length*2];
    for (int i = 0; i<newArray.length; i++)
      newArray[i] = array[i];
    array = newArray;
  }
  
  //getters
  
  public int getX() {
    return xPos;
  }
  
  public int getY() {
    return yPos;
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
  
  public void moveDown() {
    this.yPos += this.size;
  }
    
  //character is hit - check!
  public boolean isHit(){
    if (FallingObject.xLocation == this.xLocation && FallingObject.yLocation == this.yLocation){
      return trye;
    }
    return false;
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
