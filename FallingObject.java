/**
 * FILENAME: FallingObject
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Mara Steiu, Angelina Li
 */

import java.awt.*;
import java.util.*;

//a FallingObject is a Character interface's child
public interface FallingObject extends Character {
    
    public void moveDown(int speed);
    
    public int getX();

    public int getY();
}
