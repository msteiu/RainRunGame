/**
 * FILENAME: ScoresPanel
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

public class ScoresPanel extends JPanel {
  
  private static final Font NAME_FONT = RRConstants.getFont(60); // new Font(RRConstants.FONT_NAME, Font.BOLD, 60);
  private static final Font TEXT_FONT = RRConstants.getFont(30); // new Font(RRConstants.FONT_NAME, Font.BOLD, 60);
  private static final Font BUTTON_FONT = RRConstants.getFont(30); // new Font(RRConstants.FONT_NAME, Font.BOLD, 30);
  protected static final Color BACK_COLOR = Color.CYAN;
  protected JLabel title;
  protected JLabel scores;
  protected JButton mainMenu;
  protected JLabel highscores;
  
  public ScoresPanel() {
    //setting up background panel
    setLayout(null);
    setBorder(BorderFactory.createLineBorder(RRConstants.BORDER_COLOR, RRConstants.BORDER));
    setBackground(RRConstants.BACKGROUND_COLOR);
    setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
    
    //setting up "High Scores" Label
    title = new JLabel("<html><center>HIGH<br>SCORES</html>");
    title.setFont(NAME_FONT);
    title.setForeground(RRConstants.BORDER_COLOR);
    
    //setting up scores Label
    scores = new JLabel("<html>1._______<br>2._______<br>3._______</html>");
    scores.setFont(TEXT_FONT);
    scores.setForeground(RRConstants.BORDER_COLOR);
    
    //setting up main menu button
    mainMenu = new JButton("BACK TO MENU");
    mainMenu.setFont(BUTTON_FONT);
    mainMenu.setForeground(Color.white);
    mainMenu.setBackground(BACK_COLOR);
    mainMenu.setOpaque(true);
    mainMenu.setBorderPainted(false);
    
    //setting up action listener for main menu button
    mainMenu.addActionListener (new ButtonListener());
    
    add(title);
    add(scores);
    add(mainMenu);
    
    Dimension sizeTitle = title.getPreferredSize();
    Dimension sizeScores = scores.getPreferredSize();
    Dimension sizeMainMenu = mainMenu.getPreferredSize();
    
    title.setBounds((RRConstants.WIDTH - sizeTitle.width)/2, RRConstants.HEIGHT/6, sizeTitle.width, sizeTitle.height);
    scores.setBounds((RRConstants.WIDTH - sizeScores.width)/2, RRConstants.HEIGHT/2 - 30, sizeScores.width, sizeScores.height);
    mainMenu.setBounds((RRConstants.WIDTH - sizeMainMenu.width)/2, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/4, sizeMainMenu.width, sizeMainMenu.height);
    
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
    }
  }
}