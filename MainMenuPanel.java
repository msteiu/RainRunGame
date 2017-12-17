/**
 * FILENAME: MainMenuPanel
 * DESCRIPTION: Class that contains elements of game's main menu panel. User has the option to
 * start the game, look at the rules, look at the high scores, look at the credits. 
 * @author Isabel Bryant
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenuPanel extends TextPanel {
  
  private static final Color PLAY_COLOR = RRConstants.CHAR_DEFAULT_COLOR;
  private static final Color RULES_COLOR = RRConstants.RULE_BUTTON_COLOR;
  private static final Color SCORES_COLOR = new Color(255, 0, 255);
  private static final Color CREDITS_COLOR = new Color(57, 158, 90);
  
  private String name;
  private JLabel gameName;
  private JLabel nameLabel;
  private JTextField nameField;
  private JButton playButton;
  private JButton rulesButton;
  private JButton scoresButton;
  private JButton creditsButton;
  
  /*
   * Constructor of panel
   */
  public MainMenuPanel() {
    super(RRConstants.BORDER_COLOR);
    int increment = RRConstants.HEIGHT/10;
    
    //setting up "Rain Run" Label
    gameName = new JLabel("RAIN RUN");
    gameName.setFont(this.nameFont);
    gameName.setForeground(Color.white);
    
    // making name label
    name = "";
    nameLabel = new JLabel("Enter your name:");
    nameLabel.setFont(this.textFont);
    nameLabel.setForeground(Color.white);
    
    // setting up where user types in their name
    nameField = new JTextField(12);
    nameField.setFont(this.textFont);
    nameField.setBackground(RRConstants.BORDER_COLOR);
    nameField.setForeground(Color.white);
    nameField.setCaretColor(Color.white);
    nameField.setHorizontalAlignment(JTextField.CENTER);
    nameField.setBorder(BorderFactory.createLineBorder(RRConstants.BORDER_COLOR, RRConstants.BORDER));
    nameField.addActionListener(new NameListener());
    
    // setting up the buttons
    ButtonListener b = new ButtonListener();
    playButton = getButton("PLAY", PLAY_COLOR, b);
    rulesButton = getButton("RULES", RULES_COLOR, b);
    scoresButton = getButton("SCORES", SCORES_COLOR, b);
    creditsButton = getButton("CREDITS", CREDITS_COLOR, b);
    
    // adding all the labels and buttons to the panel, formatting them nicely on the panel
    addComponent(gameName, RRConstants.HEIGHT/5);
    addComponent(nameLabel, RRConstants.HEIGHT/5 + (5*increment/4));
    addComponent(nameField, RRConstants.HEIGHT/5 + (3*increment/2));
    addComponent(playButton, RRConstants.HEIGHT/2);
    addComponent(rulesButton, RRConstants.HEIGHT/2 + increment);
    addComponent(scoresButton, RRConstants.HEIGHT/2 + 2*increment);
    addComponent(creditsButton, RRConstants.HEIGHT/2 + 3*increment);
  }
  
  private class ButtonListener implements ActionListener {
    
    /*
     * Method that checks the source of the action perdormed when button pressed (play/rules/score).
     * @param event desired by player
     */
    public void actionPerformed (ActionEvent event) {
      if (event.getSource() == playButton) {
        //creates a new game
        RainRunGUI.newGame(name);
        // display the game panel
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.PLAYPANEL);
        RainRunGUI.gamePanel.startGame();
        RainRunGUI.gamePanel.requestFocusInWindow();  //makes sure keys are being listened to rather than mouse
      }
      else if (event.getSource() == rulesButton){
        // display the rules panel
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.RULESPANEL);
      }
      else if (event.getSource() == scoresButton) {
        // display the scores panel
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.SCORESPANEL);
      }
      else if (event.getSource() == creditsButton) {
        // display the credits panel
        RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.CREDITSPANEL);
      }
    }
  }
  
  private class NameListener implements ActionListener {
    
    /*
     * Method that gets the name entered by player.
     * @param event/action of player
     */
    public void actionPerformed(ActionEvent event) {
      String enteredName = nameField.getText();
      boolean valid = Score.isValidName(enteredName);
      if (!valid) {
        nameLabel.setText(
                          "Can't use '" + RRConstants.DELIMITER + "'s!");
      }
      else if (!enteredName.equals("")) {
        name = enteredName;
        remove(nameLabel);
        remove(nameField);
        repaint();
      }
    }
  }
}
