package project;

import java.awt.event.ActionEvent;

import project.presentation.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MenuHandler implements MouseListener {
    private MenuBar menuBar;
    private JPanel screen;

    public MenuHandler(MenuBar menuBar){
        this.menuBar = menuBar;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Character shima = new Character(menuBar.getChosenCharacter(), e.getX(),e.getY());
        screen.add(shima);
        shima.start();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setScreen(JPanel screen) {
        this.screen = screen;
    }
}
