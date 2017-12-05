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
        setForeground(RainRun.BACKGROUND);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(getDeathLabel());

        // quitButton = new JButton("Quit");
        // quitButton = new JButton("Play Again!");
    }

    private JLabel getDeathLabel() {
        JLabel message = new JLabel(
            "<html><b>YOU DIED :(</b></html>", JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);
        message.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        message.setForeground(RainRun.TEXT);
        return message;
    }

}