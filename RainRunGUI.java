/**
 * FILENAME: RainRunGUI
 * DESCRIPTION: CS230 Final Project - Rain Run Game. Displays the graphics of the game including the character,
 * falling raindrops and powerups, pause button, score, and lives.
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
    
    /**
     * Constructor
     */
    public RainRunGUI() {
        username = "";
        c1 = new CardLayout(); //using CardLayout to easily and neatly switch among panels

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
        
        // creating all the panels
        gamePanel = new RainRunPanel(username);
        gamePanel.pauseGame(); //make sure the game isn't playing in the background while on the initial main menu panel
        mainMenuPanel = new MainMenuPanel();
        rulesPanel = new RulesPanel();
        scoresPanel = new ScoresPanel();
        deadPanel = new DeadPanel(0); // initialize dead panel with a score of 0
        creditsPanel = new CreditsPanel();
        cards = new JPanel(c1); //"container panel" that will hold all the above panels
        
        // add all the panels to the "container panel" = cards
        cards.add(mainMenuPanel, MENUPANEL);
        cards.add(gamePanel, PLAYPANEL);
        cards.add(rulesPanel, RULESPANEL);
        cards.add(scoresPanel, SCORESPANEL);
        cards.add(deadPanel, DEADPANEL);
        cards.add(creditsPanel, CREDITSPANEL);
        
        // initially display the main menu panel
        c1.show(cards, MENUPANEL);
        
        // center the display
        add(cards, BorderLayout.CENTER);
    }
    
    /**
     * Method that sets up new game. Used when the user hits the playAgain button on DeadPanel
     * @param String of user's name
     */
    public static void newGame(String username) {
        cards.remove(gamePanel);
        gamePanel = new RainRunPanel(username);
        cards.add(gamePanel, PLAYPANEL);
    }
    
    /**
     * Method that sets up new scores panel
     */
    public static void newScoresPanel() {
        cards.remove(scoresPanel);
        scoresPanel = new ScoresPanel();
        cards.add(scoresPanel, SCORESPANEL);
    }

    /**
     * Method that sets up new dead panel
     */
    public static void newDeadPanel(int score) {
        cards.remove(deadPanel);
        deadPanel = new DeadPanel(score);
        cards.add(deadPanel, DEADPANEL);
    }
    
    /**
     * Method that runs it, making it visible
     */
    public void run() {
        setVisible(true);
    }
    
    /**
     * Main (driver) method envoking new GUI
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new RainRunGUI());
    }
    
}
