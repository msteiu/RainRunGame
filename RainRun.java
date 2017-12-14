/**
 * FILENAME: RainRun
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Hunter Sessa, Angelina Li
 */

import java.awt.*;
import java.util.*;

public class RainRun {

    private static final int SPACE_BETWEEN_OBJ = 100; // leave approx 80 pixels between falling objects
    private static final int NEXT_LEVEL_INTERVAL = getIntervalFromSecond(30); // new level every half minute
    private static final int MAX_SPEED = 10;
    private static final double PROB_RAIN = 0.8;

    private MyCharacter character;

    private int rainSize, time, score, scoreInc, level, speed;
    private Vector<FallingObject> fallingObjects;
    private HashMap<String, HashMap<String, Integer>> hitRules;

    /**
     * Constructor - defines what will be contained in RainRun instance
     * Threads all backend aspects of the game together 
     * @param charColor- color of character
     * @param charSize- size of character
     */     
    public RainRun(int charSize, Color charColor) {

        this.character = new MyCharacter(RRConstants.WIDTH/2, 
            RRConstants.HEIGHT - RRConstants.BORDER - 75, charSize, charColor);
        this.rainSize = charSize;
        this.speed = 1;
        this.time = 0;
        this.score = 0;
        this.scoreInc = 1;
        this.level = 1;
        
        this.fallingObjects = new Vector<FallingObject>();
        this.hitRules = getHitRules();
    }

    public RainRun() {
        this(20, RRConstants.CHAR_DEFAULT_COLOR);
    }

    // Helper methods //

    private static int randInt(int start, int end) {
        // uses math.Random()
        // INCLUSIVE of start and end
        int scale = end - start;
        double randNum = (Math.random() * scale) + start;
        int rand = Math.round((float)randNum);
        return (rand >= start && rand <= end) ? rand : end;
    }


    private static int getIntervalFromSecond(int seconds) {
        return (seconds * 1000) / RainRunPanel.DELAY;
    }

    // Initializing our instance variables //

    private HashMap<String, Integer> getHitRule(int pointAdd, int healthAdd, 
            int speedAdd, int scoreIncAdd) {
        HashMap<String, Integer> hitRule = new HashMap<String, Integer>();
        hitRule.put("points", pointAdd);
        hitRule.put("health", healthAdd);
        hitRule.put("speed", speedAdd);
        hitRule.put("scoreInc", scoreIncAdd);

        return hitRule;
    }
 
    private HashMap<String, HashMap<String, Integer>> getHitRules() {
        HashMap<String, HashMap<String, Integer>> allHitRules;
        allHitRules = new HashMap<String, HashMap<String, Integer>>();

        allHitRules.put("raindrop", getHitRule(0, -1, 0, 0));
        allHitRules.put("health", getHitRule(10, 1, 0, 0));
        allHitRules.put("speed", getHitRule(0, 0, 1, 1));
        allHitRules.put("umbrella", getHitRule(50, 0, 0, 0));

        return allHitRules;
    }

    // Allowing our characters to move based on keyboard input //

    public void moveLeft() {
        character.moveLeft();
    }

    public void moveRight() {
        character.moveRight();
    }

    // Add a new FallingObject to our game //

    private void addRainDrop() {
        int size = randInt(rainSize, rainSize*2);
        int xLeftBound = Math.max(0, character.getX() - 75); // monsters will appear near character
        int xRightBound = Math.min(RRConstants.WIDTH - size, character.getX() + 75);
        int xCoord = randInt(xLeftBound, xRightBound);
        fallingObjects.add(new RainDrop(xCoord, RRConstants.BORDER, size));
    }

    private String getPUPath(String nameStub, int size) {
        return "images/" + nameStub + size + ".png";
    }

    private void addPowerUp() {
        int size = randInt(1, 2);
        int xCoord = randInt(0, RRConstants.WIDTH - 30); // biggest image size is 30px
        PowerUp newPowerUp = new HealthPowerUp(xCoord, RRConstants.BORDER, getPUPath("heart", size));
        switch (randInt(0, 2)) {
            case(1) : newPowerUp = new SpeedPowerUp(xCoord, RRConstants.BORDER, getPUPath("speed", size)); break;
            case(2) : newPowerUp = new UmbrellaPowerUp(xCoord, RRConstants.BORDER, getPUPath("umbrella", size)); break;
        }
        fallingObjects.add(newPowerUp);
    }

    public void addNewObject() {
        if (Math.random() <= PROB_RAIN) 
            addRainDrop();
        
        else
            addPowerUp();

        // while adding a new object, remove any stray objects who can't be seen by the game anymore
        while (fallingObjects.firstElement().getY() > RRConstants.HEIGHT  - RRConstants.BORDER) {
            fallingObjects.remove(0);
        }
    }


    // Check hit //

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

    public void checkHit() {
        Rectangle charBounds = character.getBounds();

        for(int i = fallingObjects.size() - 1; i >= 0; i--) {
            
            FallingObject obj = fallingObjects.get(i);
            
            if (charBounds.intersects(obj.getBounds())) {
                applyHitRule(obj);
                fallingObjects.remove(i);
                
                if (character.getHealth() <= 0)
                    character.setDied(true);
            }                
        }
    }


    // Check time //

    private boolean timeToAddElement() {
      return fallingObjects.lastElement().getY() >= (RRConstants.BORDER + SPACE_BETWEEN_OBJ);
    }
    
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