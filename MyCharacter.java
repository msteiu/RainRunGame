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
  protected boolean hasShield; //optional
  protected String[] powerups; //optional
  protected int countPowerups; //optional
  
  public MyCharacter(int xPos, int yPos, int size, Color color, boolean shield, String[] powers) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.size = size;
    this.charColor = color;
    this.hasShield = shield;
    this.powerups = powers;
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
    powerups[current] = powerUp;
    health += 10; //increase health score by 10 for each new power-up acquired 
    speed += 5; //increase speed score by 5 for each new power-up acquired 
  }
  
  private void expandCapacity(String[] array){
    String[] newArray = new String[array.length*2];
    for (int i = 0; i<newArray.length; i++)
      newArray[i] = array[i];
    array = newArray;
  }
  
  //getters
  public String getType() {
    return "mycharacter";
  }
  
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
  
  //character is dead
  public boolean isDead(){
    return this.health <= 0;
  }
  
  //character is hit
  public boolean isHit(){
    boolean hit = false;
    if (FallingObject.xLocation == this.xLocation && FallingObject.yLocation == this.yLocation){
      this.health -= 5; //for every hit from a falling object, decrease health by 5
      hit = true;
    }
    return hit;
  }
  
  // modify to be whatever you want. filler for now
  public void drawCharacter(Graphics g) {
    g.setColor(charColor);
    g.fillRect(xPos, yPos, size, size);
  }
  
  public Rectangle getBounds() {
    return new Rectangle(xPos, yPos, size, size);
  }
  
}
