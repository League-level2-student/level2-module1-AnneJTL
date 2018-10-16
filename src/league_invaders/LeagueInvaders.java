package league_invaders;

import javax.swing.*;

public class LeagueInvaders {
    private JFrame window;
    private final int windowWidth = 500;
    private final int windowHeight = 800;

    public static void main(String[] args) {
        new LeagueInvaders().setup();

    }

    public LeagueInvaders() {
        window = new JFrame("League Invaders");
        window.setSize(windowWidth, windowHeight);

    }

    private void setup(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
