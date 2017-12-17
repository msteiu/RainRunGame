/**
 * FILENAME: RainRun
 * DESCRIPTION: An instance of this class represents a new Rain Run game,
 * which contains different characters, rules for when to add new characters,
 * rules for what should happen to the character when it is hit, and rules for
 * when the game ends.
 *
 * @author Hunter Sessa, Angelina Li
 */

import java.awt.*;
import java.io.*;
import java.util.*;

public class RainRun {

    // the approximate amount of pixel space to maintain falling objects
    private static final int SPACE_BETWEEN_OBJ = 100; 

    // number of microseconds between increasing the level of the game
    private static final int NEXT_LEVEL_INTERVAL = getIntervalFromSecond(30); 

    // the maximum speed that each falling object can fall by each interval
    private static final int MAX_SPEED = 10;

    /* the probability that a new falling object will be a RainDrop as opposed
    to a PowerUp */
    private static final double PROB_RAIN = 0.8;
    private static final int CHAR_SIZE = 20; // default size of the main character

    private MyCharacter character; // the main character the user controls
    private int rainSize; // each new RainDrop has a size between rainSize and rainSize*2
    private int time; // keeps track of how many Timer intervals the game has gone through
    private int score; // keeps track of the current score of the game
    private int scoreInc; // the amount to increment score by each Timer interval
    private int speed; // the speed each falling object falls by each interval
    private Random rand; // Random object used to generate random integers
    
    // contains all fallingObjects (RainDrops and PowerUps) in the game
    private Vector<FallingObject> fallingObjects;
    
    /* maps from the type of each FallingObject to the rules on what should occur 
    to each instance attribute of the game if the character hits an object of
    this type */
    private HashMap<String, HashMap<String, Integer>> hitRules;

    /**
     * Constructor to initialize the instance variables needed for this game.
     */     
    public RainRun() {
        /* the main character always appears at the same position relative to
        the size of the overall game, with a default size and color */
        this.character = new MyCharacter(
            RRConstants.WIDTH/2, 
            RRConstants.HEIGHT - RRConstants.BORDER - 75, 
            CHAR_SIZE, 
            RRConstants.CHAR_DEFAULT_COLOR);

        this.rainSize = CHAR_SIZE; // new RainDrops start off small in size
        this.time = 0;
        this.speed = 1;
        this.score = 0;
        this.scoreInc = 1;
        this.rand = new Random(); // we DON'T want replicability - so we left this unseeded
        
        this.fallingObjects = new Vector<FallingObject>();
        this.hitRules = getHitRules();
    }

    // INITIALIZING RULES //

    /**
     * Helper method that creates and returns a HashMap mapping from a string 
     * representation of each instance attribute to the amount by which hitting 
     * a particular FallingObject should change each attribute. Used to create
     * the hitRules HashMap. 
     *
     * @param int pointAdd the amount by which to increment points by when hit
     * @param int healthAdd the amount by which to increment health by when hit
     * @param int speedAdd the amount by which to increment speed by when hit
     * @param int scoreIncAdd the amount by which to increment scoreInc by when hit
     *
     * @return HashMap mapping from a string representation of each attribute to
     * an amount by which they should be incremented
     */
    private HashMap<String, Integer> getHitRule(int pointAdd, int healthAdd, 
            int speedAdd, int scoreIncAdd) {
        HashMap<String, Integer> hitRule = new HashMap<String, Integer>();
        hitRule.put("points", pointAdd);
        hitRule.put("health", healthAdd);
        hitRule.put("speed", speedAdd);
        hitRule.put("scoreInc", scoreIncAdd);

        return hitRule;
    }
 
    /**
     * Helper method that creates and returns a HashMap mapping from a string
     * representation of each FallingObject type to a HashMap representing the
     * rules for how each instance attribute in this game should change when
     * our main character hits a FallingObject of this type
     *
     * @return HashMap containing rules for each PowerUp.
     */
    private HashMap<String, HashMap<String, Integer>> getHitRules() {
        HashMap<String, HashMap<String, Integer>> allHitRules;
        allHitRules = new HashMap<String, HashMap<String, Integer>>();

        allHitRules.put("raindrop", getHitRule(0, -1, 0, 0));
        allHitRules.put("health", getHitRule(10, 1, 0, 0));
        allHitRules.put("speed", getHitRule(0, 0, 1, 1));
        allHitRules.put("umbrella", getHitRule(50, 0, 0, 0));

        return allHitRules;
    }

    // HELPER METHODS //

    /**
     * Helper method that generates a pseudorandom integer in a range between 
     * [start, end] (inclusive of both start and end).
     * 
     * Credits to this Greg Case's Stack Overflow answer 
     * (https://stackoverflow.com/questions/363681/how-do-i-generate-random-
     * integers-within-a-specific-range-in-java) for helping us write this method.
     *
     * @param int start - start of range
     * @param int end - end of range
     * @return random number between [start, end] inclusive
     */
    private int randInt(int start, int end) {
        return rand.nextInt((end - start) + 1) + start;
    }

    /**
     * Helper method that converts a time value in seconds to the equivalent
     * number of Timer intervals this corresponds with (the units that the
     * time instance attribute are in). Used so that we as game designers can think 
     * about how quickly things should happen in our game in terms of seconds.
     * 
     * @return int number of seconds
     * @param int seconds
     */
    private static int getIntervalFromSecond(int seconds) {
        // each interval represents 1000/DELAY microseconds
        return (seconds * 1000) / RRConstants.DELAY;
    }

    // Allowing our characters to move based on keyboard input //

    /**
     * Moves the character to the left
     */
    public void moveLeft() {
        character.moveLeft();
    }

    /**
     * Moves the character to the right
     */
    public void moveRight() {
        character.moveRight();
    }

    /**
     * When invoked, this method will add a new RainDrop object to our Vector of
     * FallingObjects. The RainDrop's x coordinate will be initialized within 
     * 75 pixels of where the character is - this ensures the user has to keep
     * moving the character (instead of attempting to stay in one place the entire
     * time and continuously getting lucky).
     */
    private void addRainDrop() {
        int size = randInt(rainSize, rainSize*2); // radius of the RainDrop

        int xLeftBound = Math.max(RRConstants.BORDER, character.getX() - 75);
        int xRightBound = Math.min(RRConstants.WIDTH - size, character.getX() + 75);
        int xCoord = randInt(xLeftBound, xRightBound);
        fallingObjects.add(new RainDrop(xCoord, RRConstants.BORDER, size));
    }
    
    /**
     * Helper method that will return the filepath for a given powerup icon.
     * PowerUp path names are all structured as "images/NAMESTUB#.png", e.g.
     * images/heart1.png (where heart1 is a smaller sized icon than heart2).
     * 
     * @param nameStub - String representation of the PowerUp required
     * @param size - an integer between 1 and 2 representing the size of the 
     * PowerUp icon wanted
     * @return the filepath for the icon needed.
     */
    private String getPUPath(String nameStub, int size) {
        return "images/" + nameStub + size + ".png";
    }

    /**
     * Helper method that will add a random powerup to the Vector of FallingObjects
     * in our game. The x coordinate of this powerup will be selected independently
     * from the current location of the character.
     */
    private void addPowerUp() {
        /* PowerUps of size '1' are approximately 30 x 30 pixels large, and
        PowerUps of size '2' are approximately 50 x 50 pixels large */
        int size = randInt(1, 2);
        int xCoord = randInt(RRConstants.BORDER, RRConstants.WIDTH - 50); // biggest image size is 50px
        PowerUp newPowerUp = new HealthPowerUp(xCoord, RRConstants.BORDER, getPUPath("heart", size));
        switch (randInt(0, 2)) {
            case(1) : newPowerUp = new SpeedPowerUp(xCoord, RRConstants.BORDER, getPUPath("speed", size)); break;
            case(2) : newPowerUp = new UmbrellaPowerUp(xCoord, RRConstants.BORDER, getPUPath("umbrella", size)); break;
        }
        fallingObjects.add(newPowerUp);
    }

    /**
     * Method that, when invoked, will add a random FallingObject to the game,
     * with probability PROB_RAIN of getting a RainDrop character and a probability
     * 1 - PROB_RAIN of getting a PowerUp character. 
     *
     * Every time an object is added to our vector of FallingObjects, this 
     * method will also check whether or not the last element of the vector has 
     * moved too far off the screen for the user to see it, and if so will remove
     * it to ensure our Vector stays of a manageable size. Because FallingObjects
     * each fall by the same vertical amount each time interval in this game,
     * we know the object which has travelled the farthest at any given time is
     * the first object in our vector (i.e. the first added).
     */
    public void addNewObject() {
        if (Math.random() <= PROB_RAIN) {
            addRainDrop();
        } else {
            addPowerUp();
        }

        /* While adding a new object, remove any stray FallingObjects who can't be 
        seen within the game anymore. (i.e. whose starting Y coordinate is obscured
        by the game border or who are completely out of bounds of the game). */
        while (fallingObjects.firstElement().getY() > RRConstants.HEIGHT - RRConstants.BORDER) {
            fallingObjects.remove(0);
        }
    }


    /**
     * Helper method that, given a FallingObject that the main character has hit,
     * will use the hitRules HashMap to increment each instance attribute that
     * might have changed by the amount by which it should change.
     *
     * @param falling object that you've hit.
     */
    private void applyHitRule(FallingObject obj) {
        
        HashMap<String, Integer> rules = hitRules.get(obj.getType());
        this.score += rules.get("points");
        this.scoreInc += rules.get("scoreInc");

        int newHealth = character.getHealth() + rules.get("health");
        if (newHealth <= RRConstants.MAX_HEALTH)
            character.setHealth(newHealth);

        int newSpeed = speed + rules.get("speed");
        if (newSpeed <= MAX_SPEED)
            speed = newSpeed;
    }

    /**
     * Method that checks whether or not the main character was hit by any Falling
     * Object, and if so will update each of the instance attributes affected in
     * the game given the type of this FallingObject, will remove the FallingObject
     * in question from view (so that you can't be constantly hit by an object)
     * and will determine whether this change kills the main character.
     */
    public void checkHit() {
        Rectangle charBounds = character.getBounds();

        /* increment downwards to preserve index of each falling object in the
        vector at the time of access even as we remove some of the objects */
        for(int i = fallingObjects.size() - 1; i >= 0; i--) {
            
            FallingObject obj = fallingObjects.get(i);
            
            /* each character has a getBounds() method specified in the Character 
            interface */
            if (charBounds.intersects(obj.getBounds())) {
                applyHitRule(obj);
                fallingObjects.remove(i);
                
                if (character.getHealth() <= 0) {
                    character.setDied(true);
                    break;
                }
            }                
        }
    }

    /*
     * Method that chekcs whether it's time to add element to game
     */
    private boolean timeToAddElement() {
      return fallingObjects.lastElement().getY() >= (RRConstants.BORDER + SPACE_BETWEEN_OBJ);
    }
    
    /*
     * Method that chekcs the time needed to add element to game
     */
    public void checkTime() {

        if (time == 0 || (fallingObjects.size() > 0 && timeToAddElement())) {
            addNewObject();
        }

        if (time % getIntervalFromSecond(1) == 0) { // add to score each second
            score += scoreInc;
        }

        if (time % NEXT_LEVEL_INTERVAL == 0) {
            rainSize++;

            if (speed + 1 <= MAX_SPEED) 
                speed++;
        }

        for (FallingObject obj : fallingObjects) {
            obj.moveDown(speed);
        }

        checkHit();
        time++;
    }


    // Getters and Setters //
    public int getScore() {
        return score;
    }

    public Vector<FallingObject> getFallingObjects() {
        return fallingObjects;
    }

    public MyCharacter getCharacter() {
        return character;
    }

}
