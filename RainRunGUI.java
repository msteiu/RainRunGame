/**
 * FILENAME: RainRunGUI
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li and Isabel Bryant
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RainRunGUI extends JFrame implements Runnable {
  
  protected static RainRunPanel gamePanel;
  protected static JPanel cards;
  protected final static String MENUPANEL = "Card with Main Menu";
  protected final static String PLAYPANEL = "Card with Rain Run";
  protected final static String RULESPANEL = "Card with Rules";
  protected static CardLayout c1 = new CardLayout();
  
  public RainRunGUI() {
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
    
    gamePanel = new RainRunPanel();
    gamePanel.pauseGame();
    JPanel MainMenuPanel = new MainMenuPanel();
    JPanel RulesPanel = new RulesPanel();
    cards = new JPanel(c1);
    
    cards.add(MainMenuPanel, MENUPANEL);
    cards.add(gamePanel, PLAYPANEL);
    cards.add(RulesPanel, RULESPANEL);
    
    c1.show(cards, MENUPANEL);
    
    add(cards, BorderLayout.CENTER);
  }
  
  public void run() {
    setVisible(true);
    // gamePanel.startGame();
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new RainRunGUI());
  }
  
}