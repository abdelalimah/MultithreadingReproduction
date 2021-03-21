package project.presentation;

import project.*;
import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{

    private MenuBar menuBar;

    public Screen(MenuBar menuBar){
        this.menuBar = menuBar;
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout(100,0));

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(getWidth(),40));
        topPanel.setEnabled(false);
        this.add(topPanel,BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(getWidth(),40));
        this.add(bottomPanel,BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(600,getHeight()));
        this.add(leftPanel,BorderLayout.WEST);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        generateLobbies(leftPanel);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(400,getHeight()));
        this.add(centerPanel,BorderLayout.CENTER);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        generateLobbies(centerPanel);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(400,getHeight()));
        this.add(rightPanel,BorderLayout.EAST);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        generateLobbies(rightPanel);

    }

    void generateLobbies(JPanel panel){
        for (int i = 1; i <= 7; i++) {
            Lobby lobby;
            if(i % 2 == 0){
                lobby = new Lobby(Color.LIGHT_GRAY,panel.getWidth(),40);
            }else {
                lobby = new Lobby(Color.BLACK,panel.getWidth(),40);
                MenuHandler menuHandler = new MenuHandler(menuBar);
                menuHandler.setScreen(lobby);
                lobby.addMouseListener(menuHandler);
            }
            panel.add(lobby);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
}
