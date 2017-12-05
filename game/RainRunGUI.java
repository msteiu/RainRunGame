/**
 * FILENAME: RainRunGUI
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import javax.swing.JFrame;

public class RainRunGUI extends JFrame {

    public RainRunGUI() {
        super("Rain Run");
        setBounds(100, 100, RainRun.WIDTH, RainRun.HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new DeadPanel(3));
        pack();
    }

    public static void main(String[] args) {
        RainRunGUI frame = new RainRunGUI();
        frame.setVisible(true);
    }
}