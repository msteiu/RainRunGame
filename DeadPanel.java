/**
 * FILENAME: DeadPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DeadPanel extends JPanel {
    private JButton quitButton, againButton;
    
    public DeadPanel(int score) {
        super();

        JLabel message = new JLabel("YOU DIED :(", JLabel.CENTER);

        quitButton = new JButton("Quit");
        quitButton = new JButton("Play Again!");
    }

}