/**
 * FILENAME: DeadPanel
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

public class DeadPanel extends JPanel {
  private static final Font NAME_FONT = RRConstants.getFont(60); // new Font(RRConstants.FONT_NAME, Font.BOLD, 60);
  private static final Font BUTTON_FONT = RRConstants.getFont(30); // new Font(RRConstants.FONT_NAME, Font.BOLD, 30);
  protected static final Color BACK_COLOR = Color.CYAN;
  protected JLabel died;
  protected JButton playAgain;
  protected JButton mainMenu;
  
  public DeadPanel() {
    //setting up background panel
    setLayout(null);
    setBorder(BorderFactory.createLineBorder(RRConstants.BORDER_COLOR, RRConstants.BORDER));
    setBackground(RRConstants.BACKGROUND_COLOR);
    setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
    
    //setting up "You Died" Label
    died = new JLabel("<html>YOU GOT<br>SOAKED!</html>");
    died.setFont(NAME_FONT);
    died.setForeground(RRConstants.BORDER_COLOR);
    
    //setting up playAgain button
    playAgain = new JButton("PLAY AGAIN");
    playAgain.setFont(BUTTON_FONT);
    playAgain.setForeground(Color.white);
    playAgain.setBackground(BACK_COLOR);
    playAgain.setOpaque(true);
    playAgain.setBorderPainted(false);
    
    //setting up main menu button
    mainMenu = new JButton("BACK TO MENU");
    mainMenu.setFont(BUTTON_FONT);
    mainMenu.setForeground(Color.white);
    mainMenu.setBackground(BACK_COLOR);
    mainMenu.setOpaque(true);
    mainMenu.setBorderPainted(false);
    
    //setting up action listener for play again button and main menu button
    ButtonListener b = new ButtonListener();
    playAgain.addActionListener (b);
    mainMenu.addActionListener (b);
    
    add(died);
    add(playAgain);
    add(mainMenu);
    
    Dimension sizeDied = died.getPreferredSize();
    Dimension sizePlayAgain = playAgain.getPreferredSize();
    Dimension sizeMainMenu = mainMenu.getPreferredSize();
    
    died.setBounds((RRConstants.WIDTH - sizeDied.width)/2, RRConstants.HEIGHT/4, sizeDied.width, sizeDied.height);
    playAgain.setBounds((RRConstants.WIDTH - sizePlayAgain.width)/2, RRConstants.HEIGHT/2, sizePlayAgain.width, sizePlayAgain.height);
    mainMenu.setBounds((RRConstants.WIDTH - sizeMainMenu.width)/2, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/8, sizeMainMenu.width, sizeMainMenu.height);
    
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      if (event.getSource() == playAgain) {
        new RainRunPanel();
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.PLAYPANEL);
        RainRunGUI.gamePanel.startGame();
        RainRunGUI.gamePanel.requestFocusInWindow();
      }
      else if (event.getSource() == mainMenu){
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
      }
    }
  }
}