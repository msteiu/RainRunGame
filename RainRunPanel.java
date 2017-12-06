/**
 * FILENAME: RainRunPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.image.ImageObserver;
import javax.imageio.*;
import java.io.*;

import java.util.Vector;
import java.util.Random;


public class RainRunPanel extends JPanel {
    protected static final int WIDTH = 300; // how wide the overall game frame is
    protected static final int HEIGHT = 550; // how high the overall game frame is
    protected static final int BORDER = 15; // thickness of border
    protected static final int CHAR_SIZE = 20;

    protected static final Color BORDER_COLOR = new Color(75, 0, 130); // dark purple
    protected static final Color CHAR_COLOR = new Color(255, 215, 0); //new Color(148, 0, 211);
    protected static final Color VILLAIN_COLOR = Color.CYAN;
    protected static final Font SCORE_FONT = new Font("Sans Serif", Font.BOLD, 16);
    
    protected static final int MAX_HEALTH = 3;
    protected static final int MAX_SPEED = 100; // smaller numbers are faster
    protected static final int START_DELAY = 500; // amt to delay timer by between events
    protected static final int ADD_EL_INTERVAL = 4; // add an element every 4 timer intervals
    protected static final int INCREASE_SIZE_INTERVAL = 25; // increase monster size every 50 intervals
    protected static final int INCREASE_SPEED_INTERVAL = 50; // increase speed every 50 intervals
    protected static final double PROB_MONSTER = 0.8; // probability a new element is a monster

    private MyCharacter character;
    private Vector<Character> monsters; // includes power ups

    private Timer timer;
    private KeyListener kListener;
    private ActionListener tListener;
    private Random rand;
    private int health, time, score, scoreInc, speed, monsterSize;
    private boolean died;

    public RainRunPanel() {
        character = new MyCharacter(WIDTH/2, HEIGHT - BORDER - 75, CHAR_SIZE, CHAR_COLOR);
        monsters = new Vector<Character>();
        tListener = new TimerListener();
        kListener = new MoveListener();
        speed = START_DELAY; // start off as falling twice per second
        timer = new Timer(speed, tListener); // 1000ms = 1 second
        rand = new Random(100);

        time = 0;
        score = 0;
        scoreInc = 1; // score increment - as speed goes up, so does scoreInc per period
        health = MAX_HEALTH;
        monsterSize = CHAR_SIZE;
        died = false;

        setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER));
        setFocusable(true);
        addKeyListener(kListener);
        timer.start();
    }

    private static int randInt(int start, int end) {
        // uses math.Random()
        // INCLUSIVE of start and end
        int scale = end - start;
        double randNum = (Math.random() * scale) + start;
        int rand = Math.round((float)randNum);
        return (rand >= start && rand <= end) ? rand : end;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        makeScore(g);
        makeHealth(g);

        for(Character monster : monsters) {
            monster.drawCharacter(g);
        }

        if (!died) // remove char when dead
            character.drawCharacter(g);
        else
            makeDeathPane(g);

        repaint();
    }

    private void makeScore(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.setFont(SCORE_FONT);
        g.drawString("Score: " + score, BORDER + 8, BORDER + 20);
    }

    private void makeHealth(Graphics g) {
        try { // the health hearts are each 20 px wide
            Image img = ImageIO.read(new File("images/life.png"));
            for (int i = 1; i <= health; i++) {
                int xCoord = WIDTH - (BORDER + 3) - i*(20 + 5);
                g.drawImage(img, xCoord, BORDER + 8, new PaneObserver());
            }
        } catch (IOException e) {
            System.out.println("Couldn't open image images/life.png");
        }
    }

    private void makeDeathPane(Graphics g) {
        try {
            Image img = ImageIO.read(new File("images/dead.png"));
            g.drawImage(img, (WIDTH - 300) / 2, (HEIGHT/2) - 50, new PaneObserver()); // img 300x100
        } catch (IOException e) {
            System.out.println("Couldn't open image dead.png");
        }
    }

    private void implementHit(Character monster) {
        
        switch(monster.getType()) {
            
            case("monster") : 
                health--;
                break;
            
            case("health") :
                if (health < MAX_HEALTH)
                    health++; // refills health if health pts are down
                score += 10; // free 10 points regardless
                break;
            
            case("speed") : 
                if (speed - 50 > MAX_SPEED) { // min speed 100
                    speed -= 50; // smaller speeds are faster
                    timer.setDelay(speed);
                    scoreInc++; // to make this appealing, your score goes up by more each time period
                }
                break;
            
            case("umbrella") :
                score += 100; // free 100 points
                break;
        }
    }

    private void checkHit() {
        Rectangle charBounds = character.getBounds();
        
        for(int i = monsters.size() - 1; i >= 0; i--) {
            Character monster = monsters.get(i);
            if (charBounds.intersects(monster.getBounds())) {

                implementHit(monster);
                monsters.remove(i);

                // check whether you've died
                if (health <= 0) {
                    died = true;
                    timer.stop();
                    removeKeyListener(kListener);
                    timer.removeActionListener(tListener);
                }
            }
        }
    }

    // LISTENERS //

    // required to add an image
    public class PaneObserver implements ImageObserver {
        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
            return false;
        }
    }
    
    public class MoveListener implements KeyListener {

        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            if (keyPressed == KeyEvent.VK_LEFT || keyPressed == KeyEvent.VK_A) {
                character.moveLeft();
                checkHit();
            }
            if (keyPressed == KeyEvent.VK_RIGHT || keyPressed == KeyEvent.VK_D) {
                character.moveRight();
                checkHit();
            }
        }
        // required by the KeyListener interface
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public class TimerListener implements ActionListener {

        private void addElement() {
            if (rand.nextFloat() < PROB_MONSTER) {
                int size = randInt(monsterSize, monsterSize*2);
                int xLeftBound = Math.max(0, character.getX() - 50); // monsters will appear near you
                int xRightBound = Math.min(WIDTH - size, character.getX() + 50);
                int xCoord = randInt(xLeftBound, xRightBound);
                monsters.add(new Monster(xCoord, BORDER, size, VILLAIN_COLOR));
            }

            else {
                int xCoord = randInt(0, WIDTH - 30); // biggest image size is 30px
                int size = randInt(1, 2);
                switch (randInt(0, 2)) {
                    case(0) : monsters.add( // heart1.png is smaller than heart2.png, etc.
                                new HealthPowerUp(xCoord, BORDER, "images/heart" + size + ".png"));
                              break;
                    case(1) : monsters.add(
                                new SpeedPowerUp(xCoord, BORDER, "images/speed" + size + ".png"));
                              break;
                    case(2) : monsters.add(
                                new UmbrellaPowerUp(xCoord, BORDER, "images/umbrella" + size + ".png"));
                              break;
                    default: System.out.println("Randint not working");
                }
            }

            if (monsters.size() > 40)
                monsters.remove(0); // maintain manageable size
        }
        
        public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == timer) {
                
                if (time % ADD_EL_INTERVAL == 0) // add an element every 4 time intervals
                    addElement();

                if (time % INCREASE_SIZE_INTERVAL == 0)
                    monsterSize++; // slowly make monster sizes increase

                if (time % INCREASE_SPEED_INTERVAL == 0 && speed - 10 > MAX_SPEED) {
                    speed -= 10; // slowly increased speed -- lower nums = higher speeds
                    timer.setDelay(speed);
                }

                for (Character monster : monsters)
                    monster.moveDown();

                checkHit();
                score += scoreInc;
                time++;
            }
        }
    }

}