/**
 * FILENAME: RulesPanel
 * DESCRIPTION: Rules Panel that displays the rules of the game and the option to return 
 * to the main menu panel.
 * @author Isabel Bryant
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RulesPanel extends TextPanel {
    
    private static final Color BACK_COLOR = RRConstants.RULE_BUTTON_COLOR;
    
    private JLabel rules;
    private JLabel text;
    private JButton backButton;
    
    /*
     * Constructor for rules panel
     */
    public RulesPanel() {
        //setting up background panel
        super(RRConstants.BACKGROUND_COLOR);
        
        //setting up "Rules" Label
        rules = new JLabel("RULES");
        rules.setFont(nameFont);
        rules.setForeground(RRConstants.BORDER_COLOR);
        
        //setting up text
        text = new JLabel(
            "<html><center>Use the left and<br>right arrows to<br>dodge the " + 
            "falling<br>raindrops. Collect<br>power-ups for special<br>abilities. " + 
            "Stay dry,<br>and have fun!</html>");
        text.setFont(textFont);
        text.setForeground(RRConstants.BORDER_COLOR);
        
        //setting up backButton
        backButton = getButton("BACK TO MENU", BACK_COLOR, new ButtonListener());
        
        // add all labels and buttons to the panel and format them nicely
        addComponent(rules, RRConstants.HEIGHT/5);
        addComponent(text, RRConstants.HEIGHT/3);
        addComponent(backButton, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/5);
    }
    
    private class ButtonListener implements ActionListener {
      /*
       * Return to main menu
       * @param ActionEvent event
       */
      public void actionPerformed (ActionEvent event) {
        // display the menu panel when the backButton is pressed
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
      }
    }
    
    public static void main(String[] args) {}
}
