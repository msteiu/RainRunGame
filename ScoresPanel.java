/**
 * FILENAME: ScoresPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game. The ScoresPanel displays the top 5 high scores
 * and a button to return to the main menu panel.
 * @author Isabel Bryant, Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.*;

public class ScoresPanel extends TextPanel {
  
  protected static final Color BACK_COLOR = Color.CYAN;
  
  protected JLabel title;
  protected JLabel scores;
  protected JButton mainMenu;
  protected JLabel highScores;
  private Vector<Score> allHighScores;
  
  /**
   * Constructor
   */
  public ScoresPanel() {
    //setting up background panel
    super(RRConstants.BACKGROUND_COLOR);
    
    try {
      allHighScores = Score.parseScoresFromFile("scores.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Could not read scores.txt");
    }
    
    //setting up "High Scores" Label
    title = new JLabel("<html><center>HIGH<br>SCORES</html>");
    title.setFont(nameFont);
    title.setForeground(RRConstants.BORDER_COLOR);
    
    //setting up scores Label
    scores = new JLabel(makeLabelText());
    scores.setFont(textFont);
    scores.setForeground(RRConstants.BORDER_COLOR);
    
    //setting up main menu button
    mainMenu = getButton("BACK TO MENU", BACK_COLOR, new ButtonListener());
    
    // add all the labels and the button to the panel and format them nicely
    addComponent(title, RRConstants.HEIGHT/6);
    addComponent(scores, RRConstants.HEIGHT/2 - 30);
    addComponent(mainMenu, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/4);
  }
  
  /**
   * makeLabelText() makes the text box of all the high scores
   * formatted accordingly.
   */
  private String makeLabelText() {
    StringBuilder build = new StringBuilder("<html>");
    
    for(int i=0; i < allHighScores.size(); i++) {
      Score currentScore = allHighScores.get(i);
      String name = currentScore.getName();
      int score = currentScore.getScore();
      int num = i + 1;
      
      if(!name.equals("NONE")) {
        build.append(num + ". " + name + " - " + score + "<br>");
      }
    }
    
    build.append("</html>");
    return build.toString();
  }
  
  private class ButtonListener implements ActionListener {
    /* Returns to main menu
     */
    public void actionPerformed (ActionEvent event) {
      // if the backButton is pressed, display the main menu panel
      RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
    }
  }
}