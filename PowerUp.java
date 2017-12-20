/**
 * FILENAME: PowerUp
 * DESCRIPTION: Abstract class which contains main characteristics and behaviors of the three power-ups: health, speed, umbrella. The 
 * current class extends FallingObject abstract class, given that all power-ups are falling objects, but also has more specific charac-
 * teristics than other falling objects such as rain drops (defined in RainDrop). 
 * @author Hunter Sessa, Angelina Li
 */

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import java.util.Random;

public abstract class PowerUp extends FallingObject {
    
    //Instance variables of power-ups
    protected String powerType;
    private boolean movingLeft;
    private BufferedImage img;
    
    /**
     * Constructor - defines what will be contained in every PowerUp instance; it inherits the constructor of FallingObject and additionally
     * includes image representing power-up graphic (heart/shoe/umbrella).
     * @param xCoord int- x coordinate of power-up location
     * @param yCoord int- y coordinate of power-up location
     * @param String imagePath- the String location of the icon used for each power-up
     */ 
    public PowerUp(int xCoord, int yCoord, String imagePath) {
        super(xCoord, yCoord);

        try {
            img = ImageIO.read(new File(imagePath)); //tries to access the image with the given name
            this.setWidth(img.getWidth());
            this.setHeight(img.getHeight());
        } catch (IOException e) {
            System.out.println("Couldn't open image " + imagePath); //if image couldn't be accessed, complain to user
        }

        this.movingLeft = new Random().nextBoolean();
    }

    /**
     * getType() returns type of powerup (umbrella/speed/health)
     * @return String type of powerup 
     */     
    public String getType() {
        return powerType;
    }
    
    /**
     * drawCharacter() creates graphical representation of the PowerUp, making a power-up image appear on screen at a specific location
     */ 
    public void drawCharacter(Graphics g) {
        g.drawImage(img, getX(), getY(), new ImgObserver());
    }

    
    public class ImgObserver implements ImageObserver {

        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
            return false;
        }
    }

    /**
     * moveRight (int Speed)
     * @param speed int value to regulate speed with which the powerUp moves right
     * ensures powerup will not travel beyond the screen 
     */  
    private void moveRight(int speed) {
        int moveAmt = Math.max(speed/2, 1);
        int newxCoord = this.getX() + moveAmt;
        if (newxCoord <= getRightEdge()) {
            setX(newxCoord);
        } else {
            movingLeft = true;
        }
    }

    /**
     * moveLeft (int Speed)
     * @param speed int value to regulate speed with which the powerUp moves left
     * ensures powerup will not travel beyond the screen 
     */     
    private void moveLeft(int speed) {
        int moveAmt = Math.max(speed/2, 1);
        int newxCoord = this.getX() - moveAmt;
        if (newxCoord >= getLeftEdge()) {
            setX(newxCoord);
        } else {
            movingLeft = false;
        }
    }

    /**
     * moveDown (int Speed)
     * @param speed int value to regulate speed with which the powerUp moves down
     * fulfills one of FallingObject's abstract methods
     */      
    public void moveDown(int speed) {
        setY(speed + getY());
        if (movingLeft) {
            moveLeft(speed); 
        } else {
            moveRight(speed);
        }
    }
   
}
