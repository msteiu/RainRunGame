/**
 * FILENAME: DeadPanel
 * DESCRIPTION: Panel that apepars when character dies. Options to return the main menu or play again.
 * @author Isabel Bryant
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeadPanel extends TextPanel {
        
        private static final Color BACK_COLOR = RRConstants.RULE_BUTTON_COLOR;
        
        private JLabel died, score;
        private JButton playAgain;
        private JButton mainMenu;
        
        /*
         * Constructor of panel
         */
        public DeadPanel(int sc) {
                super(RRConstants.BACKGROUND_COLOR);
                int increment = RRConstants.HEIGHT/10;
                
                //setting up "You Died" Label
                died = new JLabel("<html>YOU GOT<br>SOAKED!</html>");
                died.setFont(this.nameFont);
                died.setForeground(RRConstants.BORDER_COLOR);

                score = new JLabel("Score: " + sc);
                score.setFont(this.buttonFont);
                score.setForeground(RRConstants.BORDER_COLOR);
                
                //setting up playAgain and MainMenu button
                ButtonListener b = new ButtonListener();
                playAgain = getButton("PLAY AGAIN", BACK_COLOR, b);
                mainMenu = getButton("BACK TO MENU", BACK_COLOR, b);
                                
                //add the "You Died" label, playAgain button, and Main Menu button to the panel
                addComponent(died, RRConstants.HEIGHT/6);
                addComponent(score, RRConstants.HEIGHT/2 - increment/2);
                addComponent(playAgain, RRConstants.HEIGHT/2 + increment);
                addComponent(mainMenu, RRConstants.HEIGHT/2 + 2*increment);
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
                    // if the playAgain button is pressed:
                        if (event.getSource() == playAgain) {
                            // display the game panel
                                RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.PLAYPANEL);
                                //start the new game
                                RainRunGUI.gamePanel.startGame();
                                RainRunGUI.gamePanel.requestFocusInWindow(); //makes sure keys are being listened to rather than mouse
                        }
                        //if the mainMenu button is pressed:
                        else if (event.getSource() == mainMenu) {
                            // display the main menu panel
                                RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
                        }
                }
        }
}
