/**
 * FILENAME: MainMenuPanel
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

import java.util.Vector;
import java.util.Random;

public class MainMenuPanel extends JPanel {
  
  protected static final int WIDTH = 300; // how wide the overall game frame is
  protected static final int HEIGHT = 550; // how high the overall game frame is
  protected static final int BORDER = 15; // thickness of border
  protected static final Color BACKGROUND_COLOR = new Color(75, 0, 130); // dark purple
  protected static final Font NAME_FONT = new Font("Courier", Font.BOLD, 60);
  protected static final Font BUTTON_FONT = new Font("Courier", Font.BOLD, 30);
  protected static final Color PLAY_COLOR = new Color(255, 215, 0);
  protected static final Color RULES_COLOR = Color.CYAN;
  protected JLabel gameName;
  protected JButton playButton;
  protected JButton rulesButton;
  
  public MainMenuPanel() {
    //setting up background panel
    setLayout(null);
    
    setBackground(BACKGROUND_COLOR);
    setSize(WIDTH, HEIGHT);
    
    //setting up "Rain Run" Label
    gameName = new JLabel("RAIN RUN");
    gameName.setFont(NAME_FONT);
    gameName.setForeground(Color.white);
    
    //setting up playButton
    playButton = new JButton("PLAY");
    playButton.setFont(BUTTON_FONT);
    playButton.setForeground(Color.white);
    playButton.setBackground(PLAY_COLOR);
    playButton.setOpaque(true);
    playButton.setBorderPainted(false);
    
    //setting up rulesButton
    rulesButton = new JButton("RULES");
    rulesButton.setFont(BUTTON_FONT);
    rulesButton.setForeground(Color.white);
    rulesButton.setBackground(RULES_COLOR);
    rulesButton.setOpaque(true);
    rulesButton.setBorderPainted(false);
    
    //setting up action listener for playButton and rulesButton
    ButtonListener b = new ButtonListener();
    playButton.addActionListener (b);
    rulesButton.addActionListener (b);
    

    add(gameName);
    add(playButton);
    add(rulesButton);
    
    Dimension sizeName = gameName.getPreferredSize();
    Dimension sizePlay = playButton.getPreferredSize();
    Dimension sizeRules = rulesButton.getPreferredSize();
    
    gameName.setBounds((WIDTH - sizeName.width)/2, HEIGHT/4, sizeName.width, sizeName.height);
    playButton.setBounds((WIDTH - sizePlay.width)/2, HEIGHT/2, sizePlay.width, sizePlay.height);
    rulesButton.setBounds((WIDTH - sizeRules.width)/2, HEIGHT/2 + HEIGHT/8, sizeRules.width, sizeRules.height);
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      if (event.getSource() == playButton) {
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.PLAYPANEL);
        RainRunGUI.gamePanel.startGame();
      }
      else if (event.getSource() == rulesButton){
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.RULESPANEL);
      }
    }
  }
  
  public static void main(String[] args) {}
}