/**
 * FILENAME: DeadPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Isabel Bryant
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeadPanel extends TextPanel {
    
    private static final Color BACK_COLOR = RRConstants.RULE_BUTTON_COLOR;
    
    private JLabel died;
    private JButton playAgain;
    private JButton mainMenu;
    
    public DeadPanel() {
        super(RRConstants.BACKGROUND_COLOR);
        
        //setting up "You Died" Label
        died = new JLabel("<html>YOU GOT<br>SOAKED!</html>");
        died.setFont(this.nameFont);
        died.setForeground(RRConstants.BORDER_COLOR);
        
        //setting up playAgain button
        ButtonListener b = new ButtonListener();
        playAgain = getButton("PLAY AGAIN", BACK_COLOR, b);
        mainMenu = getButton("BACK TO MENU", BACK_COLOR, b);
                
        addComponent(died, RRConstants.HEIGHT/4);
        addComponent(playAgain, RRConstants.HEIGHT/2);
        addComponent(mainMenu, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/8);
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            if (event.getSource() == playAgain) {
                new RainRunPanel();
                RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.PLAYPANEL);
                RainRunGUI.gamePanel.startGame();
                RainRunGUI.gamePanel.requestFocusInWindow();
            }
            else if (event.getSource() == mainMenu) {
                RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
            }
        }
    }
}