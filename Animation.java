import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class Animation extends JFrame implements MouseListener {

    private JPanel screen;
    private int counter = 0;
    public Animation(){
        screen = new JPanel();
        screen.setBackground(Color.black);
        screen.addMouseListener(this);
        setContentPane(screen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        counter++;
        Character shima = new Character("pingouin", e.getX(),e.getY());
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

    public static void main(String[] args) {
        new Animation();
    }
}
