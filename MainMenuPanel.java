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
    
    private JLabel gameName;
    private JButton playButton;
    private JButton rulesButton;
    
    public MainMenuPanel() {
        //setting up background panel
        setLayout(null);
        
        setBackground(RRConstants.BORDER_COLOR);
        setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
        
        //setting up "Rain Run" Label
        gameName = new JLabel("RAIN RUN");
        gameName.setFont(NAME_FONT);
        gameName.setForeground(Color.white);
        
        //setting up playButton
        playButton = new JButton("PLAY");
        playButton.setFont(BUTTON_FONT);
        playButton.setForeground(Color.white);
        playButton.setBackground(PLAY_COLOR);
        playButton.setOpaque(true);
        playButton.setBorderPainted(false);
        
        //setting up rulesButton
        rulesButton = new JButton("RULES");
        rulesButton.setFont(BUTTON_FONT);
        rulesButton.setForeground(Color.white);
        rulesButton.setBackground(RULES_COLOR);
        rulesButton.setOpaque(true);
        rulesButton.setBorderPainted(false);
        
        //setting up action listener for playButton and rulesButton
        ButtonListener b = new ButtonListener();
        playButton.addActionListener (b);
        rulesButton.addActionListener (b);
        

        add(gameName);
        add(playButton);
        add(rulesButton);
        
        Dimension sizeName = gameName.getPreferredSize();
        Dimension sizePlay = playButton.getPreferredSize();
        Dimension sizeRules = rulesButton.getPreferredSize();
        
        gameName.setBounds((RRConstants.WIDTH - sizeName.width)/2, RRConstants.HEIGHT/4, sizeName.width, sizeName.height);
        playButton.setBounds((RRConstants.WIDTH - sizePlay.width)/2, RRConstants.HEIGHT/2, sizePlay.width, sizePlay.height);
        rulesButton.setBounds((RRConstants.WIDTH - sizeRules.width)/2, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/8, sizeRules.width, sizeRules.height);
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
        }
    }
    
    public static void main(String[] args) {}
}