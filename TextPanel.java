/**
 * FILENAME: TextPanel
 * DESCRIPTION: CS230 Final Project - Rain Run Game
 * @author Angelina Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class TextPanel extends JPanel {

    protected Font nameFont = RRConstants.getFont(60);
    protected Font textFont = RRConstants.getFont(20);
    protected Font buttonFont = RRConstants.getFont(30);

    /* Constructor -- sets up the background panel with background color and border color
     * and to correct size
     * @param Color backgroundColor
     */
    public TextPanel(Color backgroundColor) {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(RRConstants.BORDER_COLOR, RRConstants.BORDER));
        setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
        setBackground(backgroundColor);
    }

    /* adds a component such as a JLabel or a JButton to the panel centered and at the 
     * given yCoord
     * @param int yCoord
     */
    public void addComponent(JComponent component, int yCoord) {
        add(component);
        Dimension sizeComponent = component.getPreferredSize();
        int xCoord = (RRConstants.WIDTH - sizeComponent.width)/2;
        component.setBounds(xCoord, yCoord, sizeComponent.width, sizeComponent.height);
    }

    /* getButton() sets up and formats a JButton given it's name, color, and ActionListener
     * @param String name
     * @param Color color 
     * @param ActionListener b
     * @return JButton
     */
    public JButton getButton(String name, Color color, ActionListener b) {
        JButton button = new JButton(name);
        
        button.setFont(buttonFont);
        button.setForeground(Color.white);
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addActionListener(b);

        return button;
    }
}