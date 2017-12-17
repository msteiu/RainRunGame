/**
 * FILENAME: RainRunPanel
 * DESCRIPTION: This class is the graphical representation of a RainRun game.
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

import javax.imageio.*;
import java.io.*;

import java.util.Vector;

public class RainRunPanel extends JPanel {
    
    // color of the pause button background
    private static final Color PAUSE_COLOR = RRConstants.CHAR_DEFAULT_COLOR;

    // font that the score of the game is displayed using
    private static final Font SCORE_FONT = RRConstants.getFont(16);
    
    private RainRun game; // the RainRun game being graphically represented
    private Timer timer; // timer to keep track of how much time has passed
    private TimerListener tListener; // listener to update the game each time interval
    private MoveListener kListener; // listener to update the character position based on key input
    private PauseListener pListener; // listener to update the game when the pause button is clicked
    private JButton pause; // button user can click on to pause the game
    
    // icons used in the pause button to demonstrate whether the game is paused or nor
    private ImageIcon pauseIcon, playIcon;
    private boolean running; // whether the game is currently running
    private String username; // name of the user playing this game
    
    /**
     * Constructor that creates a new instance of this class.
     * @param String username - name of the user playing this game
     */
    public RainRunPanel(String username) {
        this.game = new RainRun();
        this.tListener = new TimerListener();
        this.kListener = new MoveListener();
        this.pListener = new PauseListener();
        this.running = false; // the game won't start playing until its manually started
        
        // will default to 'Anon' if user doesn't submit a name
        this.username = username.equals("") ? "Anon" : username;
        this.timer = new Timer(RRConstants.DELAY, tListener);

        setBorder(BorderFactory.createLineBorder(RRConstants.BORDER_COLOR, RRConstants.BORDER));
        setBackground(RRConstants.BACKGROUND_COLOR);

        // initializing the pause button
        this.pause = new JButton();
        this.pauseIcon = getPauseIcon("images/pause.png");
        this.playIcon = getPauseIcon("images/play.png");

        pause.setIcon(pauseIcon);
        pause.setBackground(PAUSE_COLOR);
        pause.setOpaque(true);
        pause.setBorderPainted(false);
        pause.addActionListener(pListener);
        add(pause);
        
        // this JPanel needs to be set as focusable in order for our KeyListener to function
        setFocusable(true);
        requestFocus(); 
        addKeyListener(kListener);
        timer.start();
    }

    /**
     * Returns an ImageIcon used to create the pause button
     * @param String path of the image used as an icon
     * @return ImageIcon needed
     */
    private ImageIcon getPauseIcon(String imagePath) {
        return new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(
            15, 15, Image.SCALE_DEFAULT));
    }

    /**
     * Method that, given a Graphics object, will draw the score of the current
     * game, in the top left corner of the JPanel.
     * @param Graphics g - given Graphics object
     */
    private void makeScore(Graphics g) {
        g.setColor(RRConstants.BORDER_COLOR);
        g.setFont(SCORE_FONT);
        g.drawString("Score: " + game.getScore(), RRConstants.BORDER + 8, 
            RRConstants.BORDER + 20);
    }
    
    /**
     * Method that, given a Graphics object, will represents the number of lives
     * left in the game as a series of heart images.
     * @param Graphics g - a specified Graphics object
     */
    private void makeHealth(Graphics g) {
        try {
            Image img = ImageIO.read(new File("images/life.png"));
            for (int i = 1; i <= game.getCharacter().getHealth(); i++) {
                /* to ensure each heart appears next to the previous one - each
                heart is approximately 20x20 pixels large */
                int xCoord = RRConstants.WIDTH - (RRConstants.BORDER + 3) - i*(20 + 5);
                g.drawImage(img, xCoord, RRConstants.BORDER + 8, new PaneObserver());
            }
        } catch (IOException e) {
            System.out.println("Couldn't open image images/life.png");
        }
    }
    
    /**
     * paintComponent() draws all of the Characters in the game, as well as 
     * the current score and number of lives left in the game.
     * @param Graphics g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.getCharacter().drawCharacter(g);
        
        for(FallingObject obj : game.getFallingObjects()) {
            obj.drawCharacter(g);
        }
        
        /* ensures score and health appear on top of (and thus are not obscured
        by) FallingObjects */
        makeScore(g);
        makeHealth(g);

        repaint();
    }
    
    
    // LISTENERS //
    
    /**
     * Required class to draw an image in makeHealth(g)
     */
    public class PaneObserver implements ImageObserver {
      /**
       * Required method to draw an image in makeHealth(g)
       * @param Image image wanted
       * @param int 
       * @param x location coordinate
       * @param y location coordinate
       * @param width of image
       * @param heigh of image
       */
      public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
      }
    }
    
    /**
     * Listener to check for keyboard input from user and to update the game
     * accordingly.
     */
    public class MoveListener implements KeyListener {
        
        /**
         * Method that defines what should occur given a specified key input
         * @param KeyEvent e specified key input
         */
        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();

            // will move left if user presses left or A keys, as long as game is running
            if (running && (keyPressed == KeyEvent.VK_LEFT || keyPressed == KeyEvent.VK_A)) {
                game.moveLeft();
                game.checkHit();
            }
            // will move right if user presses right or D keys, as long as game is running
            if (running && (keyPressed == KeyEvent.VK_RIGHT || keyPressed == KeyEvent.VK_D)) {
                game.moveRight();
                game.checkHit();
            }
            /* when user hits space, will pause game if its currently running 
            and play game if currently paused */
            if (keyPressed == KeyEvent.VK_SPACE) {
                if (isRunning()) {
                    pauseGame();
                    pause.setIcon(playIcon);
                } else {
                    startGame();
                    pause.setIcon(pauseIcon);
                }
            }
        }
        // required by the KeyListener interface
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }
    
    /**
     * Listener to update the game every Timer interval.
     */
    public class TimerListener implements ActionListener {

        /**
         * Helper method invoked after the main character has died and the game
         * is over, that will update the file storing top scores from this game
         * with the new top scores.
         */
        private void addScore() {
            try {
                Vector<Score> scores = Score.parseScoresFromFile("scores.txt");
                PrintWriter writer = new PrintWriter(new FileOutputStream("scores.txt", false));

                Score gameScore = new Score(username, game.getScore());
                int totalAdded = 0; // total number of scores written to the file
                boolean added = false; // whether the current score has been added
                
                for(int i = 0; i < scores.size() && totalAdded < RRConstants.NUM_TOPSCORES; i++) {
                    Score prevScore = scores.get(i);
                    
                    // all else equal, newer scores replace old ones
                    if (!added && gameScore.compareTo(prevScore) >= 0) {
                        writer.println(gameScore);
                        totalAdded++;
                        added = true;
                    }

                    if (totalAdded < RRConstants.NUM_TOPSCORES) {
                        writer.println(prevScore);
                        totalAdded++;
                    }
                }
                writer.close();
            } catch(IOException e) {
                System.out.println("Couldn't save to scores.txt");
            } 
        }
        
        /**
         * When an ActionEvent occurs, this method specifies what should occur.
         * If the main character dies, will specify the steps that should occur.
         * @param ActionEvent event that triggered this listener
         */
        public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == timer && running) {
                
                if (game.getCharacter().getDied()) {
                    removeKeyListener(kListener);
                    timer.stop();
                    timer.removeActionListener(tListener);
                    running = false;

                    addScore();
                    RainRunGUI.newGame(username);
                    // need to generate a new Scores Panel because top scores may have changed
                    RainRunGUI.newScoresPanel();
                    RainRunGUI.c1.show(RainRunGUI.cards, RainRunGUI.DEADPANEL);
                }
                else {
                    game.checkTime();
                }
            }
        }
    }
    
    /**
     * Listener to update the game when the pause/play button is clicked on.
     */
    private class PauseListener implements ActionListener {

        /**
         * When the pause/play button is clicked on, this method specifies what 
         * to do. The game will pause if not currently paused and will play if
         * not currently playing.
         * @param ActionEvent event that triggered this listener
         */
        public void actionPerformed (ActionEvent event) {
            if (isRunning()) {
                pauseGame();
                pause.setIcon(playIcon);
            } else {
                startGame();
                pause.setIcon(pauseIcon);
                // requestFocusInWindow() is necessary for the KeyListener to function
                RainRunGUI.gamePanel.requestFocusInWindow();
            }
        }
    }
       
    /**
     * Will start the game when invoked
     */
    public void startGame() {
        this.running = true;
    }
    
    /**
     * Will pause the game when invoked
     */
    public void pauseGame() {
        this.running = false;
    }
    
    /**
     * Will return whether the game is currently running
     * @return boolean whether the game is currently running
     */
    public boolean isRunning() {
        return running;
    }
    
}
