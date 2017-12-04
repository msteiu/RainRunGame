/**
 * FILENAME: RainRunGUI
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import javax.swing.JFrame;

public class RainRunGUI {

    public static void main(String[] args) {
        // creates and shows a Frame 
        JFrame frame = new JFrame("Rain Run");
        frame.setBounds(100, 100, RainRun.WIDTH, RainRun.HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
        // create a panel, and add it to the frame
        frame.getContentPane().add(new RainRunPanel());
        
        frame.pack();
        frame.setVisible(true);
    }
}