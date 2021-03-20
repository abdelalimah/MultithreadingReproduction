import java.awt.Color;

import javax.swing.JPanel;

public class Border extends JPanel {

    // private int width;
    // private final int height = 300;

    public Border(Color color){
        setBackground(color);
        setSize(30,this.getWidth());
    }
}
