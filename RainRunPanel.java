/**
 * FILENAME: RainRunPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

// use a queue to change how powerups are used
// use a hash table for cases and effects
// hash table to store scores

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.image.ImageObserver;
import javax.imageio.*;
import java.io.*;

public class RainRunPanel extends JPanel {
    protected static final int HEIGHT = 550; // how high the overall game frame is
    protected static final int WIDTH = 300; // how wide the overall game frame is
    protected static final int BORDER = 15; // thickness of border
    protected static final Font SCORE_FONT = new Font("Sans Serif", Font.BOLD, 16);
    protected static final Color BORDER_COLOR = new Color(75, 0, 130); // dark purple
    protected static final int DELAY = 25;

    private RainRun game;
    private Timer timer;
    private TimerListener tListener;
    private MoveListener kListener;
    private boolean running;

    public RainRunPanel() {
        this.game = new RainRun();
        tListener = new TimerListener();
        kListener = new MoveListener();

        timer = new Timer(DELAY, tListener); // 1000ms = 1 second

        setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER));
        setFocusable(true);
        addKeyListener(kListener);
        running = false;
        timer.start();
    }

    public RainRunPanel(Color charColor, Color monsterColor, int charSize) {
        this.game = new RainRun(charColor, monsterColor, charSize);
        tListener = new TimerListener();
        kListener = new MoveListener();

        timer = new Timer(DELAY, tListener); // 1000ms = 1 second

        setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER));
        setFocusable(true);
        addKeyListener(kListener);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        makeScore(g);
        makeHealth(g);

        for(FallingObject obj : game.getFallingObjects()) {
            obj.drawCharacter(g);
        }

        if (!game.getDied()) // remove char when dead
            game.getCharacter().drawCharacter(g);
        else
            makeDeathPane(g);

        repaint();
    }

    private void makeScore(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.setFont(SCORE_FONT);
        g.drawString("Score: " + game.getScore(), BORDER + 8, BORDER + 20);
    }

    private void makeHealth(Graphics g) {
        try { // the health hearts are each 20 px wide
            Image img = ImageIO.read(new File("images/life.png"));
            for (int i = 1; i <= game.getHealth(); i++) {
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
                game.moveLeft();
                game.checkHit();
            }
            if (keyPressed == KeyEvent.VK_RIGHT || keyPressed == KeyEvent.VK_D) {
                game.moveRight();
                game.checkHit();
            }
        }
        // required by the KeyListener interface
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public class TimerListener implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == timer && running) {
                
                if (game.getDied()) {
                    timer.stop();
                    removeKeyListener(kListener);
                    timer.removeActionListener(tListener);
                    running = false;
                }

                game.checkTime();
            }
        }
    }

    // GETTERS AND SETTERS //

    public void start() {
        this.running = true;
    }

    public void pause() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

}