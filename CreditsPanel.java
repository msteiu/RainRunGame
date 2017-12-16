/**
 * FILENAME: CreditsPanel
 * DESCRIPTION: Contains elements of the credits panel 
 * @author Isabel Bryant
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreditsPanel extends TextPanel {
    
    private static final Color BACK_COLOR = RRConstants.RULE_BUTTON_COLOR;
    private Font contributorFont;

    private JButton backButton;
    
    /*
     * Constructor for rules panel
     */
    public CreditsPanel() {
        //setting up background panel
        super(RRConstants.BACKGROUND_COLOR);
        contributorFont = RRConstants.getFont(15);
        int increment = RRConstants.HEIGHT/10;

        JLabel credits = makeText("CREDITS", nameFont);
        
        JLabel creatorSubtitle = makeText("Created by:", buttonFont);
        JLabel creatorText = makeText(
            "<html><center>Isabel Bryant,<br>Hunter Sessa,<br>" + 
            "Mara Steiu &<br>Angelina Li</html>", textFont);

        JLabel contributorSubtitle = makeText("Thanks to:", buttonFont);
        JLabel contributorText = makeText(
            "<html><center>Ada & Takis,<br>" + 
            "This: bit.ly/sojavaswing,<br>" + 
            "and CS230 for teaching us <br>how to make our game.</html>", contributorFont);

        //setting up backButton
        backButton = getButton("BACK TO MENU", BACK_COLOR, new ButtonListener());
        
        addComponent(credits, RRConstants.HEIGHT/6);
        addComponent(creatorSubtitle, RRConstants.HEIGHT/5 + increment);
        addComponent(creatorText, RRConstants.HEIGHT/5 + (3*increment/2));
        addComponent(contributorSubtitle, RRConstants.HEIGHT/2 + increment/2);
        addComponent(contributorText, RRConstants.HEIGHT/2 + increment);
        addComponent(backButton, RRConstants.HEIGHT - RRConstants.HEIGHT/6 - increment);
    }

    private JLabel makeText(String text, Font font) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(font);
        label.setForeground(RRConstants.BORDER_COLOR);
        return label;
    }
    
    private class ButtonListener implements ActionListener {
        /*
         * Return to main menu
         * @param ActionEvent event
         */
        public void actionPerformed (ActionEvent event) {
            RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
        }
    }
    
    public static void main(String[] args) {}
}
