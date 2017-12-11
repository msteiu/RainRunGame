/**
 * FILENAME: RainRunGUI
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RainRunGUI extends JFrame implements Runnable {

    private RainRunPanel gamePanel;

    public RainRunGUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(RainRunPanel.WIDTH, RainRunPanel.HEIGHT);
        gamePanel = new RainRunPanel();
        getContentPane().add(gamePanel);
    }

    public void run() {
        setVisible(true);
        gamePanel.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new RainRunGUI());
    }

}