import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{
    public Screen(){
        this.setBackground(Color.black);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        int width = this.getWidth();
        int height = this.getHeight();
        int borderHeight = 30;
        int borderWidth = width /3;

        int hGap = height / 4;
        int vGap = width / 3;

        //top
        g.setColor(Color.blue);
        g.fillRect(0, 0, width, borderHeight);
        
        for (int i = 0; i <= 2; i++) {
            g.setColor(Color.blue);
            g.fillRect(0, hGap * (i+1), borderWidth, borderHeight);
            // g.fillRect(vGap * (i+1) , hGap * (i+1), borderWidth, borderHeight);
            // g.fillRect(vGap * (i+1) + vGap, hGap * (i+1), borderWidth, borderHeight);
        }

        //bottom
        g.setColor(Color.blue);
        g.fillRect(0, height - borderHeight, width, borderHeight);
    }
}
