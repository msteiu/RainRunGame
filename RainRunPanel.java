/**
 * FILENAME: RainRunPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class RainRunPanel extends JPanel {
    private RainRun game;
    // private MyCharacter character;
    // private ArrayList<PowerUp> powerUps;
    private Timer timer;
    private Color backgroundColor;

    public RainRunPanel() {
        game = new RainRun();
        // character = new MyCharacter();
        // powerUps = new ArrayList<PowerUp>();
        timer = new Timer(1000, new TimerListener()); // 1000ms = 1 second
        backgroundColor = game.getBackgroundColor();

        setBorder(BorderFactory.createLineBorder(backgroundColor, 10));
        setFocusable(true);
        // addKeyListener(new MoveListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // character.drawCharacter(g);
        repaint();
    }

    // LISTENERS //
    
    // public class MoveListener implements KeyListener {

    //     public void keyPressed(KeyEvent e) {
    //         int keyPressed = e.getKeyCode();
    //         if (keyPressed == KeyEvent.VK_LEFT || keyPressed == KeyEvent.VK_A) {
    //             character.moveLeft();
    //         }
    //         if (keyPressed == KeyEvent.VK_RIGHT || keyPressed == KeyEvent.VK_D) {
    //             character.moveRight();
    //         }
    //     }

    //     public void keyReleased(KeyEvent e) {
        
    //     }

    //     public void keyTyped(KeyEvent e) {
            
    //     }
    // }

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == timer) {
                
            }
        }
    }
}