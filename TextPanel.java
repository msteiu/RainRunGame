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

    public TextPanel(Color backgroundColor) {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(RRConstants.BORDER_COLOR, RRConstants.BORDER));
        setSize(RRConstants.WIDTH, RRConstants.HEIGHT);
        setBackground(backgroundColor);
    }

    public void addComponent(JComponent component, int yCoord) {
        add(component);
        Dimension sizeComponent = component.getPreferredSize();
        int xCoord = (RRConstants.WIDTH - sizeComponent.width)/2;
        component.setBounds(xCoord, yCoord, sizeComponent.width, sizeComponent.height);
    }

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