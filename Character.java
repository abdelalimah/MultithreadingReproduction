import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import java.awt.*;

/**
 * Pingouin
 */
public class Character extends JPanel implements Runnable {
    
    private Thread runner;
    private int x,y;
    private String characterDirectoryName;
    private String charactersDirectory = "characters/";
    private int height,width;
    private Hashtable<String,Integer> sources;
    private String ext;
    private int rythme;
    private int whichImage = 0;
    private Image[] images;
    private XMLNode root;
    private int step = 3;
    private String iconsDirectory;

    public Character(String characterName, int x, int y){

        this.characterDirectoryName = characterName;
        root = new XMLNode(characterName);
        this.height = root.extractIntAttribute("height");
        this.width = root.extractIntAttribute("width");
        rythme = root.extractIntAttribute("rythme");
        this.x = x;
        this.y = y;
        setLocation(x, y);
        setSize(height,width);
        this.runner = new Thread(this);
        loadSources();
        loadImagesFromSources();
    }

    void loadSources(){
        sources = new Hashtable();
        XMLNode sourcesNode = root.extractChild("sources");
        this.ext = sourcesNode.extractAttribute("ext");
        XMLNode[] sourceChildNodes = sourcesNode.extractChildren();
        for (int i = 0; i < sourceChildNodes.length; i++) {   
            sources.put(sourceChildNodes[i].textValue(), i);
        }
    }

    void loadImagesFromSources(){
        XMLNode sourcesNode = root.extractChild("sources");
        this.iconsDirectory = sourcesNode.extractAttribute("path");
        images = new Image[sources.size()];
        for (String actionValue : sources.keySet()) {
            String completePath = charactersDirectory+characterDirectoryName+iconsDirectory+actionValue+ext;
            System.out.println(completePath);
            images[sources.get(actionValue)] = new ImageIcon(completePath).getImage();
        }
        /**
         * sources tabel : {
         * "left1": 1
         * "left2": 2
         * }
         */
    }

    void start(){
        this.runner.start();
    }

    void characterAction(String actionName){
        XMLNode actions = root.extractChild("actions");
        
        String iconsComposition[] = null;

        for (XMLNode action : actions.extractChildren()) {
            if(actionName.equals(action.textValue())){
                iconsComposition = action.extractAttribute("iconsComposition").split(",");
            }
        }

        for (int i = 0; i < rythme; i++) {
            if(iconsComposition != null){
                for (int j = 0; j < iconsComposition.length ; j++) {
                    int getCorrespondantIconIndexInSources = sources.get(iconsComposition[j]);
                    whichImage = getCorrespondantIconIndexInSources;
                    if("goRight".equals(actionName)){
                        x+=step;
                    }else {
                        x-=step;
                    }
                    setLocation(x, y);
                    repaint();
                    pause(100);
                }
            }
        }
    }

    void goRight(){
        characterAction("goRight");
    }

    void goLeft(){
        characterAction("goLeft");
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
                goRight();
            }
            else if(decision < 90){
                goLeft();
            }else {
                stop();
            }
        }
    }

}