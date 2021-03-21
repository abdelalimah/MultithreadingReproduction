package project.presentation;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class Animation extends JFrame {

    public Animation(){
        this.setLayout(null);
        MenuBar menuBar = new MenuBar();
        
        Screen screen = new Screen(menuBar);
        
        
        setJMenuBar(menuBar.getMenuBar());

        setContentPane(screen);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Animation();
    }
}
