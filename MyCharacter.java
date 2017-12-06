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

    public MyCharacter(int xPos, int yPos, int size, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.size = size;
        this.charColor = color;

        this.leftEdge = RainRunPanel.BORDER;
        this.rightEdge = RainRunPanel.WIDTH - size - RainRunPanel.BORDER;
    }

    public String getType() {
        return "mycharacter";
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

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

    // modify to be whatever you want. filler for now
    public void drawCharacter(Graphics g) {
        g.setColor(charColor);
        g.fillRect(xPos, yPos, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, size, size);
    }

}