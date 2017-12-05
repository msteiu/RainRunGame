/**
 * FILENAME: RainRunPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Vector;

public class RainRunPanel extends JPanel {
    private int score;
    private int health;

    private MyCharacter character;
    private Vector<RainMonster> monsters;
    private Vector<PowerUp> powerUps;
    private Timer timer;
    private Color backgroundColor;

    public RainRunPanel() {
        character = new MyCharacter();
        powerUps = new Vector<PowerUp>();
        monsters = new Vector<RainMonster>();
        timer = new Timer(1000, new TimerListener()); // 1000ms = 1 second
        backgroundColor = RainRun.BACKGROUND;

        setBorder(BorderFactory.createLineBorder(backgroundColor, 10));
        setFocusable(true);
        addKeyListener(new MoveListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        character.drawCharacter(g);
        for(RainMonster monster : monsters) {
            monster.drawMonster(g);
        }
        repaint();
    }

    public void checkDeath() {

    }

    // LISTENERS //
    
    public class MoveListener implements KeyListener {

        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            if (keyPressed == KeyEvent.VK_LEFT || keyPressed == KeyEvent.VK_A) {
                character.moveLeft();
            }
            if (keyPressed == KeyEvent.VK_RIGHT || keyPressed == KeyEvent.VK_D) {
                character.moveRight();
            }
        }

        public void keyReleased(KeyEvent e) {
        
        }

        public void keyTyped(KeyEvent e) {
            
        }
    }

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == timer) {
                score ++;
            }
        }
    }
}