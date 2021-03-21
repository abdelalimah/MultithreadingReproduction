package project.presentation;

import javax.swing.JPanel;
import java.awt.*;

public class Lobby extends JPanel{

    public Lobby(Color color,int width,int height){
        this.setBackground(color);
        setPreferredSize(new Dimension(width,height));
    }
    
}
