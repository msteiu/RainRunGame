/**
 * FILENAME: RainRun
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Hunter Sessa
 */

import java.awt.*;
import java.util.*;

public class RainRun {

    private static final int HEIGHT = RainRunPanel.HEIGHT;
    private static final int WIDTH = RainRunPanel.WIDTH;
    private static final int BORDER = RainRunPanel.BORDER;
    private static final int ADD_EL_INTERVAL = 2; // add an element every second
    private static final int INCREASE_SIZE_INTERVAL = 10;
    private static final int INCREASE_SPEED_INTERVAL = 10;
    private static final int MAX_SPEED = 10;
    private static final int MAX_HEALTH = 3;
    private static final double PROB_MONSTER = 0.8;

    private MyCharacter character;
    private Color monsterColor;
    private Font scoreFont;
    private boolean died;
    private int charSize, monsterSize, time, score, scoreInc, speed, health;
    private Vector<FallingObject> fallingObjects;
    private HashMap<String, HashMap<String, Integer>> hitRules;

    public RainRun(Color charColor, Color monsterColor, int charSize) {

        this.character = new MyCharacter(WIDTH/2, HEIGHT - BORDER - 75, charSize, charColor);
        this.monsterColor = monsterColor;

        this.scoreFont = new Font("Sans Serif", Font.BOLD, 16);
        this.monsterSize = charSize;
        this.died = false;
        this.time = 0;
        this.score = 0;
        this.scoreInc = 1;
        this.speed = 1;
        this.health = MAX_HEALTH;

        this.fallingObjects = new Vector<FallingObject>();
        this.hitRules = getHitRules();
    }

    public RainRun() {
        this(new Color(255, 215, 0), Color.CYAN, 20);
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

    private int getMSFromTime() {
        return time*RainRunPanel.DELAY;
    }

    private static int getMSFromSecond(int seconds) {
        // convert second to millisecond
        return seconds * 1000; 
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

        allHitRules.put("monster", getHitRule(0, -1, 0, 0));
        allHitRules.put("health", getHitRule(10, 1, 0, 0));
        allHitRules.put("speed", getHitRule(0, 0, 1, 1));
        allHitRules.put("umbrella", getHitRule(100, 0, 0, 0));

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

    public void addMonster() {
        int size = randInt(monsterSize, monsterSize*2);
        int xLeftBound = Math.max(0, character.getX() - 50); // monsters will appear near character
        int xRightBound = Math.min(WIDTH - size, character.getX() + 50);
        int xCoord = randInt(xLeftBound, xRightBound);
        fallingObjects.add(new Monster(xCoord, BORDER, size, monsterColor));
    }

    public String getPUPath(String nameStub, int size) {
        return "images/" + nameStub + size + ".png";
    }

    public void addPowerUp() {
        int size = randInt(1, 2);
        int xCoord = randInt(0, WIDTH - 30); // biggest image size is 30px
        PowerUp newPowerUp = new HealthPowerUp(xCoord, BORDER, getPUPath("heart", size));
        switch (randInt(0, 2)) {
            case(1) : newPowerUp = new SpeedPowerUp(xCoord, BORDER, getPUPath("speed", size)); break;
            case(2) : newPowerUp = new UmbrellaPowerUp(xCoord, BORDER, getPUPath("umbrella", size)); break;
        }
        fallingObjects.add(newPowerUp);
    }

    public void addNewObject() {
        if (Math.random() <= PROB_MONSTER)
            addMonster();
        else
            addPowerUp();

        while (fallingObjects.size() > HEIGHT / monsterSize) {
            fallingObjects.remove(0); // faster than removing only elements that are off the screen but maybe glitchy
        }
    }


    // Check hit //

    private void applyHitRule(FallingObject obj) {
        HashMap<String, Integer> rules = hitRules.get(obj.getType());
        this.score += rules.get("points");
        this.scoreInc += rules.get("scoreInc");

        int newHealth = health + rules.get("health");
        if (newHealth <= MAX_HEALTH)
            health = newHealth;

        int newSpeed = speed + rules.get("speed");
        if (speed <= MAX_SPEED)
            speed = newSpeed;
    }

    public void checkHit() {
        Rectangle charBounds = character.getBounds();

        
        for(int i = fallingObjects.size() - 1; i >= 0; i--) {
            FallingObject obj = fallingObjects.get(i);
            
            if (charBounds.intersects(obj.getBounds())) {
                applyHitRule(obj);
                fallingObjects.remove(i);

                if (health <= 0)
                    this.died = true;
            }                
        }
    }


    // Check time //

    public void checkTime() {
        if (getMSFromTime() % getMSFromSecond(ADD_EL_INTERVAL) == 0) {
            addNewObject();
            score += scoreInc;
        }

        if (getMSFromTime() % getMSFromSecond(INCREASE_SIZE_INTERVAL) == 0) {
            monsterSize++;
        }

        if (getMSFromTime() % getMSFromSecond(INCREASE_SPEED_INTERVAL) == 0 && speed - 1 < MAX_SPEED) 
            speed++;

        for (FallingObject obj : fallingObjects)
            obj.moveDown(speed);

        checkHit();
        time++;
    }


    // Getters and Setters //

    public int getCharSize() {
        return charSize;
    }

    public void setCharSize(int charSize) {
        this.charSize = charSize;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScoreInc() {
        return scoreInc;
    }

    public void setScoreInc(int scoreInc) {
        this.scoreInc = scoreInc;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean getDied() {
        return died;
    }

    public void setDied(boolean died) {
        this.died = died;
    }

    public Vector<FallingObject> getFallingObjects() {
        return fallingObjects;
    }

    public MyCharacter getCharacter() {
        return character;
    }

}