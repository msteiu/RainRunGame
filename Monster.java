/**
 * FILENAME: Monster
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu and Angelina Li
 */

import java.awt.*;
import java.util.Random;

// if you uncomment lines above the monster will move in a zig zag;
// not sure if thats more fun
public class Monster extends MyCharacter implements Character {

    // int moveAmt;
    // boolean movingLeft;
    
    public Monster(int xPos, int yPos, int size, Color color) {
        super(xPos, yPos, size, color);
        // this.moveAmt = new Random().nextInt(size / 3) + 1; // gentle drift
        // this.movingLeft = false;
    }

    @Override
    public String getType() {
        return "monster";
    }

    // @Override
    // public void moveRight() {
    //     super.moveRight();
    //     if ( (xPos + size) > rightEdge) {
    //         movingLeft = true;
    //     }
    // }

    // @Override
    // public void moveLeft() {
    //     super.moveLeft();
    //     if ( (xPos - size) < leftEdge) {
    //         movingLeft = false;
    //     }
    // }

    // @Override
    // public void moveDown() {
    //     super.moveDown();
    //     if (movingLeft) {
    //         moveLeft();
    //     } else {
    //         moveRight();
    //     }
    // }

    // @Override
    // public void drawCharacter(Graphics g) {}

    // @Override
    // public Rectangle getBounds() {}
}