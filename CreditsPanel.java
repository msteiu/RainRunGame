/**
 * FILENAME: CreditsPanel
 * DESCRIPTION: Represents a JPanel that displays the names of the creators
 * of this game, as well as acknowledging other sources who helped us create
 * Rain Run.
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreditsPanel extends TextPanel {
    
    // back color is the color of the back button
    private static final Color BACK_COLOR = RRConstants.RULE_BUTTON_COLOR;
    
    // an additional font object to use while acknowledging contributors
    private Font contributorFont;
    
    /* button to go back to the main menu - needed as an instance variable
    so we can access this in an ActionListener below */
    private JButton backButton;
    
    /*
     * Constructor for rules panel - extends the functionality of a TextPanel
     * to 
     */
    public CreditsPanel() {
        super(RRConstants.BACKGROUND_COLOR);
        contributorFont = RRConstants.getFont(15);

        /* this is a useful helper variable used to position elements in
        aesthetically pleasing places in the CreditsPanel */
        int increment = RRConstants.HEIGHT/10;

        // title of the CreditsPanel
        JLabel credits = makeText("CREDITS", nameFont);
        
        // the first section of the JPanel - represents the names of creators
        JLabel creatorSubtitle = makeText("Created by:", buttonFont);
        JLabel creatorText = makeText(
            "<html><center>Isabel Bryant,<br>" + 
            "Hunter Sessa,<br>" + 
            "Mara Steiu &<br>" + 
            "Angelina Li</html>", textFont);

        // second section of the JPanel - represents names of contributors
        JLabel contributorSubtitle = makeText("Thanks to:", buttonFont);
        JLabel contributorText = makeText(
            "<html><center>Ada & Takis,<br>" + 
            "This: bit.ly/sojavaswing,<br>" + 
            "and CS230 for teaching us <br>" + 
            "how to make our game.</html>", contributorFont);

        //setting up backButton - getButton is a method inherited from TextPanel
        backButton = getButton("BACK TO MENU", BACK_COLOR, new ButtonListener());
        
        /* adding each component to the CreditsPanel, using the addComponent 
        method inherited from TextPanel */
        addComponent(credits, RRConstants.HEIGHT/6);
        addComponent(creatorSubtitle, RRConstants.HEIGHT/5 + increment);
        addComponent(creatorText, RRConstants.HEIGHT/5 + (3*increment/2));
        addComponent(contributorSubtitle, RRConstants.HEIGHT/2 + increment/2);
        addComponent(contributorText, RRConstants.HEIGHT/2 + increment);
        addComponent(backButton, RRConstants.HEIGHT - RRConstants.HEIGHT/6 - increment);
    }

    /**
     * Helper method that will create and return centered JLabel with the color 
     * BORDER_COLOR as defined in the RRConstants class, including the given
     * text and in the given font.
     * 
     * @param String text - represents the text that should be included in the
     * JLabel
     * @param Font font - represents the font the text should be displayed in
     * @return JLabel created
     */
    private JLabel makeText(String text, Font font) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(font);
        label.setForeground(RRConstants.BORDER_COLOR);
        return label;
    }
    
    /**
     * Class creating an ActionListener specific to the backbutton
     */
    private class ButtonListener implements ActionListener {
        
        /**
         * Will show the Main Menu Panel when triggered. Doesn't need to check
         * the event source because this will only be used by one component.
         * 
         * @param ActionEvent event represents the event that triggered this
         * ActionListener
         */
        public void actionPerformed (ActionEvent event) {
            RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
        }
    }
    
}
