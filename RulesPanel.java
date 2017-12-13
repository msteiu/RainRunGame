/**
 * FILENAME: RulesPanel
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

public class RulesPanel extends JPanel {
  
  private static final Font NAME_FONT = RRConstants.getFont(60); // new Font(RRConstants.FONT_NAME, Font.BOLD, 60);
  private static final Font TEXT_FONT = RRConstants.getFont(20); // new Font(RRConstants.FONT_NAME, Font.BOLD, 20);
  private static final Font BUTTON_FONT = RRConstants.getFont(30); // new Font(RRConstants.FONT_NAME, Font.BOLD, 30);
  private static final Color BACK_COLOR = RRConstants.RULE_BUTTON_COLOR;
  
  private JLabel rules;
  private JLabel text;
  private JButton backButton;
  
  public RulesPanel() {
    //setting up background panel
    setLayout(null);
    setBorder(BorderFactory.createLineBorder(RRConstants.BORDER_COLOR, RRConstants.BORDER));
    setBackground(RRConstants.BACKGROUND_COLOR);
    setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
    
    //setting up "Rules" Label
    rules = new JLabel("RULES");
    rules.setFont(NAME_FONT);
    rules.setForeground(RRConstants.BORDER_COLOR);
    
    //setting up text
    text = new JLabel("<html><center>Use the left and<br>right arrows to<br>dodge the " + 
    "falling<br>raindrops. Collect<br>power-ups for special<br>abilities. Stay dry,<br>and have fun!</html>");
    text.setFont(TEXT_FONT);
    text.setForeground(RRConstants.BORDER_COLOR);
    
    
    //setting up backButton
    backButton = new JButton("BACK TO MENU");
    backButton.setFont(BUTTON_FONT);
    backButton.setForeground(Color.white);
    backButton.setBackground(BACK_COLOR);
    backButton.setOpaque(true);
    backButton.setBorderPainted(false);
    
    //setting up action listener for playButton
    backButton.addActionListener (new ButtonListener());
    
    add(rules);
    add(text);
    add(backButton);
    
    Dimension sizeRules = rules.getPreferredSize();
    Dimension sizeText = text.getPreferredSize();
    Dimension sizeBack = backButton.getPreferredSize();

    rules.setBounds((RRConstants.WIDTH - sizeRules.width)/2, RRConstants.HEIGHT/5, sizeRules.width, sizeRules.height);
    text.setBounds((RRConstants.WIDTH - sizeText.width)/2, RRConstants.HEIGHT/3, sizeText.width, sizeText.height);
    backButton.setBounds((RRConstants.WIDTH - sizeBack.width)/2, RRConstants.HEIGHT/2 + RRConstants.HEIGHT/5, sizeBack.width, sizeBack.height);
    
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
    }
  }
  
  public static void main(String[] args) {}
}