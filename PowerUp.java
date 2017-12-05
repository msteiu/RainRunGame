
import javax.swing.*;

public class PowerUp {
  
  private int xCoord;
  private int yCoord;
  private boolean onScreen;
  // potentially not in this class:
  protected ImageIcon icon;
  // temporary until we discuss panel size
  private final int SCREEN_WIDTH = 10;
  private final int SCREEN_HEIGHT = 40;
  
  // temp to complete isCaught method:
  private final int CHAR_TEMP_X = 1;
  private final int CHAR_TEMP_Y = 1;
  
  
  public PowerUp() {
    this.xCoord = SCREEN_WIDTH/2;
    this.yCoord = SCREEN_HEIGHT;
    onScreen = true;
  }
  
  // diagonal motion
  // test actual values when GUI is set up
  public void fall() {
    while (yCoord > 0) {
      yCoord -= 0.5;
      bounce();
    }
    onScreen = false;
  }
  
  
  // possible bug
  public void bounce() {
    while (xCoord < SCREEN_WIDTH) {
      xCoord += 0.5;
    } 
    while (xCoord > 0) {
      xCoord -= 0.5;
    } 
  }
  
  // need info about character position -
  public boolean isCaught() {
    if (xCoord == CHAR_TEMP_X && yCoord == CHAR_TEMP_Y) {
      onScreen = false;
      return true;
    } 
    return false;
  }
  
  public int getXCoord() {
    return xCoord;
  }
  
  public int getYCoord() {
    return yCoord;
  }
  
  public boolean isOnScreen() {
    return onScreen; 
  }
  
  
  public void setXCoord(int xCoord) {
    this.xCoord = xCoord;
  }
  
  
  public void setYCoord (int yCoord) {
    this.yCoord = yCoord;
  }
  
  public ImageIcon getIcon() {
   return icon; 
  }
  
  
  
  
  
}