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

    public RainRunGUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(RainRunPanel.WIDTH, RainRunPanel.HEIGHT);
        getContentPane().add(new RainRunPanel());
    }

    public void run() {
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new RainRunGUI());
    }

}