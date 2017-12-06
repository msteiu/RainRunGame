import java.awt.*;
import javax.swing.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

import java.util.Random;

public class PowerUp implements Character {
    
    protected String powerType;
    private int xCoord, yCoord, height, width, moveAmt;
    private int leftEdge, rightEdge;
    private boolean onScreen, movingLeft;
    private BufferedImage img;

    // potentially not in this class:
    // protected ImageIcon icon;

    // // temporary until we discuss panel size
    // private final int SCREEN_WIDTH = 10;
    // private final int SCREEN_HEIGHT = 40;
    
    // // temp to complete isCaught method:
    // private final int CHAR_TEMP_X = 1;
    // private final int CHAR_TEMP_Y = 1;
    
    public PowerUp(int xCoord, int yCoord, String imagePath) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;

        try {
            img = ImageIO.read(new File(imagePath));
            this.width = img.getWidth();
            this.height = img.getHeight();
        } catch (IOException e) {
            System.out.println("Couldn't open image " + imagePath);
        }

        this.moveAmt = new Random().nextInt((width / 2) + 1);
        this.leftEdge = RainRunPanel.BORDER;
        this.rightEdge = RainRunPanel.WIDTH - width - RainRunPanel.BORDER;

        onScreen = true;
        movingLeft = true;
    }

    public String getType() {
        return powerType;
    }

    public void moveRight() {
        if ( (xCoord + moveAmt) <= rightEdge) {
            xCoord += moveAmt;
        } else {
            movingLeft = true;
        }
    }

    public void moveLeft() {
        if ( (xCoord - moveAmt) >= leftEdge) {
            xCoord -= moveAmt;
        } else {
            movingLeft = false;
        }
    }
    
    // Will move down in a zig zag motion
    public void moveDown() {
        this.yCoord += (height / 2);
        if (movingLeft) {
            moveLeft();
        } else {
            moveRight();
        }
    }

    public void drawCharacter(Graphics g) {
        g.drawImage(img, xCoord, yCoord, new ImgObserver());
    }

    public Rectangle getBounds() {
        return new Rectangle(xCoord, yCoord, width, height);
    }

    public class ImgObserver implements ImageObserver {
        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
            return false;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // // diagonal motion
    // // test actual values when GUI is set up
    // public void fall() {
    //     while (yCoord > 0) {
    //         yCoord -= 0.5;
    //         bounce();
    //     }
    //     onScreen = false;
    // }
    
    // // possible bug
    // public void bounce() {
    //     while (xCoord < SCREEN_WIDTH) {
    //         xCoord += 0.5;
    //     } 
    //     while (xCoord > 0) {
    //         xCoord -= 0.5;
    //     } 
    // }
    
    // need info about character position -
    // public boolean isCaught() {
    //     if (xCoord == CHAR_TEMP_X && yCoord == CHAR_TEMP_Y) {
    //         onScreen = false;
    //         return true;
    //     } 
    //     return false;
    // }
    
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
    
    // public ImageIcon getIcon() {
    //     return icon; 
    // }
    
}