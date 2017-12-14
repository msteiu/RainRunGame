/**
 * FILENAME: ScoresPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Isabel Bryant
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScoresPanel extends TextPanel {
    
    protected static final Color BACK_COLOR = Color.CYAN;

    protected JLabel title;
    protected JLabel scores;
    protected JButton mainMenu;
    protected JLabel highscores;
    
    public ScoresPanel() {
        //setting up background panel
        super(RRConstants.BACKGROUND_COLOR);
        this.textFont = RRConstants.getFont(30);
        
        //setting up "High Scores" Label
        title = new JLabel("<html><center>HIGH<br>SCORES</html>");
        title.setFont(nameFont);
        title.setForeground(RRConstants.BORDER_COLOR);
        
        //setting up scores Label
        scores = new JLabel("<html>1._______<br>2._______<br>3._______</html>");
        scores.setFont(textFont);
        scores.setForeground(RRConstants.BORDER_COLOR);
        
        //setting up main menu button
        mainMenu = getButton("BACK TO MENU", BACK_COLOR, new ButtonListener());

        addComponent(title, RRConstants.HEIGHT/6);
        addComponent(scores, RRConstants.HEIGHT/2 - 30);
        addComponent(mainMenu, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/4);
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
        }
    }
}