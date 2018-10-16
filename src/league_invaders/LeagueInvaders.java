package league_invaders;

import javax.swing.*;
import java.awt.*;

public class LeagueInvaders {
    private JFrame window;
    private GamePanel gamePanel;
    private final int WIDTH = 500;
    private final int HEIGHT = 800;

    public static void main(String[] args) {
        new LeagueInvaders().setup();
    }

    public LeagueInvaders() {
        window = new JFrame("League Invaders");
        window.setSize(WIDTH, HEIGHT);
        gamePanel = new GamePanel();

    }

    private void setup(){

        window.add(gamePanel);
        window.addKeyListener(gamePanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.pack();
        window.setVisible(true);
        gamePanel.startGame();
    }
}
