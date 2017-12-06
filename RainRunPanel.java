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
    protected static final int HEIGHT = 500; // how high the overall game frame is
    protected static final int BORDER = 10;
    protected static final int CHAR_SIZE = 20;

    protected static final Color BORDER_COLOR = new Color(75, 0, 130); // dark purple
    protected static final Color CHAR_COLOR = new Color(148, 0, 211);
    protected static final Color VILLAIN_COLOR = Color.CYAN;
    // protected static final Color BORDER_COLOR = new Color(255, 215, 0); // yellow
    protected static final Font SCORE_FONT = new Font("Sans Serif", Font.BOLD, 15);
    
    private MyCharacter character;
    private Vector<Character> monsters; // includes power ups

    private Random rand;
    private Timer timer;
    private KeyListener kListener;
    private ActionListener tListener;

    private int health, time;
    private boolean died;

    public RainRunPanel() {
        character = new MyCharacter(WIDTH/2, HEIGHT - BORDER - 75, CHAR_SIZE, CHAR_COLOR);
        monsters = new Vector<Character>();
        tListener = new TimerListener();
        kListener = new MoveListener();
        timer = new Timer(500, tListener); // 1000ms = 1 second
        rand = new Random(150);

        time = 0;
        health = 3;
        died = false;

        setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER));
        setFocusable(true);
        addKeyListener(kListener);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        makeScore(g);
        makeHealth(g);
        character.drawCharacter(g);
        for(Character monster : monsters) {
            monster.drawCharacter(g);
        }

        if (died)
            makeDeathPane(g);
        
        repaint();
    }

    private void makeScore(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.setFont(SCORE_FONT);
        g.drawString("Score: " + time, BORDER + 5, BORDER + 15);
    }

    private void makeHealth(Graphics g) {
        String h = "Health: " + health;
        g.setColor(BORDER_COLOR);
        g.setFont(SCORE_FONT);
        g.drawString(h, WIDTH - (BORDER + 5) - (h.length()*8), BORDER + 15);
    }

    private void makeDeathPane(Graphics g) {
        try {
            Image img = ImageIO.read(new File("images/dead.png"));
            g.drawImage(img, (WIDTH - 300) / 2, (HEIGHT/2) - 50, new PaneObserver()); // img 300x100
        } catch (IOException e) {
            System.out.println("Couldn't open image dead.png");
        }
    }

    private void checkHit() {
        Rectangle charBounds = character.getBounds();
        for(int i = monsters.size() - 1; i >= 0; i--) {

            Character monster = monsters.get(i);

            if (charBounds.intersects(monster.getBounds())) {
                
                switch(monster.getType()) {
                    case("monster") : health--; break;
                    case("health") : if (health < 3) health++; break;
                    case("speed") : break;
                    case("umbrella") : break;
                }

                monsters.remove(i);

                if (health < 0) {
                    died = true;
                    timer.stop();
                    removeKeyListener(kListener);
                    timer.removeActionListener(tListener);
                }

            }

        }
    }

    // LISTENERS //

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

        public void keyReleased(KeyEvent e) {}

        public void keyTyped(KeyEvent e) {}

    }

    public class TimerListener implements ActionListener {

        private void addElement() {
            if (rand.nextFloat() < 0.9) {
                int size = rand.nextInt(CHAR_SIZE*2) + CHAR_SIZE;
                int xCoord = rand.nextInt(WIDTH - size);
                monsters.add(new Monster(xCoord, BORDER, size, VILLAIN_COLOR));
            }
            else {
                int xCoord = rand.nextInt(WIDTH - 30);
                int size = rand.nextInt(2) + 1;
                switch (rand.nextInt(3)) {
                    case(0) : monsters.add(
                                new SpeedPowerUp(xCoord, BORDER, "images/speed" + size + ".png"));
                              break;
                    case(1) : monsters.add(
                                new HealthPowerUp(xCoord, BORDER, "images/heart" + size + ".png"));
                              break;
                    case(2) : monsters.add(
                                new UmbrellaPowerUp(xCoord, BORDER, "images/umbrella" + size + ".png"));
                }
            }

            if (monsters.size() > 40)
                monsters.remove(0);
        }
        
        public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == timer) {
                
                if (time % 4 == 0)
                    addElement();

                for (Character monster : monsters)
                    monster.moveDown();

                checkHit();
                time++;
            }
        }
    }
}