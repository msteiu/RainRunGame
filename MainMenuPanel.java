/**
 * FILENAME: MainMenuPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Isabel Bryant
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

public class MainMenuPanel extends JPanel {
    
    private static final Font NAME_FONT = RRConstants.getFont(60); // new Font(RRConstants.FONT_NAME, Font.BOLD, 60);
    private static final Font BUTTON_FONT = RRConstants.getFont(30); // new Font(RRConstants.FONT_NAME, Font.BOLD, 30);
    private static final Color PLAY_COLOR = RRConstants.CHAR_DEFAULT_COLOR;
    private static final Color RULES_COLOR = RRConstants.RULE_BUTTON_COLOR;
    private static final Color SCORES_COLOR = new Color(255, 0, 255);
    
    private JLabel gameName;
    private JButton playButton;
    private JButton rulesButton;
    private JButton scoresButton;
    
    public MainMenuPanel() {
        //setting up background panel
        setLayout(null);
        
        setBackground(RRConstants.BORDER_COLOR);
        setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
        
        //setting up "Rain Run" Label
        gameName = new JLabel("RAIN RUN");
        gameName.setFont(NAME_FONT);
        gameName.setForeground(Color.white);

        // setting up the buttons
        ButtonListener b = new ButtonListener();
        playButton = getButton("PLAY", PLAY_COLOR, b);
        rulesButton = getButton("RULES", RULES_COLOR, b);
        scoresButton = getButton("SCORES", SCORES_COLOR, b);

        addComponent(gameName, RRConstants.HEIGHT/4);
        addComponent(playButton, RRConstants.HEIGHT/2);
        addComponent(rulesButton, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/8);
        addComponent(scoresButton, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/4);
    }

    private void addComponent(JComponent component, int yCoord) {
        add(component);
        Dimension sizeComponent = component.getPreferredSize();
        int xCoord = (RRConstants.WIDTH - sizeComponent.width)/2;
        component.setBounds(xCoord, yCoord, sizeComponent.width, sizeComponent.height);
    }

    private JButton getButton(String name, Color color, ButtonListener b) {
        JButton button = new JButton(name);
        
        button.setFont(BUTTON_FONT);
        button.setForeground(Color.white);
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addActionListener(b);

        return button;
    }
    
    private class ButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {
            if (event.getSource() == playButton) {
                RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.PLAYPANEL);
                RainRunGUI.gamePanel.startGame();
                RainRunGUI.gamePanel.requestFocusInWindow();
            }
            else if (event.getSource() == rulesButton){
                RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.RULESPANEL);
            }
            else if (event.getSource() == scoresButton) {
              RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.SCORESPANEL);
            }
        }
    }
    
    public static void main(String[] args) {}
}