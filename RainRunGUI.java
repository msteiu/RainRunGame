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
    
    protected final static String MENUPANEL = "Card with Main Menu";
    protected final static String PLAYPANEL = "Card with Rain Run";
    protected final static String RULESPANEL = "Card with Rules";
    protected final static String SCORESPANEL = "Card with Scores";
    protected final static String DEADPANEL = "Card with Death";
    protected final static String CREDITSPANEL = "Card with Credits";

    protected static CardLayout c1;
    protected static JPanel cards;
    protected static RainRunPanel gamePanel;
    protected static JPanel mainMenuPanel;
    protected static JPanel rulesPanel;
    protected static JPanel scoresPanel;
    protected static JPanel deadPanel;
    protected static JPanel creditsPanel;
    protected static String username;
    
    /*
     * Constructor
     */
    public RainRunGUI() {
        username = "";
        c1 = new CardLayout();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
        
        gamePanel = new RainRunPanel(username);
        gamePanel.pauseGame();

        mainMenuPanel = new MainMenuPanel();
        rulesPanel = new RulesPanel();
        scoresPanel = new ScoresPanel();
        deadPanel = new DeadPanel();
        creditsPanel = new CreditsPanel();
        cards = new JPanel(c1);
        
        cards.add(mainMenuPanel, MENUPANEL);
        cards.add(gamePanel, PLAYPANEL);
        cards.add(rulesPanel, RULESPANEL);
        cards.add(scoresPanel, SCORESPANEL);
        cards.add(deadPanel, DEADPANEL);
        cards.add(creditsPanel, CREDITSPANEL);
        
        c1.show(cards, MENUPANEL);
        
        add(cards, BorderLayout.CENTER);
    }
    
    /*
     * Method that sets up new game
     * @param String of user's name
     */
    public static void newGame(String username) {
        cards.remove(gamePanel);
        gamePanel = new RainRunPanel(username);
        cards.add(gamePanel, PLAYPANEL);
    }
    
    /*
     * Method that sets up new scores panel
     */
    public static void newScoresPanel() {
        cards.remove(scoresPanel);
        scoresPanel = new ScoresPanel();
        cards.add(scoresPanel, SCORESPANEL);
    }
    
    /*
     * Method that runs it, making it visible
     */
    public void run() {
        setVisible(true);
    }
    
    /*
     * Main (driver) method envoking new GUI
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new RainRunGUI());
    }
    
}
