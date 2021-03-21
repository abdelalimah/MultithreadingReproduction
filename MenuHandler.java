import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MenuHandler implements ActionListener,MouseListener {
    private JMenuBar menuBar;
    private String chosenCharacter = "pingouin";
    JPanel screen;

    public MenuHandler(){
        this.menuBar = new JMenuBar();
        JMenu characters = new JMenu("Characters");
        

        JMenuItem character1= new JMenuItem("character1");
        character1.setIcon(new ImageIcon("characters/character1/icons/stop.gif"));
        character1.addActionListener(this);
        characters.add(character1);
        
        JMenuItem character2= new JMenuItem("character2");
        character2.setIcon(new ImageIcon("characters/character2/icons/stop.gif"));
        character2.addActionListener(this);
        characters.add(character2);
        
        JMenuItem pingouin= new JMenuItem("pingouin");
        pingouin.setIcon(new ImageIcon("characters/pingouin/icons/stop.gif"));
        pingouin.addActionListener(this);
        characters.add(pingouin);
        
        menuBar.add(characters);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        chosenCharacter = (((JMenuItem)e.getSource()).getText());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Character shima = new Character(chosenCharacter, e.getX(),e.getY());
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

    public String getChosenCharacter() {
        return chosenCharacter;
    }

    public void setChosenCharacter(String chosenCharacter) {
        this.chosenCharacter = chosenCharacter;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setScreen(JPanel screen) {
        this.screen = screen;
    }
}
