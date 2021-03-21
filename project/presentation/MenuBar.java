package project.presentation;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuBar implements ActionListener {
    
    private String chosenCharacter = "pingouin";
    private JMenuBar menuBar;
    
    
    public MenuBar(){
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
        System.out.println(chosenCharacter);
    }

    public String getChosenCharacter() {
        return chosenCharacter;
    }
    public JMenuBar getMenuBar() {
        return menuBar;
    }
    
}
