/**
 * FILENAME: DeadPanel
 * DESCRIPTION: Panel containing elements show when character dies.
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
    
    /*
     * Constructor of panel
     */
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
    
    /*
     * Private class that listens to the action when button is pressed, implementing ActionListener interface
     */
    private class ButtonListener implements ActionListener {
        
    /*
     * Method that checks the source of the action perdormed (play again/go back to menu).
     * @args event desired by player
     */
        public void actionPerformed (ActionEvent event) {
            if (event.getSource() == playAgain) {
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
