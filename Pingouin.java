import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.*;

/**
 * Pingouin
 */
public class Character extends JPanel implements Runnable {
    
    private Thread runner;
    private int x,y;
    private String name;
    private String path = "characters/";
    private int height,width;
    private String[] sources;
    private String ext;
    private int rythme;
    private int whichImage = 0;
    private Image[] images;

    public Character(String characterName, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
        setLocation(x, y);
        setSize(height,width);
        this.runner = new Thread(this);
        loadImages();
    }

    void loadImages(){
        images = new Image[sources.length];
        for (int i = 0; i < sources.length; i++) {
            String completePath = path+sources[i]+ext;
            //images[i] = Toolkit.getDefaultToolkit().getImage(completePath);
            images[i] = new ImageIcon(completePath).getImage();
        }
    }

    void start(){
        this.runner.start();
    }

    void goRight(int howManyTimes){
        for (int i = 0; i < howManyTimes; i++) {
            for (int j = 4; j <= 6 ; j++) {
                whichImage = j; 
                x+=step;
                setLocation(x, y);
                repaint();
                pause(100);
            }
        }
    }

    void goLeft(int howManyTimes){
        for (int i = 0; i < howManyTimes; i++) {
            for (int j = 1; j <= 3 ; j++) {
                whichImage = j;
                x-=step;
                setLocation(x, y);
                repaint();
                pause(100);
            }
        }
    }

    void stop(){
        whichImage = 0;
        repaint();
        pause(2000);
    }

    void pause(int time){
        try{
            TimeUnit.MILLISECONDS.sleep(time);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(images[whichImage], 0,0, null);
    }
    
    @Override
    public void run() {
        while(true){
            int decision = (int)(Math.random() * 130);
            if(decision < 50){
                goRight(7);
            }
            else if(decision < 90){
                goLeft(7);
            }else {
                stop();
            }
        }
    }

}