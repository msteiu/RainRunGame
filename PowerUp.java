import java.awt.*;
import javax.swing.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

import java.util.Random;

public class PowerUp implements FallingObject {
    
    protected String powerType;
    private int xCoord, yCoord, height, width, moveAmt;
    private int leftEdge, rightEdge;
    private boolean movingLeft;
    private BufferedImage img;
    
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

        this.moveAmt = new Random().nextInt(2) + 1;
        this.leftEdge = RainRunPanel.BORDER;
        this.rightEdge = RainRunPanel.WIDTH - width - RainRunPanel.BORDER;
        this.movingLeft = true;
    }

    public String getType() {
        return powerType;
    }

    public void moveRight(int speed) {
        if ( (xCoord + (moveAmt*speed)) <= rightEdge) {
            xCoord += (moveAmt*speed);
        } else {
            movingLeft = true;
        }
    }

    public void moveLeft(int speed) {
        if ( (xCoord - (moveAmt*speed)) >= leftEdge) {
            xCoord -= (moveAmt*speed);
        } else {
            movingLeft = false;
        }
    }
    
    // Will move down in a zig zag motion
    public void moveDown(int speed) {
        this.yCoord += (moveAmt*speed);
        if (movingLeft) {
            moveLeft(speed);
        } else {
            moveRight(speed);
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

    public int getXCoord() {
        return xCoord;
    }
    
    public int getYCoord() {
        return yCoord;
    }
    
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    
    public void setYCoord (int yCoord) {
        this.yCoord = yCoord;
    }
    
}