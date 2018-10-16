package league_invaders;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener  {
    private Timer timerGame;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("In the GamePanel.ActionPerformed() method");
    }

    public GamePanel() {
        this.timerGame = new Timer(1000/60, this);
    }

    public void startGame(){
        timerGame.start();
    }
}
