import java.awt.*;
import javax.swing.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class PowerUp implements FallingObject {
    
    protected String powerType;
    private int xCoord, yCoord, height, width;
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

        this.leftEdge = RRConstants.BORDER;
        this.rightEdge = RRConstants.WIDTH - width - RRConstants.BORDER;
        this.movingLeft = true;
    }

    public String getType() {
        return powerType;
    }

    // move left and right by less than you move down
    public void moveRight(int speed) {
        int moveAmt = Math.max(speed / 2, 1);
        if ( (xCoord + moveAmt) <= rightEdge) {
            xCoord += moveAmt;
        } else {
            movingLeft = true;
        }
    }

    public void moveLeft(int speed) {
        int moveAmt = Math.max(speed / 2, 1);
        if ( (xCoord - moveAmt) >= leftEdge) {
            xCoord -= moveAmt;
        } else {
            movingLeft = false;
        }
    }
    
    // Will move down in a zig zag motion
    public void moveDown(int speed) {
        this.yCoord += speed;
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

    public int getX() {
        return xCoord;
    }
    
    public int getY() {
        return yCoord;
    }
    
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    
    public void setYCoord (int yCoord) {
        this.yCoord = yCoord;
    }
    
}