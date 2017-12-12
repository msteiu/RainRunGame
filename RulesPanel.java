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
  
  protected static final int WIDTH = 300; // how wide the overall game frame is
  protected static final int HEIGHT = 550; // how high the overall game frame is
  protected static final int BORDER = 15; // thickness of border
  protected static final Color BACKGROUND_COLOR = new Color(233, 223, 239); // lilac-ish
  protected static final Color BORDER_COLOR = new Color(75, 0, 130); // dark purple
  protected static final Font NAME_FONT = new Font("Courier", Font.BOLD, 60);
  protected static final Font TEXT_FONT = new Font("Courier", Font.BOLD, 20);
  protected static final Font BUTTON_FONT = new Font("Courier", Font.BOLD, 30);
  protected static final Color BACK_COLOR = Color.CYAN;
  protected JLabel rules;
  protected JLabel text;
  protected JButton backButton;
  
  public RulesPanel() {
    //setting up background panel
    setLayout(null);
    setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER));
    setBackground(BACKGROUND_COLOR);
    setSize(WIDTH, HEIGHT);
    
    //setting up "Rules" Label
    rules = new JLabel("RULES");
    rules.setFont(NAME_FONT);
    rules.setForeground(BORDER_COLOR);
    
    //setting up text
    text = new JLabel("<html><center>Use the left and<br>right arrows to<br>dodge the " + 
    "falling<br>raindrops. Collect<br>power-ups for special<br>abilities. Stay dry,<br>and have fun!</html>");
    text.setFont(TEXT_FONT);
    text.setForeground(BORDER_COLOR);
    
    
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

    rules.setBounds((WIDTH - sizeRules.width)/2, HEIGHT/5, sizeRules.width, sizeRules.height);
    text.setBounds((WIDTH - sizeText.width)/2, HEIGHT/3, sizeText.width, sizeText.height);
    backButton.setBounds((WIDTH - sizeBack.width)/2, HEIGHT/2 + HEIGHT/5, sizeBack.width, sizeBack.height);
    
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.MENUPANEL);
    }
  }
  
  public static void main(String[] args) {}
}